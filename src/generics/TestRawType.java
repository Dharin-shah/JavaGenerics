/**
 * 
 */
package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/** This Class Tests Best Practices for using Generics by Avoiding raw types */

/* Class for Testing */
class Stamp{
	private int id;
	
	public Stamp(int a){
		id = a;
	}
	
	public int get(){
		return id;
	}
}

public class TestRawType {
	public static void main(String abc[]){
		
		/* no compile-time error, only warnings generated */
		
		/* our Stamps Collection -- RAW TYPE COLLECTION */
		final Collection stamps_1 = new ArrayList(); 
		stamps_1.add(new Stamp(5));
		
		/* adversary attacks our collection by inserting non-stamp type and succeeds */
		stamps_1.add(new Integer(2)); 
		
		/* error during run-time */
		/* RAW TYPE ITERATOR */
		for(Iterator i = stamps_1.iterator(); i.hasNext();){
			Stamp s = (Stamp)i.next(); //Will Definitely Throw java.lang.ClassCastException
		}
		
		/** To Avoid Run-time error which is what always desired, 
		 * enforce type-check at compile time by avoiding raw type and parameterizing 
		 * the generic type. 
		 * */
		
		/** With generics, you can tell the compiler what 
		 * type is permitted in the collection at compile time.*/
		
		/* No Warnings after this point */
		final Collection<Stamp> stamps_2 = new ArrayList<Stamp>();
		stamps_2.add(new Stamp(4));
		/* Compile-time error. Wont allow non-stamp type to be added in the collection 
		 * as it checks at compile-time  */
		@SuppressWarnings("unused")
		Stamp s;
		//stamps_2.add(new Integer(4)); 
		for(Iterator<Stamp> i = stamps_2.iterator(); i.hasNext();){
			s = i.next(); //No Cast needed, Iterator is of Stamp.
		}
		
		/** List of arbitrary Object type vs raw type */
		
		Collection<Object> object = new ArrayList<Object>();
		object.add("Hello");
		//String s = ()object.remove("Hello");
		
	}
}
