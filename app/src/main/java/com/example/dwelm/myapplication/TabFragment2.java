package com.example.dwelm.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TabFragment2 extends Fragment {

    String urlAddress ="http://www.wilhelmbotha.co.za/saveData.php";
    EditText nameTxt, vistitTxt, commentTxt;
    FloatingActionButton saveBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_fragment_2, container, false);
        final Context c = getContext();
        nameTxt = (EditText) v.findViewById(R.id.nameEditTxt);
        vistitTxt = (EditText) v.findViewById(R.id.dateEditTxt);
        commentTxt = (EditText) v.findViewById(R.id.commentEditTxt);
        saveBtn = (FloatingActionButton) v.findViewById(R.id.fab2);

        saveBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Sender s = new Sender(c,urlAddress,nameTxt,vistitTxt,commentTxt);
                s.execute();
            }
        });

        return v;
    }
}