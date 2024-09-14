package com.example.mommygram;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText edmail,edpass;
    FirebaseAuth mAuth;
    Button btnlogin;
    TextView tv_register;
   // DBHelper dbHelper;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent=new Intent(getApplicationContext(),HomePageActivity.class);
            startActivity(intent);
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth=FirebaseAuth.getInstance();
        edmail=findViewById(R.id.et_user);
        edpass=findViewById(R.id.et_pass);
        btnlogin=findViewById(R.id.btn_login);
        tv_register=findViewById(R.id.textView4);
        //  dbhelper=new DBHelper(this);

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

       btnlogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String email,password;
               email=String.valueOf(edmail.getText());
               password=String.valueOf(edpass.getText());

               if(TextUtils.isEmpty(email)){
                   Toast.makeText(LoginActivity.this,"Enter mail ID",Toast.LENGTH_SHORT).show();
                   return;
               }
               if(TextUtils.isEmpty(password)){
                   Toast.makeText(LoginActivity.this,"Enter password",Toast.LENGTH_SHORT).show();
                   return;
               }

               mAuth.signInWithEmailAndPassword(email, password)
                       .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               if (task.isSuccessful()) {
                                   // Sign in success, update UI with the signed-in user's information
                                   Toast.makeText(LoginActivity.this, "Login Successfully!",
                                           Toast.LENGTH_SHORT).show();
                                   Intent intent=new Intent(getApplicationContext(),HomePageActivity.class);
                                   startActivity(intent);
                                   finish();
                               } else {
                                   // If sign in fails, display a message to the user.
                                  Toast.makeText(LoginActivity.this, "Login failed.",
                                           Toast.LENGTH_SHORT).show();
                               }
                           }
                       });
           }
       });


    }
}
