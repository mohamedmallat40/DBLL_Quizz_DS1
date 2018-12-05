package com.example.moham.ds1dbll_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText login;
    EditText mdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (EditText) findViewById(R.id.loginTxt);
        mdp = (EditText) findViewById(R.id.mdpTxt);


    }

    public void btnConnexion(View view) {

        String user = login.getText().toString();
        String pass = mdp.getText().toString();

        if (user.equals("mohamed")) {
            if (pass.equals("12345")) {
                Intent intent = new Intent(this,QuizzActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this,"Mot de passe incorrecte",Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this,"Login incorrecte",Toast.LENGTH_LONG).show();
        }
    }
}
