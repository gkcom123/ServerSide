package com.javaprog;

import java.util.*;

/**
* @author 
* Map is a wonderful collection, bringing us the niftiness of key/value pair collections 
* often found in other languages like Perl. And the JDK gives us a great Map implementation
*  in the form of the HashMap, which uses hashtables internally to support fast key lookups
*  for corresponding values. But therein lies a subtle problem:
*  Keys that support hash codes dependent on the contents of mutable fields are 
*  vulnerable to a bug that will drive even the most patient Java developer batty.
*
*/
public class MissingHash
{
  public static void main(String[] args)
  {
      Person p1 = new Person("Ted", "Neward", 39);
      Person p2 = new Person("Charlotte", "Neward", 38);
      System.out.println(p1.hashCode());
      
      Map<Person, Person> map = new HashMap<Person, Person>();
      map.put(p1, p2);
      System.out.println(map);
      
      p1.setLastName("Finkelstein");
      System.out.println(p1.hashCode());
      
      System.out.println(map.get(p1));
  }
}
class Person implements Iterable<Person>
{
  public Person(String fn, String ln, int a, Person... kids)
  {
      this.firstName = fn;
      this.lastName = ln;
      this.age = a;
      System.out.println("in cons");
      for (Person kid : kids)
      {
    	  System.out.println(kid);
    	  children.add(kid);
      }
         
  }
  public void setFirstName(String value) { this.firstName = value; }
  public void setLastName(String value) { this.lastName = value; }
  public void setAge(int value) { this.age = value; }
  
  public int hashCode() {
      return firstName.hashCode() & lastName.hashCode() & age;
  }
 private String firstName;
  private String lastName;
  private int age;
  private List<Person> children = new ArrayList<Person>();
	@Override
	public Iterator<Person> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [age=" + age + ", children=" + children + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}
}



