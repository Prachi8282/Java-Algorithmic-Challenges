import java.io.*;
import java.util.*;

class GFG {

	public static String ReverseString(String str)
	{
		char[] reverseString = new char[str.length()];
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
		}

		int i = 0;
		while (!stack.isEmpty()) { 
			reverseString[i++] = stack.pop();
		}
		return new String(reverseString);
	}

	public static void main(String[] args)
	{
		String str1 = "HacktoberFest";
		
		System.out.println(str1 + " <- Reverse -> "
						+ ReverseString(str1));
		
		String str2 = "Hello World";
		
		System.out.println(str2 + " <- Reverse -> "
						+ ReverseString(str2));
	}
}
