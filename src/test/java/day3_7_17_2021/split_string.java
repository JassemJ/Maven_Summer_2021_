package day3_7_17_2021;

public class split_string {
    public static void main(String[] args) {
        String message = "My name is John_Abc";
        String[] splitMessage = message.split(" ");
        System.out.println("My name is "+splitMessage[3]+".");

        String[] arrayMessage2 = splitMessage[3].split("_");
        System.out.println("Actual name is: "+arrayMessage2[0]);
    }
}
