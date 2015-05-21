/**
 * 
 */
package com.oaks.sorting;

/**
 * @author administrator
 *
 */
public class QuickSortDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[] = {10, 7, 8, 9, 1, 5};
		int arr[] = {10, 15, 1, 4, 7, 9};
		
	    QuickSortDemo qDemo = new QuickSortDemo();
	    qDemo.quickSort(arr, 0, arr.length-1);
	   System.out.println(arr);

	}
	private void swap(int[] arr,int first, int sec)
	{
		int t = arr[first];
		arr[first]=arr[sec];
		arr[sec]=t;
	}
	/* This function takes last element as pivot, places the pivot element at its
	   correct position in sorted array, and places all smaller (smaller than pivot)
	   to left of pivot and all greater elements to right of pivot */
	private int partition (int arr[], int l, int h)
	{
	    int x = arr[h];    // pivot, its last element
	    int i = (l - 1);  // Index of smaller element
	 
	    for (int j = l; j <= h- 1; j++)
	    {
	        // If current element is smaller than or equal to pivot 
	        if (arr[j] <= x)
	        {
	            i++;    // increment index of smaller element
	            swap(arr,i, j);  // Swap current element with index
	        }
	    }
	    swap(arr,i + 1,h);  
	    return (i + 1);
	}
	private void quickSort(int arr[], int l, int h)
	{
	    if (l < h)
	    {
	        int p = partition(arr, l, h); /* Partitioning index */
	        quickSort(arr, l, p - 1);
	        quickSort(arr, p + 1, h);
	    }
	}
}
	
