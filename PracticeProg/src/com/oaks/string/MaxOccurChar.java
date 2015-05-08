/**
 * 
 */
package com.oaks.string;

/**
 * @author administrator
 *
 */
public class MaxOccurChar {

	/**
	 * @param args
	 * Return maximum occurring character in the input string
	 * if input string is “test string” then function should return ‘t’.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "teststring";
		MaxOccurChar obj = new MaxOccurChar();
		obj.getMaxOccuredChar(s);
		//char[] charArray = s.toCharArray();
		//System.out.println(charArray);

	}
	private void getMaxOccuredChar(String s)
	{
		int[] countArray = new int[26];
		int length = s.length();
		for(int i=0;i<length;i++)
		{
			int val = countArray[s.charAt(i)-97];
			System.out.println(val);
			countArray[s.charAt(i)-97] = val+1;
		}
		System.out.println(countArray);
		int max = countArray[0];
		int maxIndex = 0;
		for (int i =1;i<countArray.length;i++)
		{
			if(countArray[i]>max)
			{
				max = countArray[i];
				maxIndex = i;
			}
		}
		System.out.println(maxIndex+97);
	}

}
