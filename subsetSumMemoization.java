// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Solution {
    public static void main(String[] args) {
        int [] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;

        System.out.println("Subset Sum: "+subsetSumExist(arr, sum, arr.length));
    }

    public static void memoize(int [][]t, int n, int sum){
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= sum; j++){
                t[i][j] = -1;
            }
        }
    }

    //DP
    public static Boolean subsetSumExist(int [] arr, int sum, int n){
        int [][] t = new int[n+1][sum+1];
        memoize(t, n, sum);
        //base case
        if(sum == 0){
            return true;
        }
        if(n == 0){
            return false;
        }
        if(t[n][sum] != -1){
            return (t[n][sum] == 1);
        }
        if(arr[n-1] <= sum){
            //include
            t[n][sum] = (subsetSumExist(arr, sum-arr[n-1], n-1) || subsetSumExist(arr, sum, n-1))?1:0;
        }else{
            t[n][sum] = subsetSumExist(arr, sum, n-1)?1:0;
        }
        return t[n][sum]==1;
    }
}
