package com.nbb.aaa.chess_tacticts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class chess_build extends AppCompatActivity {

    LinearLayout linearLayout;
    BoardGame boardGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boardGame = new BoardGame(this);
        //cb = new ChessBoard(this);
        setContentView(boardGame);

    }
}