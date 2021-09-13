package testtype.type1unit;

import static org.assertj.core.api.Assertions.assertThat;
import static testtype.FizzBuzz.fizzBuzz;

import org.junit.jupiter.api.Test;

class FizzBuzzTest {

	@Test
	void canConvertOne() {
		assertThat(fizzBuzz(1)).isEqualTo("1");
	}

	@Test
	void canConvertThree() {
		assertThat(fizzBuzz(3)).isEqualTo("Fizz");
	}

	@Test
	void canConvertSix() {
		assertThat(fizzBuzz(6)).isEqualTo("Fizz");
	}

	@Test
	void canConvertFive() {
		assertThat(fizzBuzz(5)).isEqualTo("Buzz");
	}

	@Test
	void canConvertFifteen() {
		assertThat(fizzBuzz(15)).isEqualTo("FizzBuzz");
	}

}
