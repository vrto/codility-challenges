package sk.vrto.lesson02;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Score 100%.
 * 100% correct.
 * 100% performance.
 */
public class PermCheck2 {

    int solution(int[] arr) {
        boolean[] checks = new boolean[arr.length];
        for (int val : arr) {
            if (val < 1 || val > arr.length)
                return 0;

            if (checks[val - 1]) // already exists => not a permutation
                return 0;

            checks[val - 1] = true;
        }
        return 1;
    }

    @Test
    public void shouldBePermutation() {
        int[] arr = {4, 1, 3, 2};
        assertThat(solution(arr), is(1));
    }

    @Test
    public void shouldNotBePermutation() {
        int[] arr = {4, 1, 3};
        assertThat(solution(arr), is(0));
    }
}
