package com.example.mommygram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NutrientActivity extends AppCompatActivity  implements View.OnClickListener{

    private CardView fo1,fo2,fo3,fo4,fo5,fo6,fo7,fo8,fo9,fo10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrient);
        fo1=(CardView) findViewById(R.id.m_fo1);
        fo2=(CardView) findViewById(R.id.m_fo2);
        fo3=(CardView) findViewById(R.id.m_fo3);
        fo4=(CardView) findViewById(R.id.m_fo4);
        fo5=(CardView) findViewById(R.id.m_fo5);
        fo6=(CardView) findViewById(R.id.m_fo6);
        fo7=(CardView) findViewById(R.id.m_fo7);
        fo8=(CardView) findViewById(R.id.m_fo8);
        fo9=(CardView) findViewById(R.id.m_fo9);
        fo10=(CardView) findViewById(R.id.m_fo10);

        fo1.setOnClickListener((View.OnClickListener)this);
        fo2.setOnClickListener((View.OnClickListener)this);
        fo3.setOnClickListener((View.OnClickListener)this);
        fo4.setOnClickListener((View.OnClickListener)this);
        fo5.setOnClickListener((View.OnClickListener)this);
        fo6.setOnClickListener((View.OnClickListener)this);
        fo7.setOnClickListener((View.OnClickListener)this);
        fo8.setOnClickListener((View.OnClickListener)this);
        fo9.setOnClickListener((View.OnClickListener)this);
        fo10.setOnClickListener((View.OnClickListener)this);

    }
    @Override
    public void onClick(View v){
        Intent i;
        switch (v.getId()){
            case R.id.m_fo1 :i=new Intent(this,m_fo1Activity.class); startActivity(i); break;
            case R.id.m_fo2 :i=new Intent(this,m_fo2Activity.class); startActivity(i); break;
            case R.id.m_fo3 :i=new Intent(this,m_fo3Activity.class); startActivity(i); break;
            case R.id.m_fo4 :i=new Intent(this,m_fo4Activity.class); startActivity(i); break;
            case R.id.m_fo5 :i=new Intent(this,m_fo5Activity.class); startActivity(i); break;
            case R.id.m_fo6 :i=new Intent(this,m_fo6Activity.class); startActivity(i); break;
            case R.id.m_fo7 :i=new Intent(this,m_fo7Activity.class); startActivity(i); break;
            case R.id.m_fo8 :i=new Intent(this,m_fo8Activity.class); startActivity(i); break;
            case R.id.m_fo9 :i=new Intent(this,m_fo9Activity.class); startActivity(i); break;
            case R.id.m_fo10 :i=new Intent(this,m_fo10Activity.class); startActivity(i); break;

        }
    }
}