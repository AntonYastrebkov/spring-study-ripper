package com.epam.spring.ripper;

public class T1000 extends TerminatorQuoter implements Quoter {
    @Override
    public void sayQuote() {
        System.out.println("I'm liquid");
    }
}
