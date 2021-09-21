package day2_7_11_2021;

public class for_loop_with_array {
    public static void main(String[] args){
        // dynamic array of zipcodes
        int[] myZipcode = new int[2];
        myZipcode[0]=11219;
        myZipcode[1]=11232;

        /* iterate through myZipcode and print each zipcode */
        //for (int j : myZipcode)
            //System.out.println("My zip code is " + j);

        int i = 0;
        while(i != myZipcode.length){
            System.out.println("My zip code is " +myZipcode[i]);
            i++;
        }
        System.out.println(" ");

        System.out.println("My zip code array is size "+myZipcode.length);
    }
}
