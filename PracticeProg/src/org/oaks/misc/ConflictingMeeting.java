/**
 * 
 */
package org.oaks.misc;

/**
 * @author administrator
 *
 */
public class ConflictingMeeting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval i1 = new Interval();
		i1.high = 5;
		i1.low = 1;
		Interval i2 = new Interval();
		i2.high = 7;
		i2.low = 3;
		Interval i3 = new Interval();
		i3.high = 60;
		i3.low = 20;
		Interval appt[] = new Interval[3];
		appt[0]= i1;
		appt[1]= i2;
		appt[2]= i3;
		
		new ConflictingMeeting().printConflicting(appt, appt.length);
	}
	
	// A utility function to create a new Interval Search Tree Node
	ITNode newNode(Interval i)
	{
	    ITNode temp = new ITNode();
	    temp.i = i;
	    temp.max = i.high;
	    temp.left = null;
	    temp.right = null;
	    return temp;
	}
	// A utility function to insert a new Interval Search Tree
	// Node. This is similar to BST Insert.  Here the low value
	//  of interval is used to maintain BST property
	ITNode insert(ITNode root, Interval i)
	{
	    // Base case: Tree is empty, new node becomes root
	    if (root == null)
	        return newNode(i);
	 
	    // Get low value of interval at root
	    int l = root.i.low;
	 
	    // If root's low value is smaller, then new interval
	    //  goes to left subtree
	    if (i.low < l)
	        root.left = insert(root.left, i);
	 
	    // Else, new node goes to right subtree.
	    else
	        root.right = insert(root.right, i);
	 
	    // Update the max value of this ancestor if needed
	    if (root.max < i.high)
	        root.max = i.high;
	 
	    return root;
	}
	// A utility function to check if given two intervals overlap
	boolean doOVerlap(Interval i1, Interval i2)
	{
	    if (i1.low < i2.high && i2.low < i1.high)
	        return true;
	    return false;
	}
	// The main function that searches a given interval i
	// in a given Interval Tree.
	Interval overlapSearch(ITNode root, Interval i)
	{
	    // Base Case, tree is empty
	    if (root == null) return null;
	 
	    // If given interval overlaps with root
	    if (doOVerlap((root.i), i))
	        return root.i;
	 
	    // If left child of root is present and max of left child
	    // is greater than or equal to given interval, then i may
	    // overlap with an interval is left subtree
	    if (root.left != null && root.left.max >= i.low)
	        return overlapSearch(root.left, i);
	 
	    // Else interval can only overlap with right subtree
	    return overlapSearch(root.right, i);
	}
	// This function prints all conflicting appointments in a given
	// array of appointments.
	void printConflicting(Interval appt[], int n)
	{
	     // Create an empty Interval Search Tree, add first
	     // appointment
	     ITNode root = null;
	     root = insert(root, appt[0]);
	 
	     // Process rest of the intervals
	     for (int i=1; i<n; i++)
	     {
	         // If current appointment conflicts with any of the
	         // existing intervals, print it
	         Interval res = overlapSearch(root, appt[i]);
	         if (res != null)
	         {
	        	 System.out.println("["+appt[i].low+","+appt[i].high+"] Conflicts with ["
	        	 		+ res.low +","+res.high+"]\n");
	         }
	         // Insert this appointment
	         root = insert(root, appt[i]);
	     }
	}
	 

}
//// Structure to represent an interval
class Interval 
{
	int low;
	int high;
}
//Structure to represent a node in Interval Search Tree
class ITNode
{
    Interval i;  // 'i' could also be a normal variable
    int max;
    ITNode left, right;
}

