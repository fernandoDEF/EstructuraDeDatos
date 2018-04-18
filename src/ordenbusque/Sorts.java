package ordenbusque;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Scanner;

public class Sorts {
	
	public int[] bubbleSort(int[] unsorted)
	{
		boolean swap = false;
		int temp;
		
		do
		{
			swap = false;
			for( int i = 0; i < (unsorted.length -1); i++)
			{
				if(unsorted[i] > unsorted[i+1])
				{
					temp = unsorted[i];
					unsorted[i]= unsorted[i+1];
					unsorted[i+1] = temp;
					swap = true;
					
				}
			}
		}
		while(swap);
		return unsorted;
	}
	
	public void insertionSort(int[] unsorted)
	{
		int temp, indexHole;
		
		for(int i = 1; i < unsorted.length; i++)
		{
			temp = unsorted[i];
			indexHole = i;
			
			while(indexHole > 0 && unsorted[indexHole -1] > temp)
			{
				unsorted[indexHole] = unsorted[indexHole - 1];
				indexHole -= 1;
			}
			unsorted[indexHole] = temp;
		}
	}
	
	public int[] mergeSort(int[] unsorted)
	{
		int size;
		if (unsorted.length > 1)
		{
			size = unsorted.length / 2;
			int[] left_array = new int[size];
			int[] right_array = new int[unsorted.length - size];
			
			for(int i = 0; i<size ; i++)
				left_array[i] = unsorted[i];
			
			for(int i = size; i < unsorted.length; i++)
				right_array[i -size] = unsorted[i];
			
			
			left_array = mergeSort(left_array);
			right_array = mergeSort(right_array);
			
			return merge(left_array, right_array);
		}
		return unsorted;
	}

	public int[] merge(int[] a, int[] b) {	
		int i = 0, j = 0, k = 0; // i: indexA, j: indexB, k: indexC
		int l = a.length+b.length;	
		int[] c = new int[l];

		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				c[k] = a[i];
				i++;
			} else {
				c[k] = b[j];
				j++;
			}
			k++;
		}
		while(i < a.length) {
			c[k] = a[i];
			i++;
			k++;
		}
		while (j < b.length) {
			c[k] = b[j];
			j++;
			k++;
		}
		return c;
	}
	
	public void countingShort(int[] unsorted) 
	{
		int max = Integer.MIN_VALUE;
		int[] aux;
		int index = 0;
		
		for(int i = 0; i < unsorted.length; i++) 
			if(unsorted[i] > max)
				max = unsorted[i];
		
		aux= new int[max + 1];
		
		for(int i = 0; i < unsorted.length; i++)
				aux[unsorted[i]] +=1;
		
	    for(int i = 0; i < aux.length; i++)
	    	for(int j = 0; j < aux[i]; j++)
	    	{
	    		unsorted[index] = i;
	    		index +=1;
	    	}
    }
	
	public int binarySearch(int[] a, int x)
	{
		int lower = 0;
		int upper = a.length - 1;
		int index = - 1;
		int middlePoint;
		
		while(lower < upper) 
		{
			middlePoint = (lower + upper)/2;
			
			if (x==a[middlePoint]) 
			{
				index = middlePoint;
				break;
			}
			else if (x < a[middlePoint])
			{
				upper = middlePoint - 1;
			}
			else
			{
				lower = middlePoint + 1;
			}
		 }
		 if((lower == upper) && (a[lower] == x))
		 {
			 index = lower;
		 }
		 return index;	
	}
	
	public int searchBinaryRecursive(int[] a, int x, int lower, int upper)
	{
		int middlePoint = (lower + upper)/2;
		if (lower == upper)
		{
			if(x == a[middlePoint])
			{
				return middlePoint;
			}
			else 
			{
				return - 1;
			}
		}
		else
		{
			if (x==a[middlePoint])
			{
				return middlePoint;
			}
			else
			{
				if(x < a[middlePoint])
				{
					return searchBinaryRecursive(a, x, lower, middlePoint);
				}
				else
				{
					return searchBinaryRecursive(a, x, middlePoint + 1, upper);
				}
			}
		}
		
	}
	
	public int interpolationSearch(int[] a, int x)
	{
		int lower = 0;
		int upper = a.length - 1;
		int index = -1;
		
		while(lower < upper) 
		{
			int middlePoint = lower + (upper -lower)/(a[upper]-a[lower])*(x - a[lower]);
			
			System.out.println(middlePoint);
			
			if (x == a[middlePoint])
			{
				index = middlePoint;
				break;
			}
			else
			{
				if (x < a[middlePoint])
				{
					upper = middlePoint - 1;
				}
				else
				{
					lower = middlePoint + 1;
				}
			}
			if ((lower == upper) && (a[lower] == x))
			{
				index = lower;
			}
		}	
		return index;		
	}
	/*
	public int[] quickSort(int[] a)
	{
		int j = 0;
		if (a[j] > a[j+1])
		{
			return a;
		}
		else
		{
			int pivot = a[0];
			int less_subarray;
			int greater_subarray;
			for (int i = 1; i < a.length; i++)
			{
				if (a[i] < pivot)
				{
					less_subarray = a[i];
				}
				else
				{
					greater_subarray = a[i];
				}
				
				int[] unsorted = (quickSort(less_subarray)) + (pivot) + quickSort(greater_subarray);
				return unsorted;
			}
		}
	}
	*/
	public void printArray(int[] array) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for( int i = 0; i < array.length -1; i++)
		
			bw.write(array[i] + " ");
			
			bw.write("\n");
			bw.flush();
	}
	
	public int[] bigArray(int lenght)
	{
		Random rd = new Random();
		int[] temp = new int[lenght];
		
		for(int i = 0; i< lenght; i++)
			temp[i] = rd.nextInt(50);
		
		return temp;
	}

	public static void main(String[] args) throws IOException 
	{
		
		
		Sorts sorts = new Sorts();
		
		int[] a = sorts.bigArray(50);
		int[] b = a.clone();
		int[] ar = sorts.mergeSort(a);
		int x = 20;
		
		sorts.printArray(a);
		//sorts.countingShort(a);
		//sorts.binarySearch(a,20);
		
		//sorts.searchBinaryRecursive(a, 10, 1, 100);
		sorts.interpolationSearch(ar,x);
		
		
		//sorts.printArray(a);
		/*
		long startTime1 = System.nanoTime();
		a = sorts.mergeSort(a);
		sorts.printArray(a);
		long endTime1 = System.nanoTime();
		System.out.println(endTime1-startTime1);
		
		sorts.printArray(b);
		long startTime2 = System.nanoTime();
		sorts.countingShort(a);
		sorts.printArray(a);
		long endTime2 = System.nanoTime();
		System.out.println(endTime2-startTime2);
		*/
		
	}
}
