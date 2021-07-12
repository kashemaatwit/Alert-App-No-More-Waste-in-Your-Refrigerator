package edu.wit.mobileappdevelopment.seniorproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper  extends SQLiteOpenHelper {



    public static final String COLUMN_ITEM_NAME = "Item_Name";
    public static final String COLUMN_QUANTITY = "Quantity";
    public static final String COLUMN_PURCHASE_DATE = "Purchase_Date";
    public static final String COLUMN_EXPIRED_DATE = "Expired_Date";
    public static final String REFRIGERATOR_TABLE = "REFRIGERATOR_TABLE";
    public static final String COLUMN_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "Refrigerator.db", null, 1);


    }

    // create a new database
    @Override
    public void onCreate(SQLiteDatabase db)
    {
         String createTableStatement  = "CREATE TABLE "  + REFRIGERATOR_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_ITEM_NAME + " TEXT, " + COLUMN_QUANTITY + " INT, " + COLUMN_PURCHASE_DATE + "TEXT, " + COLUMN_EXPIRED_DATE + " TEXT)";
         db.execSQL(createTableStatement);

    }
// this method would be helpful when we change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public boolean addOne(String ItemName, String Quanity, String PurchaseDate, String ExpiredDate)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ITEM_NAME,ItemName );
        cv.put(COLUMN_QUANTITY, Quanity);
        cv.put(COLUMN_PURCHASE_DATE, PurchaseDate);
        cv.put(COLUMN_EXPIRED_DATE, ExpiredDate);
        long insert = db.insert(REFRIGERATOR_TABLE, null, cv);
        if(insert ==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res  = db.rawQuery("SELECT * from " + REFRIGERATOR_TABLE, null);
        return res;
    }



}
