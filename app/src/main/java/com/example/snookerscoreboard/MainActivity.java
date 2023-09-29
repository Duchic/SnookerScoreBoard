package com.example.snookerscoreboard;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
    TextView reds;
    Button restart;

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
    int yellowCount;
    int greenCount;
    int brownCount;
    int blueCount;
    int pinkCount;
    int blackCount;


    Button yellow;
    Button faul2;
    Button faul3;
    Button faul4;
    Button faul5;
    Button faul6;
    Button faul7;
    Button changePlayer;
    Player p1 = new Player();
    Player p2 = new Player();
    int redCount = 15;
    private Player selected = p1;

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
        reds = findViewById(R.id.reds);
        restart = findViewById(R.id.restart);

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
        disableBalls(1000); //aby se nastavilo enable jen red ball
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
        restart.setOnClickListener(view -> restartGame());
        editTextListeners();
    }

    private void restartGame() {
        redCount = 15;
        possible.setText("" + 147);
        ahead.setText("" + 0);
        remaining.setText("" + 147);
        reds.setText(""+redCount);
        p1.setPoints(0);
        p1.setBreakPoints(0);
        p1points.setText(""+p1.getPoints());
        p1break.setText(""+p1.getBreakPoints());
        p2.setPoints(0);
        p2.setBreakPoints(0);
        p2points.setText(""+p2.getPoints());
        p2break.setText(""+p2.getBreakPoints());
        disableBalls(1000); //aby se nastavilo enable jen red ball
    }

    private void editTextListeners() {
        p1name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                p1.setName(p1name.getText().toString());
            }
        });

        p2name.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                p2.setName(p2name.getText().toString());
            }
        });
    }

    private void pot(int points) {
        if (selectedPlayer == 1) {
            p1.setPoints(p1.getPoints() + points);
            p1.setBreakPoints(p1.getBreakPoints() + points);
            p1break.setText(p1.getBreakPoints()+"");
            p1points.setText(p1.getPoints()+"");
            changeAhead();
            changeRemaining(points);
            changePossiblePoints();
        } else {
            p2.setPoints(p2.getPoints() + points);
            p2.setBreakPoints(p2.getBreakPoints() + points);
            p2break.setText(p2.getBreakPoints()+"");
            p2points.setText(p2.getPoints()+"");
            changeAhead();
            changeRemaining(points);
            changePossiblePoints();
        }

        if (points == 1){
            redCount--;
            changeRemaining(points);
            changePossiblePoints();
            changeNumberOfReds();
            disableBalls(points);
        }

        if (redCount < 1) {
            setRedButtonDisabledEnabled(false);
        }

        switch (points) {
            case 2:
                yellowCount++;
                disableBalls(points);
                break;
            case 3:
                greenCount++;
                disableBalls(points);
                break;
            case 4:
                brownCount++;
                disableBalls(points);
                break;
            case 5:
                blueCount++;
                disableBalls(points);
                break;
            case 6:
                pinkCount++;
                disableBalls(points);
                break;
            case 7:
                blackCount++;
                disableBalls(points);
                break;
        }

    }

    private void setPottedBallsCount(int selectedPlayer, int points) {
        if (selectedPlayer == 1){
            if (points == 1){
                p1.setPottedRed(p1.getPottedRed() + 1);
            } //TODO - vsechny koule + hrac2 + volani metody na prislusnych mistech + vyzkouset funkcnost
        }
    }

    private void disableBalls(int points) {
        if (points == 1) {
            red.setBackgroundColor(Color.GRAY);
            red.setEnabled(false);
            black.setBackgroundColor(Color.parseColor("#000000"));
            black.setEnabled(true);
            pink.setBackgroundColor(Color.parseColor("#e01f72"));
            pink.setEnabled(true);
            blue.setBackgroundColor(Color.parseColor("#134a8d"));
            blue.setEnabled(true);
            brown.setBackgroundColor(Color.parseColor("#562e19"));
            brown.setEnabled(true);
            green.setBackgroundColor(Color.parseColor("#2b4119"));
            green.setEnabled(true);
            yellow.setBackgroundColor(Color.parseColor("#ffb100"));
            yellow.setEnabled(true);
        } else {
            red.setBackgroundColor(Color.parseColor("#FF050F"));
            red.setEnabled(true);
            black.setBackgroundColor(Color.GRAY);
            black.setEnabled(false);
            pink.setBackgroundColor(Color.GRAY);
            pink.setEnabled(false);
            blue.setBackgroundColor(Color.GRAY);
            blue.setEnabled(false);
            brown.setBackgroundColor(Color.GRAY);
            brown.setEnabled(false);
            green.setBackgroundColor(Color.GRAY);
            green.setEnabled(false);
            yellow.setBackgroundColor(Color.GRAY);
            yellow.setEnabled(false);
        }
    }

    private void faul(int points) {
        if (selectedPlayer == 1) {
            p1.setBreakPoints(0);
            p1break.setText("" + p1.getBreakPoints());
            p2.setPoints(p2.getPoints() + points);
            p2points.setText("" + p2.getPoints());
            changeAhead();
            changeRemaining(points);
            changePossiblePoints();
        } else {
            p2.setBreakPoints(0);
            p2break.setText("" + p2.getBreakPoints());
            p1.setPoints(p2.getPoints() + points);
            p1points.setText("" + p1.getPoints());
            changeAhead();
            changeRemaining(points);
            changePossiblePoints();
        }
    }

    private void changeRemaining(int points) {
        if (redCount == 0 & points == 1) {
            remaining.setText("" + (27));
        } else if (redCount == 0 & points != 1) {
            remaining.setText("" + (27 - points));
        } else {
            remaining.setText(((redCount * 8) + 27)+"");
        }
    }

    private void changeAhead() {
        if (p1.getPoints() - p2.getPoints() == 0){
            ahead.setText(0+"");
        }
        if (p1.getPoints() - p2.getPoints() > 0){
            ahead.setText((p1.getPoints() - p2.getPoints())+"");
        }
        if (p2.getPoints() - p1.getPoints() > 0){
            ahead.setText((p2.getPoints() - p1.getPoints())+"");
        }
    }

    private void changePossiblePoints() { //funguje spatne
        if (selectedPlayer == 1) {
            if (blackCount > 0) {
                int blackPoints = ((Balls.BLACK.getValue() + 1) * blackCount);
            }
            if (pinkCount > 0) {
                int pinkPoints = ((Balls.PINK.getValue() + 1) * pinkCount);
            }
            if (blueCount > 0) {
                int bluePoints = ((Balls.BLUE.getValue() + 1) * blueCount);
            }
            if (brownCount > 0) {
                int brownPoints
            }
        }
    }

    private void changeNumberOfReds() {
        reds.setText("" + redCount);
    }

    private void changeActivePlayer(){
        p1.setBreakPoints(0);
        p2.setBreakPoints(0);
        p1break.setText(p1.getBreakPoints()+"");
        p2break.setText(p2.getBreakPoints()+"");
        if (selectedPlayer == 1){
            selectedPlayer = 2;
            p2name.setTypeface(null, Typeface.BOLD);
            p1name.setTypeface(null, Typeface.NORMAL);
            Toast.makeText(this,"Active player: " + p2name.getText(), Toast.LENGTH_SHORT).show();
            setPottedColorBallsCountToZero();
            disableBalls(1000);
        } else {
            selectedPlayer = 1;
            p2name.setTypeface(null, Typeface.NORMAL);
            p1name.setTypeface(null, Typeface.BOLD);
            Toast.makeText(this,"Active player: " + p1name.getText(), Toast.LENGTH_SHORT).show();
            setPottedColorBallsCountToZero();
            disableBalls(1000);
        }
    }

    private void setPottedColorBallsCountToZero() {
        blackCount = 0;
        pinkCount = 0;
        blueCount = 0;
        brownCount = 0;
        greenCount = 0;
        yellowCount = 0;
    }

    private void setRedButtonDisabledEnabled(boolean status){
        red.setEnabled(status);
        red.setBackgroundColor(Color.GRAY);
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