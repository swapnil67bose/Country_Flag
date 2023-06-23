package com.example.custom_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


import com.example.custom_listview.databinding.ActivityMainBinding;
import com.example.custom_listview.databinding.ActivityUserBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,
                R.drawable.m,R.drawable.z,R.drawable.n, R.drawable.h};
        String[] name = {"Afganistan","Bangladesh","Bhutan","India","Pakistan","Maldives","Ameraican","Nepal","Sri Lanka"};
        String[] country = {"Afghanistan, officially the Islamic Emirate of Afghanistan, is a landlocked country located at the crossroads of Central Asia and South Asia."
                ,"It is the eighth-most-populous country in the world, with a population of around 169 million people in an area of 148,460 square kilometres (57,320 sq mi)."
                ,"Bhutan officially the Kingdom of Bhutan is a landlocked Southern Asian country, which is situated in the Eastern Himalayas, between China in the north"
                ,"India, officially the Republic of India (ISO: Bhārat Gaṇarājya), is a country in South Asia. It is the seventh-largest country by area, the most populous "
                ,"Pakistan is the 33rd-largest country in the world by area and the second-largest in South Asia, spanning 881,913 square kilometres (340,509 square miles)."
                ,"The Flag of the Republic of Maldives is green with a red border. The center bears a vertical white crescent; the closed side of the crescent ",
                "The national flag of the United States consists of thirteen equal horizontal stripes of red (top and bottom) alternating with white",
                "Nepal officially the Federal Democratic Republic of Nepal is a landlocked country in South Asia. It is mainly situated in the Himalayas, but also includes"
                ,"Sri Lanka is a developing country, ranking 73rd on the Human Development Index. It is the highest-ranked South Asian nation in terms of development "};

        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            User user = new User(name[i],country[i],imageId[i]);
            userArrayList.add(user);

        }


        ListAdapter listAdapter = new ListAdapter(MainActivity.this,userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this,UserActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("country",country[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });

    }
}