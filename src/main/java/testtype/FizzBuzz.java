package testtype;

public class FizzBuzz {

	public static String fizzBuzz(int number) {
		StringBuilder sb = new StringBuilder();
		sb = isDivisableBy(number, 3) ? sb.append("Fizz") : sb;
		sb = isDivisableBy(number, 5) ? sb.append("Buzz") : sb;
		sb = isEmpty(sb) ? sb.append(number) : sb;
		return sb.toString();

	}

	// instance method available with JDK15
	private static boolean isEmpty(StringBuilder sb) {
		// yes, length can't be less than zero, this is an "optimization" for mutation
		// tests, play around with it!
		return sb.length() <= 0;
	}

	private static boolean isDivisableBy(int number, int divisor) {
		return number % divisor == 0;
	}

}
