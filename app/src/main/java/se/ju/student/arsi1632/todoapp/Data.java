package se.ju.student.arsi1632.todoapp;

import android.content.res.Resources;

import java.util.ArrayList;

public class Data {
    public static ArrayList<ToDo> todos = new ArrayList<>();
    static{
        todos.add(new ToDo("Do A"));
        todos.add(new ToDo("Do B"));
        todos.add(new ToDo("Do C"));
    }
    public static class ToDo{
        public String title;
        public ToDo(String title) { this.title = title; }
        @Override
        public String toString() { return "Todo: " + title; }
    }
}
