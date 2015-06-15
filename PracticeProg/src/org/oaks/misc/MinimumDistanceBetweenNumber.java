/**
 * 
 */
package org.oaks.misc;

/**
 * @author administrator
 *
 */
public class MinimumDistanceBetweenNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] ={3, 5, 4, 2, 6, 4, 0, 0, 5, 4, 8, 3};
		System.out.println(new MinimumDistanceBetweenNumber().minDistanceEff(arr, 3, 6));
		

	}
	
	private int minDistance(int[] arr, int first, int last)
	{
		int min = arr.length;
		for(int i = 0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				if(((first==arr[i] && last==arr[j])||(first==arr[j] && last==arr[i])) && min>Math.abs(i-j))
				{
					min = Math.abs(i-j);
				}
			}
		}
		return min;
	}
	private int minDistanceEff(int[] arr, int first, int last)
	{
		int min = arr.length;
		int prev =0;
		for(int i = 0;i<arr.length;i++)
		{
			if(arr[i]==first || arr[i]==last)
			{
				prev = i;
				break;
			}
		}
		//Traverse after the first occurence
		   for ( int j = prev+1; j < arr.length; j++)
		   {
		      if (arr[j] == first || arr[j] == last)
		      {
		          // If the current element matches with any of the two then
		          // check if current element and prev element are different
		          // Also check if this value is smaller than minimm distance so far
		          if ( arr[prev] != arr[j] && (j - prev) < min )
		          {
		             min = j - prev;
		             prev = j;
		          }
		          else
		             prev = j;
		      }
		   }
		return min;
	}

}
