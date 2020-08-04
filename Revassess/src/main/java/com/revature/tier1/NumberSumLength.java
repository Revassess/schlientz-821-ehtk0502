package com.revature.tier1;

import java.lang.Math; 

public class NumberSumLength {

	public static boolean checkNumberPowerLength(long num) {
		
		String m_num = String.valueOf(num);
		System.out.println(m_num);
		
		int len = m_num.length();
		System.out.println(len);
		
		int m_ans = 0;
		
		for(int i= len-1; i > -1; i--) {
			
			m_ans += Math.pow(Integer.valueOf(m_num.charAt(i))-48, len);
			
		}
		
		if(m_ans == num) {
			return true;
		}
		
		
		return false;
	}
}
