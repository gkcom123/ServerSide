/**
 * 
 */
package com.oaks.dynamicProg;

/**
 * @author administrator
 *
 */
public class FibonacciSeries {
	private int[] lookup = new int[100];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1;
		 new FibonacciSeries().initialize();
		int val =  new FibonacciSeries().fib(n);
		System.out.println(val);

	}
	private void initialize()
	{
	  int i;
	  for (i = 0; i < 100; i++)
	    lookup[i] = 0;
	}
	
	/* function for nth Fibonacci number */
	private int fib(int n)
	{
	   if(lookup[n] == 0)
	   {
	    if ( n <= 1 )
	      lookup[n] = n;
	    else
	      lookup[n] = fib(n-1) + fib(n-2);
	   }
	 
	   return lookup[n];
	}


}
