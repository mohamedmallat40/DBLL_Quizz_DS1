package com.example.moham.ds1dbll_quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Bd extends SQLiteOpenHelper {

    public static final String DB_NAME = "mybdd.bd";

    public Bd(Context context) {
        super(context, DB_NAME, null, 1);
        // TODO Auto-generated constructor stub
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE User (login Text Primary Key , mdp Text , note INTEGER )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS User");

    }


    public Boolean inserUser(String login , String mdp ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("login",login);
        contentValues.put("mdp",mdp);
        contentValues.put("note",0);
        long r = db.insert("User",null,contentValues);
        if (r==-1) {
            return false;
        }
        else
            return true;
    }

    public String login(String login,String mdp){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM User WHERE login='"+login+"'",null);
        if (c == null || c.getCount() == 0 ) {
            return "Veuillez vérifier vos informations !";
        }
        else {
            c.moveToFirst();
            if (!c.getString(c.getColumnIndex("mdp")).equals(mdp)) {
              return "Mot de passe incorrect";
            }
            else
                return "ok";
        }
    }

    public Boolean insertNote(String login,int note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("note",note);
        db.update("User",contentValues,"login= ?",new String[]{login});
        return true;

    }

    public ArrayList<String> listNote(){
        ArrayList<String> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String user;
        Cursor c = db.rawQuery("SELECT * FROM User ",null);
        if (c == null || c.getCount() == 0 ) {
            return null;
        }
        else {
            c.moveToFirst();
            user = c.getString(c.getColumnIndex("login")) + " : " + c.getString(c.getColumnIndex("note"));
            list.add(user);
            while (c.moveToNext()) {
                user = c.getString(c.getColumnIndex("login")) + " : " + c.getString(c.getColumnIndex("note"));
                list.add(user);
            }
            return list;
        }
    }

}
