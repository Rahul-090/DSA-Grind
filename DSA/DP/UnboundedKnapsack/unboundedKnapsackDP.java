/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    
    
	public static void main(String[] args) {
	    int [] values = {5, 11, 13};
	    int [] weight = {2, 4, 6};
	    int W = 10;
	    int n = values.length;
	    int [][] t = new int[n+1][W+1];
		System.out.println("Maximum profit one can make: "+unboundedKnapsack(values, weight, n, W, t));
	}
	
	public static void memoize(int [][] t, int n, int W){
	    for(int i = 0; i <= n; i++){
	        for(int j = 0; j <= W; j++){
	            t[i][j] = -1;
	        }
	    }
	}
	
	//Dynamic Programming
	public static int unboundedKnapsack(int [] values, int [] weight, int n, int W, int [][] t){
	    
	    //initializing base condition
	    for(int i = 0; i <= n; i++){
	        for(int j = 0; j <= W; j++){
	            if(i == 0){
	                t[i][j] =  0;
	            }
	            if(j == 0){
	                t[i][j] = 0;
	            }
	        }
	    }
	    
	    for(int i = 1; i <= n; i++){
	        for(int j = 1; j <= W; j++){
	                    if(weight[i-1] <= j){
	                        t[i][j] = Math.max(values[i-1] + t[i][j-weight[i-1]], t[i-1][j]);
	                    }else{
	                        t[i][j] = t[i-1][j];
	                    }
	            }
	        }
	    
	    return t[n][W];
	    }
}
