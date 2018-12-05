package com.example.moham.ds1dbll_quiz;

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
    Boolean correcte;


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

        quest = "Si le code JavaScript est présent dans le code HTML, dans quelle balise doit-il être placé ?";
        repUne = "<script>";
        repDeux = "<javascript>";
        repTrois = "<js>" ;
        repCorrecte = "<script>";

        listeQuestion.add(new Question(quest,repUne,repDeux,repTrois,repCorrecte));

        quest = " Comment déclare-t-on une variable valant le chiffre 2";
        repUne = "int monChiffre = 2;";
        repDeux = "Number monChiffre = 2;";
        repTrois = "var monChiffre = 2;" ;
        repCorrecte = "ar monChiffre = 2;";

        listeQuestion.add(new Question(quest,repUne,repDeux,repTrois,repCorrecte));

        quest = "Parmi ces syntaxes, laquelle permet d'écrire une condition qui vérifie que la variable a est égale à 2 ?";
        repUne = "<if(a = 2)";
        repDeux = "if(a == 2)";
        repTrois = "if(a = 2)" ;
        repCorrecte = "if(a == 2";

        listeQuestion.add(new Question(quest,repUne,repDeux,repTrois,repCorrecte));

        quest = "Un fichier \".js\" ne doit pas contenir :";
        repUne = "de document.getElementById";
        repDeux = "de balise <script>";
        repTrois = "de variable globale" ;
        repCorrecte = "de balise <script>";

        listeQuestion.add(new Question(quest,repUne,repDeux,repTrois,repCorrecte));

        quest = "Quel type de commentaire n'est pas un commentaire JavaScript ?";
        repUne = "<!-- Commentaire -->";
        repDeux = "/* Commentaire */";
        repTrois = "// Commentaire" ;
        repCorrecte = "<!-- Commentaire -->";

        listeQuestion.add(new Question(quest,repUne,repDeux,repTrois,repCorrecte));

        quest = "Comment concatène-t-on deux chaînes de caractères ?";
        repUne = "\"ma \" . \"chaine\"";
        repDeux = "\"ma \" + \"chaine\"";
        repTrois = "\"ma \" || \"chaine\"" ;
        repCorrecte = "\"ma \" + \"chaine\"";

        listeQuestion.add(new Question(quest,repUne,repDeux,repTrois,repCorrecte));

        quest = "Comment déclare-t-on une chaine de caractères ?";
        repUne = "var chaine = \"ma chaine\";";
        repDeux = "var chaine = 'ma chaine';";
        repTrois = "Les deux versions sont équivalentes." ;
        repCorrecte = "var chaine = \"ma chaine\";";

        listeQuestion.add(new Question(quest,repUne,repDeux,repTrois,repCorrecte));

        quest = "Parmi ces syntaxes, laquelle permet de construire un tableau ?";
        repUne = "var monTableau = {\"élément1\", \"élément2\", \"élément3\"};";
        repDeux = "var monTableau = [\"élément1\", \"élément2\", \"élément3\"];";
        repTrois = "var monTableau = [0: \"élément1\", 1: \"élément2\", 2: \"élément3\"];" ;
        repCorrecte = "var monTableau = [\"élément1\", \"élément2\", \"élément3\"];";

        listeQuestion.add(new Question(quest,repUne,repDeux,repTrois,repCorrecte));

        quest = "Parmi ces syntaxes, laquelle permet d'inclure un script externe à la page HTML ?";
        repUne = "<script langage=\"javascript\" src=\"xxx.js\">";
        repDeux = "<script type=\"text/javascript\" src=\"xxx.js\">";
        repTrois = "<script type=\"text/javascript\" name=\"xxx.js\">" ;
        repCorrecte = "<script langage=\"javascript\" src=\"xxx.js\">";
        listeQuestion.add(new Question(quest,repUne,repDeux,repTrois,repCorrecte));

        quest = "comment lire un variable";
        repUne = "scanf("");";
        repDeux = "system.out.println("");";
        repTrois = "variable=prompt(");" ;
        repCorrecte = "variable=prompt(\"\"); ";



        listeQuestion.add(new Question(quest,repUne,repDeux,repTrois,repCorrecte));

       installQuestion();


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
                rep1.setBackgroundColor(Color.LTGRAY);
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
                rep2.setBackgroundColor(Color.LTGRAY);
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
                rep3.setBackgroundColor(Color.LTGRAY);
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

        if (correcte) note++;
        current++;
        if (current>=9) {
            Toast.makeText(this,"Vous avez terminé ! votre note est: " +note+"/10 ",Toast.LENGTH_LONG).show();
        }
        else {

            installQuestion();
            btn.setVisibility(View.INVISIBLE);
        }
        rep1.setBackgroundColor(Color.WHITE);
        rep2.setBackgroundColor(Color.WHITE);
        rep3.setBackgroundColor(Color.WHITE);



    }

    public Boolean verif(String rep,int i) {

        if (listeQuestion.get(i).getRepCorrecte().equals(rep)) return true;
        else return false;

    }
}
