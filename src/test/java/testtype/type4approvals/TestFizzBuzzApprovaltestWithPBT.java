package testtype.type4approvals;

import static net.jqwik.api.ShrinkingMode.OFF;
import static org.approvaltests.Approvals.verify;
import static org.approvaltests.namer.NamerFactory.withParameters;
import static testtype.FizzBuzz.fizzBuzz;

import org.approvaltests.namer.NamedEnvironment;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

/**
 * An approval test based on jqwik. Please note that to get this work a modified
 * version of {@link org.approvaltests.namer.AttributeStackSelector} was copied
 * to this project.
 */
class TestFizzBuzzApprovaltestWithPBT {

	@Property(seed = "-1787866974758305853", shrinking = OFF)
	void approvePositiveInts(@ForAll @IntRange(min = 1) int number) {
		try (NamedEnvironment env = withParameters(number)) {
			verify(fizzBuzz(number));
		}
	}

}
