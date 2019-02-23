package com.nbb.aaa.chess_tacticts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class DataBaseManagerUser extends SQLiteOpenHelper {

    public static final String DATABASENAME = "product.db1";
    public static final String TABLE_PRODUCT = "tblproducts";
    public static final int DATABASEVERSION = 1;

    public static final String COLUMN_ID = "userId";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";


    SQLiteDatabase database;

    private static final String CREATE_TABLE_PPRODUCT = "CREATE TABLE IF NOT EXISTS " +
            TABLE_PRODUCT + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USERNAME + " VARCHAR," + COLUMN_PASSWORD + " VARCHAR " + ");";


    String[] allColumns = {DataBaseManagerUser.COLUMN_ID, DataBaseManagerUser.COLUMN_USERNAME, DataBaseManagerUser.COLUMN_PASSWORD,};

    public DataBaseManagerUser(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);

    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PPRODUCT);
        Log.i("data1", "Table username created");
    }

    public User insert(User user) {
        Log.d("daniel", CREATE_TABLE_PPRODUCT);

        ContentValues values = new ContentValues();
        values.put(DataBaseManagerUser.COLUMN_USERNAME, user.getUsername());
        values.put(DataBaseManagerUser.COLUMN_PASSWORD, user.getPassword());

        long insertId = database.insert(DataBaseManagerUser.TABLE_PRODUCT, null, values);
        Log.i("data", "Product " + insertId + "insert to database");
        user.setUserId(insertId);
        return user;
    }


    public User createUser1(User user) {
        //INSERT INTO table_name (column1, column2, column3, ...)
        //VALUES (value1, value2, value3, ...);
        long lastId = -1;
        String str_sql = "INSERT INTO " + DataBaseManagerUser.TABLE_PRODUCT + "(" + DataBaseManagerUser.COLUMN_ID + ","
                + DataBaseManagerUser.COLUMN_USERNAME + "," + DataBaseManagerUser.COLUMN_PASSWORD + ")" + " VALUES (" +
                "'" + user.getUserId() + "'" + "," + "'" + user.getUsername() + "'," + "'" + user.getPassword() + "')";

        database.execSQL(str_sql);

        str_sql = "SELECT " + DataBaseManagerUser.COLUMN_ID + " from " + DataBaseManagerUser.TABLE_PRODUCT + "  order by " + DataBaseManagerUser.COLUMN_ID + " DESC limit 1\n";

        Cursor c = database.rawQuery(str_sql, null);
        if (c != null && c.moveToFirst()) {
            lastId = c.getLong(0); //The 0 is the column index, we only have 1 column, so the index is 0
            Log.d("data1", "" + lastId);
        }

        user.setUserId(lastId);
        return user;
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
        onCreate(db);
    }

    public void open() {
        database = this.getWritableDatabase();
        Log.d("daniel", "Database connection open");
    }


    public ArrayList<User> getAllUsers() {

        ArrayList<User> l = new ArrayList<User>();
        Cursor cursor = database.query(DataBaseManagerUser.TABLE_PRODUCT, allColumns, null, null, null, null, null);

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String username = cursor.getString(cursor.getColumnIndex(DataBaseManagerUser.COLUMN_USERNAME));
                String password = cursor.getString(cursor.getColumnIndex(DataBaseManagerUser.COLUMN_PASSWORD));
                User u = new User(username, password);
                l.add(u);
            }
        }
        return l;
    }

    public boolean isExist(User u) {
        ArrayList<User> l = getAllUsers();
        boolean b = false;

        for(int i = 0;i<l.size();i++)
        {
            if(u.getUsername().equals(l.get(i).getUsername()) && u.getPassword().equals(l.get(i).getPassword()))
            {
                b = true;
            }

        }
        return b;
    }

}

