package main;


import main.commands.CommandRegistery;
import utils.Color;
import utils.StringStyling;
import utils.Style;
import main.commands.Command;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Game.getGameInstance().run();
        System.out.println(StringStyling.StyleString("Terminating...", Style.ITALIC, Color.GREEN));
    }
}