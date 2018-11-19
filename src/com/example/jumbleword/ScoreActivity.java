package com.example.jumbleword;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class ScoreActivity extends Activity {
	TextView score,message,highscore,tv2;
	SharedPreferences sp;
	int hs=1; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score);
		
		sp=getSharedPreferences("jubmle", MODE_PRIVATE);
		Editor edit=sp.edit();
		
		Intent abc=getIntent();
		String message1=abc.getStringExtra("message");
		int score1=abc.getIntExtra("userscore", 0);
		score=(TextView) findViewById(R.id.textView3);
		message=(TextView) findViewById(R.id.textView1);
		highscore=(TextView) findViewById(R.id.textView4);
		tv2=(TextView) findViewById(R.id.textView2);
		score.setText(""+score1);
		message.setText(message1);
		int newhs=sp.getInt("highscore", 1);
		if(newhs<score1)
		{
			highscore.setText("New HighScore");
			edit.putInt("highscore", score1);
			edit.commit();
		}
		if(score1==-1)
		{
			tv2.setText("Highscore: ");
			score.setText(""+newhs);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.score, menu);
		return true;
	}

}
