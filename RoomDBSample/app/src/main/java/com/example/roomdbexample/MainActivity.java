package com.example.roomdbexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.roomdbexample.roomdb.Event;
import com.example.roomdbexample.roomdb.EventDao;
import com.example.roomdbexample.roomdb.EventDb;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private ListView eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventList = findViewById(R.id.event_list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventDb db = Room.databaseBuilder(getApplicationContext(),
                EventDb.class, EventDb.DATABASE_NAME).allowMainThreadQueries().build();
        EventDao dao = db.eventDao();
        ArrayAdapter<Event> adapter = new EventListAdapter(getApplicationContext(), dao.getAllEvent());
        eventList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, CreateEventActivity.class);
        startActivity(intent);
        return true;
    }
}