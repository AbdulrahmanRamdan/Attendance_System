package com.example.attendance_system;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class faculty_Datahelper extends SQLiteOpenHelper {
    private static String name_database="faculty_database";
    SQLiteDatabase facultydb;
    public faculty_Datahelper(Context context) {
        super(context, name_database, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table faculty_table (pass_word text primary key, "+" user_name text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists faculty_table");
        onCreate(db);
    }
    public void add_faculty(String pass,String name){
        facultydb=getWritableDatabase();
        ContentValues rowf=new ContentValues();
        rowf.put("pass_word",pass);
        rowf.put("user_name",name);
        facultydb.insert("faculty_table",null,rowf);
        facultydb.close();
    }

    public Cursor veiw_faculties(){
        facultydb=getReadableDatabase();
        String[] rowf_datails={"user_name","pass_word"};
        Cursor cursor=facultydb.query("faculty_table",rowf_datails,null,null,null,null,null);
       if(cursor!=null)
           cursor.moveToFirst();
        return cursor;
    }

    public String get_pass_word(String name){
        facultydb=getReadableDatabase();
        String[]arg={name};
        Cursor cursor=facultydb.rawQuery("select pass_word from faculty_table where user_name like ?",arg);
        cursor.moveToFirst();
        return cursor.getString(0);

    }

    public void delete_faculty(String name){
        facultydb=getWritableDatabase();
       facultydb.delete("faculty_table","user_name='"+name+"'",null);
     facultydb.close();
    }
}
