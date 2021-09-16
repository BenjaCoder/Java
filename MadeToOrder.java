package futilityCloset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MadeToOrder {

	public final static long MIN = 1023456789L;
	public final static long MAX = 9876543210L;
	
	public static boolean calculate(long answer) {
		String ansStr = Long.toString(answer);
		for (int i = 0; i < ansStr.length(); i++) {
			String partStr = ansStr.substring(0, i+1);
			double partInt = Long.parseLong(partStr);
			boolean wholeNumber = partInt / partStr.length() == Math.floor((partInt / partStr.length()));
			if (!wholeNumber)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		boolean printed = false;
		List<String> digits = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0"));
		for (long i = MIN; i < MAX; i += 9) {
			List<String> s = new ArrayList<>(Arrays.asList(Long.toString(i).split("")));
			if (!s.containsAll(digits)) {
				continue;
			}
			boolean x = MadeToOrder.calculate(i);
			if (x == true) {
				System.out.println(i); printed = true;
			}
		}
		if (!printed) {
			System.out.println(">> No solutions found.");
		}
	}	
}

/*
	The constants MIN and MAX are the corresponding minimum and maximum possible values for
	10-digit numbers (in which, for MIN, '0' cannot be the first digit, since it would then
	really be 9 digits in size)
	
	calculate() takes in a long (as numbers will easily surpass the int max of 2,147,483,647)
	and returns 'true' if the argument "passes", 'false' otherwise. A string version of the
	argument is gotten, and a new number is created each loop iteration to contain the next
	digit from left to right. The number represented by those digits is divided by its own
	length (i.e. 123 / 3; 4298 / 4), and to check if this is a whole number, that dividend is
	compared for equivalence to its floor'd self (a fractional number i.e. 12.75 will return
	'false'). As soon as a fractional number i.e. non-whole number is found, processing ends
	and 'false' is returned; if 'false' is never returned, the divisions were all successful
	in producing whole numbers, and 'true' is returned.
	  
 	main() - In each iteration value is split into an array and converted to a list, to take
 	advantage of the containsAll() method of Collections. The iteration value is compared to
 	the list of digits 0-9 to check that each of those digits are present; if any digit is
 	not found, the loop continues to the next iteration value. If a value is found to contain
 	0-9, it is passed to calculate() and is processed; if 'true' is returned, the value is
 	printed as a solution. If no solution is ever printed, a message of "No solutions found"
 	is printed so successful execution is made clear regardless of a found solution.
 	
 	Only one value was ever found to satisfy the original premise, "Arrange the digits 0-9
 	into a 10-digit number such that the leftmost n digits comprise a number divisible by n."
 	The solution is 3816547290.
*/