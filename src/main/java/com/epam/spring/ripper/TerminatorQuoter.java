package com.epam.spring.ripper;

public class TerminatorQuoter implements Quoter {
    @InjectRandomInt(min = 1, max = 10)
    private int repeat;

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("message: " + message);
        }
    }
}
