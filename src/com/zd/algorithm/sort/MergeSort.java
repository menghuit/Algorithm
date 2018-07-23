package com.zd.algorithm.sort;

import java.util.Arrays;

import com.zd.algorithm.Utils;

public class MergeSort {
	public static void main(String[] args) {
		int[] A = Utils.genRandomArray(10);
		System.out.println(Arrays.toString(A));
		
		sort(A, 0, A.length - 1);
		System.out.println(Arrays.toString(A));
	}

	private static void sort(int[] nums, int left, int right) {
		if (left >= right)
			return;
		int mid = (left + right) / 2;
		sort(nums, left, mid);
		sort(nums, mid + 1, right);
		merge(nums, left, right, mid);
	}

	private static void merge(int[] nums, int left, int right, int mid) {
		System.out.println(left+","+right+","+mid);
		int nL = mid - left + 1;
		int nR = right - mid;
		int[] AL = new int[nL];
		int[] AR = new int[nR];

		for (int i = 0; i < nL; i++) {
			AL[i] = nums[left + i];
		}

		for (int j = 0; j < nR; j++) {
			AR[j] = nums[mid + 1 + j];
		}

		int lIndex = 0, rIndex = 0;

		for (int k = left; k <= right; k++) {
			boolean isLOut = lIndex >= nL;
			boolean isROut = rIndex >= nR;
			if(isLOut && isROut) break;
			
			if (isROut || (!isLOut && AL[lIndex] <= AR[rIndex])) {
				nums[k] = AL[lIndex];
				lIndex++;
			} else {
				nums[k] = AR[rIndex];
				rIndex++;
			}
		}
	}
}
