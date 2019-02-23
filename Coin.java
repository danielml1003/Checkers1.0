package com.nbb.aaa.chess_tacticts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;



public class Coin {

    float lastx,lasty;
    float x,y;
    float r;
    int color;
    BoardGame boardGame;
    Paint p;
    public Coin(BoardGame boardGame,float x,float y,float r,int color)
    {
        this.boardGame = boardGame;
        this.lastx=x;
        this.lasty=y;
        this.x=x;this.y=y;
        this.r=r;
        this.color=color;
        p = new Paint();
        p.setColor(color);

    }
    public void draw(Canvas canvas)
    {
        canvas.drawCircle(x,y,r,p);
    }




    public boolean didUserTouchMe(float xu,float yu)
    {
        if(xu > x - r && xu < x + r && yu > y -r && yu < y + r ) {




            return true;
        }
        return false;
    }
}
