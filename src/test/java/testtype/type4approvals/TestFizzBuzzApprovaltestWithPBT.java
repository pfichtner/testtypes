package testtype.type4approvals;

import static net.jqwik.api.ShrinkingMode.OFF;
import static org.approvaltests.Approvals.settings;
import static org.approvaltests.Approvals.verify;
import static org.approvaltests.namer.NamerFactory.withParameters;
import static testtype.FizzBuzz.fizzBuzz;

import org.approvaltests.core.Options;
import org.approvaltests.namer.NamedEnvironment;

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
		try (NamedEnvironment env = withParameters(number)) {
			verify(fizzBuzz(number), options());
		}
	}

	private Options options() {
		return new Options()
//				.withReporter(new AutoApproveWhenEmptyReporter())
		;
	}

}
