package com.example.rodo.examen02.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.example.rodo.examen02.Utils.DBUtils;
import com.example.rodo.examen02.Models.Board;
import com.example.rodo.examen02.Models.Snakes;
import com.example.rodo.examen02.Models.Ladders;
import java.util.ArrayList;

public class DBHelper_Board {
    private DBUtils dbHelper;
    private SQLiteDatabase database;
    private String[] BOARD_TABLE_COLUMNS = {
            DBUtils.BOARD_ID,
            DBUtils.BOARD_NAME,
            DBUtils.BOARD_AUTHOR
    };

    public DBHelper_Board(Context context){
        dbHelper = new DBUtils(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Board Create(Board game) {
        ContentValues values = new ContentValues();

        values.put(DBUtils.BOARD_ID, game.GetId());
        values.put(DBUtils.BOARD_NAME, game.GetName());
        values.put(DBUtils.BOARD_AUTHOR, game.GetAuthor());

        long commentId = database.insert(DBUtils.BOARD_TABLE_NAME, null, values);

        Cursor cursor = database.query(DBUtils.BOARD_TABLE_NAME, BOARD_TABLE_COLUMNS,
                DBUtils.BOARD_ID + " = " + commentId, null, null, null, null);

        cursor.moveToFirst();
        Board response = parseGame(cursor);
        cursor.close();

        return response;
    }

    public void Delete(int gameId) {
        database.delete(DBUtils.BOARD_TABLE_NAME, DBUtils.BOARD_ID + " = " + gameId, null);
    }

    public int Read(int gameId) {
        Cursor cursor = database.query(DBUtils.BOARD_TABLE_NAME, new String[] {DBUtils.BOARD_ID}, DBUtils.BOARD_ID + " = " + gameId, null, null, null, null);
        cursor.moveToFirst();
        int id = cursor.getInt(cursor.getColumnIndex(DBUtils.BOARD_ID));
        return id;
    }

    public void clearTable(String tableName) {
        database.execSQL("DELETE FROM " + tableName);
    }

    private Board parseGame(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndex(DBUtils.BOARD_ID));
        String name = cursor.getString(cursor.getColumnIndex(DBUtils.BOARD_NAME));
        String author = cursor.getString(cursor.getColumnIndex(DBUtils.BOARD_AUTHOR));

        Board game = new Board(id, name, author);
        return game;
    }
}