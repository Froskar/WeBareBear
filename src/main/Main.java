package main;


import main.commands.commandRegistery;
import utils.Color;
import utils.StringStyling;
import utils.Style;
import main.commands.Command;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println(StringStyling.StyleString("Starting...", Style.ITALIC, Color.BLACK));
        Game game = new Game();
        game.run();
        System.out.println(StringStyling.StyleString("Terminating...", Style.ITALIC, Color.BLACK));


        System.out.println(StringStyling.StyleString("Welcome to the game! Type 'help' for a list of commands.", Style.BOLD, Color.GREEN));
        commandRegistery registry = new commandRegistery();
        boolean gameWon = false;
        Scanner scanner = new Scanner(System.in);
        while (gameWon != true){
            System.out.print("Entrez une commande : ");
            String inputLowercase = scanner.nextLine();
            inputLowercase = inputLowercase.toLowerCase();

            if (inputLowercase != null) {
                System.out.println(commandRegistery.getCommandInstance().getCommand(inputLowercase).execute());
            } else {
                System.out.println("Commande inconnue.");
            }

        }


    }
}