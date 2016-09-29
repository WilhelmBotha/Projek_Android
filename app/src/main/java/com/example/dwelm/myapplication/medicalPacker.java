package com.example.dwelm.myapplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

/**
 * Created by Dwelm on 9/29/2016.
 */
public class medicalPacker {

    String Name, Amount;

    public medicalPacker(String Name, String Amount) {
        this.Name = Name;
        this.Amount = Amount;
    }

    public String packData()
    {
        JSONObject jo = new JSONObject();
        StringBuffer sb = new StringBuffer();

        try
        {
            jo.put("Medicine_name", Name);
            jo.put("Number_left", Amount);
            Boolean firstValue = true;

            Iterator it = jo.keys();

            do {
                String key = it.next().toString();
                String value = jo.get(key).toString();

                if(firstValue)
                {
                    firstValue = false;
                }
                else
                {
                    sb.append("&");
                }

                sb.append(URLEncoder.encode(key, "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(value, "UTF-8"));
            }
            while(it.hasNext());

            return sb.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
