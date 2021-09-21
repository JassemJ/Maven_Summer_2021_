package day3_7_17_2021;

public class driver_ {
    public static void main(String[] args) {
        //int x=1; int y=2;
        //reusable_methods_.add2nums(x,y); // calling a static method to another class is know as inheritance
        //reusable_methods_.sub2nums(x,y);
        //add_(x,y);
        int result = reusable_methods_.add2numsReturn(3,4);
        System.out.println("New result +5: " + (result+5));
    }

//    public static void add_(int x, int y){
//        System.out.println(x+y);
//    }
}
//java: non-static method add2nums(int,int) cannot be referenced from a static context