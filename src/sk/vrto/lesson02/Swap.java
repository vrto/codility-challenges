package sk.vrto.lesson02;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Swap {

    boolean isSwapPossible(int m, int[] a, int[] b) {
        long sumA = IntStream.of(a).sum();
        long sumB = IntStream.of(b).sum();

        for (int i = 0; i < a.length; i++) {
            int aCandidate = a[i];
            for (int j = 0; j < b.length; j++) {
                int bCandidate = b[j];
                if ((sumA - aCandidate + bCandidate) == (sumB - bCandidate + aCandidate)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void shouldBePossible() {
        int[] a = {1, 4, 5};
        int[] b = {2, 3, 1};
        assertThat(isSwapPossible(10, a, b), is(true));
    }

    @Test
    public void shouldNotBePossible() {
        int[] a = {1, 4, 6};
        int[] b = {2, 3, 1};
        assertThat(isSwapPossible(10, a, b), is(false));
    }

}
