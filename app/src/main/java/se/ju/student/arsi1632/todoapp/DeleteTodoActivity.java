package se.ju.student.arsi1632.todoapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DeleteTodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_todo);
        int position = getIntent().getIntExtra("position", 0);
        TextView textBox = findViewById(R.id.todoText);
        textBox.setText( "Todo: " + Data.todos.get(position).title);
    }

    public void deleteButtonClicked(View view) {
        final int position = getIntent().getIntExtra("position", 0);
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.delete_todo))
                .setMessage(getString(R.string.confirm_delete))
                .setPositiveButton(
                        android.R.string.yes,
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int whichButton){
                                // Delete it.
                                Data.todos.remove(position);
                                finish();
                            }
                        }
                ).setNegativeButton(
                android.R.string.no,
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int whichButton){
                        // Do not delete it.
                    }
                }
        ).show();
    }
}
