package com.example.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MenuItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item);
        Intent intent = getIntent();
        MenuItem retrievedItem = (MenuItem) intent.getSerializableExtra("menuItem");

        TextView name = findViewById(R.id.name);
        name.setText(retrievedItem.getName());

        TextView description = findViewById(R.id.description);
        description.setText(retrievedItem.getDescription());

        TextView price = findViewById(R.id.price);
        price.setText("€" + retrievedItem.getPrice());

        ImageView imageView = findViewById(R.id.image);
        Picasso.with(getApplicationContext()).load(retrievedItem.getImageUrl()).into(imageView);
    }
}
