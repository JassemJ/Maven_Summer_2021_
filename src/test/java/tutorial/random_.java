package tutorial;

import java.util.Random;

public class random_{
    public static void main(String[] args){
        Random random = new Random();
        int myDiceNum = random.nextInt(6)+1;
        System.out.println("Your dice roll is: "+myDiceNum);
    }
}
