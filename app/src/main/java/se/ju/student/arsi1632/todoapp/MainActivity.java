package se.ju.student.arsi1632.todoapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createButtonClicked(View view) {
        Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);
    }

    public void selectButtonClicked(View view) {
        Intent intent = new Intent(this, PickTodoActivity.class);
        intent.putExtra("isDelete", false);
        startActivityForResult(intent, 1);
    }

    public void deleteButtonClicked(View view) {
        Intent intent = new Intent(this, PickTodoActivity.class);
        intent.putExtra("isDelete", true);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                int position = data.getIntExtra("position", 0);
                boolean isDelete = data.getBooleanExtra("isDelete", false);

                if (isDelete) {
                    Intent intent = new Intent(MainActivity.this, DeleteTodoActivity.class);
                    intent.putExtra("position", position);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity.this, ViewTodoActivity.class);
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }

    }
}
