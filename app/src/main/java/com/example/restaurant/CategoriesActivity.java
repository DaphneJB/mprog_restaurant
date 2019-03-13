package com.example.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity implements CategoriesRequest.Callback {
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        CategoriesRequest req = new CategoriesRequest(this);
        req.getCategories(this);
    }

    @Override
    public void gotCategories(ArrayList<String> categories) {
        adapter = new MenuItemAdapter(this, R.layout.activity_categories, categories);
        ListView view = findViewById(R.id.listview);
        view.setAdapter(adapter);
        view.setOnItemClickListener(new ClickListener());
    }

    @Override
    public void gotCategoriesError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private class ClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(CategoriesActivity.this, MenuActivity.class);
            String clickedCat = (String) parent.getItemAtPosition(position);
            intent.putExtra("category", clickedCat);
            startActivity(intent);
        }
    }
}
