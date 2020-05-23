package com.yyh.practice.func.strategy;

@FunctionalInterface
public interface RemoveStrategy {
    String execute(String s);
}
