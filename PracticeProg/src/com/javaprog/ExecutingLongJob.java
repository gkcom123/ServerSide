/**
 * 
 */
package com.javaprog;

/**
 * @author gunjan
 *
 */
public class ExecutingLongJob {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTask t = new MyTask();
		t.start();
		try {
			Thread.sleep(50L);
			flag = true;
			t.join();
			System.out.println("end");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	private static boolean flag = false;
	private static class MyTask extends Thread
	{
		public void run()
		{
			while(!flag)
			{
				System.out.println("in Mytask");
				//time consuming operation
			}
		}
	}

}
