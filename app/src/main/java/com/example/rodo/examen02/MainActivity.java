package com.example.rodo.examen02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.rodo.examen02.Helper.DBHelper_Board;
import com.example.rodo.examen02.Models.Ladders;
import com.example.rodo.examen02.Models.Snakes;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int userPos;
    String url;
    DBHelper_Board db;
    ArrayList<Snakes> posts;
    ArrayList<Ladders> comments;
    String snakes_ladders;
    Button buttonRoll,verJSON,buttonSyncP,buttonPostComments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = new DBHelper_Board(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper_Board(this);
        buttonRoll = (Button) findViewById((R.id.buttonRoll));
        verJSON = (Button) findViewById((R.id.buttonRoll));
        buttonSyncP = (Button) findViewById((R.id.buttonRoll));
        buttonPostComments = (Button) findViewById((R.id.buttonPostComments));
        url ="http://107.170.247.123:2403/sankes-ladders";
    }


}
