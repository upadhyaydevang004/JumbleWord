package com.example.jumbleword;

import android.os.Bundle;
import android.os.CountDownTimer;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity {
	CountDownTimer t;
	TextView score,attempt,time,word;
	EditText et;
	Button b;
	ImageView iv;
	int	count=0,tick,cross;
	int score1=0,time1,attempt1=2,level;
	Resources rs;
	String word_1[]=	{"what","pure","tear","love","beat","meat","kick","mat","sing","pest","ring","brim","trim","fax","sun","boil","king","grey","gate","game","pet","cat","grip","sake","core","take","seat"};        
	String jumbled_1[]= {"hwat","rupe","aret","veol","ebta","etma","cikk","tam","nigs","tesp","grin","ribm","mitr","xfa","uns","oilb","gnik","rgye","atge","emag","etp","tac","rpig","kase","roce","kate","teas"};
	String word_2[]=	{"hello","prize","water","taste","money","honey","refil","green","woman","mango","phone","sheet"};
	String jumbled_2[]= {"lehlo","ripze","etarw","atase","neyom","heyno","feril","regen","mowna","gamno","hnope","heste"};
	String word_3[]=	{"amazing","number","purple","switch","yellow"};
	String jumbled_3[]= {"zigmaan","benmru","rulpep","ihcwst","welloy"};
	Set<Integer>generate=new LinkedHashSet<Integer>();
	ArrayList<Integer>order=new ArrayList<Integer>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
	rs=getResources();
	tick=rs.getIdentifier("tick","drawable", getPackageName());
	cross=rs.getIdentifier("cross","drawable", getPackageName());
		score=(TextView) findViewById(R.id.score);
	attempt=(TextView) findViewById(R.id.attempt);
	time=(TextView) findViewById(R.id.time);
	word=(TextView) findViewById(R.id.textView4);
	et=(EditText) findViewById(R.id.editText1);
	b=(Button) findViewById(R.id.button1);
	iv=(ImageView) findViewById(R.id.imageView1);
	Intent i=getIntent();
	level=i.getIntExtra("level", 0);
	if(level==0)
	{
		while(generate.size()<word_1.length)
		{
			Random rand=new Random();
			generate.add(rand.nextInt(word_1.length));
		}
		order.addAll(generate);
		word.setText(jumbled_1[order.get(0)]);
		
		
	}
	
	
	if(level==1)
	{
		while(generate.size()<word_2.length)
		{
			Random rand=new Random();
			generate.add(rand.nextInt(word_2.length));
		}
		order.addAll(generate);
	word.setText(jumbled_2[order.get(0)]);
		
		
	}
	if(level==2)
	{
	
		while(generate.size()<word_3.length)
		{
			Random rand=new Random();
			generate.add(rand.nextInt(word_3.length));
		}
		order.addAll(generate);
		word.setText(jumbled_3[order.get(0)]);
		
		
	}
	
	
	
	
	 t=new CountDownTimer(60000,1000) {
		
		@Override
		public void onTick(long millisUntilFinished) {
			// TODO Auto-generated method stub
			time.setText(" "+millisUntilFinished/1000);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
		
					
				if(level==0)
				{
					if(attempt1>0)
					{	
						
						if(count<word_1.length-1)
						{
							String s=et.getText().toString().trim();
							int index=order.get(count);
							if(s.equalsIgnoreCase(word_1[index]))
							{
								iv.setImageResource(tick);
								count++;
								index=order.get(count);
								score1++;
								word.setText(jumbled_1[index]);
								score.setText(""+score1);
								et.setText("");
							if(count==word_1.length-1)
							{
								Intent abc=new Intent(GameActivity.this,ScoreActivity.class);
								abc.putExtra("userscore", score1);
								abc.putExtra("message", "Winner!!");
								startActivity(abc);
								t.cancel();
								finish();
							}
							}
							else
							{
								attempt1--;
								iv.setImageResource(cross);
								et.setText("");
								
								attempt.setText(""+attempt1);
							if(attempt1==0)
							{
								Intent abc=new Intent(GameActivity.this,ScoreActivity.class);
								abc.putExtra("userscore", score1);
								abc.putExtra("message" ,"Game Over");
								startActivity(abc);
								t.cancel();
								finish();
							}
							
							}
						}
						else
						{
							Intent abc=new Intent(GameActivity.this,ScoreActivity.class);
							abc.putExtra("userscore", score1);
							abc.putExtra("message", "Winner!!");
							startActivity(abc);
							t.cancel();
							finish();
							
						}
						
					}
					else
					{
						
						Intent abc=new Intent(GameActivity.this,ScoreActivity.class);
						abc.putExtra("userscore", score1);
						abc.putExtra("message" ,"Game Over");
						startActivity(abc);
						t.cancel();
						finish();

					
					}
				}
				if(level==1)
				{
					if(attempt1>0)
					{	
						
						if(count<word_2.length-1)
						{
							String s=et.getText().toString().trim();
							int index=order.get(count);
							if(s.equalsIgnoreCase(word_2[index]))
							{
								iv.setImageResource(tick);
								count++;
								index=order.get(count);
								score1+=2;
								word.setText(jumbled_2[index]);
								score.setText(""+score1);
								et.setText("");
							if(count==word_2.length-1)
							{
								Intent abc=new Intent(GameActivity.this,ScoreActivity.class);
								abc.putExtra("userscore", score1);
								abc.putExtra("message", "Winner!!");
								startActivity(abc);
								t.cancel();
								finish();
							}
							}
							else
							{
								attempt1--;
								iv.setImageResource(cross);
								et.setText("");
									
								attempt.setText(""+attempt1);
							if(attempt1==0)
							{
								Intent abc=new Intent(GameActivity.this,ScoreActivity.class);
								abc.putExtra("userscore", score1);
								abc.putExtra("message" ,"Game Over");
								startActivity(abc);
								t.cancel();
								finish();
							}
							
							}
						}
						else
						{
						
							Intent abc=new Intent(GameActivity.this,ScoreActivity.class);
							abc.putExtra("userscore", score1);
							abc.putExtra("message", "Winner!!");
							startActivity(abc);
							t.cancel();
							finish();
							
						}
						
					}
					else
					{
						Intent abc=new Intent(GameActivity.this,ScoreActivity.class);
						abc.putExtra("userscore", score1);
						abc.putExtra("message" ,"Game Over");
						startActivity(abc);
						t.cancel();
						finish();

					
					}
				}
				if(level==2)
				{
					if(attempt1>0)
					{	
						
						if(count<word_3.length-1)
						{
							String s=et.getText().toString().trim();
							int index=order.get(count);
							if(s.equalsIgnoreCase(word_3[index]))
							{
								iv.setImageResource(tick);
								count++;
								index=order.get(count);
								score1+=3;
								word.setText(jumbled_3[index]);
								score.setText(""+score1);
					
								et.setText("");
							if(count==word_3.length-1)
							{
								Intent abc=new Intent(GameActivity.this,ScoreActivity.class);
								abc.putExtra("userscore", score1);
								abc.putExtra("message", "Winner!!");
								startActivity(abc);
								t.cancel();
								finish();
							}
							}
							else
							{
								attempt1--;
								iv.setImageResource(cross);
								et.setText("");
								
								attempt.setText(""+attempt1);
							if(attempt1==0)
							{
								Intent abc=new Intent(GameActivity.this,ScoreActivity.class);
								abc.putExtra("userscore", score1);
								abc.putExtra("message" ,"Game Over");
								startActivity(abc);
								t.cancel();
								finish();
							}
							
							}
						}
						else
						{
							Intent abc=new Intent(GameActivity.this,ScoreActivity.class);
							abc.putExtra("userscore", score1);
							abc.putExtra("message", "Winner!!");
							startActivity(abc);
							t.cancel();
							finish();
							
						}
						
					}
					else
					{
						Intent abc=new Intent(GameActivity.this,ScoreActivity.class);
						abc.putExtra("userscore", score1);
						abc.putExtra("message" ,"Game Over");
						startActivity(abc);
						t.cancel();
						finish();

					
					}
				}
				
			}
		});
	
		}
		
		@Override
		public void onFinish() {
			// TODO Auto-generated method stub
			Intent abc=new Intent(GameActivity.this,ScoreActivity.class);
			abc.putExtra("userscore", score1);
			abc.putExtra("message" ,"Time UP\n Game Over");
			startActivity(abc);
			finish();		
		}
	};
	
	t.start();
	}

}
