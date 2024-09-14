package com.example.mommygram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ExerciseActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView ex1,ex2,ex3,ex4,ex5,ex6,ex7,ex8,ex9,ex10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        ex1=(CardView) findViewById(R.id.m_ex1);
        ex2=(CardView) findViewById(R.id.m_ex2);
        ex3=(CardView) findViewById(R.id.m_ex3);
        ex4=(CardView) findViewById(R.id.m_ex4);
        ex5=(CardView) findViewById(R.id.m_ex5);
        ex6=(CardView) findViewById(R.id.m_ex6);
        ex7=(CardView) findViewById(R.id.m_ex7);
        ex8=(CardView) findViewById(R.id.m_ex8);
        ex9=(CardView) findViewById(R.id.m_ex9);
        ex10=(CardView) findViewById(R.id.m_ex10);

        ex1.setOnClickListener((View.OnClickListener)this);
        ex2.setOnClickListener((View.OnClickListener)this);
        ex3.setOnClickListener((View.OnClickListener)this);
        ex4.setOnClickListener((View.OnClickListener)this);
        ex5.setOnClickListener((View.OnClickListener)this);
        ex6.setOnClickListener((View.OnClickListener)this);
        ex7.setOnClickListener((View.OnClickListener)this);
        ex8.setOnClickListener((View.OnClickListener)this);
        ex9.setOnClickListener((View.OnClickListener)this);
        ex10.setOnClickListener((View.OnClickListener)this);

    }
    @Override
    public void onClick(View v){
        Intent i;
        switch (v.getId()){
            case R.id.m_ex1 :i=new Intent(this,m_ex1Activity.class); startActivity(i); break;
            case R.id.m_ex2 :i=new Intent(this,m_ex2Activity.class); startActivity(i); break;
            case R.id.m_ex3 :i=new Intent(this,m_ex3Activity.class); startActivity(i); break;
            case R.id.m_ex4 :i=new Intent(this,m_ex4Activity.class); startActivity(i); break;
            case R.id.m_ex5 :i=new Intent(this,m_ex5Activity.class); startActivity(i); break;
            case R.id.m_ex6 :i=new Intent(this,m_ex6Activity.class); startActivity(i); break;
            case R.id.m_ex7 :i=new Intent(this,m_ex7Activity.class); startActivity(i); break;
            case R.id.m_ex8 :i=new Intent(this,m_ex8Activity.class); startActivity(i); break;
            case R.id.m_ex9 :i=new Intent(this,m_ex9Activity.class); startActivity(i); break;
            case R.id.m_ex10 :i=new Intent(this,m_ex10Activity.class); startActivity(i); break;

        }
    }
}