package com.github.timshnayder;

public class Grid
{
    public static final int NUM_ROWS = 3;
    public static final int NUM_COLS = 3;

    private Cell[][] cells = new Cell[NUM_ROWS][NUM_COLS];


    public Grid()
    {
        for(int row = 0; row < NUM_ROWS; row++)
        {
            for(int col = 0; col < NUM_COLS; col++)
            {
                cells[row][col] = new Cell();
            }
        }
    }

    public void print()
    {
        System.out.println("    A   B   C ");
        System.out.println("  +---+---+---+");
        for(int row = 0; row < NUM_ROWS; row++)
        {
            System.out.print(row+1 + " |");
            for(int col = 0; col < NUM_COLS; col++)
            {
                if(cells[row][col].getContent() == Cell.X)
                {
                    System.out.print(" X |");
                }
                else if(cells[row][col].getContent() == Cell.O)
                {
                    System.out.print(" O |");
                }
                else
                {
                    System.out.print("   |");
                }

            }
            System.out.println();
            System.out.println("  +---+---+---+");
        }
    }

    public void setCell(int row, int col, int content)
    {
        cells[row-1][col-1].setContent(content);
    }

    public int getCell(int row, int col)
    {
        return cells[row-1][col-1].getContent();
    }

    public int getComplete()
    {
        for(int row = 0; row < NUM_ROWS; row++)
        {
            int first = cells[row][0].getContent();
            if (first != Cell.NOBODY) {
                for(int col = 1; col < NUM_COLS; col++)
                {
                    if (first != cells[row][col].getContent())
                    {
                        first = Cell.NOBODY;
                        break;
                    }
                }
                if (first != Cell.NOBODY)
                {
                    return first;
                }
            }
        }

        for(int col = 0; col < NUM_COLS; col++)
        {
            int first = cells[0][col].getContent();
            if (first != Cell.NOBODY) {
                for(int row = 1; row < NUM_ROWS; row++)
                {
                    if (first != cells[row][col].getContent())
                    {
                        first = Cell.NOBODY;
                        break;
                    }
                }
                if (first != Cell.NOBODY)
                {
                    return first;
                }
            }
        }

        int first = cells[0][0].getContent();
        if(first != Cell.NOBODY)
        {
            for(int i = 1; i < NUM_ROWS; i++)
            {
                if (first != cells[i][i].getContent())
                {
                    first = Cell.NOBODY;
                    break;
                }
            }
            if (first != Cell.NOBODY)
            {
                return first;
            }

        }

        first = cells[0][2].getContent();
        if(first != Cell.NOBODY)
        {
            for(int i = 1; i < NUM_ROWS; i++)
            {
                if (first != cells[i][2-i].getContent())
                {
                    first = Cell.NOBODY;
                    break;
                }
            }
            return first;
        }
        return Cell.NOBODY;

    }

    public boolean hasSpace()
    {
        for(int row = 0; row < NUM_ROWS; row++)
        {
            for(int col = 0; col < NUM_COLS; col++)
            {
                if(cells[row][col].getContent() == Cell.NOBODY)
                {
                    return true;
                }
            }
        }
        return false;
    }
    /*
       |   |
    ---+---+---
       |   |
    ---+---+---
       |   |
    A   B   C
  +---+---+---+
1 | X | X | X |
  +---+---+---+
2 |   | O |   |
  +---+---+---+
3 | X |   |   |
  +---+---+---+

    */
}

