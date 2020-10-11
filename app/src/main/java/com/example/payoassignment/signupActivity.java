package com.example.payoassignment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class signupActivity extends AppCompatActivity {
    private TextView email;
    private TextView firstName,phone,address,lastName;
    private TextView password,confirmPassword;
    private FirebaseAuth auth;
    private DatabaseReference userdata;
    private FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        email=findViewById(R.id.email);
        firstName =findViewById(R.id.firstname);
        password=findViewById(R.id.password);
        lastName=findViewById(R.id.lastname);
        phone=findViewById(R.id.phone);
        address=findViewById(R.id.address);
        confirmPassword=findViewById(R.id.confirmpassword);
        auth=FirebaseAuth.getInstance();
        Button create = findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String emailInput=email.getText().toString();
                String passwordInput=password.getText().toString();
                String firstNameInput= firstName.getText().toString();
                String lastNameInput=lastName.getText().toString();
                String phoneInput =phone.getText().toString();
                String adderInput=address.getText().toString();
                if(TextUtils.isEmpty(emailInput)||TextUtils.isEmpty(passwordInput)||TextUtils.isEmpty(firstNameInput)||TextUtils.isEmpty(lastNameInput)||TextUtils.isEmpty(phoneInput)||TextUtils.isEmpty(adderInput)){
                    Toast.makeText(signupActivity.this, "Please fill all the information", Toast.LENGTH_SHORT).show();
                }
                else if(passwordInput.length()<6){
                    Toast.makeText(signupActivity.this, "Password must contain at least 6 characters", Toast.LENGTH_SHORT).show();
                }else if(!passwordInput.equals(confirmPassword.getText().toString())){
                    Toast.makeText(signupActivity.this, "password mut be same as confirm password", Toast.LENGTH_SHORT).show();
                }else{
                    registerUser( emailInput, passwordInput);
                }
            }
        });
    }
    private void registerUser(String email, String password) {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(signupActivity.this, new OnCompleteListener<AuthResult>() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(signupActivity.this, "Registered user successfully", Toast.LENGTH_SHORT).show();
                    user=FirebaseAuth.getInstance().getCurrentUser();
                    userdata= FirebaseDatabase.getInstance().getReference().child("users").child(user.getUid());
                    HashMap<String ,String>usermap=new HashMap<>();
                    usermap.put("userid",user.getUid());
                    usermap.put("firstName", firstName.getText().toString());
                    usermap.put("email",user.getEmail());
                    usermap.put("lastName", lastName.getText().toString());
                    usermap.put("phone",phone.getText().toString());
                    usermap.put("address",address.getText().toString());
                    userdata.setValue(usermap);
                    startActivity(new Intent(signupActivity.this, MainActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(signupActivity.this, "user already exist", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}