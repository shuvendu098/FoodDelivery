package com.example.fooddelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class home extends AppCompatActivity {
	BottomNavigationView bottomNavigationView;
	HomeFragment homeFragment=new HomeFragment();
	OrderFragment orderFragment= new OrderFragment();
	ProfileFragment profileFragment=new ProfileFragment();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		bottomNavigationView=findViewById(R.id.bottomNavigationView);
		getSupportFragmentManager().beginTransaction().replace(R.id.fragmentholder,homeFragment).commit();
		bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem item) {
				switch (item.getItemId()){
					case R.id.homeMenu:
						getSupportFragmentManager().beginTransaction().replace(R.id.fragmentholder,homeFragment).commit();
						overridePendingTransition(0,0);
						return true;
					case R.id.myOrderMenu:
						getSupportFragmentManager().beginTransaction().replace(R.id.fragmentholder,orderFragment).commit();
						overridePendingTransition(0,0);
						return true;
					case R.id.profileMenu:
						getSupportFragmentManager().beginTransaction().replace(R.id.fragmentholder,profileFragment).commit();
						overridePendingTransition(0,0);
						return true;
				}
				return true;
			}
		});

		if (getSupportActionBar() != null) {
			getSupportActionBar().hide();
		}

	}
}