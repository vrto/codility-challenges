package sk.vrto.lesson01;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Score 100%
 * 100% correct
 * 100% performance
 * Detected O(1)
 */
public class FrogJump {

    public int solution(int start, int end, int jump) {
        double jumps = (end - start) / (double) jump;
        return Double.valueOf(Math.ceil(jumps)).intValue();
    }

    @Test
    public void givenCase() {
        assertThat(solution(10, 85, 30), is(3));
    }

    @Test
    public void smallestCase() {
        assertThat(solution(1, 1, 1), is(0));
    }

    @Test
    public void extremeCase() {
        assertThat(solution(1, 1_000_000_000, 1), is(999_999_999));
    }

}
