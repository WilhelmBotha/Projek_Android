package com.example.dwelm.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

/**
 * Created by Dwelm on 9/28/2016.
 */
public class updateMeds extends AsyncTask<Void,Void,String>{

    Context c;
    String urlAddress;
    String mystring;

    ProgressDialog pd;

    public updateMeds(Context c, String urlAddress, String mystring) {
        this.c = c;
        this.urlAddress = urlAddress;
        this.mystring = mystring;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd = new ProgressDialog(c);
        pd.setTitle("Send");
        pd.setMessage("Sending data");
        pd.show();
    }

    @Override
    protected String doInBackground(Void... params) {
        return this.send();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        pd.dismiss();

        if(s != null)
        {
            Toast.makeText(c,s,Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(c,"Unsuccessful entry", Toast.LENGTH_LONG).show();
        }
    }

    private String send()
    {
        HttpURLConnection con = Connecter.conect(urlAddress);

        if(con==null)
        {
            return null;
        }

       /* try
        {
            OutputStream os = con.getOutputStream();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            bw.write(String.valueOf(js));
            bw.flush();
            bw.close();
            os.close();

            int responseCode = con.getResponseCode();

            if(responseCode == con.HTTP_OK)
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuffer response = new StringBuffer();

                String line = null;

                while ((line = br.readLine()) != null)
                {
                    response.append(line);
                }

                br.close();

                return response.toString();
            }
            else
            {

            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        return null;
    }
}
