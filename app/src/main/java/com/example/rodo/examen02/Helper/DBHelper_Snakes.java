package com.example.rodo.examen02.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.example.rodo.examen02.Utils.DBUtils;
import com.example.rodo.examen02.Models.Snakes;

/**
 * Created by rodo on 10/27/17.
 */

public class DBHelper_Snakes {
    private DBUtils dbHelper;
    private SQLiteDatabase database;
    private String[] SNAKES_TABLE_COLUMNS = {
            DBUtils.SNAKE_ID,
            DBUtils.SNAKE_BEGIN,
            DBUtils.SNAKE_DESTINATION
    };

    public DBHelper_Snakes(Context context){
        dbHelper = new DBUtils(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Snakes Create(Snakes snake) {
        ContentValues values = new ContentValues();

        values.put(DBUtils.SNAKE_ID, snake.GetId());
        values.put(DBUtils.SNAKE_BEGIN, snake.GetBegin());
        values.put(DBUtils.SNAKE_DESTINATION, snake.GetDestination());

        long snakeId = database.insert(DBUtils.SNAKES_TABLE_NAME, null, values);

        Cursor cursor = database.query(DBUtils.SNAKES_TABLE_NAME, SNAKES_TABLE_COLUMNS,
                DBUtils.SNAKE_ID + " = " + snakeId, null, null, null, null);

        cursor.moveToFirst();
        Snakes response = parseSnake(cursor);
        cursor.close();

        return response;
    }

    public void Delete(int snakeId) {
        database.delete(DBUtils.SNAKES_TABLE_NAME, DBUtils.SNAKE_ID + " = " + snakeId, null);
    }

    public int Read(int snakeId) {
        Cursor cursor = database.query(DBUtils.SNAKES_TABLE_NAME, new String[] {DBUtils.SNAKE_ID}, DBUtils.SNAKE_ID + " = " + snakeId, null, null, null, null);
        cursor.moveToFirst();
        int id = cursor.getInt(cursor.getColumnIndex(DBUtils.SNAKE_ID));
        return id;
    }

    public void clearTable(String tableName) {
        database.execSQL("DELETE FROM " + tableName);
    }

    private Snakes parseSnake(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndex(DBUtils.SNAKE_ID));
        int begin = cursor.getInt(cursor.getColumnIndex(DBUtils.SNAKE_BEGIN));
        int destination = cursor.getInt(cursor.getColumnIndex(DBUtils.SNAKE_DESTINATION));

        Snakes snake = new Snakes(id, begin, destination);
        return snake;
    }
}