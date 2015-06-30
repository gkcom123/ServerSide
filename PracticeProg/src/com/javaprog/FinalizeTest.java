package com.javaprog;

public class FinalizeTest extends MyTestFinalize{
	MyFin1 fin;
	public void executeMe(){
		System.out.println("Executed Derived");
	}
	
	FinalizeTest(){
		fin = new MyFin1();
		System.out.println("Derived -- Constructor");
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTestFinalize fin1 = new FinalizeTest();
		fin1.executeMe();
		fin1 = null;
		System.out.println("In main");
		System.gc();
	}

}
class MyTestFinalize{
	MyFin0 fin;
	MyTestFinalize(){
		fin = new MyFin0();
		System.out.println("Base -- Constructor");
	}
	
	public void executeMe(){
		System.out.println("Executed Base");
	}
	//Will I be executed???
	protected void finalize(){
		System.out.println("MyTestFinalize-BaseClass finalize -- Will I be executed???");
	}
}

class MyFin0{
	protected void finalize(){
		/*String s = null;
		s.length();*/
		System.out.println("MyFin0-Inner Object reference (BaseClass) finalize -- Will I be executed???");
	}
}

class MyFin1{
	protected void finalize(){
		/*String s = null;
		s.length();*/
		System.out.println("MyFin1-Inner Object reference (DerivedClass) finalize -- Will I be executed???");
	}
}