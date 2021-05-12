package com.example.tpgit_miniblog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button bn;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bn = (Button)findViewById(R.id.login);
        tv1 = (TextView)findViewById(R.id.new_user);
        tv2 = (TextView)findViewById(R.id.forgot);

        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ih = new Intent(MainActivity.this,Home_page.class);
                startActivity(ih);
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
}