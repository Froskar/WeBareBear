package main.world;

public class worldMap {
    
	int rows = 3;
	int cols = 4;

	// Créer un tableau bidimensionnel
	int[][] tableau = new int[rows][cols];

	// Remplir le tableau avec des zéros
	public worldMap() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				tableau[i][j] = 0;
			}
		}
	} 
	public void printWorld() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(tableau[i][j] + " ");
			}
			System.out.println();
		}
	}
}
