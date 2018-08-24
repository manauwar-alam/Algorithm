package com.manauwar.sort;

public class MergeSort {
	
	
	// Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
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
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
        
    }
    
    
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    
    
    /* Iterative mergesort function to sor
    t arr[0...n-1] */
    static void sortIterative(int arr[], int n)
    {
         
        // For current size of subarrays to
        // be merged curr_size varies from 
        // 1 to n/2
        int curr_size; 
                     
        // For picking starting index of 
        // left subarray to be merged
        int left_start;
                         
         
        // Merge subarrays in bottom up 
        // manner. First merge subarrays 
        // of size 1 to create sorted 
        // subarrays of size 2, then merge
        // subarrays of size 2 to create 
        // sorted subarrays of size 4, and
        // so on.
        for (curr_size = 1; curr_size <= n-1; curr_size = 2*curr_size)
        {
             
            // Pick starting point of different
            // subarrays of current size
            for (left_start = 0; left_start < n-1;
                        left_start += 2*curr_size)
            {
                // Find ending point of left 
                // subarray. mid+1 is starting 
                // point of right
                int mid = left_start + curr_size - 1;
         
                int right_end = Math.min(left_start 
                             + 2*curr_size - 1, n-1);
         
                // Merge Subarrays arr[left_start...mid]
                // & arr[mid+1...right_end]
                mergeIterative(arr, left_start, mid, right_end);
            }
        }
    }
     
    /* Function to merge the two haves arr[l..m] and
    arr[m+1..r] of array arr[] */
    static void mergeIterative(int arr[], int l, int m, int r)
    {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;
     
        /* create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
     
        /* Copy data to temp arrays L[]
        and R[] */
        for (i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (j = 0; j < n2; j++)
            R[j] = arr[m + 1+ j];
     
        /* Merge the temp arrays back into
        arr[l..r]*/
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
     
        /* Copy the remaining elements of 
        L[], if there are any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
     
        /* Copy the remaining elements of
        R[], if there are any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
     
    /* Function to print an array */
    static void printArray(int A[], int size)
    {
        int i;
        for (i=0; i < size; i++)
            System.out.printf("%d ", A[i]);
        System.out.printf("\n");
    }
     
    /* Driver program to test above functions 
    public static void main(String[] args)
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;
     
        System.out.printf("Given array is \n");
        printArray(arr, n);
     
        sortIterative(arr, n);
     
        System.out.printf("\nSorted array is \n");
        printArray(arr, n);
    }*/

}
