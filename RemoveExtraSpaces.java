package com.revise.anubha.java.algo;

/*So let's say you've got a set of source files in C, C++, or Java. Your choice. And I want you to modify them so that in each source file, every open- and close-paren has exactly one space character before and after it. If there is any other whitespace around the paren, it's collapsed into a single space character.

For instance, this code:


foo (bar ( new Point(x, graph.getY()) ));

Would be modified to look like this:

foo ( bar ( new Point ( x, graph.getY ( ) ) ) ) ;

I tell you (as your manager) that I don't care how you solve this problem. You can take the code down to Kinko's Copies and manually cut and paste the characters with scissors if you like.

How will you solve this problem?*/
public class RemoveExtraSpaces {
	public static void main(String[] args){
		
		String s = "Test     (    something )       )       )        )     111";
		
		s = s.replaceAll("\\s+", " ");
		System.exit(0);
	}
}
