
class Solution {
    public static void main(String[] args) {
        int [] arr = {1, 1, 1, 1};
        int sum = sum(arr);
        int diff = 0;
        System.out.println("Subset with given difference: "+countSubsetWithGivenDifference(arr, sum, arr.length, diff));
    }

    public static int sum(int [] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum+=arr[i];
        }
        return sum;
    }

    public static int countSubsetWithGivenDifference(int [] arr, int sum, int n, int diff){
        if(diff > sum){
            return 0;
        }
        if((diff + sum)%2 != 0){
            return 0;
        }
        int sum1 = (diff + sum)/2;
        return countSubset(arr, sum1, n);
    }

    
    public static int countSubset(int [] arr, int sum, int n){
        int [][] t = new int[n+1][sum+1];
        
        //base case
        // for(int i = 0; i <= n; i++){
        //     for(int j = 0; j <= sum; j++){
        //         if(i == 0){
        //             t[i][j] = false;
        //         }
        //         if(j == 0){
        //             t[i][j] = true;
        //         }
        //     }
        // }
        t[0][0] = 1;

        //iterative code
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= sum; j++){
                if(arr[i-1] <= j){
                    //include or exclude
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }else{
                    //exclude
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
