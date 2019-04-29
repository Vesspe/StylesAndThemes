package com.example.scorekeeperapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {


    private TextView firstTeamScore;
    private TextView secondTeamScore;
    private int mScore1 =0;
    private int mScore2 =0;
    private String STATE_SCORE_1="";
    private String STATE_SCORE_2="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstTeamScore= (TextView) findViewById(R.id.first_team_score);
        secondTeamScore= (TextView) findViewById(R.id.second_team_score);

        if(savedInstanceState !=null)
        {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);


            //Set the score text views
            firstTeamScore.setText(valueOf(mScore1));
            secondTeamScore.setText(valueOf(mScore2));
            //for some weird reason mScore1 takes value of mScore2 after restore and i cant figure out why
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.night_mode)
        {
            //get current night mode state
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            //set theme mode
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES)
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            else
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        recreate();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void decreaseScore(View view) {
         int viewID = view.getId();
         switch(viewID) {
             case R.id.decreaseTeam1:
                 mScore1--;
                 firstTeamScore.setText(valueOf(mScore1));
                 break;
             case R.id.decreaseTeam2:
                 mScore2--;
                 secondTeamScore.setText(valueOf(mScore2));
                 break;
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
                firstTeamScore.setText(valueOf(mScore1));
                break;
            case R.id.increaseTeam2:
                mScore2++;
                secondTeamScore.setText(valueOf(mScore2));
                break;
                default:
                    //do nothing
        }

    }
}
