package main.commands.commands;

import main.items.Letter;

public class inspect {

    public void inspectLetter(Letter letter) {
        System.out.println("Vous lisez la lettre :");
        System.out.println(letter.read());
    }
}
//permet de lire une lettre et d'afficher son contenu