package com.example.githubku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private UserAdapter userAdapter;
    private String[] dataUsername;
    private String[] dataName;
    private int[] dataFollowers;
    private int[] dataFollowing;
    private TypedArray dataPhoto;
    private ArrayList<User> users;
    private String[] location;
    private String[] company;
    private String[] repo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listview);
        prepare();
        users = addItem();
        userAdapter = new UserAdapter(this, users);
        listView.setAdapter(userAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailUser.class);
                intent.putParcelableArrayListExtra(DetailUser.EXTRA_USER, users);
                startActivity(intent);
            }
        });

    }

    private void prepare(){
        dataUsername = getResources().getStringArray(R.array.username);
        dataName = getResources().getStringArray(R.array.name);
        dataFollowers = getResources().getIntArray(R.array.followers);
        dataFollowing = getResources().getIntArray(R.array.following);
        dataPhoto = getResources().obtainTypedArray(R.array.avatar);
        location = getResources().getStringArray(R.array.location);
        company = getResources().getStringArray(R.array.company);
        repo = getResources().getStringArray(R.array.repository);
    }

    private ArrayList<User> addItem(){
        ArrayList<User> users = new ArrayList<>();
        String string;
        String string2;

        for (int i = 0; i < dataUsername.length; i++){
            User user = new User();
            user.setImage(dataPhoto.getResourceId(i, -1));
            user.setUsername(dataUsername[i]);
            user.setName(dataName[i]);
            user.setLocation(location[i]);
            user.setCompany(company[i]);
            user.setRepository(repo[i]);
            if (dataFollowers[i] >= 1000){
                dataFollowers[i] = dataFollowers[i]/1000;
                string = String.valueOf(dataFollowers[i]);
                string = string + "k";
                user.setFollowers(string);
            }else{
                string = String.valueOf(dataFollowers[i]);
                user.setFollowers(string);
            }

            if (dataFollowing[i] >= 1000){
                dataFollowing[i] = dataFollowing[i]/1000;
                string2 = String.valueOf(dataFollowing[i]);
                string2 = string2 + "k";
                user.setFollowing(string2);
            }else{
                string2 = String.valueOf(dataFollowing[i]);
                user.setFollowing(string2);
            }

            users.add(user);
        }
        return users;
    }
}