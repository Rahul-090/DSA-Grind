

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
	
	public static void memoize(int [][] arr, int n, int target){
	    for(int i = 0; i <= n; i++){
	        for(int j = 0; j <= target; j++){
	            arr[i][j] = -1;
	        }
	    }
	}
	
	public static Boolean equalPartition(int [] arr, int n, int sum){
	    int [][] t = new int[n+1][(sum/2)+1];
	    memoize(t, n, sum/2);
	    if(sum % 2 != 0){
	        return false;
	    }
	    return hasSubset(arr, n, sum/2, t);
	    
	}
	
	public static Boolean hasSubset(int [] arr, int n, int sum, int [][] t){
	    
	    if(sum == 0){
	        return true;
	    }
	    if(n == 0){
	        return false;
	    }
	    if(t[n][sum] != -1){
	        return t[n][sum] == 1;
	    }
	    if(arr[n-1] <= sum){
	        t[n][sum] = (hasSubset(arr, n-1, sum-arr[n-1], t) || hasSubset(arr, n-1, sum, t))?1:0 ;
	    }else{
	       t[n][sum] = (hasSubset(arr, n-1, sum, t))?1:0;
	    }
	    return t[n][sum]==1;
	}
	
	
	
	
}
