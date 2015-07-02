/**
 * 
 */
package com.javaprog;

/**
 * @author gunjan
 *
 */
public class JoinDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadA d = new ThreadA();
		Thread t1 = new Thread(d,"Thread A");
		t1.start();
		
		try {
			System.out.println("Main is going to join ThreadA");
			t1.join();
			
			//t1.join(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main joined  ThreadA");

	}

}
class ThreadA implements Runnable
{

	@Override
	public void run() {
		try {
			System.out.println("A is sleeping  for 1000 ms");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Thread A interrupted.");
		}
		System.out.println("Leaving A");
	}
	
}