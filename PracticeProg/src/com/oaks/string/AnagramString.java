/**
 * 
 */
package com.oaks.string;

/**
 * @author administrator
 *
 */
public class AnagramString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnagramString agObj = new AnagramString();
		System.out.println(agObj.areAnagram("orchestra","carthorse"));

	}
	private boolean areAnagram(String s1,String s2)
	{
		if(s1.length()!= s2.length())
		{
			return false;
		}
		int countArray[] = new int[256];
		for(int i =0;i<s1.length();i++)
		{
			char c1= s1.charAt(i);
			int i1 = (int)c1;
			//System.out.println(i1);
			countArray[i1]++;
			char c2= s2.charAt(i);
			int i2 = (int)c2;
			countArray[i2]--;
			
		}
		//compare the count array
		for(int i =0;i<256;i++)
		{
			if(countArray[i]!=0)
			{
				return false;
			}
		}
		return true;
	}

}
