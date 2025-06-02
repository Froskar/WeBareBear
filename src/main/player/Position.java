package main.player;

public class Position {
        private int row = 0;
        private int col = 0;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() { return row; }
        public int getCol() { return col; }
        public void setRow(int row) { this.row = row; }
        public void setCol(int col) { this.col = col; }
    }
