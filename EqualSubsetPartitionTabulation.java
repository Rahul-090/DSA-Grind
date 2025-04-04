

public class Main
{
    public static int sum(int [] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum+=arr[i];
        }
        return sum;
    }
    
	public static void main(String[] args) {
	    
        int [] arr = {2, 8, 3, 11, 2};
        int n = arr.length;
        int sum = sum(arr);
        
        System.out.println("Can partition into equal sum subset: "+equalPartition(arr, n, sum));
        
	}
	
	public static void baseCase(boolean [][] t, int n, int target){
	    
	}
	
	public static Boolean equalPartition(int [] arr, int n, int sum){
	    boolean [][] t = new boolean[n+1][(sum/2)+1];
	    baseCase(t, n, sum/2);
	    if(sum % 2 != 0){
	        return false;
	    }
	    return hasSubset(arr, n, sum/2, t);
	    
	}
	
	public static Boolean hasSubset(int [] arr, int n, int sum, boolean [][] t){
	    
	    for(int i = 1; i <= n; i++){
	        for(int j = 1; j <= sum; j++){
	            if(arr[i-1] <= j){
	                t[i][j] = t[i-1][j] || t[n-1][j-arr[i-1]] ;
	            }else{
	                t[i][j] = t[i-1][j];
	                }
	            }
	    }
	    return t[n][sum];
	}
}
