package day2_7_11_2021;

public class action_item_1 {
    public static void main(String[] args) {
        int size_=4;
        String[] zipCode = new String[size_]; // zipcode array of strings
        int[] streetNumber = new int[size_];  // street number array of integers
        zipCode[0] = "11219";
        zipCode[1] = "11220";
        zipCode[2] = "11221";
        zipCode[3] = "11222";
        streetNumber[0] = 901;
        streetNumber[1] = 902;
        streetNumber[2] = 903;
        streetNumber[3] = 904;
        // print both array data side by side
        for (int i = 0; i < size_; i++) {
            System.out.println("My zipcode is " + zipCode[i] + " and my street number is " + streetNumber[i]);
        }
    }
}
