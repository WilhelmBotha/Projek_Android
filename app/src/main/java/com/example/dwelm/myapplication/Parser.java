package com.example.dwelm.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.test.PerformanceTestCase;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Dwelm on 9/27/2016.
 */

public class Parser extends AsyncTask<Void, Integer, Integer>{

    Context c;
    ListView lv;
    String data;
    Integer tab;

    ArrayList<String> patients = new ArrayList<>();

    ProgressDialog pd;

    public Parser(Context c, ListView lv, String data, Integer tab) {
        this.c = c;
        this.lv = lv;
        this.data = data;
        this.tab = tab;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd = new ProgressDialog(c);
        pd.setTitle("Parser");
        pd.setMessage("Parsing data");
        pd.show();
    }

    @Override
    protected Integer doInBackground(Void... params) {

        return this.parse();

    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);

        if(integer == 1)
        {
            ArrayAdapter<String> _adapter = new ArrayAdapter<String>(c,android.R.layout.simple_list_item_1,patients);
            lv.setAdapter(_adapter);

           /* lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String items = lv.getSelectedItem().toString();
                    Snackbar.make(view, patients.get(position), Snackbar.LENGTH_SHORT).show();
                }
            });*/

        }
        else
        {
            Toast.makeText(c,"Unable to parse data",Toast.LENGTH_SHORT).show();
        }

        pd.dismiss();
    }

    private int parse()
    {
       try
       {
           JSONArray js = new JSONArray(data);
           JSONObject jo = null;

           patients.clear();

           if(tab == 1)
           {
               for(int i = 0;i<js.length();i++)
               {
                   jo = js.getJSONObject(i);

                   // String name = jo.getString("Name");
                   String id = jo.getString("ID");
                   String date = jo.getString("Last_visit");
                   String comment = jo.getString("Comments");

                   //patients.add(name);
                   patients.add(id + "\n" + date + "\n" + comment + "\n");
                   //patients.add(date);
                   //patients.add(comment);
               }
           }
           else
           {
               for(int i = 0;i<js.length();i++)
               {
                   jo = js.getJSONObject(i);

                   // String name = jo.getString("Name");
                   String name = jo.getString("Medicine_name");
                   String left = jo.getString("Number_left");
                   //String comment = jo.getString("Comments");

                   //patients.add(name);
                   patients.add(name + "\n" + left + "\n");
                   //patients.add(date);
                   //patients.add(comment);
               }
           }


           return 1;
       } catch (JSONException e) {
           e.printStackTrace();
       }
        return 0;
    }
}
