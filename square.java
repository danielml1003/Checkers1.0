package com.nbb.aaa.chess_tacticts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;



public class square  {

    BoardGame boardGame;
    float x,y,w,h;//top left
    int color;
    Paint p;
    int colorSoldirer = 0;//0 - available , 1 black , 2 - white soldier

    int i,j;

    public square(BoardGame boardGame,float x,float y,float w,float h,int color,int i, int j)
    {
        this.x = x;
        this.y = y;
        this.color = color;
        this.boardGame = boardGame;
        p = new Paint();
        p.setColor(color);
        this.w = w;
        this.h = h;
        this.i = i;
        this.j = j;
    }

    public void draw(Canvas canvas)
    {
        canvas.drawRect(x,y,x+w,y+h,p);
    }

    public boolean didXAndYInSquare(float xo, float yo)
    {
        if(xo > x && xo < x + w && yo > y && yo < yo + h )
            return true;
        return false;
    }


}
