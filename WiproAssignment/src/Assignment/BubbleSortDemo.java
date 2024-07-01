package Assignment;

import java.util.Arrays;

public class BubbleSortDemo {

		static int[] bubbleSorting(int a[], int n) {
			int i,j,temp;
			for(i=0;i<n-1;i++) {
				for(j=0;j<n-i-1;j++) {
					if(a[j]>a[j+1]) {
						temp = a[j];
						a[j] = a[j+1];
						a[j+1] = temp;
					}
				}
			}
			return a;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,6,3,5,8,1};
		int n = arr.length;
		
		System.out.println("Before Sorting....");
		System.out.println(Arrays.toString(arr));
		int[] result = BubbleSortDemo.bubbleSorting(arr, n);
		System.out.println("After sorting....");
		System.out.println(Arrays.toString(result));
	}

}