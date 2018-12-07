package com.example.moham.ds1dbll_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Inscription extends AppCompatActivity {

    EditText login,mdp,veridMdp;
    Bd bd = new Bd(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        login = (EditText) findViewById(R.id.loginTxt);
        mdp = (EditText) findViewById(R.id.passText);
        veridMdp = (EditText) findViewById(R.id.verifMdpText);

    }

    public void inscrire(View view) {

        String loginTxt , pass , verifPass ;
        loginTxt = login.getText().toString();
        pass = mdp.getText().toString();
        verifPass = veridMdp.getText().toString();

        if (!pass.equals(verifPass)) {
            Toast.makeText(this,"Veuillez introduire le même mot de passe",Toast.LENGTH_LONG).show();
        }
        else {
            if (bd.inserUser(loginTxt,pass)) {
                Toast.makeText(this,"Utilisateur ajouté avec succés !",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this,QuizzActivity.class);
                intent.putExtra("login",loginTxt);
                startActivity(intent);
            }
            else {
                Toast.makeText(this,"Erreur !",Toast.LENGTH_LONG).show();
            }

        }

    }
}
