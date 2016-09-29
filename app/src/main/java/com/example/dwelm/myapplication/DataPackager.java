package com.example.dwelm.myapplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

/**
 * Created by Dwelm on 9/28/2016.
 */
public class DataPackager {
    String ID, Last_Visit, Comments;

    public DataPackager(String ID, String last_Visit, String comments) {
        this.ID = ID;
        this.Last_Visit = last_Visit;
        this.Comments = comments;
    }

    public String packData()
    {
        JSONObject jo = new JSONObject();
        StringBuffer sb = new StringBuffer();

        try
        {
            jo.put("ID", ID);
            jo.put("Last_visit", Last_Visit);
            jo.put("Comments", Comments);
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
