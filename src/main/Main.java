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

// parfois les fichier se renoment automatiquement avec git, malheureusement nous n'avons pas trouvé comment changer cela
// si le code ne s'exécute pas, il faut soit renomer les fichier comme dis au dessus, soit supprimer le fichier "out" et ensuite run
//Je suis vraiment désolé je n'ai pas trouvé de fix

// si rien ne marche, il y a un fichier zip c'est le V7.zip, qui contient le dossier src