package com.example.restaurant;

import android.content.Context;
import android.view.Menu;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MenuRequest implements Response.Listener<JSONObject>, Response.ErrorListener {

    private Context context;
    private ArrayList<MenuItem> menu;
    private JSONArray category;
    private CategoriesRequest.Callback activity;

    public MenuRequest(Context cont) {
        context = cont;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        activity.gotCategoriesError(error.getMessage());
    }

    @Override
    public void onResponse(JSONObject response) {
        try {
            menu = new ArrayList<>();
            category = response.getJSONArray("items");
            for(int i = 0; i < category.length(); i++) {
                JSONObject item = category.getJSONObject(i);
                menu.add(new MenuItem(item.getString("description"), item.getString("name"),
                        item.getString("image_url"), item.getString("category"),
                        item.getDouble("price")));
            }
            activity.gotCategories(menu);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public interface Callback {
        void gotCategories(ArrayList<MenuItem>categories);
        void gotCategoriesError(String message);
    }

    public void getCategories(CategoriesRequest.Callback activity) {
        this.activity =activity;
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("https://resto.mprog.nl/menu", null, this, this);
        queue.add(jsonObjectRequest);
    }
}
