package com.example.ameya.indianheritage;
import android.content.Context;

import com.example.ameya.indianheritage.R;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
public class XMLHeritageListData {
    private Context context;
    private HeritageDetails[] data;

    public  XMLHeritageListData(Context context){
        this.context = context;

        //get stream to xml and parse it
        InputStream stream = this.context.getResources().openRawResource(R.raw.heritage);
        DocumentBuilder builder =null;
        Document document = null;
        try{
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = builder.parse(stream);
        }catch (Exception e){

        }
        //extract the nodelists for name,address etc.
        NodeList nameList = document.getElementsByTagName("name");
        NodeList addressList = document.getElementsByTagName("address");
        NodeList imageList = document.getElementsByTagName("image");
        NodeList urlList = document.getElementsByTagName("url");
        NodeList informationList = document.getElementsByTagName("information");

        data = new HeritageDetails[nameList.getLength()];
        //traverse these node lists to populate data
        for(int i=0; i<nameList.getLength();i++){
            //extract name,address etc
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String address = addressList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();
            String url = urlList.item(i).getFirstChild().getNodeValue();
            String information = informationList.item(i).getFirstChild().getNodeValue();

            //make a Person object
            HeritageDetails p = new HeritageDetails(name,address,image,url,information);

            // add it to data
            data[i] = p;
        }
    }

    public HeritageDetails getHeritageData(int i){
        return data[i];
    }


    public String [] getNames(){

        String [] names = new String[data.length];
        for(int i = 0;i<data.length;i++){

            names[i] = data[i].getName();

        }
        return names;
    }

    public int getLength(){
        return data.length;
    }
}

