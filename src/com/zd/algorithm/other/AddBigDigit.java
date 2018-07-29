package com.zd.algorithm.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 两个大数相加
 * @author zhangdi
 */
public class AddBigDigit {
	public static void main(String[] args) {

		String AStr = "3456";
		String BStr = "7890";

		int[] A = toIntArray(AStr);
		int[] B = toIntArray(BStr);
		
		System.out.println(Arrays.toString(add(A, B)));
	}

	// 数字的字符串转int数组
	private static int[] toIntArray(String num) {
		int len = num.length();
		int[] result = new int[len];
		for(int i=0;i<len;i++) {
			result[i] = num.charAt(i) - 48; // ‘0’的Ascll码 是 48
		}
		return result;
	}
	
	private static Integer[] add(int[] A, int[] B) {
		List<Integer> result = new ArrayList<Integer>();
		int ALen = A.length;
		int BLen = B.length;
		
		// 从数组的尾开始相加，即从个位开始相加
		int AIndex = ALen - 1;
		int BIndex = BLen - 1;
		int extra = 0;
		// 要考虑最高位相加之后有进位的情况
		while(AIndex >= 0 || BIndex >= 0 || extra != 0) {
			int tmp = 0;
			if(AIndex >= 0) {
				tmp += A[AIndex--];
			}
			if(BIndex >= 0) {
				tmp += B[BIndex--];
			}
			tmp += extra;
			
			result.add(0, tmp % 10);
			extra = tmp / 10;
		}
		Integer[] r = new Integer[result.size()];
		result.toArray(r);
		return r;
	}
}
