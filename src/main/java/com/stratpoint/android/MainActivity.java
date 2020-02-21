package com.stratpoint.android;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Player> players;
    RecyclerView rvPlayers;
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        this.init();
//        String a = String.valueOf();
        new JsonTask().execute("http://www.mocky.io/v2/5e4ff4f53000009000226cf6");

//        TextView tv = (TextView) findViewById(R.id.textView);
//        tv.setText("sample");
    }

    private class JsonTask extends AsyncTask<String, String, String> {

        protected String doInBackground(String... params) {


            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                java.net.URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line+"\n");
                }

                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            init(result);
        }
    }

    public void init(String obj){
        ArrayList<Player> players = new ArrayList<>();
        JSONArray jsonArray =null, sorted = null;
        try{
            jsonArray = new JSONArray(obj);
            System.out.println(jsonArray.getJSONObject(0));
        }catch(Exception e){
            e.printStackTrace();
        }
        sorted  = jsonArraySort(jsonArray);
//        Player ramon = new Player("ramon", 2);
//        players = ramon.createPlayerList(5);
//        System.out.println(jsonArray.getJSONObject(0));
        try{
            for(int i = 0; i < sorted.length(); i++){
                Player player = new Player(sorted.getJSONObject(i).getString("name"), sorted.getJSONObject(i).getString("score"));
                players.add(player);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this, players);
        recyclerView.setAdapter(adapter);
        Swipe simpleItemTouchCallback = new Swipe(this);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }
    public JSONArray jsonArraySort(JSONArray list){
        JSONArray sorted = new JSONArray();
        int flag = 0;
        while(list.length() > 0){
            flag = 0;
            try{
                for(int i = 0; i < list.length(); i++){
                    if(list.getJSONObject(i).getString("score").compareTo(list.getJSONObject(flag).getString("score")) > 0){
                        flag = i;
                    }
//                    Player player = new Player(list.getJSONObject(i).getString("name"), list.getJSONObject(i).getString("score"));
//                    players.add(player);
                }
                sorted.put(list.remove(flag));
            }catch(Exception e){
                e.printStackTrace();
            }

        }



        return sorted;
    }

}
