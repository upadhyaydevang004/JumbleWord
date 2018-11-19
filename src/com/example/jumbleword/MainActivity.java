package com.example.jumbleword;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button b1,b2,b3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
		b3=(Button) findViewById(R.id.button3);
	
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			AlertDialog.Builder build=new AlertDialog.Builder(MainActivity.this);	
			build.setTitle("Level");
			build.setMessage("Please Select Level?");
			build.setPositiveButton("Easy", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Intent i=new Intent(MainActivity.this, GameActivity.class);
					i.putExtra("level", 0);
					startActivity(i);		
					
				}
			});
		
			build.setNeutralButton("Medium", new DialogInterface.OnClickListener() {
	
				@Override
				public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
					Intent i=new Intent(MainActivity.this, GameActivity.class);
					i.putExtra("level", 1);
					startActivity(i);		
		
				}
			});
			
			build.setNegativeButton("Hard", new DialogInterface.OnClickListener() {
				
				@Override
		public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
					Intent i=new Intent(MainActivity.this, GameActivity.class);
					i.putExtra("level", 2);
					startActivity(i);		
		
				}
			});
		
			build.show();
			}
		});
		
		
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent abc=new Intent(MainActivity.this,ScoreActivity.class);
				abc.putExtra("userscore", -1);
				abc.putExtra("message", " ");
				startActivity(abc);
			
			}
		});
		
		b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("Exit?");
				builder.setMessage("Do you Really want to Exit?");
				builder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
					finish();	
					}
				} );
				
				builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				});
				builder.show();
			}
			
		});
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
