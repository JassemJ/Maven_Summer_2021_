package day3_7_17_2021;

public class so_far_ {
    public static void main(String[] args) {
        String[] cities = new String[4];
        cities[0]="Brooklyn";
        cities[1]="Manhattan";
        cities[2]="Queens";
        cities[3]="Staten Island";

        for(String i : cities)
            if(i=="Brooklyn" || i=="Queens")
                System.out.println("My city is " + i);
    }
}
