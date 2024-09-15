package test;

import main.StackOverflowInvoker;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class

StackOverflowInvokerTest {

    @Test
    public void testStackOverflowInvoker() {
        StackOverflowInvoker example = new StackOverflowInvoker();

        assertThrows(StackOverflowError.class, example::invokeStackOverflowRecursively);
    }
}
