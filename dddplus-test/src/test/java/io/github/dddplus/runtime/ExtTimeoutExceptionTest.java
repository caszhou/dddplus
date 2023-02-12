package io.github.dddplus.runtime;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExtTimeoutExceptionTest {
    @Test
    public void getMessage() {
        ExtTimeoutException extTimeoutException = new ExtTimeoutException(5000);
        assertEquals("timeout:5000ms", extTimeoutException.getMessage());
    }
}
