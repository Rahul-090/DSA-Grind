// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Solution {
    public static void main(String[] args) {
        int [] arr = {3, 34, 4, 12, 5, 2};
        int sum = 30;
        System.out.println("Subset Sum: "+subsetSumExist(arr, sum, arr.length));
    }

    //recursive code
    public static Boolean subsetSumExist(int [] arr, int sum, int n){
        boolean [][] t = new boolean[n+1][sum+1];
        
        //base case
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= sum; j++){
                if(i == 0){
                    t[i][j] = false;
                }
                if(j == 0){
                    t[i][j] = true;
                }
            }
        }

        //iterative code
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                if(arr[i-1] <= j){
                    //include or exclude
                    t[i][j] = (t[i-1][j-arr[i-1]] || t[i-1][j]);
                }else{
                    //exclude
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
