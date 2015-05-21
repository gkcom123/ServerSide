/**
 * 
 */
package com.oaks.searching;

/**
 * @author administrator
 *
 */
public class BinarySearchDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2, 3, 4, 10, 40};
		int n = arr.length;
		int x = 10;
		int result = new BinarySearchDemo().binarySearch(arr, 0, n-1, x);
		System.out.println("Element is present at index "+result);
		

	}
	private int binarySearch(int[] arr,int l,int r,int x)
	{
		if(r>=l)
		{
			int mid = l+(r-l)/2;
			  // If the element is present at the middle itself
	        if (arr[mid] == x)  return mid;
	 
	        // If element is smaller than mid, then it can only be present
	        // in left subarray
	        if (arr[mid] > x) return binarySearch(arr, l, mid-1, x);
	 
	        // Else the element can only be present in right subarray
	        return binarySearch(arr, mid+1, r, x);
		}
		return -1;
	}

}
