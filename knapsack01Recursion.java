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

    public static int maximumItemValue(int [] value, int [] wt, int W, int n){
        //Base cases
        if(W <= 0){
            return 0;
        }

        if(n == 0){
            return 0;
        }

        if(wt[n-1] <= W){
            //include and exclude
            return Math.max(value[n-1]+ maximumItemValue(value, wt, W-wt[n-1], n-1), maximumItemValue(value, wt, W, n-1));
        }else{
            //exclude
            return maximumItemValue(value, wt, W, n-1);
        }
    }
}
