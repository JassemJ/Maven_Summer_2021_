package day3_7_17_2021;

public class reusable_methods_ {
    // void method to add two integers


    public static void add2nums(int x, int y){
        int z = x+y;
        System.out.println("My result is "+ z);
    }

    public static void sub2nums(int x, int y){
        int z = x-y;
        System.out.println("My result is "+ z);
    }

    public static int add2numsReturn(int x, int y){
        System.out.println("My result is "+ (x+y));
        return x+y;
    }
}
