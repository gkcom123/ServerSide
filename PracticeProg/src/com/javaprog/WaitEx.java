package com.javaprog;


public class WaitEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A obj = new A();
		for(int i =0;i<2;i++)
		{
			if(i==1)
			{
				System.out.println("I m setting flag true");
				obj.setFlag(true);
			}
			TRunnable r = new TRunnable(obj);
			Thread t = new Thread(r);
			t.start();
			try{
				System.out.println("Wait for 2 sec. i m going to sleep ");
				Thread.sleep(2000);
			}
			catch(InterruptedException ir)
			{
				ir.printStackTrace();
			}
		}

	}

}
class A
{
	public synchronized void transfer() throws InterruptedException
	{
		if(!flag)
		{
			System.out.println("This is A, waiting");
			wait();
			System.out.println(Thread.currentThread().getName()+"-I got released. thanks");
		}
		System.out.println(Thread.currentThread().getName());
		notifyAll();
		
		
	}
	private boolean flag;
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
class TRunnable implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			a.transfer();
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		
	}
	private A a;
	TRunnable(A a) {
		super();
		this.a = a;
	}
	
}