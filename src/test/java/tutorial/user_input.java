package tutorial;

import java.util.Scanner;

public class user_input {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); // scanner initialization
        // scanner is ready to accept user input
        System.out.println("What is your name? ");
        String name = scanner.nextLine(); // accept input until '/n' created when we hit enter
        System.out.println("How old are you? ");
        int age = scanner.nextInt(); // does not read 'n' ex user enters 23+enter we have "23\n"
        // '\n' is left
        System.out.println("What is your favorite food? ");
        scanner.nextLine(); // take '\n'
        String food = scanner.nextLine(); // accept input until '/n'
        System.out.println("Your name is "+name);
        System.out.println("Your are "+age+ " years old");
        System.out.println("Your favorite food is "+food);
        scanner.close();
    }
}
