package com.github.timshnayder;

public class Cell
{
    //Instance Variables
    public static final int NOBODY = 0;
    public static final int X = 1;
    public static final int O = 2;
    private int content = NOBODY;

    public void setContent(int c)
    {
        content = c;
    }

    public int getContent()
    {
        return content;
    }
}

