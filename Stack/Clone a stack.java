// Java Code to count minimum reversal for
// making an expression balanced.
import java.util.*;
public class GFG {

	// Method count minimum reversal for
	// making an expression balanced.
	// Returns -1 if expression cannot be balanced
	static int countMinReversals(String expr)
	{
		int len = expr.length();
		int ans;
	
		// Expressions of odd lengths
		// cannot be balanced
		if (len % 2 != 0) {
			return -1;
		}
		int left_brace = 0, right_brace = 0;
		for (int i = 0; i < len; i++) {
			char ch = expr.charAt(i);
		
			// If we find a left bracket then we simply
			// increment the left bracket
			if (ch == '{') {
				left_brace++;
			}
		
			// Else if left bracket is 0 then we find
			// unbalanced right bracket and increment
			// right bracket or if the expression
			// is balanced then we decrement left
			else {
				if (left_brace == 0) {
					right_brace++;
				}
				else {
					left_brace--;
				}
			}
		}
		ans = (int)(Math.ceil((0.0 + left_brace) / 2)
					+ Math.ceil((0.0 + right_brace) / 2));
		return ans;
	}

	// Driver method
	public static void main(String[] args)
	{
		String expr = "}}{{";

		System.out.println(countMinReversals(expr));
	}
}
