package com.ceylon.iotcontroller;

import androidx.appcompat.app.AppCompatActivity;
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

    //the hero list where we will store all the hero objects after parsing json
    List<Posts> postsList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        postsList = new ArrayList<>();
        recyclerView =findViewById(R.id.recycler);

       GetData getData =new GetData();
       getData.execute();

    }
    public class GetData extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... strings) {
       String current ="";
       try {
          URL url;
           HttpURLConnection urlConnection =null;

           try {
               url =new URL(JSON_URL);
               urlConnection =(HttpURLConnection) url.openConnection();

               InputStream is = urlConnection.getInputStream();
               InputStreamReader isr =new InputStreamReader(is);

               int data =isr.read();
               while (data !=-1){

                   current +=(char)data;
                   data =isr.read();


               }
               return current;

           } catch (MalformedURLException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }finally {
               if(urlConnection != null){
                   urlConnection.disconnect();
               }
           }
       }catch (Exception e){
           e.printStackTrace();
       }
       return current;
        }

        @Override
        protected void onPostExecute(String s) {
          try {
              JSONObject jsonObject = new JSONObject(s);
              JSONArray jsonArray =jsonObject.getJSONArray("posts");

              for (int i = 0; i < jsonArray.length(); i++) {
                  //getting the json object of the particular index inside the array
                  JSONObject jsonObject1 = jsonArray.getJSONObject(i);


                  Posts posts = new Posts();
                  posts.setName(jsonObject1.getString("title"));
                  posts.setImageUrl(jsonObject1.getString("created_at"));
                  posts.setFeature_image(jsonObject1.getString("feature_image"));
                  posts.setHtml(jsonObject1.getString("html"));

                  postsList.add(posts);

              }



          } catch (JSONException e) {
              e.printStackTrace();
          }

          putDataIntoRecyclerView(postsList);
        }
    }
private void putDataIntoRecyclerView(List<Posts>postsList){
        ListViewAdapter listViewAdapter =new  ListViewAdapter(postsList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listViewAdapter);
        recyclerView.setHasFixedSize(true);
}
    }



