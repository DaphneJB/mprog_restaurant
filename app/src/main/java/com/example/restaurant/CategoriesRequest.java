package com.example.restaurant;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class CategoriesRequest implements Response.Listener<JSONObject>, Response.ErrorListener {

    private Context context;
    private ArrayList<String>cat;
    private JSONArray category;
    private Callback activity;

    public CategoriesRequest(Context cont) {
        context = cont;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        activity.gotCategoriesError(error.getMessage());
    }

    @Override
    public void onResponse(JSONObject response) {
        try {
            cat = new ArrayList<>();
            category = response.getJSONArray("categories");
            for(int i = 0; i < category.length(); i++) {
                cat.add(category.getString(i));
            }
            activity.gotCategories(cat);
            System.out.println("oke2 " + cat.size());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public interface Callback {
        void gotCategories(ArrayList<String> categories);
        void gotCategoriesError(String message);
    }

    public void getCategories(Callback activity) {
        this.activity =activity;
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("https://resto.mprog.nl/categories", null, this, this);
        queue.add(jsonObjectRequest);
    }
}
