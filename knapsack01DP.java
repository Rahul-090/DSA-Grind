// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Solution {
    public static void main(String[] args) {

        int [] value = {10, 40, 30, 50};
        int [] wt = {5, 4, 2, 3};
        int W = 5;
        System.out.println("Maximum value we can pick: "+maximumValue(value, wt, W, value.length));
    }

    public static int maximumValue(int [] values, int [] wt, int W, int n){
        //writing the base case
        int [][] t = new int[n+1][W+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= W; j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }
            }
        }

        //interative solution
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= W; j++){
                if(wt[i-1] <= W){
                    t[i][j] = Math.max(values[i-1]+ maximumValue(values, wt, W-wt[i-1], n-1), maximumValue(values, wt, W, n-1));
                }
                else{
                    t[i][j] = maximumValue(values, wt, W, n-1);
                }
            }
        }
        return t[n][W];
    }
}
