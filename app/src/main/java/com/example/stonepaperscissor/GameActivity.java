package com.example.stonepaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    private String playerName;
    private int usersChoice,computersChoice;
    private ProgressBar loading;
    private ImageView computerChoiceImage;
    private TextView gameInstruction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        playerName = getIntent().getStringExtra("name");
        usersChoice = -1;
        computersChoice = -1;
        loading = findViewById(R.id.progressBar);
        computerChoiceImage = (ImageView) findViewById(R.id.computerChoiceImage);
        gameInstruction = findViewById(R.id.gameInstruction);
    }

    public void userChoice(View view) {
        computersChoice = (int)(Math.random()*3)+1;
        switch(view.getId()){
            case R.id.stoneIcon:
                usersChoice = 1;
                break;
            case R.id.paperIcon:
                usersChoice = 2;
                break;
            case R.id.scissorIcon:
                usersChoice = 3;
                break;
            default:
                break;
        }
        loading.setVisibility(View.GONE);
        computerChoiceImage.setVisibility(View.VISIBLE);
        switch(computersChoice){
            case 1:
                computerChoiceImage.setImageResource(R.drawable.stone_icon);
                break;
            case 2:
                computerChoiceImage.setImageResource(R.drawable.paper_icon);
                break;
            case 3:
                computerChoiceImage.setImageResource(R.drawable.scissor_icon);
                break;
        }
        showResult(usersChoice,computersChoice);
    }
    public void showResult(int user,int computer){
        if(user==computer) {
            gameInstruction.setText(getString(R.string.draw_message) + playerName);
        }
        else if(user==1){
            if(computer==2)
                gameInstruction.setText("Computer Wins,Better luck next time " + playerName);
            else
                gameInstruction.setText("Congratulations, " + playerName+" wins");
        }
        else if(user==2){
            if(computer==3)
                gameInstruction.setText("Computer Wins,Better luck next time " + playerName);
            else
                gameInstruction.setText("Congratulations, " + playerName+" wins");
        }
        else{
            if(computer==1)
                gameInstruction.setText("Computer Wins,Better luck next time " + playerName);
            else
                gameInstruction.setText("Congratulations, " + playerName+" wins");
        }
    }
}