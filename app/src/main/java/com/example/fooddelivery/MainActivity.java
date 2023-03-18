package com.example.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.window.SplashScreen;

public class MainActivity extends AppCompatActivity {
	private static int SPLASH_SCREEN=5000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		if (getSupportActionBar() != null) {
			getSupportActionBar().hide();
		}
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent intent =new Intent(MainActivity.this, login.class);
				startActivity(intent);
				finish();
			}
		}, SPLASH_SCREEN);
	}
}