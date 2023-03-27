package com.example.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SpalsScreen extends AppCompatActivity {

	Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spals_screen);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		if (getSupportActionBar() != null) {
			getSupportActionBar().hide();
		}
		handler=new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent intent=new Intent(SpalsScreen.this,MainActivity.class);
				startActivity(intent);
				finish();
			}
		},3000);
	}
}