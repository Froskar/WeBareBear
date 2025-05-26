package main;


import main.commands.commandRegistery;
import utils.Color;
import utils.StringStyling;
import utils.Style;

public class Main {

    public static void main(String[] args) {

        System.out.println(StringStyling.StyleString("Starting...", Style.ITALIC, Color.BLACK));
        Game game = new Game();
        game.run();
        System.out.println(StringStyling.StyleString("Terminating...", Style.ITALIC, Color.BLACK));


        System.out.println(StringStyling.StyleString("Welcome to the game! Type 'help' for a list of commands.", Style.BOLD, Color.GREEN));
        commandRegistery registry = new commandRegistery();
        boolean gameWon = false;

        while (gameWon == false) {
        registry.commandChoose();
        }


    }
}