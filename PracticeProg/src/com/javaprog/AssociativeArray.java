/**
 * 
 */
package com.javaprog;

/**
 * @author gunjan
 * pairs = new Object[length][2] this is an array of array.
 * Here index 0 will have an array of size 2(key,value)
 * first[] is index position and second[] is an array.
 * map.put("Gunjan", "Kumar"); this will tell index 0 has an array of value {Gunjan,kumar}
 *
 */

public class AssociativeArray<K,V> {
	private Object[][] pairs;
	private int index;
	public AssociativeArray(int length) {
		super();
		pairs = new Object[length][2];
	}
	public void put(K key, V value) {
		if(index >= pairs.length)
			throw new ArrayIndexOutOfBoundsException();
		pairs[index++] = new Object[]{ key, value };
	}
	@SuppressWarnings("unchecked")
	public V get(K key) {
		for(int i = 0; i < index; i++)
			if(key.equals(pairs[i][0]))
				return (V)pairs[i][1];
		return null; // Did not find key
	}
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < index; i++) {
			result.append(pairs[i][0].toString());
			result.append(" : ");
			result.append(pairs[i][1].toString());
			if(i < index - 1)
				result.append("\n");
		}
		return result.toString();
	}
	public static void main(String[] args)
	{
		AssociativeArray<String,String> map = new AssociativeArray<String,String>(5);
		map.put("Gunjan", "Kumar");
		map.put("Ram", "Help");
		map.put("ocean", "dancing");
		map.put("tree", "tall");
		map.put("earth", "brown");
		try
		{
			map.put("Extra", "Inning");
		}
		catch(ArrayIndexOutOfBoundsException aie)
		{
			System.out.println("too many objects");
		}
		System.out.println(map);
		System.out.println(map.get("Gunjan"));
	}
	
}

