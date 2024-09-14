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

public class RegisterActivity extends AppCompatActivity {

    EditText edmail,edpass;
    Button btnreg;
    TextView tv_reg;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth=FirebaseAuth.getInstance();
        edmail=findViewById(R.id.reg_user);
        edpass=findViewById(R.id.reg_pass);
        btnreg=findViewById(R.id.btn_reg);
        tv_reg=findViewById(R.id.textView);
      //  dbhelper=new DBHelper(this);

        tv_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                String email,password;
                email=String.valueOf(edmail.getText());
                password=String.valueOf(edpass.getText());

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(RegisterActivity.this,"Enter mail ID",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(RegisterActivity.this,"Enter password",Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(RegisterActivity.this, "Account created!",
                                            Toast.LENGTH_SHORT).show();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(RegisterActivity.this, "Registration failed!",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }

        });
    }

}

