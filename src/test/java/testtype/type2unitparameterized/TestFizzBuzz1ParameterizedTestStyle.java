package testtype.type2unitparameterized;

import static org.assertj.core.api.Assertions.assertThat;
import static testtype.FizzBuzz.fizzBuzz;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class TestFizzBuzz1ParameterizedTestStyle {

	@ParameterizedTest
	@CsvSource(value = { "1:1", "2:2", "3:Fizz", "4:4", "5:Buzz", "6:Fizz", "7:7", "8:8", "9:Fizz", "10:Buzz", "11:11",
			"12:Fizz", "13:13", "14:14", "15:FizzBuzz", "16:16", "17:17", "18:Fizz", "19:19", "20:Buzz", "21:Fizz",
			"22:22", "23:23", "24:Fizz", "25:Buzz", "26:26", "27:Fizz", "28:28", "29:29",
			"30:FizzBuzz", }, delimiter = ':')
	void parameterizedTestViaCsvSource(int number, String expected) {
		assertThat(fizzBuzz(number)).isEqualTo(expected);
	}

	@ParameterizedTest
	@MethodSource("parameterizedTestArgs")
	void parameterizedTestViaMethodSource(int number, String expected) {
		assertThat(fizzBuzz(number)).isEqualTo(expected);
	}

	static Stream<Arguments> parameterizedTestArgs() {
		return Stream.of( //
				Arguments.of(1, "1"), //
				Arguments.of(2, "2"), //
				Arguments.of(3, "Fizz"), //
				Arguments.of(4, "4"), //
				Arguments.of(5, "Buzz"), //
				Arguments.of(6, "Fizz"), //
				Arguments.of(7, "7"), //
				Arguments.of(8, "8"), //
				Arguments.of(9, "Fizz"), //
				Arguments.of(10, "Buzz"), //
				Arguments.of(11, "11"), //
				Arguments.of(12, "Fizz"), //
				Arguments.of(13, "13"), //
				Arguments.of(14, "14"), //
				Arguments.of(15, "FizzBuzz"), //
				Arguments.of(16, "16"), //
				Arguments.of(17, "17"), //
				Arguments.of(18, "Fizz"), //
				Arguments.of(19, "19"), //
				Arguments.of(20, "Buzz"), //
				Arguments.of(21, "Fizz"), //
				Arguments.of(22, "22"), //
				Arguments.of(23, "23"), //
				Arguments.of(24, "Fizz"), //
				Arguments.of(25, "Buzz"), //
				Arguments.of(26, "26"), //
				Arguments.of(27, "Fizz"), //
				Arguments.of(28, "28"), //
				Arguments.of(29, "29"), //
				Arguments.of(30, "FizzBuzz") //
		);

	}

}
