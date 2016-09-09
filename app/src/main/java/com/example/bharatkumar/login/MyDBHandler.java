package com.example.bharatkumar.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDBHandler extends SQLiteOpenHelper {



    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="accountDB.db";
    public static final String TABLE_ACCOUNTS="accounts";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_USERNAME="username";
    public static final String COLUMN_USERPASSWORD="userpassword";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query="CREATE TABLE " +  TABLE_ACCOUNTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, "+
                COLUMN_USERPASSWORD + " TEXT "+
                ");";

        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_ACCOUNTS);
        onCreate(sqLiteDatabase);
    }

    public void addAccount(Accounts accounts)
    {
        ContentValues values= new ContentValues();
        values.put(COLUMN_USERNAME,accounts.get_accountname());
        values.put(COLUMN_USERPASSWORD,accounts.get_accountpassword());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_ACCOUNTS,null,values);
        db.close();

    }

    public  void  deleteAccount(String userName)
    {
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM "+ TABLE_ACCOUNTS +" WHERE "+ COLUMN_USERNAME + "=\"" + userName + "\";");
    }

    public String databaseToString(){
        String dbString="";
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+ TABLE_ACCOUNTS +" WHERE 1";

        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();

        while (!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex("username"))!=null)
            {
                int i=c.getInt(c.getColumnIndex("_id"));
                String s= Integer.toString(i);
                dbString +=s+"."+c.getString(c.getColumnIndex("username"))+" "+c.getString(c.getColumnIndex("userpassword"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

}
