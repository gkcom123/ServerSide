/**
 * 
 */
package com.oaks.sorting;

/**
 * @author administrator
 *
 */
public class BubbleSortDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {64, 34, 25, 12, 22, 11, 90};
		 new BubbleSortDemo().bublleSortDemo(arr, arr.length);
		 new BubbleSortDemo().optimizedBubbleSort(arr, arr.length);

	}
	private void swap(int[] arr,int first, int sec)
	{
		int t = arr[first];
		arr[first]=arr[sec];
		arr[sec]=t;
	}
	private void bublleSortDemo(int[] arr,int n)
	{
		int i, j;
		for (i = 0; i < n-1; i++)
		{
			for (j = 0; j < n-i-1; j++) //Last i elements are already in place
			{
				if (arr[j] > arr[j+1])
				{
					swap(arr,j, j+1);
				}
		              
			}
		}
	}
	// An optimized version of Bubble Sort
	private void optimizedBubbleSort(int[] arr,int n)
	{
		int i,j;
		boolean swapped;
		for (i=0;i<n-1;i++)
		{
			swapped = false;
			for(j=0;j<n-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					swap(arr,j, j+1);
					swapped = true;
				}
			}
			// IF no two elements were swapped by inner loop, then break
		     if (swapped == false)
		        break;
			
		}
	}
}
