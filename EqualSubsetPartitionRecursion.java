

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
	
	public static Boolean equalPartition(int [] arr, int n, int sum){
	    if(sum % 2 != 0){
	        return false;
	    }
	    return hasSubset(arr, n, sum/2);
	    
	}
	
	public static Boolean hasSubset(int [] arr, int n, int sum){
	    if(sum == 0){
	        return true;
	    }
	    if(n == 0){
	        return false;
	    }
	    if(arr[n-1] <= sum){
	        return hasSubset(arr, n-1, sum-arr[n-1]) || hasSubset(arr, n-1, sum) ;
	    }else{
	        return hasSubset(arr, n-1, sum);
	    }
	}
	
	
	
	
}
