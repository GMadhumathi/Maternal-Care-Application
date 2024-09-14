package com.example.mommygram;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
public class ProfileActivity extends AppCompatActivity {

    private ImageView profile_img;
    TextView txtname;
    Button logout;
    FirebaseAuth auth;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile_img = findViewById(R.id.profile_dp);
        txtname=findViewById(R.id.txt_name);
        logout=findViewById(R.id.btn_logout);
        auth = FirebaseAuth.getInstance();
        user= auth.getCurrentUser();
        // on below line we are setting background color to transparent
        //profile_img.setBackgroundColor(getResources().getColor(android.R.color.transparent));

        if(user==null)
        {
            Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            txtname.setText(user.getEmail());
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}