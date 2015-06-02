/**
 * 
 */
package com.oaks.string;

/**
 * @author administrator
 *
 */
public class PatternSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String txt = "AABAACAADAABAAABAA";
		String pat = "AABA";
		new PatternSearch().patternSearch(txt.toCharArray(), pat.toCharArray());

	}
	private void patternSearch(char[] text,char[] pat)
	{
		int txtLenagth = text.length;
		int patLength = pat.length;
		for(int i=0;i<txtLenagth-patLength;i++)
		{
			int j;
			for (j=0;j<patLength;j++)
			{
				if(text[i+j] !=pat[j])
				{
					break;
				}
				
			}
			if(j==patLength)
			{
				System.out.println("Pattern found at index "+i);
			}
		}
	}

}
