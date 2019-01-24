package se.ju.student.arsi1632.todoapp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewTodoActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_todo);
        int position = getIntent().getIntExtra("position", 0);
        TextView textBox = findViewById(R.id.todoText);
        textBox.setText( getString(R.string.title) + ": " + Data.todos.get(position).title);
    }
}
