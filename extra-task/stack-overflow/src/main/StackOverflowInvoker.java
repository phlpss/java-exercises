package main;

public class StackOverflowInvoker {
    public void invokeStackOverflowRecursively() {
        invokeStackOverflowRecursively();
    }
}
