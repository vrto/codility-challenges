package sk.vrto.lesson01.tapeequilibrium;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TapeEquilibrium2 {

    /**
     * Score 100%
     * 100% correct
     * 100% performance
     * Detected O(n)
     */
    public int solution(int[] arr) {
        long leftSum = arr[0];
        long rightSum = rightSum(arr);
        long minDiff = Math.abs(rightSum - leftSum);

        for (int i = 2; i < arr.length; i++) {
            leftSum += arr[i - 1];
            rightSum -= arr[i - 1];
            long diff = Math.abs(leftSum - rightSum);
            minDiff = (diff < minDiff) ? diff : minDiff;
        }
        return (int) minDiff;
    }

    private long rightSum(int[] arr) {
        long sum = 0;
        for (int i = arr.length; i > 1; i--)
            sum += arr[i - 1];
        return sum;
    }

    // ========================================== tests ==========================================

    @Test
    public void givenCase() {
        assertThat(solution(new int[] {3, 1, 2, 4, 3}), is(1));
    }

    @Test
    public void smallestCase() {
        assertThat(solution(new int[] {2, 1}), is(1));
        assertThat(solution(new int[] {10, 6}), is(4));
        assertThat(solution(new int[] {-10, -6}), is(4));
        assertThat(solution(new int[] {10, -6}), is(16));
        assertThat(solution(new int[] {-10, 6}), is(16));
    }

    @Test
    public void extremeCase() {
        int[] extremeArray = new int[100_000];
        for (int i = 0; i < 100_000; i++) {
            extremeArray[i] = 1000;
        }

        assertThat(solution(extremeArray), is(0));
    }
}
