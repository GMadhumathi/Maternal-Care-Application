package com.example.mommygram;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.Async;

public class HomePageActivity extends AppCompatActivity {
    ImageView mom,baby;

    BottomNavigationView bottom_nav;

    Button logout;
    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        mom=findViewById(R.id.mom);
        baby=findViewById(R.id.baby);
        bottom_nav=findViewById(R.id.bottom_navigation);
        bottom_nav.setSelectedItemId(R.id.home);


       /* logout=findViewById(R.id.btn_logout);
        auth = FirebaseAuth.getInstance();
        user= auth.getCurrentUser(); */


        bottom_nav.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomePageActivity.class));
                        break;
                    case R.id.music:
                        startActivity(new Intent(getApplicationContext(), MusicActivity.class));
                        break;
                    case R.id.guide:
                        startActivity(new Intent(getApplicationContext(), GuidelineActivity.class));
                        break;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        break;

                }
            }
        });
     /*   if(user==null)
        {
            Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
            finish();
        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }); */

        mom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePageActivity.this,MomPageActivity.class));
            }
        });
        baby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePageActivity.this,BabyPageActivity.class));
            }
        });
    }
}