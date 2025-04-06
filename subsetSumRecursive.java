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
        //base case
        if(sum == 0){
            return true;
        }
        if(n == 0){
            return false;
        }

        if(arr[n-1] <= sum){
            //include
            return subsetSumExist(arr, sum-arr[n-1], n-1) || subsetSumExist(arr, sum, n-1);
        }else{
            return subsetSumExist(arr, sum, n-1);
        }
    }
}
