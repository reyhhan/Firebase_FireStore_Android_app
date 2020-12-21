package com.example.bakery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import javax.annotation.Nullable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button login;
    Button register;
    EditText pwd;
    TextView email;
    ProgressBar progress;

FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.txt_email);
        pwd=findViewById(R.id.txt_pwd);
        progress=findViewById(R.id.prg_bar);
        login = findViewById(R.id.btn_login);
        register = findViewById(R.id.btn_register);

        db= FirebaseFirestore.getInstance();
        login.setOnClickListener(this);
        register.setOnClickListener(this);

    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btn_login:
                if(email.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Please enter valid email", Toast.LENGTH_SHORT).show();
                }else if( pwd.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Please enter valid password", Toast.LENGTH_SHORT).show();
                }
               db.collection("client")
                       .get()
                       .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                           @Override
                           public void onComplete(@NonNull Task<QuerySnapshot> task) {
                               if(task.isSuccessful()){
                                   for(QueryDocumentSnapshot doc : task.getResult()){
                                       String a=doc.getString("Email");
                                       String b=doc.getString("Password");
                                       String a1=email.getText().toString().trim();
                                       String b1=pwd.getText().toString().trim();
                                       if(a.equalsIgnoreCase(a1) & b.equalsIgnoreCase(b1)) {
                                           Intent home = new Intent(MainActivity.this, home_activity.class);
                                           startActivity(home);
                                           Toast.makeText(MainActivity.this, "Logged In", Toast.LENGTH_SHORT).show();
                                           break;
                                       }else
                                           Toast.makeText(MainActivity.this, "Cannot login,incorrect Email and Password", Toast.LENGTH_SHORT).show();
                                   }
                               }
                           }
                       });
                break;
            case R.id.btn_register:
                Intent register_view=new Intent(MainActivity.this,Register.class);
                startActivity(register_view);
                break;
        }
    }
}
//<a rel="nofollow" href="https://vecteezy.com">Vector Graphics by vecteezy.com</a>
