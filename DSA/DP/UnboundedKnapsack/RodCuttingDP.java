/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
	    int N = 5;
	    int [] arr = {2, 5, 7, 8, 10};
		System.out.println("Rod Cutting Maximum profit: "+rodCutting(arr, N));
	}
	
	public static int rodCutting(int [] arr, int N){
	    
	    //intializing first row and column with zero
	    int [][] t = new int[N+1][N+1];
	    
	    for(int i = 1; i <= N; i++){
	        for(int j = 1; j <= N; j++){
	            if(i <= j){
	             t[i][j] = Math.max(arr[i-1] + t[i][j-i], t[i-1][j]);   
	            }else{
	                t[i][j] = t[i-1][j];
	            }
	        }
	    }
	    return t[N][N];
	}
}
