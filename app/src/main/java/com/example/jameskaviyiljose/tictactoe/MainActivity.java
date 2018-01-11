package com.example.jameskaviyiljose.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;
    // 0 for cross and 1 for circle
    //For maintaining the game state
    int[] gameState={2,2,2,2,2,2,2,2,2};

    public void imageTapped(View view) {
        ImageView myTapped = (ImageView) view;
        //Log.i("tag is","image number is" + myTapped.getTag().toString());

        int tappedImageTag = Integer.parseInt(myTapped.getTag().toString());

        if (gameState[tappedImageTag] == 2) {
            gameState[tappedImageTag] = activePlayer;
            if(activePlayer == 0) {
                myTapped.setImageResource(R.drawable.cross);
                myTapped.animate().rotation(360).setDuration(1000);
                activePlayer = 1;
            }
            else{
                myTapped.setImageResource(R.drawable.circle);
                activePlayer = 0;
            }

        } else{
            Toast.makeText(MainActivity.this,"This icon is occupied! Try again...",Toast.LENGTH_LONG).show();
        }

    }

    public void playAgain(View view){
        //Log.i("msg","Play again tapped!");
        //Change game state to 2
        for(int i =0;i<9;i++)
        {
         gameState[i] = 2;
        }
        //Change activeplayer to 0
        activePlayer = 0;

        //Reset all images

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lineOne);

        for (int i=0;i<linearLayout.getChildCount();i++){
            ((ImageView) linearLayout.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }

        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.lineTwo);

        for (int i=0;i<linearLayout1.getChildCount();i++){
            ((ImageView) linearLayout1.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }

        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.lineThree);

        for (int i=0;i<linearLayout2.getChildCount();i++){
            ((ImageView) linearLayout2.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}