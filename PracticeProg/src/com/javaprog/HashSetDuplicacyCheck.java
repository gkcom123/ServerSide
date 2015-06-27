/**
 * 
 */
package com.javaprog;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author gunjan
 *
 */
public class HashSetDuplicacyCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DemoObject d1 = new DemoObject("Gunjan", 31);
		DemoObject d2 = new DemoObject("Gunjan", 24);
		Set<DemoObject> s = new HashSet<DemoObject>();
		System.out.println(d1.hashCode());
		System.out.println(d2.hashCode());
		boolean b1 =s.add(d1);
		System.out.println(s);
		boolean b2 =s.add(d2);
		System.out.println(s);
		System.out.println(b1+"-"+b2);
		System.out.println("--------Hash Map implememntation--------------");
		Map<DemoObject, String> m= new HashMap<DemoObject, String>();
		m.put(d1, "gunjan age 31");
		System.out.println(d1.hashCode());
		System.out.println(m);
		String s2 = m.put(d2, "gunjan age 24");
		System.out.println(s2);
		System.out.println(d2.hashCode());
		System.out.println(m);
		

	}
	

}
class DemoObject
{
	
	private String name;
	private int age;
	public DemoObject(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DemoObject [age=" + age + ", name=" + name + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DemoObject other = (DemoObject) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
