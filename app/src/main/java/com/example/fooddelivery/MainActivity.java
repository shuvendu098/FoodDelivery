package com.example.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
	ImageButton conti;
	FirebaseAuth mAuth;
//	@Override
//	public void onStart() {
//		super.onStart();
//		// Check if user is signed in (non-null) and update UI accordingly.
//		FirebaseUser currentUser = mAuth.getCurrentUser();
//		if(currentUser != null){
//			startActivity(new Intent(MainActivity.this, home.class));
//		}
//	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		mAuth=FirebaseAuth.getInstance();
		conti= (ImageButton) findViewById(R.id.conti);
		if (getSupportActionBar() != null) {
			getSupportActionBar().hide();
		}
		conti.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,login.class));
				finish();
			}
		});
	}
}