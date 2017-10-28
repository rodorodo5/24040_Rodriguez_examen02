package com.example.rodo.examen02.Models;

/**
 * Created by rodo on 10/27/17.
 */

public class Board {
    private int _Id;
    private String _Name;
    private String _Author;

    public Board(int id, String name, String author){
        _Id = id;
        _Name = name;
        _Author = author;
    }

    public Board(){

    }
    //Auto
    public int GetId(){
        return _Id;
    }
    public void SetPostId(int value){
        _Id = value;
    }

    public String GetName(){
        return _Name;
    }
    public void SetName(String value){
        _Name = value;
    }

    public String GetAuthor(){
        return _Author;
    }
    public void SetAuthor(String value){
        _Author = value;
    }

}
