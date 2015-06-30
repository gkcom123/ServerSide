/**
 * 
 */
package com.javaprog;

/**
 * @author gunjan
 *
 */
public class ProtectedSamePackageDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A1 a = new A1();
		//can be accessed without inheritance
		System.out.println(a.s);
		B1 obj = new B1();
		obj.B1Method();

	}

}
class A1{
	protected int s =9;
}
class B1 extends A1
{
	//int s = 10;
	public void B1Method()
	{
		//acessed with inheritance
		System.out.println(s);
		B1 obj = new B1();
		System.out.println(obj.s);
		A1 a = new A1();
		System.out.println(a.s);
		A1 a2 = new B1();
		System.out.println(a2.s);
		
	}
}

