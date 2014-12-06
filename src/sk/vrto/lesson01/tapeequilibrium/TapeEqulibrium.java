package sk.vrto.lesson01.tapeequilibrium;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TapeEqulibrium {

    /**
     * Score 58%
     * 100% correct
     * 16% performance
     * Detected O(n*n)
     */
    public int solution(int[] arr) {
        int[] differences = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            differences[i-1] = difference(arr, i);
        }
        return Arrays.stream(differences).min().getAsInt();
    }

    private int difference(int[] arr, int p) {
        int leftSum = leftSum(arr, p);
        int rightSum = rightSum(arr, p);
        return Math.abs(leftSum - rightSum);
    }

    private int leftSum(int[] arr, int p) {
        int sum = 0;
        for (int i = 0; i < p; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private int rightSum(int[] arr, int p) {
        int sum = 0;
        for (int i = p; i < arr.length; i++) {
            sum += arr[i];
        }
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
