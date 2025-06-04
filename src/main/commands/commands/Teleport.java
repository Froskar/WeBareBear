package main.commands.commands;

import main.commands.Command;
import main.player.Player;
import main.world.Location;
import main.world.WorldMap;

import java.util.Scanner;
import java.util.Set;

public class Teleport extends Command {

    public Teleport(String name, String descr, boolean commandState) {
        super(name, descr, commandState);
    }

    @Override
    public String execute() {
        Player player = Player.getInstance();

        // 1) Récupération des locations déjà visitées
        Set<Location> visited = player.getVisitedLocations();
        if (visited.isEmpty()) {
            return "Vous n'avez encore visité aucune salle. Impossible de vous téléporter.";
        }

        // Afficher la liste des noms des salles visitées
        System.out.println("Lieux visités :");
        for (Location loc : visited) {
            System.out.println(" - " + loc.getName());
        }

        // 2) Demander à l'utilisateur où il veut se téléporter
        Scanner scanner = new Scanner(System.in);
        System.out.print("Où voulez-vous vous téléporter ? ");
        String cible = scanner.nextLine().trim();

        // 3) Chercher dans 'visited' une location au nom exact
        for (Location loc : visited) {
            if (loc.getName().equalsIgnoreCase(cible)) {
                // 4) Modifier la position du joueur
                // On suppose que Player possède methods setPosition(row, col) ou setLocationRow/Col
                int[] coords = WorldMap.getLocationCoordinates(loc.getName());
                if (coords == null) {
                    return "Erreur interne : coordonnées introuvables pour \"" + cible + "\".";
                }
                player.getPosition().setRow(coords[0]);
                player.getPosition().setCol(coords[1]);
                return "Téléportation réussie vers : " + loc.getName();
            }
        }

        return "Vous n'avez jamais visité \"" + cible + "\". Impossible de vous y téléporter.";
    }
}
