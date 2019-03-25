package com.example.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
//shows the user detailed information about the chosen dish
public class MenuItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item);
        Intent intent = getIntent();
        MenuItem retrievedItem = (MenuItem) intent.getSerializableExtra("menuItem");
        TextView name = findViewById(R.id.name);
        name.setText(retrievedItem.getName());
        //show description
        TextView description = findViewById(R.id.description);
        description.setText(retrievedItem.getDescription());
        //show price
        TextView price = findViewById(R.id.price);
        price.setText("€" + retrievedItem.getPrice());
        //show image of dish
        ImageView imageView = findViewById(R.id.image);
        Picasso.with(getApplicationContext()).load(retrievedItem.getImageUrl()).into(imageView);
    }
}
