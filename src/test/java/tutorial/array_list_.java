package tutorial;

import java.util.ArrayList;

public class array_list_ { // stores reference types check wrapper class
    public static void main(String[] args){
        ArrayList<String> myCars = new ArrayList<>();
        myCars.add("Toyota");
        myCars.add("Hyundai");
        myCars.add("Ferrari");

        for(int i=0; i<myCars.size(); i++){
            System.out.print(myCars.get(i)+" ");
        }

//        for(String i:myCars){
//            System.out.print(i+" ");
//        }

        System.out.println();
    }

}
