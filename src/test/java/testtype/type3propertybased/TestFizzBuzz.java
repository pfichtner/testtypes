package testtype.type3propertybased;

import static org.assertj.core.api.Assertions.assertThat;
import static testtype.FizzBuzz.fizzBuzz;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;

class TestFizzBuzz {

	@Property
	boolean isDivisibleBy3_ShouldReturnFizz(@ForAll("divisibleBy3") int number) {
		// no assertion needed (but can be done), see next test
		return fizzBuzz(number).startsWith("Fizz");
	}

	@Property
	void isDivisibleBy5_ShouldReturnBuzz(@ForAll("divisibleBy5") int number) {
		assertThat(fizzBuzz(number)).endsWith("Buzz");
	}

	// both tests above also included the 15 as argument, so we had to verify using
	// #startsWith and #endsWith. How to avoid getting divisible by 15 values? We
	// can filter on the property as well on the provider method. First shown
	// filtering on the property.

	@Property
	boolean isDivisibleBy3ButNot15_ShouldExactlyBeFizz(@ForAll("divisibleBy3") int number) {
		Assume.that(number % 15 != 0);
		return fizzBuzz(number).equals("Fizz");
	}

	@Property
	void isDivisibleBy5ButNot15_ShouldExactlyBeBuzz(@ForAll("divisibleBy5") int number) {
		Assume.that(number % 15 != 0);
		assertThat(fizzBuzz(number)).isEqualTo("Buzz");
	}

	// now we know how to filter during property evaluation. How does filtering
	// during generation in the provider looks alike?

	@Property
	void isNotDivisibleBy3Nor5_ShouldReturnTheNumber(@ForAll("notDivisibleBy3Nor5") int number) {
		// we do NOT filter her but in the provider
		// Assume.that(number % 3 != 0);
		// Assume.that(number % 5 != 0);
		assertThat(fizzBuzz(number)).isEqualTo(String.valueOf(number));
	}

	@Provide
	Arbitrary<Integer> divisibleBy3() {
		return positiveAndDivisibleBy(3);
	}

	@Provide
	Arbitrary<Integer> divisibleBy5() {
		return positiveAndDivisibleBy(5);
	}

	Arbitrary<Integer> positiveAndDivisibleBy(int divisor) {
		return Arbitraries.integers().between(1, (Integer.MAX_VALUE - divisor + 1) / divisor).map(i -> i * divisor);
	}

	@Provide
	Arbitrary<Integer> notDivisibleBy3Nor5() {
		return Arbitraries.integers().greaterOrEqual(1).filter(i -> i % 3 != 0 && i % 5 != 0);
	}

}
