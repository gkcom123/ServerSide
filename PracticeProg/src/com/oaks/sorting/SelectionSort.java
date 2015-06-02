/**
 * 
 */
package com.oaks.sorting;

/**
 * @author administrator
 *
 */
public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {64,25, 12, 22, 11};
		new SelectionSort().selectionSort(arr, arr.length);
		System.out.println(arr);


	}
	private void swap(int[] arr, int i,int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	private void selectionSort(int arr[], int n)
	{
	    int i, j, min_idx;
	 
	    // One by one move boundary of unsorted subarray
	    for (i = 0; i < n-1; i++)
	    {
	        // Find the minimum element in unsorted array
	        min_idx = i;
	        for (j = i+1; j < n; j++)
	          if (arr[j] < arr[min_idx])
	            min_idx = j;
	 
	        // Swap the found minimum element with the first element
	        swap(arr,min_idx, i);
	    }
	}

}
