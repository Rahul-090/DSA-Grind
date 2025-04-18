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
		System.out.println("Maximum profit one can make: "+unboundedKnapsack(values, weight, values.length, W));
	}
	
	//Recursion
	public static int unboundedKnapsack(int [] values, int [] weight, int n, int W){
	    if(W == 0){
	        return 0;
	    }
	    if(n == 0){
	        return 0;
	    }
	    
	    if(weight[n-1] <= W){
	        return Math.max(values[n-1] + unboundedKnapsack(values, weight, n, W-weight[n-1]), unboundedKnapsack(values, weight, n-1, W));
	    }else{
	        return unboundedKnapsack(values, weight, n-1, W);
	    }
	}
}
