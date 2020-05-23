package com.yyh.practice.func;

public class Main {

    public static void main(String[] args) {

        //Gac gac = (Gac) MelonFactory.newInstance(Gac.class);
        Melon2 melon = (Melon2) MelonFactory.newInstance("Hemi", 2000, "red", "XL");

        //System.out.println("Gac: " + gac);
        System.out.println("Melon: " + melon);
    }

}
