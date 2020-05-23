package com.yyh.practice.func;

@FunctionalInterface
public interface TriFunction<T, U, V, X, R> {

    R apply(T t, U u, V v, X x);
}
