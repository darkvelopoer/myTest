package com.yyh.practice.func;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public  class MelonFactory {



    private MelonFactory() {
        throw new AssertionError("Cannot be instantiated");
    }

    private static final TriFunction<String, Integer, String, String, Melon2> MELON = Melon2::new;


    //Map<String, Supplier<Fruit>> mapOne = new HashMap<>();

    private static final Map<String, Supplier<Fruit>> MELONS
            = new HashMap<>(); //Map.of("Gac", Gac::new, "Hemi", Hemi::new, "Cantaloupe", Cantaloupe::new);

    public static Fruit newInstance(String name, int weight, String color, String size) {

        return MELON.apply(name, weight, color, size);
    }

    public static Fruit newInstance(Class<?> clazz) {
        MELONS.put("Gac", Gac::new);
        MELONS.put("Hemi", Hemi::new);
        MELONS.put("Cantaloupe", Cantaloupe::new);
        System.out.println("simpleName: " + clazz.getSimpleName());
        Supplier<Fruit> supplier = MELONS.get(clazz.getSimpleName());

        if (supplier == null) {
            throw new IllegalArgumentException("Invalid clazz argument: " + clazz);
        }

        return supplier.get();
    }

    /*
    public static Fruit newInstance(Class<?> clazz) {

        switch (clazz.getSimpleName()) {

            case "Gac":
                return new Gac();
            case "Hemi":
                return new Hemi();
            case "Cantaloupe":
                return new Cantaloupe();
            default:
                throw new IllegalArgumentException("Invalid clazz argument: " + clazz);
        }
    }
     */
}
