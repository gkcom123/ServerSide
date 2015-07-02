/**
 * 
 */
package com.javaprog;

import java.util.Collections;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author gunjan
 *
 */
public class ComparatorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ItemComparator it1 = new ItemComparator();
		PriceComparator it2 = new PriceComparator();
		SortedSet<Item2> s = new TreeSet<Item2>(it2);
		s.add(new Item2("a", 24));
		s.add(new Item2("d", 40));
		s.add(new Item2("b", 4));
		System.out.println(s);
		SortedSet<Item2> s2 = new TreeSet<Item2>(it1);
		s2.add(new Item2("a", 24));
		s2.add(new Item2("d", 40));
		s2.add(new Item2("b", 4));
		System.out.println(s2);
		Collections.synchronizedSet(s);

	}

}
 class Item2
{
	private String description;
	private int price;
	public Item2(String description, int price) {
		super();
		this.description = description;
		this.price = price;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Item2 [description=" + description + ", price=" + price + "]";
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	
	
}
 class ItemComparator implements Comparator<Item2>
 {

	@Override
	public int compare(Item2 o1, Item2 o2) {
		return o1.getDescription().compareTo(o2.getDescription());
	}
	 
 }
 class PriceComparator implements Comparator<Item2>
 {

	@Override
	public int compare(Item2 o1, Item2 o2) {
		return o1.getPrice()-o2.getPrice();
	}
	 
 }
 