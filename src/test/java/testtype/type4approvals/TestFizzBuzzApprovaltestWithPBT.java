package testtype.type4approvals;

import static net.jqwik.api.ShrinkingMode.OFF;
import static org.approvaltests.Approvals.settings;
import static org.approvaltests.Approvals.verify;
import static testtype.FizzBuzz.fizzBuzz;

import org.approvaltests.Approvals;
import org.approvaltests.core.Options;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

/**
 * An approval test based on jqwik.
 */
class TestFizzBuzzApprovaltestWithPBT {

	/**
	 * we have to use the same seed over and over again otherwise the numbers would
	 * differ and we wouldn't have approved them.
	 */
	private static final String FIXED_SEED = "-1787866974758305853";

	@Property(seed = FIXED_SEED, shrinking = OFF)
	void approvePositiveInts(@ForAll @IntRange(min = 1) int number) {
		settings().allowMultipleVerifyCallsForThisClass();
		settings().allowMultipleVerifyCallsForThisMethod();
		verify(fizzBuzz(number), configure(Approvals.NAMES.withParameters(String.valueOf(number))));
	}

	private static Options configure(Options options) {
		return options
//				.withReporter(new AutoApproveWhenEmptyReporter())
		;
	}

}
