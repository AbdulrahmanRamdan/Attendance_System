package com.example.attendance_system;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class student extends SQLiteOpenHelper {
    private static String databasename="studentdb";
    SQLiteDatabase studentdb;
    public student(@Nullable Context context) {
        super(context,databasename,null,1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student (id integer primary key,"+"name text not null ,department text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists student");
        onCreate(db);
    }
    public void create_student(String name,String id,String dep){
        ContentValues row=new ContentValues();
        row.put("name",name);
        row.put("id",id);
        row.put("department",dep);
        studentdb=getWritableDatabase();
        studentdb.insert("student",null,row);
        studentdb.close();
    }
    public Cursor display_all_syudent(){
        studentdb=getReadableDatabase();
        String[]rowdetails={"name","id","department"};
        Cursor cursor=studentdb.query("student",rowdetails,null,null,null,null,null);
        if(cursor!=null)
            cursor.moveToFirst();
        return cursor;
    }
    public String getStudent_dep(String name){
        studentdb=getReadableDatabase();
        String[]arg={name};
        Cursor cursor=studentdb.rawQuery("select department from student where name like ?",arg);
        cursor.moveToFirst();
        return cursor.getString(0);

    }
    public void delete_student(String name){
        studentdb=getWritableDatabase();
        studentdb.delete("student","name='"+name+"'",null);
        studentdb.close();
    }
    public void update_student(String oldname,String newname,String id,String dep){
        studentdb=getWritableDatabase();
        ContentValues row=new ContentValues();
        row.put("name",newname);
        row.put("id",id);
        row.put("department",dep);
        studentdb.update("student",row,"name like?",new String []{oldname});
        studentdb.close();
    }
}
