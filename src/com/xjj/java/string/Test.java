package com.xjj.java.string;

public class Test {
	
	private static String aString= "ab";
	
	public static void main(String[] args) {
//		String aString = "abcdefgh";
//		System.out.println(aString.replace("e", "b").indexOf("e"));	
	    String aString ="ab";
		final String bb = "b";
		String bString = "a"+bb;
		System.out.println(aString==bString);
		
		
		/*String s1= "a";
		String s2 = "b";
		String s3 = s1+s2;
		System.out.println(s3.intern()==aString);*/
		
		/*String aString="abcdefgh";
		System.out.println(aString.replace("e", "b").substring(1,7).lastIndexOf(b));
		*/
		
	
	}

}
