package com.example.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
		EditText inputEmail, inputPassword;
		Button loginBtn;
		TextView forgotPassword,newUser;
		ImageView signGoogle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		if (getSupportActionBar() != null) {
			getSupportActionBar().hide();
		}
		inputEmail=findViewById(R.id.inputEmail);
		inputPassword=findViewById(R.id.inputPassword);
		loginBtn=(Button) findViewById(R.id.loginBtn);
		newUser=findViewById(R.id.newUser);
		forgotPassword=findViewById(R.id.forgotPassword);
		newUser.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(login.this,signup.class));
			}
		});

		forgotPassword.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(login.this,forgotPassword.class));
			}
		});


		loginBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(inputEmail.getText().toString().isEmpty() || inputPassword.getText().toString().isEmpty()){
					Toast.makeText(login.this, "Enter Valid Information.", Toast.LENGTH_SHORT).show();
				} else if (inputEmail.getText().toString().equals("admin@cutm.com") && inputPassword.getText().toString().equals("admin")) {
					startActivity(new Intent(login.this, home.class));

				}
			}
		});

	}
}