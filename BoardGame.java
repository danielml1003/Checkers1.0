package com.nbb.aaa.chess_tacticts;

        import android.content.Context;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.util.Log;
        import android.view.MotionEvent;
        import android.view.View;
        import android.widget.Toast;


public class BoardGame extends View {

    boolean setCoin = false;
    Coin coin;
    square[][]squares;
    Context context;
    public BoardGame(Context context) {
        super(context);
        this.context = context;
        squares = new square[8][8];
        coin = new Coin(this,0,0,10,Color.RED);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBoard(canvas);





    }


    public void updateCoinAfterRelease(){
        int x1=0,y1=0;
        for(int i=0;i<squares.length;i++){
            for(int j=0;j<squares.length;j++){
                if(squares[i][j].didXAndYInSquare(coin.x-coin.r, coin.y-coin.r)){
                    x1=i;
                    y1=j;
                }
            }
        }
        Log.d("asaf","i=" + x1 + " and j=" + y1);
        if(squares[x1][y1].color == Color.BLACK) {
            coin.x = squares[x1][y1].x + 2*coin.r;
            coin.y =squares[x1][y1].y + 2*coin.r;
            coin.lastx = squares[x1][y1].x + 2*coin.r;
            coin.lasty =squares[x1][y1].y + 2*coin.r;

        }else
        {
            coin.x = coin.lastx;
            coin.y = coin.lasty;
        }
    }
    public void drawBoard(Canvas canvas){
        int x = 0;
        int y = 0;
        int h = canvas.getWidth()/8;
        int w = canvas.getWidth()/8;
        int cnt = 1;
        int color;
        for(int i=0;i<squares.length;i++){
            for(int j=0;j<squares.length;j++){
                if(i%2==0) {
                    if (j % 2 == 0) {
                        color = Color.WHITE;


                    }
                    else{
                        color = Color.BLACK;
                    }

                }
                else{
                    if (j % 2 == 0){
                        color = Color.BLACK;

                    }

                    else color = Color.WHITE;

                }
                squares[i][j] = new square(this,x,y,w,h,color,i,j);
                squares[i][j].draw(canvas);

                if (i == 0 || i == 1 || i==2 || i == 5 || i == 6 || i==7)
                {
                    if(squares[i][j].color == Color.BLACK)
                    {
                        if(i == 5 || i == 6 || i==7)

                        coin = new Coin(this, x + 90, y + 90, 45,Color.BLUE);
                        if(i == 0 || i == 1 || i==2)
                        coin = new Coin(this, x + 90, y + 90, 45, Color.RED);
                        coin.draw(canvas);
                    }
                }




                x = x + w;
            }
            y = y + h;
            x = 0;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                coin.x = coin.lastx;
                coin.y = coin.lasty;
                coin.x = event.getRawX();
                coin.x = event.getRawY();
                return true;

            case MotionEvent.ACTION_MOVE:
                coin.x = coin.lastx + (int) (event.getRawX() - coin.lastx);
                coin.y = coin.lasty + (int) (event.getRawY() - coin.lasty);


                // Log.d("Params", "X: " + params.x + ".  Y: " + params.y + ".");



                return true;
            case MotionEvent.ACTION_UP:
                return true;
        }
        return false;

    }
}








