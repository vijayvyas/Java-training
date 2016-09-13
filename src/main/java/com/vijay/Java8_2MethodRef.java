package com.vijay;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Kind	Example
Reference to a static method	ContainingClass::staticMethodName
Reference to an instance method of a particular object	containingObject::instanceMethodName
Reference to an instance method of an arbitrary object of a particular type	ContainingType::methodName
Reference to a constructor	ClassName::new*/

public class Java8_2MethodRef {
	public static void main(String args[]){
	      List names = new ArrayList();
			
	      names.add("Mahesh");
	      names.add("Suresh");
	      names.add("Ramesh");
	      names.add("Naresh");
	      names.add("Kalpesh");
			
	      names.forEach(System.out::println);
	      
	      Comparison myComparison = new Comparison();
	      Arrays.sort((String[])names.toArray(new String[5]), myComparison::compare);
	   }
	}
class Comparison {
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
}
