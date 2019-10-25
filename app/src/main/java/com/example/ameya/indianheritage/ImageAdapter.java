package com.example.ameya.indianheritage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.ameya.indianheritage.R;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private  String hName;

    public ImageAdapter(Context c,String name) {
        mContext = c;
        hName = name;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(180, 180));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5, 10, 5, 10);
        } else {
            imageView = (ImageView) convertView;
        }
        switch (hName){
            case  "Taj Mahal" :imageView.setImageResource(mThumbIds[position]);
            break;
            case  "Qutub Minar" :imageView.setImageResource(mThumbIds1[position]);
                break;
            case  "Red Fort" :imageView.setImageResource(mThumbIds2[position]);
                break;
            case  "The Sun Temple" :imageView.setImageResource(mThumbIds3[position]);
                break;
            case  "Ajanta Caves" :imageView.setImageResource(mThumbIds4[position]);
                break;


        }

        return imageView;
    }

    // references to our images
    public static Integer[] mThumbIds = {
            R.drawable.tajmahal1,R.drawable.tajmahal3,R.drawable.tajmahal4,R.drawable.tajmahal6,R.drawable.taj1,
            R.drawable.taj1, R.drawable.taj3, R.drawable.taj4, R.drawable.taj5, R.drawable.taj6, R.drawable.taj7,
            R.drawable.taj8, R.drawable.tajmahal4,

    };
    public static Integer[] mThumbIds1 = {
            R.drawable.qutub4,R.drawable.qutub3,R.drawable.qutub2,R.drawable.qutub1,R.drawable.qutubminar1,
            R.drawable.qutubminar2, R.drawable.qutubminar3, R.drawable.qutubminar4, R.drawable.taj5, R.drawable.taj6,
            R.drawable.taj7, R.drawable.taj8, R.drawable.tajmahal4,

    };
    public static Integer[] mThumbIds2 = {
            R.drawable.redfort1,R.drawable.redfort2,R.drawable.redfort3,R.drawable.redfort4,R.drawable.qutubminar1,
            R.drawable.qutubminar2, R.drawable.qutubminar3, R.drawable.qutubminar4, R.drawable.taj5, R.drawable.taj6,
            R.drawable.taj7, R.drawable.taj8, R.drawable.tajmahal4,

    };
    public static Integer[] mThumbIds3 = {
            R.drawable.suntemple5,R.drawable.suntemple4,R.drawable.suntemple3,R.drawable.suntemple2,R.drawable.suntemple1,
            R.drawable.qutubminar2, R.drawable.qutubminar3, R.drawable.qutubminar4, R.drawable.taj5, R.drawable.taj6,
            R.drawable.taj7, R.drawable.taj8, R.drawable.tajmahal4,

    };
    public static Integer[] mThumbIds4 = {
            R.drawable.ajanta1,R.drawable.ajanta2,R.drawable.ajanta3,R.drawable.ajanta4,R.drawable.ajanta5,
            R.drawable.ajanta6, R.drawable.ajanta7, R.drawable.ajanta8, R.drawable.taj5, R.drawable.taj6,
            R.drawable.taj7, R.drawable.taj8, R.drawable.tajmahal4,


    };
}

