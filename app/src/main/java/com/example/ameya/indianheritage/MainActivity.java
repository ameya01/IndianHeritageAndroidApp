package com.example.ameya.indianheritage;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list = null;
    private ArrayAdapter<String> adapter = null;
    private XMLHeritageListData heritageListData = null;
   // LinearLayout ly;
    Intent intent = null;
    Bundle b = null;
    int[] listviewImage = new int[]{
            R.drawable.thumbnail1, R.drawable.thumbnail2,R.drawable.thumbnail3,R.drawable.thumbnail4, R.drawable.thumbnail5
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        Log.d("DEBUG", " 1 \n");
        heritageListData = new XMLHeritageListData(getApplicationContext());

        Log.d("DEBUG", heritageListData.getHeritageData(0).getName());
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < listviewImage.length; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", heritageListData.getHeritageData(i).getName());
            hm.put("listview_discription", heritageListData.getHeritageData(i).getAddress());
            hm.put("listview_image", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }
        Log.d("DEBUG", "3 \n");
        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};
        Log.d("DEBUG", "4 \n");
        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.activity_main, from, to);
        Log.d("DEBUG", "5 \n");
        ListView androidListView = (ListView) findViewById(R.id.list_view);
        Log.d("DEBUG", "6 \n");
        androidListView.setAdapter(simpleAdapter);
        Log.d("DEBUG", "7 \n");


        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                intent = new Intent(getApplicationContext(), SelectedHeritage.class);
                b = new Bundle();

                Log.d("DEBUG", " Bundle made \n");

                b.putSerializable("data", heritageListData.getHeritageData(i));
                Log.d("DEBUG", " string put in bundle \n");

                intent.putExtras(b);

                startActivity(intent);
            }
        });
    }

}
