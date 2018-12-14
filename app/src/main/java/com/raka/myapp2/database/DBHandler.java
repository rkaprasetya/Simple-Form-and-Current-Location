package com.raka.myapp2.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.raka.myapp2.model.Employee;
import com.raka.myapp2.model.UserAccount;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "employee.DB.db";
    private static final String TABLE_ACCOUNT = "account";
    private static final String COLUMN_UNAME = "Uname";
    private static final String COLUMN_PASSWORD = "NIK";
    private static final String TABLE_EMPLOYEE = "employee";
    private static final String COLUMN_ID = "NIK";
    private static final String COLUMN_NAME = "EmployeeName";
    private static final String COLUMN_BIRTHPLACE = "BirthPlace";
    private static final String COLUMN_BIRTHDATE = "BirthDate";
    private static final String COLUMN_GENDER = "Gender";
    private static final String COLUMN_ADDRESS = "Address";
    private static final String COLUMN_HOBBY = "Hobby";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_EMPLOYEE = "CREATE TABLE "+ TABLE_EMPLOYEE +"("+COLUMN_ID+" INTEGER PRIMARY KEY,"+ COLUMN_NAME +" TEXT,"
                + COLUMN_BIRTHPLACE +" TEXT,"+ COLUMN_BIRTHDATE +" TEXT,"+COLUMN_GENDER+ " TEXT,"+ COLUMN_HOBBY +" TEXT,"+ COLUMN_ADDRESS +" TEXT "+")";
        db.execSQL(CREATE_TABLE_EMPLOYEE);
        String CREATE_TABLE_ACCOUNT = "CREATE TABLE "+ TABLE_ACCOUNT+"("+COLUMN_UNAME+" TEXT,"+COLUMN_PASSWORD+" TEXT"+")";
        db.execSQL(CREATE_TABLE_ACCOUNT);
        insertAccount(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);
        onCreate(db);
    }
    public void insertAccount(SQLiteDatabase db){
        ContentValues values = new ContentValues();
        values.put(COLUMN_UNAME, "user1@gmail.com");
        values.put(COLUMN_PASSWORD, "123");
        db.insert(TABLE_ACCOUNT, null, values);
    }
    public void insertEmployeeHandler(Employee data){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, data.getName());
        values.put(COLUMN_ID, data.getNIK());
        values.put(COLUMN_BIRTHDATE, data.getBirthDate());
        values.put(COLUMN_BIRTHPLACE, data.getBirthPlace());
        values.put(COLUMN_ADDRESS, data.getAddress());
        values.put(COLUMN_GENDER, data.getGender());
        values.put(COLUMN_HOBBY, data.getHobby());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_EMPLOYEE, null, values);
        db.close();
    }
    public Boolean selectAccountHandler(UserAccount account){
        String query = "SELECT * FROM "+ TABLE_ACCOUNT+" WHERE " + COLUMN_UNAME + " = '"+ account.getUname() +"' AND "+COLUMN_PASSWORD+" = '"+account.getPassword()+"'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Boolean result;
        if (cursor.moveToFirst()){
            cursor.moveToFirst();
           result = true;
        }else{
            result = false;
        }
        db.close();
        return result;
    }
    public Boolean checkNik(Employee data){
        String query = "SELECT * FROM "+ TABLE_EMPLOYEE+" WHERE " + COLUMN_ID + " = '"+ data.getNIK() +"'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Boolean result;
        if (cursor.moveToFirst()){
            cursor.moveToFirst();
            result = true;
        }else{
            result = false;
        }
        db.close();
        return result;
    }
}
