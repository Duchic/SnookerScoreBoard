package com.example.snookerscoreboard;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText p1name;
    EditText p2name;

    TextView possible;
    TextView ahead;
    TextView remaining;

    TextView p1points;
    TextView p1break;
    TextView p2points;
    TextView p2break;
    Button red;
    Button black;
    Button pink;
    Button blue;
    Button brown;
    Button green;


    Button yellow;
    Button faul2;
    Button faul3;
    Button faul4;
    Button faul5;
    Button faul6;
    Button faul7;
    Button changePlayer;

    private int selectedPlayer = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p1name = findViewById(R.id.player1name);
        p2name = findViewById(R.id.player2name);
        possible = findViewById(R.id.possiblePoints);
        ahead = findViewById(R.id.ahead);
        remaining = findViewById(R.id.remaining);


        p1points = findViewById(R.id.p1points);
        p1break = findViewById(R.id.p1break);
        p2points = findViewById(R.id.p2points);
        p2break = findViewById(R.id.p2break);

        red = findViewById(R.id.red);
        black = findViewById(R.id.black);
        pink = findViewById(R.id.pink);
        blue = findViewById(R.id.blue);
        brown = findViewById(R.id.brown);
        green = findViewById(R.id.green);
        yellow = findViewById(R.id.yellow);

        faul2 = findViewById(R.id.faul2);
        faul3 = findViewById(R.id.faul3);
        faul4 = findViewById(R.id.faul4);
        faul5 = findViewById(R.id.faul5);
        faul6 = findViewById(R.id.faul6);
        faul7 = findViewById(R.id.faul7);
        changePlayer = findViewById(R.id.switcher);
        p1name.setTypeface(null, Typeface.BOLD);
        setListeners();
    }

    private void setListeners() {
        changePlayer.setOnClickListener(view -> changeActivePlayer());
        red.setOnClickListener(view -> pot(Balls.RED.getValue()));
        black.setOnClickListener(view -> pot(Balls.BLACK.getValue()));
        pink.setOnClickListener(view -> pot(Balls.PINK.getValue()));
        blue.setOnClickListener(view -> pot(Balls.BLUE.getValue()));
        brown.setOnClickListener(view -> pot(Balls.BROWN.getValue()));
        green.setOnClickListener(view -> pot(Balls.GREEN.getValue()));
        yellow.setOnClickListener(view -> pot(Balls.YELLOW.getValue()));
        faul2.setOnClickListener(view -> faul(Fauls.FAUL2.getValue()));
        faul3.setOnClickListener(view -> faul(Fauls.FAUL3.getValue()));
        faul4.setOnClickListener(view -> faul(Fauls.FAUL4.getValue()));
        faul5.setOnClickListener(view -> faul(Fauls.FAUL5.getValue()));
        faul6.setOnClickListener(view -> faul(Fauls.FAUL6.getValue()));
        faul7.setOnClickListener(view -> faul(Fauls.FAUL7.getValue()));
    }

    private void pot(int points) {

    }

    private void faul(int points) {

    }

    private void changeRemaining(int points) {

    }

    private void changeAhead(int p1, int p2) {

    }

    private void changePossiblePoints() {

    }

    private void changeActivePlayer(){
        if (selectedPlayer == 1){
            selectedPlayer = 2;
            p2name.setTypeface(null, Typeface.BOLD);
            p1name.setTypeface(null, Typeface.NORMAL);
            Toast.makeText(this,"Active player: " + selectedPlayer, Toast.LENGTH_SHORT).show();
        } else {
            selectedPlayer = 1;
            p2name.setTypeface(null, Typeface.NORMAL);
            p1name.setTypeface(null, Typeface.BOLD);
            Toast.makeText(this,"Active player: " + selectedPlayer, Toast.LENGTH_SHORT).show();
        }
    }

    public TextView getP1points() {
        return p1points;
    }

    public void setP1points(TextView p1points) {
        this.p1points = p1points;
    }

    public TextView getP1break() {
        return p1break;
    }

    public void setP1break(TextView p1break) {
        this.p1break = p1break;
    }

    public TextView getP2points() {
        return p2points;
    }

    public void setP2points(TextView p2points) {
        this.p2points = p2points;
    }

    public TextView getP2break() {
        return p2break;
    }

    public void setP2break(TextView p2break) {
        this.p2break = p2break;
    }

    public TextView getPossible() {
        return possible;
    }

    public void setPossible(TextView possible) {
        this.possible = possible;
    }

    public TextView getAhead() {
        return ahead;
    }

    public void setAhead(TextView ahead) {
        this.ahead = ahead;
    }

    public TextView getRemaining() {
        return remaining;
    }

    public void setRemaining(TextView remaining) {
        this.remaining = remaining;
    }
}