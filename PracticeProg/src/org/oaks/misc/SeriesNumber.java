/**
 * 
 */
package org.oaks.misc;

/**
 * @author administrator
 * Prob Statement : we have Fibonacci Series, Ex: 1 1 2 3 5 8 13 21 ...
 * Similarly We can have Trionacci like 1 1 1 3 5 9 17 ....
 * Quadnacci Series like 1 1 1 1 4 7 13 ...
 * This program will print the number exist at the passed location (2nd Arg) for a passed series number (1st Argument) 
 * 2: Fibonacci, 3: Trionacci etc 
 * 
 */
public class SeriesNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new SeriesNumber().getNumber(4, 6));

	}
	private int getNumber(int seriesCount,int point)
	{
		int[] sumArray = new int[seriesCount];
		int sum=0;
		for(int i=0;i<seriesCount;i++)
		{
			sumArray[i] = 1;
		}
		
		for(int j=0;j<point-seriesCount;j++)
		{
			sum =0;
			for(int k=0;k<sumArray.length;k++)
			{
				sum = sum+sumArray[k];
			}
			for(int l=sumArray.length-1;l>=0;l--)
			{
				
				if(l==0)
				{
					sumArray[l]= sum;
				}
				else
				{
					sumArray[l] = sumArray[l-1];
				}
			}
		}
		return sumArray[0];
	}

}
