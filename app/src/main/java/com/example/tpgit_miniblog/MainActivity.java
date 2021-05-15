package com.example.tpgit_miniblog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button bn;
    TextView tv1,tv2;
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bn = (Button)findViewById(R.id.login);
        tv1 = (TextView)findViewById(R.id.new_user);
        tv2 = (TextView)findViewById(R.id.forgot);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);

        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateUser(email, password);
            }
        });

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(MainActivity.this,Register.class);
                startActivity(ir);
            }
        });
    }

    private void validateUser(EditText eUser, EditText ePwd) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://tpgitminiblog.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitGetAPI retrofitGetAPI = retrofit.create(RetrofitGetAPI.class);
        Call<List<GetUserData>> call = retrofitGetAPI.getUsers();
        call.enqueue(new Callback<List<GetUserData>>() {
            @Override
            public void onResponse(Call<List<GetUserData>> call, Response<List<GetUserData>> response) {
                if (response.isSuccessful()) {
                    List<GetUserData> users = response.body();
                    Boolean login = false;

                    for (GetUserData user: users){
                        String email = user.getEmail();
                        String pwd = user.getPassword();
                        String checkEmail = eUser.getText().toString();
                        String checkPwd = ePwd.getText().toString();

                        if ((checkEmail).equals(email) && (checkPwd).equals(pwd)){
                            Intent ih = new Intent(MainActivity.this,Home_page.class);
                            startActivity(ih);
                            login = true;
                        }
                    }
                    if (!login) {
                        Toast.makeText(MainActivity.this, "Invalid Username/Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<GetUserData>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error 0", Toast.LENGTH_SHORT).show();
            }
        });
    }
}