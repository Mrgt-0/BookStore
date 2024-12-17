package com.example.myapplication.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static Context myContext;
    private static final String DB_NAME = "BookStoreDB.db";
    private static final String DB_PATH = myContext.getFilesDir().getPath() + DB_NAME;
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

    public void createDb(){
        File file = new File(DB_PATH);
        if (!file.exists()) {
            try (InputStream myInput = myContext.getAssets().open(DB_NAME);
                 OutputStream myOutput = new FileOutputStream(DB_PATH)) {

                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }
                myOutput.flush();
            } catch (IOException ex) {
                Log.d("DatabaseHelper", ex.getMessage());
            }
        }
    }

    public void insertImage(byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("image", image);
        db.insert("images", null, values);
        db.close();
    }

    public byte[] getImage(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("images", new String[]{"image"}, "id=?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            byte[] image = cursor.getBlob(0);
            cursor.close();
            return image;
        }
        return null;
    }
}
