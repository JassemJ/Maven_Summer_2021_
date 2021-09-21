package day7_7_31_2021;

import java.util.ArrayList;

public class array_list_ {
    public static void main(String[] args) {
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("India");
        countries.add("Japan");

/*        for(String i : countries)
            System.out.println(i);*/

        for(int i=0; i<countries.size(); i++)
            System.out.println(countries.get(i));
    }
}
