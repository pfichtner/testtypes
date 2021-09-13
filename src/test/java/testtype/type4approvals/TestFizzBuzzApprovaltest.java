package testtype.type4approvals;

import static java.util.stream.IntStream.rangeClosed;
import static org.approvaltests.Approvals.verifyAll;
import static testtype.FizzBuzz.fizzBuzz;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

/**
 * If we have legacy code and no clue what the code does there are approval
 * tests to the rescue.
 */
class TestFizzBuzzApprovaltest {

	@Test
	void approve1To100() throws Exception {
		verifyAll(asArray(rangeClosed(1, 100)), i -> fizzBuzz((Integer) i));
	}

	Integer[] asArray(IntStream intStream) {
		return intStream.mapToObj(Integer::valueOf).toArray(Integer[]::new);
	}

}
