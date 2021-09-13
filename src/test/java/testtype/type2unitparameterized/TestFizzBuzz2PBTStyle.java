package testtype.type2unitparameterized;

import static org.assertj.core.api.Assertions.assertThat;
import static testtype.FizzBuzz.fizzBuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TestFizzBuzz2PBTStyle {

	@ParameterizedTest
	@ValueSource(ints = { 3, 6, 9, 12, 18, 21, 24, 27, 33 })
	void isDivisibleBy3_ShouldReturnFizz(int number) {
		assertThat(fizzBuzz(number)).isEqualTo("Fizz");
	}

	@ParameterizedTest
	@ValueSource(ints = { 5, 10, 20, 25, 35, 40, 50, 55, 65 })
	void isDivisibleBy5_ShouldReturnBuzz(int number) {
		assertThat(fizzBuzz(number)).isEqualTo("Buzz");
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 4, 7, 8, 11, 13, 14, 16, 17, 19, 22, 23, 26, 28, 29 })
	void notDivisibleBy3NorBy5_ShouldReturnTheNumber(int number) {
		assertThat(fizzBuzz(number)).isEqualTo(String.valueOf(number));
	}

}
