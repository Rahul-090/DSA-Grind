
class Solution {
    public static void main(String[] args) {
        int [] arr = {35, 2, 8, 22};
        int sum = 0;
        System.out.println("Subset Sum: "+countSubset(arr, sum, arr.length));
    }

    
    public static int countSubset(int [] arr, int sum, int n){
        int [][] t = new int[n+1][sum+1];
        
        //base case
        t[0][0] = 1;

        //iterative code
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= sum; j++){
                if(arr[i-1] <= j){
                    //include or exclude
                    t[i][j] = (t[i-1][j-arr[i-1]] + t[i-1][j]);
                }else{
                    //exclude
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
