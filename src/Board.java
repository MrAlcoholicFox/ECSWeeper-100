import ecs100.UI;

import java.awt.*;
import java.util.Random;

public class Board {
    private int[][] board; //0 is bomb, 1 is normal unclicked Square, 2 is clicked square
    public boolean gameRunning = false;
    public Random rand = new Random();
    public int mineNumber = 20;
    public static final double SQUARES = 20;
    public double squareSize;

    public static final Color unclickedSquare = new Color(83, 83, 83);
    public static final Color clickedSquare = new Color(160, 160, 160);


    public Board(){
        create_board();
        draw_game();
    }

    public void create_board(){
        this.board = new int[(int) SQUARES][(int) SQUARES];
        int minePopulation = 0;
        while (minePopulation <= mineNumber){
            for (int i_row = 0; i_row < SQUARES; i_row++) {
                for (int i_col = 0; i_col < SQUARES; i_col++) {
                    if (board[i_row][i_col] != 1) {
                        board[i_row][i_col] = gridValue(rand.nextInt(20), minePopulation);
                        if (board[i_row][i_col] == 1) {
                            minePopulation++;
                        }
                    }
                }
            }
        }
    }

    /*This method is used for deciding whether or not
    the square should contain a mine or just be a normal square*/
    public int gridValue(int val, int minePop){
        if (val == 4 && minePop <= mineNumber){
            return 1;
        }
        else{
            return 0;
        }
    }

    public void boardClick(double x, double y){
        int rowBoard = (int) ((y-Main.startY) / squareSize);
        int colBoard = (int) ((x-Main.startX) / squareSize);

        if (rowBoard >= 0 && rowBoard <= board.length && colBoard >=0 && colBoard <= board.length){
            board[rowBoard][colBoard] = 2;
            this.draw_game();
        }
    }

    public void draw_game(){
        double spacing = 1;
        double squareSize = Main.gridSize/board.length/spacing;
        this.squareSize = squareSize;
        UI.clearGraphics();

        for (int i_row = 0; i_row < board.length; i_row++) {
            for (int i_col = 0; i_col < board.length; i_col++) {
                if (board[i_row][i_col] == 1){
                    UI.setColor(Color.red);
                    UI.fillRect(Main.startX + (squareSize*i_col)*spacing, Main.startY + (squareSize*i_row)*spacing, squareSize, squareSize);
                }
                else if (board[i_row][i_col] == 2){
                    UI.drawImage("img/squareClicked.png", Main.startX + (squareSize*i_col)*spacing, Main.startY + (squareSize*i_row)*spacing, squareSize, squareSize);
                }
                else {
                    /*UI.setColor(unclickedSquare);*/
                    UI.drawImage("img/squareUnclicked.png", Main.startX + (squareSize*i_col)*spacing, Main.startY + (squareSize*i_row)*spacing, squareSize, squareSize);
                }
            }
        }
    }
}
