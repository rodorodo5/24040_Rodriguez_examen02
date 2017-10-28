package com.example.rodo.examen02.Models;

import android.os.Parcel;
import android.os.Parcelable;


public class Snakes {
    private int _Id;
    private int _Begin;
    private int _Destination;

    public Snakes(int id, int begin, int destination){
        _Id = id;
        _Begin = begin;
        _Destination = destination;
    }

    public Snakes(){

    }

    public int GetId(){
        return _Id;
    }
    public void SetPostId(int value){
        _Id = value;
    }

    public int GetBegin(){
        return _Begin;
    }
    public void SetBegin(int value){
        _Begin = value;
    }

    public int GetDestination(){
        return _Destination;
    }
    public void SetDestination(int value){
        _Destination = value;
    }

}