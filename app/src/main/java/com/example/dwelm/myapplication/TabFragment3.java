package com.example.dwelm.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class TabFragment3 extends Fragment {

    String url = "http://www.wilhelmbotha.co.za/getMeds.php";
    String urlAddress = "http://www.wilhelmbotha.co.za/updateMeds.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_fragment_1, container, false);

        final Context c = getContext();
        final ListView lv = (ListView) v.findViewById(R.id.lv);
        //final ListView lv2 = (ListView) v.findViewById(R.id.lv2);
        final Downloader d = new Downloader(getContext(),url,lv,3);

        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(d == null)
                {
                    d.execute();
                }
                else
                {
                    final Downloader d = new Downloader(c,url,lv,3);
                    d.execute();
                }

            }
        });


        lv.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue = (lv.getItemAtPosition(position).toString());
                final updateMeds med = new updateMeds(c,urlAddress,itemValue);
                med.execute();

                final Downloader d = new Downloader(c,url,lv,3);
                d.execute();
            }
        });

        return v;
    }
}