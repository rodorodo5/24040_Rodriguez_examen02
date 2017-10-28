package com.example.rodo.examen02.Helper;
import com.example.rodo.examen02.Utils.DBUtils;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import com.example.rodo.examen02.Models.Ladders;
/**
 * Created by rodo on 10/27/17.
 */

public class DBHelper_Ladder {
    private DBUtils dbHelper;
    private SQLiteDatabase database;
    private String[] LADDER_TABLE_COLUMNS = {
            DBUtils.LADDER_ID,
            DBUtils.LADDER_BEGIN,
            DBUtils.LADDER_DESTINATION
    };

    public DBHelper_Ladder(Context context){
        dbHelper = new DBUtils(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Ladders Create(Ladders ladder) {
        ContentValues values = new ContentValues();

        values.put(DBUtils.LADDER_ID, ladder.GetId());
        values.put(DBUtils.LADDER_BEGIN, ladder.GetBegin());
        values.put(DBUtils.LADDER_DESTINATION, ladder.GetDestination());

        long ladderId = database.insert(DBUtils.LADDERS_TABLE_NAME, null, values);

        Cursor cursor = database.query(DBUtils.LADDERS_TABLE_NAME, LADDER_TABLE_COLUMNS,
                DBUtils.LADDER_ID + " = " + ladderId, null, null, null, null);

        cursor.moveToFirst();
        Ladders response = parseLadder(cursor);
        cursor.close();

        return response;
    }

    public void Delete(int ladderId) {
        database.delete(DBUtils.LADDERS_TABLE_NAME, DBUtils.LADDER_ID + " = " + ladderId, null);
    }

    public int Read(int gameId) {
        Cursor cursor = database.query(DBUtils.LADDERS_TABLE_NAME, new String[] {DBUtils.LADDER_ID}, DBUtils.LADDER_ID + " = " + gameId, null, null, null, null);
        cursor.moveToFirst();
        int id = cursor.getInt(cursor.getColumnIndex(DBUtils.LADDER_ID));
        return id;
    }

    public void clearTable(String tableName) {
        database.execSQL("DELETE FROM " + tableName);
    }

    private Ladders parseLadder(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndex(DBUtils.LADDER_ID));
        int begin = cursor.getInt(cursor.getColumnIndex(DBUtils.LADDER_BEGIN));
        int destination = cursor.getInt(cursor.getColumnIndex(DBUtils.LADDER_DESTINATION));

        Ladders ladder = new Ladders(id, begin, destination);
        return ladder;
    }
}
