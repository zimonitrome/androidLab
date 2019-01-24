package se.ju.student.arsi1632.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
    }

    public void createButtonClicked(View view) {
        EditText editText = (EditText) findViewById(R.id.enteredTitle);
        String enteredTitle = editText.getText().toString();
        Data.todos.add(new Data.ToDo(enteredTitle));
        finish();
    }
}
