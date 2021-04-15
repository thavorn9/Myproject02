package com.example.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.INotificationSideChannel;

public class myManager {
    myDbHelper myhelper;
    public myManager(Context context) {
        myhelper = new myDbHelper(context);
    }
    public long insert(String name, String score,String love) {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, name);
        contentValues.put(myDbHelper.SCORE, score);
        contentValues.put(myDbHelper.Love, love);
        long id = dbb.insert(myDbHelper.TABLE_NAME, null ,
                contentValues);
        return id;
    }
    public String getData() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper._ID, myDbHelper.NAME, myDbHelper.SCORE, myDbHelper.Love};
        Cursor cursor = db.query(myDbHelper.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
            int cid = cursor.getInt(cursor.getColumnIndex(myDbHelper._ID));
            String name = cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            String password = cursor.getString(cursor.getColumnIndex(myDbHelper.SCORE));
            String love = cursor.getString(cursor.getColumnIndex(myDbHelper.Love));
            buffer.append(cid + " " + name + " " + password + " "+ love + "\n");
        }
        return buffer.toString();
    }

}
