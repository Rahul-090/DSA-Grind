// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Solution {
    public static void main(String[] args) {
        // Write your code here
        //o-1 KnapSack
        int [] value = {10, 40, 30, 50};
        int []wt = {5, 4, 2, 3};
        int W = 5;
        int n = value.length;
        
        System.out.println("Maximum value: "+maximumItemValue(value, wt, W, n));
    }

    public static void memoize(int [][] t, int n, int W){
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= W; j++){
                t[i][j] = -1;
            }
        }
    }

    public static int maximumItemValue(int [] value, int [] wt, int W, int n){

        int [][] t = new int[n+1][W+1];
        memoize(t, n, W);
        //Base cases
        if(W <= 0){
            return 0;
        }

        if(n == 0){
            return 0;
        }//

        if(t[n][W] != -1){
            return t[n][W];
        }
        
        if(wt[n-1] <= W){
            //include and exclude
            t[n][W] = Math.max(value[n-1]+ maximumItemValue(value, wt, W-wt[n-1], n-1), maximumItemValue(value, wt, W, n-1));
             
        }else{
            //exclude
            t[n][W] = maximumItemValue(value, wt, W, n-1);
            
        }
        return t[n][W];
    }

    //Time Complexity = 2^n 
    //Space Complexity = 
}
