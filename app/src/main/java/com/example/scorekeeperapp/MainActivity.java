package com.example.scorekeeperapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView firstTeamScore;
    private TextView secondTeamScore;
    private int mScore1 =0;
    private int mScore2 =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstTeamScore= (TextView) findViewById(R.id.first_team_score);
        secondTeamScore= (TextView) findViewById(R.id.second_team_score);
    }

    public void decreaseScore(View view) {
         int viewID = view.getId();
         switch(viewID) {
             case R.id.decreaseTeam1:
                 mScore1--;
                 firstTeamScore.setText(String.valueOf(mScore1));
                 break;
             case R.id.decreaseTeam2:
                 mScore2--;
                 secondTeamScore.setText(String.valueOf(mScore2));
             default:
                 //do nothing

         }
    }

    public void increaseScore(View view) {
        int viewId = view.getId();
        switch(viewId)
        {
            case R.id.increaseTeam1:
                mScore1++;
                firstTeamScore.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam2:
                mScore2++;
                secondTeamScore.setText(String.valueOf(mScore2));
                break;
                default:
                    //do nothing
        }

    }
}
