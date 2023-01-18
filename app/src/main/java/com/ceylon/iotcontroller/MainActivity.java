package com.ceylon.iotcontroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String JSON_URL = "https://telecomworlds.com/ghost/api/content/posts/?key=b2d3310778046fca39d75a2c9d";

    //listview object
    ListView listView;


    List<Posts> postsList;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        postsList = new ArrayList<>();
        recyclerView =findViewById(R.id.recycler);

        progressBar =findViewById(R.id.idPBLoading);


getdatavolly();
    }

    private void getdatavolly() {


        //making the progressbar visible
        progressBar.setVisibility(View.VISIBLE);

        //creating a string request to send request to the url
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //hiding the progressbar after completion
                        progressBar.setVisibility(View.INVISIBLE);


                        try {
                            //getting the whole json object from the response
                            JSONObject obj = new JSONObject(response);

                            //we have the array named hero inside the object
                            //so here we are getting that json array
                            JSONArray heroArray = obj.getJSONArray("posts");

                            //now looping through all the elements of the json array
                            for (int i = 0; i < heroArray.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject jsonObject1 = heroArray.getJSONObject(i);

                                //creating a posts object and giving them the values from json object
                                Posts posts = new Posts();
                                posts.setName(jsonObject1.getString("title"));
                                posts.setImageUrl(jsonObject1.getString("created_at"));
                                posts.setFeature_image(jsonObject1.getString("feature_image"));
                                posts.setHtml(jsonObject1.getString("html"));
                                posts.setReading_time(jsonObject1.getString("reading_time"));

                                postsList.add(posts);


                            }


                            ListViewAdapter adapter = new ListViewAdapter(postsList, getApplicationContext());




                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        putDataIntoRecyclerView(postsList);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


        RequestQueue requestQueue = Volley.newRequestQueue(this);


        requestQueue.add(stringRequest);
    }




private void putDataIntoRecyclerView(List<Posts>postsList){
        ListViewAdapter listViewAdapter =new  ListViewAdapter(postsList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listViewAdapter);
        recyclerView.setHasFixedSize(true);
}
    }



