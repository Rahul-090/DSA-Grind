/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
	    int A = 5;
	    int [] arr = {1, 2, 5};
		System.out.println("Number of way to change coin: "+coinChange(arr, A));
	}
	
	public static int coinChange(int [] arr, int A){
	    int n = arr.length;
	    int [][] t = new int[n+1][A+1];
	    
	    for(int i = 0; i <= n; i++){
	        for(int j = 0; j <= A; j++){
	            if(j == 0){
	                t[i][j] = 1;
	            }
	        }
	    }
	    
	    for(int i = 1; i <= n; i++){
	        for(int j = 1; j <= A; j++){
	            if(arr[i-1] <= j){
	                t[i][j] = t[i][j-arr[i-1]] + t[i-1][j];
	                }else{
	                    t[i][j] = t[i-1][j];
	                }
	        }
	    }
	    
	    return t[n][A];
	}
}
