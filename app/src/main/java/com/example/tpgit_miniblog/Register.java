package com.example.tpgit_miniblog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register extends AppCompatActivity {

    Button submit;
    EditText firstname, lastname, email, password, batch, department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        submit = (Button)findViewById(R.id.submit);
        firstname = (EditText)findViewById(R.id.fname1);
        lastname = (EditText)findViewById(R.id.lname1);
        email = (EditText)findViewById(R.id.u_mail1);
        password = (EditText)findViewById(R.id.passw1);
        batch = (EditText)findViewById(R.id.batch1);
        department = (EditText)findViewById(R.id.dept1);
        submit = (Button)findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postData(firstname.getText().toString(), lastname.getText().toString(), email.getText().toString(), password.getText().toString(), batch.getText().toString(), department.getText().toString());
            }
        });
    }

    private void postData(String firstname, String lastname, String email, String password, String batch, String department ) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://tpgitminiblog.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        DataModal modal = new DataModal(firstname, lastname, email, password, batch, department);
        Call<DataModal> call = retrofitAPI.createPost(modal);
        call.enqueue(new Callback<DataModal>() {
            @Override
            public void onResponse(Call<DataModal> call, Response<DataModal> response) {
                Toast.makeText(Register.this,"Data Posted",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<DataModal> call, Throwable t) {
                Toast.makeText(Register.this,"Error",Toast.LENGTH_SHORT).show();
            }
        });
    }
}