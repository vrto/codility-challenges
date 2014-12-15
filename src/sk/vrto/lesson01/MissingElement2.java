package sk.vrto.lesson01;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Score 100%
 */
public class MissingElement2 {

    public int solution(int[] arr) {
        long sum = 0;
        for (int i : arr)
            sum += i;

        // casting the result of multiplication to long to prevent overflow :-/
        long total = (arr.length + 1) * (long) (arr.length + 2) / 2;
        return (int) (total - sum);
    }

    @Test
    public void middleMissing() {
        int[] arr = {2, 1, 5, 4};
        assertThat(solution(arr), is(3));
    }

    @Test
    public void firstMissing() {
        int[] arr = {1, 3, 4, 5};
        assertThat(solution(arr), is(2));
    }

    @Test
    public void givenCase() { // last missing
        int[] arr = {1, 2, 3, 5};
        assertThat(solution(arr), is(4));
    }

    @Test
    public void minimalCase() {
        int[] arr = {2};
        assertThat(solution(arr), is(1));
    }
}
