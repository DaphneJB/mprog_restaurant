package com.example.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements MenuRequest.Callback {
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent = getIntent();
        String category = (String) intent.getSerializableExtra("category");
        MenuRequest req = new MenuRequest(this, category);
        req.getMenu(this);
    }

    @Override
    public void gotMenuItems(ArrayList<MenuItem>items) {
        adapter = new MenuAdapter(this, R.layout.activity_menu, items);
        ListView view = findViewById(R.id.menu);
        view.setAdapter(adapter);
        view.setOnItemClickListener(new ClickListener());
    }

    @Override
    public void gotMenuItemsError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private class ClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(MenuActivity.this, MenuItemActivity.class);
            MenuItem clickedItem = (MenuItem) parent.getItemAtPosition(position);
            intent.putExtra("menuItem", clickedItem);
            startActivity(intent);
        }
    }

}
