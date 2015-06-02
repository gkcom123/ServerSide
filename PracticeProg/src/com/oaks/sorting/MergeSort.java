/**
 * 
 */
package com.oaks.sorting;

/**
 * @author administrator
 *
 */
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {12, 11, 13, 5, 6, 7};
	    new MergeSort().mergeSort(arr, 0, arr.length - 1);
	}
	/* Function to merge the two haves arr[l..m] and arr[m+1..r] of array arr[] */
	void merge(int arr[], int l, int m, int r)
	{
	    int i, j, k;
	    int n1 = m - l + 1;
	    int n2 =  r - m;
	 
	    /* create temp arrays */
	    int L[] = new int[n1];
	    int R[] = new int[n2];
	    
	 
	    /* Copy data to temp arrays L[] and R[] */
	    for(i = 0; i < n1; i++)
	        L[i] = arr[l + i];
	    for(j = 0; j < n2; j++)
	        R[j] = arr[m + 1+ j];
	 
	    /* Merge the temp arrays back into arr[l..r]*/
	    i = 0;
	    j = 0;
	    k = l;
	    while (i < n1 && j < n2)
	    {
	        if (L[i] <= R[j])
	        {
	            arr[k] = L[i];
	            i++;
	        }
	        else
	        {
	            arr[k] = R[j];
	            j++;
	        }
	        k++;
	    }
	 
	    /* Copy the remaining elements of L[], if there are any */
	    while (i < n1)
	    {
	        arr[k] = L[i];
	        i++;
	        k++;
	    }
	 
	    /* Copy the remaining elements of R[], if there are any */
	    while (j < n2)
	    {
	        arr[k] = R[j];
	        j++;
	        k++;
	    }
	}
	 
	/* l is for left index and r is right index of the sub-array
	  of arr to be sorted */
	void mergeSort(int arr[], int l, int r)
	{
	    if (l < r)
	    {
	        int m = l+(r-l)/2; //Same as (l+r)/2, but avoids overflow for large l and h
	        mergeSort(arr, l, m);
	        mergeSort(arr, m+1, r);
	        merge(arr, l, m, r);
	    }
	}

}
