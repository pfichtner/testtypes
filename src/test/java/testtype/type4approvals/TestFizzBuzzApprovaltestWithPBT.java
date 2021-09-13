package testtype.type4approvals;

import static net.jqwik.api.ShrinkingMode.OFF;
import static org.approvaltests.combinations.CombinationApprovals.verifyAllCombinations;
import static testtype.FizzBuzz.fizzBuzz;

import java.util.List;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.api.arbitraries.ListArbitrary;
import net.jqwik.api.constraints.IntRange;

/**
 * An approval test based on jqwik. Please note that to get this work a modified
 * version of {@link org.approvaltests.namer.AttributeStackSelector} was copied
 * to this project.
 */
class TestFizzBuzzApprovaltestWithPBT {

	@Property(tries = 1, seed = "-1787866974758305853", shrinking = OFF)
	void approve1To100(@ForAll("listsWithIntegersBetween1And100") List<Integer> numbers) {
		verifyAllCombinations(i -> fizzBuzz(i), numbers.toArray(new Integer[numbers.size()]));
	}

	@Provide
	ListArbitrary<Integer> listsWithIntegersBetween1And100() {
		// pick 250 random integer values
		return Arbitraries.integers().greaterOrEqual(1).list().uniqueElements().ofSize(250);
	}

}
