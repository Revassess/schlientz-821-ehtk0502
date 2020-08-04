package com.revature.tier1;

public class SumOverArray {

	public static int IterateAndSum(int[] arr) {
		
		if(arr == null) {
			return 0;
		}
		
		int m_ans = 0;
		
		for(int i=0; i<arr.length; i++) {
			
			m_ans = m_ans + arr[i];
			
		}
		
		return m_ans;
	}
}
