package com.example.rodo.examen02.Utils;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.rodo.examen02.Utils.*;

public class DBUtils extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "popis.db";
    public static final int DATABASE_VERSION = 1;

    public static final String BOARD_TABLE_NAME = "Board";
    public static final String BOARD_ID = "Id";
    public static final String BOARD_NAME = "Name";
    public static final String BOARD_AUTHOR = "Author";

    public static final String SNAKES_TABLE_NAME = "Snakes";
    public static final String SNAKE_ID = "Id";
    public static final String SNAKE_BEGIN = "Begin";
    public static final String SNAKE_DESTINATION = "Destination";

    public static final String LADDERS_TABLE_NAME = "Ladder";
    public static final String LADDER_ID = "Id";
    public static final String LADDER_BEGIN = "Begin";
    public static final String LADDER_DESTINATION = "Destination";

    public static final String GAMESNAKE_TABLE_NAME = "GameSnake";
    public static final String GAMESNAKE_ID = "Id";
    public static final String GAMESNAKE_GAMEID = "GameId";
    public static final String GAMESNAKE_SNAKEID = "SnakeId";

    public static final String GAMELADDER_TABLE_NAME = "GameLadder";
    public static final String GAMELADDER_ID = "Id";
    public static final String GAMELADDER_GAMEID = "GameId";
    public static final String GAMELADDER_LADDERID = "LadderId";



    public static final String DATABASE_CREATE =
            "CREATE TABLE " + BOARD_TABLE_NAME + "(" +
                    BOARD_ID + " integer primary key autoincrement, " +
                    BOARD_NAME + " text not null, " +
                    BOARD_AUTHOR + " text not null, " +
                    ");" +
                    "CREATE TABLE " + SNAKES_TABLE_NAME + "(" +
                    SNAKE_ID + " integer primary key autoincrement, " +
                    SNAKE_BEGIN + " integer not null, " +
                    SNAKE_DESTINATION + " integer not null, " +
                    ");" +
                    "CREATE TABLE " + LADDERS_TABLE_NAME + "(" +
                    LADDER_ID + " integer primary key autoincrement, " +
                    LADDER_BEGIN + " integer not null, " +
                    LADDER_DESTINATION + " integer not null, " +
                    ");" +
                    "CREATE TABLE " + GAMESNAKE_TABLE_NAME + "(" +
                    GAMESNAKE_ID + " integer primary key autoincrement, " +
                    GAMESNAKE_GAMEID + " integer not null, " +
                    GAMESNAKE_SNAKEID + " integer not null, " +
                    ");" +
                    "CREATE TABLE " + GAMELADDER_TABLE_NAME + "(" +
                    GAMELADDER_ID + " integer primary key autoincrement, " +
                    GAMELADDER_GAMEID + " integer not null, " +
                    GAMELADDER_LADDERID + " integer not null, " +
                    ");";

    public DBUtils(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + BOARD_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SNAKES_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + LADDERS_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + GAMELADDER_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + GAMESNAKE_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}