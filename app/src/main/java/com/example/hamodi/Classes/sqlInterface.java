package com.example.hamodi.Classes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public interface sqlInterface {

    long Add(SQLiteDatabase db);
    int Delete(SQLiteDatabase db, int id);
    int Update(SQLiteDatabase db, int id);
    Cursor Select(SQLiteDatabase db);
}
