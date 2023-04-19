package com.example.fooddelivery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fooddelivery.adapter.AsiaFoodAdapter;
import com.example.fooddelivery.adapter.PopularFoodAdapter;
import com.example.fooddelivery.model.AsiaFood;
import com.example.fooddelivery.model.PopularFood;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
	RecyclerView popularRecycler, asiaRecycler;
	PopularFoodAdapter popularFoodAdapter;
	AsiaFoodAdapter asiaFoodAdapter;
	View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		view= inflater.inflate(R.layout.fragment_home, container, false);
		popularRecycler=(RecyclerView)view.findViewById(R.id.popular_recycler);
		asiaRecycler=(RecyclerView)view.findViewById(R.id.asia_recycler);

		List<PopularFood> popularFoodList = new ArrayList<>();
		popularFoodList.add(new PopularFood("Float Cake Vietnam", "$7.05", R.drawable.popularfood1));
		popularFoodList.add(new PopularFood("Chiken Drumstick", "$17.05", R.drawable.popularfood2));
		popularFoodList.add(new PopularFood("Fish Tikka Stick", "$25.05", R.drawable.popularfood3));
		popularFoodList.add(new PopularFood("Float Cake Vietnam", "$7.05", R.drawable.popularfood1));
		popularFoodList.add(new PopularFood("Chiken Drumstick", "$17.05", R.drawable.popularfood2));
		popularFoodList.add(new PopularFood("Fish Tikka Stick", "$25.05", R.drawable.popularfood3));
		popularFoodAdapter = new PopularFoodAdapter(getContext(), popularFoodList);
		popularRecycler.setAdapter(popularFoodAdapter);


		List<AsiaFood> asiaFoodList = new ArrayList<>();
		asiaFoodList.add(new AsiaFood("Chicago Pizza", "$20", R.drawable.asiafood1, "4.5", "Briand Restaurant"));
		asiaFoodList.add(new AsiaFood("Straberry Cake", "$25", R.drawable.asiafood2, "4.2", "Friends Restaurant"));
		asiaFoodList.add(new AsiaFood("Chicago Pizza", "$20", R.drawable.asiafood1, "4.5", "Briand Restaurant"));
		asiaFoodList.add(new AsiaFood("Straberry Cake", "$25", R.drawable.asiafood2, "4.2", "Friends Restaurant"));
		asiaFoodList.add(new AsiaFood("Chicago Pizza", "$20", R.drawable.asiafood1, "4.5", "Briand Restaurant"));
		asiaFoodList.add(new AsiaFood("Straberry Cake", "$25", R.drawable.asiafood2, "4.2", "Friends Restaurant"));
		asiaFoodAdapter = new AsiaFoodAdapter(getContext(), asiaFoodList);
		asiaRecycler.setAdapter(asiaFoodAdapter);

		return view;
	}



}
