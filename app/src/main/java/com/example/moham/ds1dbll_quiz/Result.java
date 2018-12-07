package com.example.moham.ds1dbll_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import javax.xml.transform.Templates;

public class Result extends AppCompatActivity {

    TextView txtResult ;
    ArrayList<String> arrayList = new ArrayList<>();
    Bd bd = new Bd(this);
    String login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtResult = (TextView) findViewById(R.id.textResult);
        login = getIntent().getExtras().getString("login");

        arrayList = bd.listNote();
        if (arrayList!=null) {
            String s="";
            for (int i=0 ; i<arrayList.size() ; i++) {
                s = s + arrayList.get(i) + "\n" ;
            }
            txtResult.setText(s);
        }
    }

    @Override
    public void onBackPressed() {

    }

    public void recommencer(View view) {

        Intent intent = new Intent(this,QuizzActivity.class);
        intent.putExtra("login",login);
        startActivity(intent);

    }
}
