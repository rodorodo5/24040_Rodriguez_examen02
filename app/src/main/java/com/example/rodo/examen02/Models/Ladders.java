package com.example.rodo.examen02.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rodo on 10/27/17.
 */

public class Ladders {
    private int _Id;
    private int _Begin;
    private int _Destination;

    public Ladders(int id, int begin, int destination){
        _Id = id;
        _Begin = begin;
        _Destination = destination;
    }

    public Ladders(){

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