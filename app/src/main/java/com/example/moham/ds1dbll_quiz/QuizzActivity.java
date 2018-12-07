package com.example.moham.ds1dbll_quiz;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizzActivity extends AppCompatActivity {


    TextView question,numQuestion,rep1,rep2,rep3;
    ArrayList<Question> listeQuestion;
    String quest,repUne,repDeux,repTrois,repCorrecte;
    Button btn ;
    int current;
    int note=1;
    Boolean finish = false;
    Boolean correcte;
    Bd bd = new Bd(this);
    String login;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        question = (TextView) findViewById(R.id.question);
        numQuestion = (TextView) findViewById(R.id.numQuestion);
        rep1 = (TextView) findViewById(R.id.rep1);
        rep2 = (TextView) findViewById(R.id.rep2);
        rep3 = (TextView) findViewById(R.id.rep3);
        btn = (Button) findViewById(R.id.btnSuivant);
        current = 0;

        listeQuestion = new ArrayList<>();

        quest = " si a=c et a<b alors est ce que c>b?";
        repUne = "vrai";
        repDeux = "faux";
        repTrois =" c du n'importe quoi";
        repCorrecte = "faux";

        listeQuestion.add(new Question(quest,repUne,repDeux,repTrois,repCorrecte));

        quest = " Effectue ce calcul : 3+3*4";
        repUne = "24";
        repDeux = "15";
        repTrois ="27";

        repCorrecte = "15";

        listeQuestion.add(new Question(quest,repUne,repDeux,repTrois,repCorrecte));

        quest = "si 1=2, 2=8,3=15, 4=24,5=20 combien vaut 6";
        repUne = "30";
        repDeux = "27";
        repTrois = "25" ;
        repCorrecte = "27";

        listeQuestion.add(new Question(quest,repUne,repDeux,repTrois,repCorrecte));

        quest = "remets dans l'ordre AHOWLENEL=QOLUEIG";
        repUne = "Halloween et quoleig";
        repDeux = "Agolenelh et logique";
        repTrois = " Halloween et logique" ;
        repCorrecte = "Halloween et logique";

        listeQuestion.add(new Question(quest,repUne,repDeux,repTrois,repCorrecte));

        quest = "Adam et Eve sont dans leur jardin . qui mange la fameuse poire";
        repUne = "Adam";
        repDeux = "Eve";
        repTrois = "personne";
        repCorrecte = "personne";

        listeQuestion.add(new Question(quest,repUne,repDeux,repTrois,repCorrecte));

        quest = "je suis la frere de 2 aveugles, mais ces deux aveugles ne sont pas mes fréres... comment cela se fait-l";
        repUne = "ce sont  tes demi-freres";
        repDeux = "tu mens ";
        repTrois = "ce sont tes soeurs" ;
        repCorrecte = "ce sont tes soeurs";

        listeQuestion.add(new Question(quest,repUne,repDeux,repTrois,repCorrecte));

        quest = "si tu es dernier (sur une course de 3 coureurs) et que tu doubles celui qui est devant toi, tu deviens..";
        repUne = "Dernier";
        repDeux = "Premier";
        repTrois = "deuxieme" ;
        repCorrecte = "deuxieme";

        listeQuestion.add(new Question(quest,repUne,repDeux,repTrois,repCorrecte));

        quest = "l'année derniere, Tom avait 10 ans. Mais à mon prochain anniversaire , Tom aura 12 ans. pourquoi?";
        repUne = "tu as sauté une classe ";
        repDeux = "tu as redoublé";
        repTrois = "c'est le jour de son anniversaire" ;
        repCorrecte = "c'est le jour de son anniversaire";

        listeQuestion.add(new Question(quest,repUne,repDeux,repTrois,repCorrecte));

        quest = "je suis la mére de la mére de la soeur de ton beau-pére. qui-suis-je?";
        repUne = "moi";
        repDeux = "ta demi -soeur";
        repTrois = "ton arriere arriere grand mere" ;
        repCorrecte = "moi";
        listeQuestion.add(new Question(quest,repUne,repDeux,repTrois,repCorrecte));

        quest = "M.course fait un marathon en 2003. il met 2h10 pour le faire. En 2016, il refait le meme marathon mais cette fois-ci, en 130 minutes.D'ou vient cette difference?";
        repUne = "il est allé plus vite";
        repDeux = "il est allé plus lentement";
        repTrois = "pas de différence" ;
        repCorrecte = "pas de différence";



        listeQuestion.add(new Question(quest,repUne,repDeux,repTrois,repCorrecte));

       installQuestion();

       login = getIntent().getExtras().getString("login");


    }



    public void installQuestion(){
        question.setText(listeQuestion.get(current).getQuestion());
        rep1.setText(listeQuestion.get(current).getRep1());
        rep2.setText(listeQuestion.get(current).getRep2());
        rep3.setText(listeQuestion.get(current).getRep3());
        numQuestion.setText("Question " + (current+1));

        rep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rep2.setBackgroundColor(Color.WHITE);
                rep3.setBackgroundColor(Color.WHITE);
                rep1.setBackgroundColor(Color.GRAY);
                if(!verif(rep1.getText().toString(),current)){
                    //Toast.makeText(getApplicationContext(),"Réponse incorrecte",Toast.LENGTH_LONG).show();
                    btn.setVisibility(View.VISIBLE);
                    correcte=false;
                }
                else {
                    //Toast.makeText(getApplicationContext(),"BRAVO !",Toast.LENGTH_LONG).show();
                    btn.setVisibility(View.VISIBLE);
                    correcte=true;
                }
            }
        });

        rep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rep1.setBackgroundColor(Color.WHITE);
                rep3.setBackgroundColor(Color.WHITE);
                rep2.setBackgroundColor(Color.GRAY);
                if(!verif(rep2.getText().toString(),current)){
                   // Toast.makeText(getApplicationContext(),"Réponse incorrecte",Toast.LENGTH_LONG).show();
                    btn.setVisibility(View.VISIBLE);
                    correcte=false;
                }
                else {
                    //Toast.makeText(getApplicationContext(),"BRAVO !",Toast.LENGTH_LONG).show();
                    btn.setVisibility(View.VISIBLE);
                    correcte=true;
                }
            }
        });

        rep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rep2.setBackgroundColor(Color.WHITE);
                rep1.setBackgroundColor(Color.WHITE);
                rep3.setBackgroundColor(Color.GRAY);
                if(!verif(rep3.getText().toString(),current)){
                   // Toast.makeText(getApplicationContext(),"Réponse incorrecte",Toast.LENGTH_LONG).show();
                    btn.setVisibility(View.VISIBLE);
                    correcte=false;
                }
                else {
                    //Toast.makeText(getApplicationContext(),"BRAVO !",Toast.LENGTH_LONG).show();
                    btn.setVisibility(View.VISIBLE);
                    correcte=true;
                }
            }
        });
    }


    public void btnSuivant(View view) {

        if (!finish) {
            if (correcte) note++;
            current++;
            if (current == 9) {
                Toast.makeText(this, "Vous avez terminé ! votre note est: " + note + "/10 ", Toast.LENGTH_LONG).show();
                finish = true;
            } else {

                installQuestion();
                btn.setVisibility(View.INVISIBLE);
            }
            //rep1.setBackgroundColor(Color.WHITE);
            rep1.setBackgroundColor(Color.WHITE);
            rep2.setBackgroundColor(Color.WHITE);
            rep3.setBackgroundColor(Color.WHITE);
            if (finish) {
                Toast.makeText(this, "Vous avez terminé ! votre note est: " + note + "/10 ", Toast.LENGTH_LONG).show();
                if (bd.insertNote(login,note)) {
                    Toast.makeText(this, "Note ajouté", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, Result.class);
                    intent.putExtra("login", login);
                    startActivity(intent);
                }


            }
        }
        else {

        }



    }

    public Boolean verif(String rep,int i) {

        if (listeQuestion.get(i).getRepCorrecte().equals(rep)) return true;
        else return false;

    }


    @Override
    public void onBackPressed() {

    }
}
