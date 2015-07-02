package com.javaprog;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerComparator itc = new IntegerComparator();
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(10, itc);
		pQueue.offer(10);
		pQueue.offer(23);
		System.out.println(pQueue);
		System.out.println(pQueue.remove());

		PriorityQueue<Integer> pQueue2 = new PriorityQueue<Integer>(10);
		pQueue2.offer(10);
		pQueue2.offer(23);
		System.out.println(pQueue2);
		System.out.println(pQueue2.remove());
		

	}

}
class IntegerComparator implements Comparator<Integer>
{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o2-o1;
	}

	
}