package com.github.timshnayder;

public class Cpu
{
    private Grid grid;
    public static final int RANDOM = 1;
    public static final int SMART = 2;

    private int aiLevel = RANDOM;

    public Cpu(Grid g)
    {
        grid = g;
    }

    public void setLevel(int l)
    {
        aiLevel = l;
    }

    public void playTurn()
    {
        if (aiLevel == RANDOM)
        {
            playRandomTurn();
        }
        else
        {
            playSmartTurn();
        }
    }

    public void playRandomTurn()
    {
        int row;
        int col;
        do
        {
            row = Randomizer.nextInt(1, Grid.NUM_ROWS);
            col = Randomizer.nextInt(1, Grid.NUM_COLS);
            System.out.println("Cpu tried placing " + row + " " + col);
        }
        while (grid.getCell(row, col) != Cell.NOBODY);
        grid.setCell(row, col, Cell.O);
    }

    public void playSmartTurn()
    {
        if(tryToComplete())
        {
            return;
        }
        if(defend())
        {
            return;
        }
        playRandomTurn();
    }

    private boolean tryToComplete()
    {
        for(int row = 1; row <= Grid.NUM_ROWS; row++)
        {
            int counter = 0;
            int empty = 0;
            for(int col = 1; col <= Grid.NUM_COLS; col++)
            {
                if (grid.getCell(row, col) == Cell.O)
                {
                    counter++;
                }
                if (grid.getCell(row, col) == Cell.X)
                {
                    counter = 0;
                    break;
                }
                if (grid.getCell(row, col) == Cell.NOBODY)
                {
                    empty = col;
                }
            }
            if (counter == Grid.NUM_COLS - 1)
            {
                System.out.println("Found place to put");
                grid.setCell(row, empty, Cell.O);
                return true;
            }
        }

        for(int col = 1; col <= Grid.NUM_COLS; col++)
        {
            int counter = 0;
            int empty = 0;
            for(int row = 1; row <= Grid.NUM_ROWS; row++)
            {
                if (grid.getCell(row, col) == Cell.O)
                {
                    counter++;
                }
                if (grid.getCell(row, col) == Cell.X)
                {
                    counter = 0;
                    break;
                }
                if (grid.getCell(row, col) == Cell.NOBODY)
                {
                    empty = row;
                }
            }
            if (counter == Grid.NUM_ROWS - 1)
            {
                System.out.println("Found place to put");
                grid.setCell(empty, col, Cell.O);
                return true;
            }
        }
        int counter = 0;
        int empty = 0;
        for(int i = 1; i <= Grid.NUM_ROWS; i++)
        {
            if (grid.getCell(i, i) == Cell.O)
            {
                counter++;
            }
            if (grid.getCell(i, i) == Cell.X)
            {
                counter = 0;
                break;
            }
            if (grid.getCell(i, i) == Cell.NOBODY)
            {
                empty = i;
            }
        }
        if (counter == Grid.NUM_ROWS - 1)
        {
            System.out.println("Found place to put");
            grid.setCell(empty, empty, Cell.O);
            return true;
        }

        counter = 0;
        empty = 0;
        for(int i = 1; i <= Grid.NUM_ROWS; i++)
        {
            if (grid.getCell(i, 4-i) == Cell.O)
            {
                counter++;
            }
            if (grid.getCell(i, 4-i) == Cell.X)
            {
                counter = 0;
                break;
            }
            if (grid.getCell(i, 4-i) == Cell.NOBODY)
            {
                empty = i;
            }
        }
        if (counter == Grid.NUM_ROWS - 1)
        {
            System.out.println("Found place to put");
            grid.setCell(empty, 4-empty, Cell.O);
            return true;
        }
        return false;

    }

    private boolean defend()
    {
        for(int row = 1; row <= Grid.NUM_ROWS; row++)
        {
            int counter = 0;
            int empty = 0;
            for(int col = 1; col <= Grid.NUM_COLS; col++)
            {
                if (grid.getCell(row, col) == Cell.X)
                {
                    counter++;
                }
                if (grid.getCell(row, col) == Cell.O)
                {
                    counter = 0;
                    break;
                }
                if (grid.getCell(row, col) == Cell.NOBODY)
                {
                    empty = col;
                }
            }
            if (counter == Grid.NUM_COLS - 1)
            {
                System.out.println("Found place to put");
                grid.setCell(row, empty, Cell.O);
                return true;
            }
        }

        for(int col = 1; col <= Grid.NUM_COLS; col++)
        {
            int counter = 0;
            int empty = 0;
            for(int row = 1; row <= Grid.NUM_ROWS; row++)
            {
                if (grid.getCell(row, col) == Cell.X)
                {
                    counter++;
                }
                if (grid.getCell(row, col) == Cell.O)
                {
                    counter = 0;
                    break;
                }
                if (grid.getCell(row, col) == Cell.NOBODY)
                {
                    empty = row;
                }
            }
            if (counter == Grid.NUM_ROWS - 1)
            {
                System.out.println("Found place to put");
                grid.setCell(empty, col, Cell.O);
                return true;
            }
        }
        int counter = 0;
        int empty = 0;
        for(int i = 1; i <= Grid.NUM_ROWS; i++)
        {
            if (grid.getCell(i, i) == Cell.X)
            {
                counter++;
            }
            if (grid.getCell(i, i) == Cell.O)
            {
                counter = 0;
                break;
            }
            if (grid.getCell(i, i) == Cell.NOBODY)
            {
                empty = i;
            }
        }
        if (counter == Grid.NUM_ROWS - 1)
        {
            System.out.println("Found place to put");
            grid.setCell(empty, empty, Cell.O);
            return true;
        }

        counter = 0;
        empty = 0;
        for(int i = 1; i <= Grid.NUM_ROWS; i++)
        {
            if (grid.getCell(i, 4-i) == Cell.X)
            {
                counter++;
            }
            if (grid.getCell(i, 4-i) == Cell.O)
            {
                counter = 0;
                break;
            }
            if (grid.getCell(i, 4-i) == Cell.NOBODY)
            {
                empty = i;
            }
        }
        if (counter == Grid.NUM_ROWS - 1)
        {
            System.out.println("Found place to put");
            grid.setCell(empty, 4-empty, Cell.O);
            return true;
        }
        return false;

    }
}
