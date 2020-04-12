package com.github.timshnayder;

public class TicTacToe {

    public static void main(String[] args) {

        Grid grid = new Grid();
        Player p = new Player(grid);
        Cpu c = new Cpu(grid);
        c.setLevel(Cpu.SMART);
        while (grid.getComplete() == Cell.NOBODY && grid.hasSpace()) {
            grid.print();
            p.playTurn();
            if(grid.getComplete() == Cell.NOBODY && grid.hasSpace())
            {
                c.playTurn();
            }
        }
        grid.print();
        if(grid.getComplete() == Cell.X)
        {
            System.out.println();
            System.out.println("You Win!");
        }
        else if(grid.getComplete() == Cell.O)
        {
            System.out.println();
            System.out.println("Cpu wins");
        }
        else
        {
            System.out.println();
            System.out.println("Tie");
        }

    }
}
