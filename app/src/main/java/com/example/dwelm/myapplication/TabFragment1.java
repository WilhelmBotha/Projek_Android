package com.example.dwelm.myapplication;

        import android.content.Context;
        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ListView;


public class TabFragment1 extends Fragment {

    String url = "http://www.wilhelmbotha.co.za/postID.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_fragment_1, container, false);

        final Context c = getContext();
        final ListView lv = (ListView) v.findViewById(R.id.lv);
        final Downloader d = new Downloader(getContext(),url,lv,1);

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
                    final Downloader d = new Downloader(c,url,lv,1);
                    d.execute();
                }

            }
        });

        return v;

    }
}