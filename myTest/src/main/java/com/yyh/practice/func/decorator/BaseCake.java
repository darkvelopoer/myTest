package com.yyh.practice.func.decorator;

public class BaseCake implements Cake {
    @Override
    public String decorate() {
        return "Base cake ";
    }
}
