package com.jw.devin.module.tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.print.PrintAttributes;
import android.widget.Toast;

/**
 * Created by devin on 16/6/7.
 */
public class HolidayDatabaseHelper extends SQLiteOpenHelper {
    private Context ctx;
    private  static HolidayDatabaseHelper holidayDatabaseHelper;

    public static final  String BOOK="create table book("
            +"id integer primary key autoincrement,"
            +"author text,"
            +"price real,"
            +"pages integer"
            +"name text)";

    public static final String STUDENT = "create table student("
            +"id integer primary key autoincrement"
            +"name text)";

    public static HolidayDatabaseHelper getInstance(Context ctx){
        if (holidayDatabaseHelper==null){
            synchronized (HolidayDatabaseHelper.class){
                if (holidayDatabaseHelper==null){
                    return new HolidayDatabaseHelper(ctx,"holiday_db",null,1);
                }
            }
        }
        return holidayDatabaseHelper;
    }

    public HolidayDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.ctx = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BOOK);
        db.execSQL(STUDENT);
        Toast.makeText(ctx,"congratulation ! create success.",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion){
            case 1:
                db.execSQL(STUDENT);
            break;
            default:
                break;
        }

    }

    public void insert(Context ctx){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name","hello world");
        contentValues.put("price",39);
        getInstance(ctx).getWritableDatabase().insert(BOOK,null,contentValues);
        getInstance(ctx).getWritableDatabase().execSQL("inset into BOOk(name,author,price) values(?,?,?)",new String[]{"dvin","33","32"});
    }
    public  void upDate(Context ctx){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name","how are u");
        getInstance(ctx).getWritableDatabase().update(BOOK,contentValues,"name=?",new String[]{"devin"});
        getInstance(ctx).getWritableDatabase().execSQL("update BOOk set price =? where name=?",new String[]{"33","devin"});
    }
    public  void delete(Context ctx){
        getInstance(ctx).getWritableDatabase().delete(BOOK,"price>?",new String[]{"55"});
        getInstance(ctx).getWritableDatabase().execSQL("delete from BOOK where price >?,new String[]{55}");
    }

    public void query(Context ctx){
        Cursor cursor= getInstance(ctx).getWritableDatabase().query(BOOK,null,null,null,null,null,null);
        if (cursor.moveToFirst()){
            do {
                cursor.getString(cursor.getColumnIndex("name"));
                cursor.getInt(cursor.getColumnIndex("price"));
            }while (cursor.moveToNext());
        }
        cursor.close();
        getInstance(ctx).getWritableDatabase().execSQL("select *from BOOK",null);
    }

    public void vpDateTransaction(Context ctx){
        SQLiteDatabase db = getInstance(ctx).getWritableDatabase();
        db.beginTransaction();
        db.delete(BOOK,"price>?",new String[]{"34"});
        ContentValues contentValues = new ContentValues();
        db.insert(BOOK,null,contentValues);
        db.setTransactionSuccessful();
        db.endTransaction();

    }
}
