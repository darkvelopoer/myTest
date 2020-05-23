package com.yyh.practice.func;

public class Melon2 implements Fruit{

    private final String type;
    private final int weight;
    private final String color;
    private final String size;

    public Melon2(String type, int weight, String color, String size) {
        this.type = type;
        this.weight = weight;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Melon2{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
