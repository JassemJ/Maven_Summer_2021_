package day3_7_17_2021;

public class switch_ {
    public static void main(String[] args) {
        String ship = "Cruise Ship";

        switch (ship) {
            case "Cruise Ship":
                System.out.println(ship + " is a type of ship where you can cruise around");
                break;
            case "Battle Ship":
                System.out.println(ship + " used for war");
            default:
                System.out.print("Other");
        }
    }

}
