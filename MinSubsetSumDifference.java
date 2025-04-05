public class Main
{
	public static void main(String[] args) {
		int [] arr = {1, 3, 8, 11};
		int n = arr.length;
		int sum = sum(arr);
		System.out.println("Minimum difference in Subset Sum: "+minDifferenceSubsetSum(arr, n, sum));
	}
	
	public static int sum(int [] arr){
	    int sum = 0;
	    for(int i = 0; i < arr.length; i++){
	        sum+=arr[i];
	    }
	    return sum;
	}
	
	public static int minDifferenceSubsetSum(int [] arr, int n,int sum){
	    boolean [][] t = new boolean[n+1][sum+1];
	    
	    //base cases
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
	    
	    //finding the last row of t matrix to find the range
	    for(int i = 1; i <= n; i++){
	        for(int j = 1; j <= sum; j++){
	            if(arr[i-1] <= j){
	                t[i][j] = t[i-1][j] || t[i-1][j-arr[i-1]];
	            }else{
	                t[i][j] = t[i-1][j];
	            }
	        }
	    }
	    
	    //finding the minimum differenc using the last row of the t Range - 2s
	    int minDiff = Integer.MAX_VALUE;
	    for(int j = 0; j <= sum/2; j++){
	        if(t[n-1][j]){
	        minDiff = Math.min(minDiff, sum - 2*j);
	        } 
	    }
	    return minDiff;
	    
	    
	    
	}
}
