import main.items.key;
import main.items.letter;
import main.items.puzzle;

public class look {

Look.player = player
Look.world = world

current_location = Look.world.worldMap.get_location(Look.player.position)//Look.world ... = cherche la description de la zone / Look.player... = écupère la position actuelle du joueur
print(f"Vous êtes ici : {current_location.description}")

if current_location.items:
    print("Objets disponibles :")
    for item in current_location.items:
        print(f"- {item.name}")

if current_location.puzzles:
    print("Vous voyez une énigme :")
    for puzzle in current_location.puzzles:
        print(f"- {puzzle.description}")

}