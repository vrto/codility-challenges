package sk.vrto.lesson01.complexity;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SumCounterTest {

    @Test
    public void shouldReturnSum() {
        assertThat(SumCounter.sum(0), is(0));
        assertThat(SumCounter.sum(1), is(1));
        assertThat(SumCounter.sum(2), is(3));
        assertThat(SumCounter.sum(5), is(15));
        assertThat(SumCounter.sum(10), is(55));
    }

}