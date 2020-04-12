package com.github.timshnayder;

public class Player extends ConsoleProgram
{
    private Grid grid;

    public Player(Grid g)
    {
        grid = g;
    }

    public void playTurn()
    {
        int row;
        int col;
        do
        {
            String turn;
            do
            {
                turn = readLine("Where do you want to place?: ");
            }
            while (turn.length() != 2);
            col = turn.charAt(0)-'A'+1;
            if (col < 1 || col > Grid.NUM_COLS)
            {
                col = turn.charAt(0)-'a'+1;
            }
            row = turn.charAt(1) - '0';
        }
        while (row < 1 || row > Grid.NUM_ROWS || col < 1 || col > Grid.NUM_COLS || grid.getCell(row, col) != Cell.NOBODY);
        grid.setCell(row, col, Cell.X);
    }
}

