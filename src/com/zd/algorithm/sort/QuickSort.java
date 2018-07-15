package com.zd.algorithm.sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * 快速排序
 * 递归，非递归
 * 挖坑法、前后指针法
 * @author zhangdi
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] nums = { 2, 8, 7, 1, 3, 5, 6, 4, 5 };
		
		// 递归方式
//		quickSort(nums, 0, nums.length - 1);
		// 非递归-使用栈
		quickSortNotRecursion(nums, 0, nums.length - 1);
		System.out.println("nums:" + Arrays.toString(nums));
	}

	// 递归实现
	private static void quickSort(int[] numbers, int left, int right) {
		if (left < right) {
			// 分别使用“挖坑法”和“前后指针法”实现
//			int pivotIndex = partitionByWakeng(numbers, left, right);
			int pivotIndex = partitionByPrePostIndex(numbers, left, right);
			quickSort(numbers, left, pivotIndex - 1); // sort left of pivot
			quickSort(numbers, pivotIndex + 1, right); // sort right of pivot
		}
	}

	// 非递归实现
	private static void quickSortNotRecursion(int[] nums, int left, int right) {
		if(left >= right) return;
		
		Stack<Integer> stack = new Stack<>();
		stack.push(left);
		stack.push(right);
		
		while(!stack.empty()) {
			right = stack.pop();
			left = stack.pop();
			int pivotIndex = partitionByPrePostIndex(nums, left, right);
			if(pivotIndex - 1 > left) {
				stack.push(left);
				stack.push(pivotIndex - 1);
			}
			
			if(pivotIndex + 1 < right) {
				stack.push(pivotIndex + 1);
				stack.push(right);
			}
		}
	}
	
	// 挖坑法
	private static int partitionByWakeng(int[] nums, int left, int right) {
		int pivot = nums[left];
		while (left < right) {
			while (left < right && nums[right] >= pivot) {
				right--;
			}
			nums[left] = nums[right];
			while (left < right && nums[left] < pivot) {
				left++;
			}
			nums[right] = nums[left];
		}
		nums[left] = pivot; // 当left==right时，左侧都小于基值，右侧都大于等于，所以用基数填充
		return left;
	}
	
	// 前后指针
	private static int partitionByPrePostIndex(int[] nums, int left, int right) {
		int privot = nums[left];
		int preIndex = left - 1;
		
		for (int cur = left; cur <= right; cur++) {
			if(nums[cur] <= privot) {
				preIndex++;
				swap(nums, preIndex, cur);
			}
		}
		swap(nums, preIndex, left); // 这里的left就是一开始选基值的下标
		
		return preIndex;
	}

	private static void swap(int[] nums, int aIndex, int bIndex) {
		int tmp = nums[aIndex];
		nums[aIndex] = nums[bIndex];
		nums[bIndex] = tmp;
	}
}
