package com.zd.algorithm.sort;

import java.util.Arrays;

import com.zd.algorithm.Utils;

/**
 * 堆排序
 * 
 * @author zhangdi 
 * 堆性质：除根结点外，满足 A[Parent(i)] >= A[i](最大堆) 或 A[Parent(i)] <= A[i](最小堆) 
 * 以下伪代码，从1开始计
 * Parent(i) = i / 2; 
 * Left(i) = i * 2; 
 * Right(i) = i * 2 + 1;
 */
public class HeapSort {

	public static void main(String[] args) {
		int[] arrays = Utils.genRandomArray(10);
		System.out.println(Arrays.toString(arrays));

		sort(arrays);
		System.out.println("sort:" + Arrays.toString(arrays));
	}

	// 父结点
	private static int parent(int i) {
		return i - 1 / 2;
	}

	// 左子结点
	private static int left(int i) {
		return i * 2 + 1;
	}

	// 右子结点
	private static int right(int i) {
		return i * 2 + 2;
	}

	// 维护堆属性
	// 从左右子结点中选出比当前结点大的，进行交换，且逐级向下执行，
	// 直到以index为根结点的子树满足最大堆属性
	private static void maxHeapify(int[] A, int heapSize, int index) {
		int largest = index;
		int l = left(index);
		int r = right(index);

		if (l < heapSize && A[l] > A[index]) {
			largest = l;
		}
		if (r < heapSize && A[r] > A[largest]) {
			largest = r;
		}
		if (largest != index) {
			Utils.swap(A, largest, index);
			maxHeapify(A, heapSize, largest);
		}
	}

	// 建立最大堆
	// 依据推导：当堆的大小为n时，叶子结点下标分别为[n/2]+1,[n/2]+2...[n](这个推导，下标从1开始)
	// 从后往前遍历所有的非叶子结点，就可以得到一个最大堆。
	private static void buildMaxHeap(int[] A) {
		int len = A.length;
		// 最后一个非叶子结点开始向前遍历，保证以结点为根的子树满足最大堆性质
		for (int i = (len / 2) - 1; i >= 0; i--) {
			maxHeapify(A, len, i);
		}
	}

	// 堆排序
	private static void sort(int[] A) {
		// 建堆
		buildMaxHeap(A);
		System.out.println("build:" + Arrays.toString(A));

		// 排序
		int len = A.length;
		int heapSize = len;
		for (int i = len - 1; i >= 1; i--) {
			Utils.swap(A, i, 0);
			maxHeapify(A, --heapSize, 0);
		}
	}
}
