package testtype;

public class FizzBuzz {

	public static String fizzBuzz(int number) {
		StringBuilder sb = new StringBuilder();
		sb = divBy(number, 3) ? sb.append("Fizz") : sb;
		sb = divBy(number, 5) ? sb.append("Buzz") : sb;
		sb = sb.length() == 0 ? sb.append(number) : sb;
		return sb.toString();

	}

	private static boolean divBy(int number, int divisor) {
		return number % divisor == 0;
	}

}
