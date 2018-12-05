package com.example.moham.ds1dbll_quiz;

public class Question {


    private String question;
    private String rep1;
    private String rep2;
    private String rep3;
    private String repCorrecte;


    public Question(String question, String rep1, String rep2, String rep3, String repCorrecte) {
        this.question = question;
        this.rep1 = rep1;
        this.rep2 = rep2;
        this.rep3 = rep3;
        this.repCorrecte = repCorrecte;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRep1() {
        return rep1;
    }

    public void setRep1(String rep1) {
        this.rep1 = rep1;
    }

    public String getRep2() {
        return rep2;
    }

    public void setRep2(String rep2) {
        this.rep2 = rep2;
    }

    public String getRep3() {
        return rep3;
    }

    public void setRep3(String rep3) {
        this.rep3 = rep3;
    }

    public String getRepCorrecte() {
        return repCorrecte;
    }

    public void setRepCorrecte(String repCorrecte) {
        this.repCorrecte = repCorrecte;
    }
}
