package com.example.stayupdated.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.stayupdated.pojo.favorite;

import java.util.ArrayList;

public class database extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "favoriteTable";
    /*
      Table Names
     */
    public static final String TABLE_FAVORITE = "favorite";

    /*
      Column names
     */
    public static final String COLUMN_ID = "id";

    public static final String COLUMN_NAME = "name"; //name
    public static final String COLUMN_DESC = "description"; //description
    public static final String COLUMN_IMAGE = "image"; //image
    public static final String COLUMN_EDIT = "edit"; //image


    public static final String CREATE_FAV_TABLE = "CREATE TABLE " +
            TABLE_FAVORITE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," +
            COLUMN_NAME + " TEXT, " + COLUMN_DESC + " TEXT, " +
             COLUMN_IMAGE + " TEXT)";

    public database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_FAV_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addFavorite(favorite fav){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME, fav.getHeading());
        values.put(COLUMN_DESC, fav.getDescription());
        values.put(COLUMN_IMAGE, fav.getImageUrl());
//        values.put(COLUMN_EDIT, fav.getEditButton());


        db.insert(TABLE_FAVORITE,null,values);
        db.close();
    }

    public favorite getFav(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        favorite favorite = null;
        Cursor cursor = db.query(TABLE_FAVORITE,
                new String[]{COLUMN_ID,COLUMN_NAME,COLUMN_DESC,COLUMN_IMAGE},COLUMN_ID + "= ?",
        new String[]{String.valueOf(id)},null,null,null);

        if (cursor.moveToFirst()){
            favorite = new favorite(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
//                    cursor.getString(4)
            );
        }
        db.close();
        return favorite;
    }

    public ArrayList<favorite> getAllFavorites(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM "
        + TABLE_FAVORITE, null);

        ArrayList<favorite> favorites = new ArrayList<>();
        while (cursor.moveToNext()){
            favorites.add(new favorite(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
//                    cursor.getString(4)
            ));
        }
        db.close();
        return favorites;
    }
    public int updateData(favorite favorite){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, favorite.getHeading());
        values.put(COLUMN_DESC, favorite.getDescription());
//        values.put(COLUMN_GEO, favorite.getButton());
        return db.update(TABLE_FAVORITE,values,COLUMN_ID+ "=?", new String[]{String.valueOf(favorite.getId())});
    }

    public void deleteLocation(int location){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FAVORITE, COLUMN_ID +  "=?",
                new String[]{String.valueOf(location)});
        db.close();
    }


}
