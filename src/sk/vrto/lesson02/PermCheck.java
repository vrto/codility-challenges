package sk.vrto.lesson02;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Score 70%.
 * 100% correct.
 * 40% performance. => looks like a codility bug :(
 */
public class PermCheck {

    int solution(int[] arr) {
        int n = arr.length;
        long expectedSum = n * (n + 1) / 2;

        long actualSum = 0;
        boolean[] flags = new boolean[n];
        for (int val : arr) {
            if (val > flags.length || flags[val - 1]) { // already have such number => no permutation
                return 0;
            } else {
                flags[val - 1] = true;
                actualSum += val;
            }
        }
        return (actualSum == expectedSum) ? 1 : 0;
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
