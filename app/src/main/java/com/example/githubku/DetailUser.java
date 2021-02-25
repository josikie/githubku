package com.example.githubku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailUser extends AppCompatActivity {

    public static final String EXTRA_USER = "extra_user";
    TextView tvUsername;
    TextView tvName;
    TextView tvFollowers;
    TextView tvFollowing;
    TextView tvLocation;
    TextView tvRepository;
    ImageView imgAvatar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        tvUsername = findViewById(R.id.usernamenya);
        tvName = findViewById(R.id.namenya);
        tvFollowers = findViewById(R.id.followernya);
        tvFollowing = findViewById(R.id.followingnya);
        tvLocation = findViewById(R.id.mylocation);
        tvRepository = findViewById(R.id.repository);
        imgAvatar = findViewById(R.id.icon_user);

        received();

    }

    private void received(){
        User user = getIntent().getParcelableExtra(EXTRA_USER);
        tvUsername.setText(user.getUsername());
        tvName.setText(user.getName());;
        tvFollowing.setText(user.getFollowing());
        tvFollowers.setText(user.getFollowers());
        tvLocation.setText(user.getLocation());
        tvRepository.setText(user.getRepository());
        imgAvatar.setImageResource(user.getImage());
    }
}