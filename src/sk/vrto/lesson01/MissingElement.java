package sk.vrto.lesson01;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Score 80%
 * 100% correct.
 * 60% performance.
 * Detected O(n) or O(n * log(n))
 */
public class MissingElement {

    public int solution(int[] arr) {
        long sum = sum(arr.length + 1);

        long currentSum = 0;
        for (int elem : arr) {
            currentSum += elem;
        }

        return (int) (sum - currentSum);
    }

    private long sum(int n) {
        return n * (n + 1) / 2;
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
