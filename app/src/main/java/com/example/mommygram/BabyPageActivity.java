package com.example.mommygram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class BabyPageActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_page);

        b1=(CardView) findViewById(R.id.b1);
        b2=(CardView) findViewById(R.id.b2);
        b3=(CardView) findViewById(R.id.b3);
        b4=(CardView) findViewById(R.id.b4);
        b5=(CardView) findViewById(R.id.b5);
        b6=(CardView) findViewById(R.id.b6);
        b7=(CardView) findViewById(R.id.b7);
        b8=(CardView) findViewById(R.id.b8);
        b9=(CardView) findViewById(R.id.b9);
        b10=(CardView) findViewById(R.id.b10);

        b1.setOnClickListener((View.OnClickListener)this);
        b2.setOnClickListener((View.OnClickListener)this);
        b3.setOnClickListener((View.OnClickListener)this);
        b4.setOnClickListener((View.OnClickListener)this);
        b5.setOnClickListener((View.OnClickListener)this);
        b6.setOnClickListener((View.OnClickListener)this);
        b7.setOnClickListener((View.OnClickListener)this);
        b8.setOnClickListener((View.OnClickListener)this);
        b9.setOnClickListener((View.OnClickListener)this);
        b10.setOnClickListener((View.OnClickListener)this);
    }

    @Override
    public void onClick(View v){
        Intent i;
        switch (v.getId()){
              case R.id.b1 :i=new Intent(this,b1Activity.class); startActivity(i); break;
              case R.id.b2 :i=new Intent(this,b2Activity.class); startActivity(i); break;
              case R.id.b3 :i=new Intent(this,b3Activity.class); startActivity(i); break;
              case R.id.b4 :i=new Intent(this,b4Activity.class); startActivity(i); break;
              case R.id.b5 :i=new Intent(this,b5Activity.class); startActivity(i); break;
              case R.id.b6 :i=new Intent(this,b6Activity.class); startActivity(i); break;
              case R.id.b7 :i=new Intent(this,b7Activity.class); startActivity(i); break;
              case R.id.b8 :i=new Intent(this,b8Activity.class); startActivity(i); break;
              case R.id.b9 :i=new Intent(this,b9Activity.class); startActivity(i); break;
              case R.id.b10 :i=new Intent(this,b10Activity.class); startActivity(i); break;

        }
    }
}