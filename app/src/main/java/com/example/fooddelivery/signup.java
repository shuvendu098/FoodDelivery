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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {

	FirebaseAuth mAuth;
	EditText editEmail,editPassword;
	Button signup;
	ImageView signgoogle;
//	@Override
//	public void onStart() {
//		super.onStart();
//		FirebaseUser currentUser = mAuth.getCurrentUser();
//		if(currentUser != null){
//			startActivity(new Intent(signup.this, home.class));
//		}
//	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);
		mAuth=FirebaseAuth.getInstance();
		editEmail=findViewById(R.id.emailUser);
		editPassword=findViewById(R.id.emailUser);
		signup=findViewById(R.id.signUp);
		signgoogle=findViewById(R.id.googlesign);
		signgoogle.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});


		if (getSupportActionBar() != null) {
			getSupportActionBar().hide();
		}
		signup.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String email, password;
				email = editEmail.getText().toString();
				password = editPassword.getText().toString();
				if (email.isEmpty())
					Toast.makeText(signup.this, "Enter Email.", Toast.LENGTH_SHORT).show();
				if (password.isEmpty())
					Toast.makeText(signup.this, "Enter Password.", Toast.LENGTH_SHORT).show();
				mAuth.createUserWithEmailAndPassword(email, password)
						.addOnCompleteListener( new OnCompleteListener<AuthResult>() {
							@Override
							public void onComplete(@NonNull Task<AuthResult> task) {
								if (task.isSuccessful()) {
									FirebaseUser user = mAuth.getCurrentUser();
									Toast.makeText(signup.this, "SignUp Successful.",
											Toast.LENGTH_SHORT).show();
									startActivity(new Intent(signup.this, home.class));
								} else {
									Toast.makeText(signup.this, "Authentication failed.",
											Toast.LENGTH_SHORT).show();
								}
							}
						});



			}



		});




	}

}