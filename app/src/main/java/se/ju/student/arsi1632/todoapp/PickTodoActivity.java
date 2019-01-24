package se.ju.student.arsi1632.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PickTodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final boolean isDelete = getIntent().getBooleanExtra("isDelete", false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_todo);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<Data.ToDo>(
                this,
                android.R.layout.simple_list_item_1,
                Data.todos
        ));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("position", position);
                returnIntent.putExtra("isDelete", isDelete);
                setResult(MainActivity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
