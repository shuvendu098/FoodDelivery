package com.example.fooddelivery;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
		EditText inputEmail, inputPassword;
		Button loginBtn;
		TextView forgotPassword,newUser;
		ImageView signGoogle;

		FirebaseAuth mAuth;

//	@Override
//	public void onStart() {
//		super.onStart();
//		// Check if user is signed in (non-null) and update UI accordingly.
//		FirebaseUser currentUser = mAuth.getCurrentUser();
//		if(currentUser != null){
//			startActivity(new Intent(login.this, home.class));
//		}
//	}
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
		mAuth=FirebaseAuth.getInstance();
		signGoogle=findViewById(R.id.signGoogle);
		signGoogle.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {


			}
		});



//	 Signup Intent
		newUser.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(login.this,signup.class));
			}
		});
//		Forgot Password Section
		forgotPassword.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(login.this,forgotPassword.class));
			}
		});






		loginBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String email=inputEmail.getText().toString();
				String password=inputPassword.getText().toString();
				if(email.isEmpty() )
					Toast.makeText(login.this, "Enter Email.", Toast.LENGTH_SHORT).show();
				if (password.isEmpty() )
					Toast.makeText(login.this, "Enter Password.", Toast.LENGTH_SHORT).show();

				mAuth.signInWithEmailAndPassword(email, password)
						.addOnCompleteListener( new OnCompleteListener<AuthResult>() {
							@Override
							public void onComplete(@NonNull Task<AuthResult> task) {
								if (task.isSuccessful()) {
									FirebaseUser user = mAuth.getCurrentUser();
									Toast.makeText(login.this, "LogIn Successful.",
											Toast.LENGTH_SHORT).show();
									startActivity(new Intent(login.this, home.class));
								} else {
									Log.w(TAG, "signInWithEmail:failure", task.getException());
									Toast.makeText(login.this, "Authentication failed.",
											Toast.LENGTH_SHORT).show();
								}
							}
						});




			}
		});

	}
}