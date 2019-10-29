package com.example.ameya.indianheritage;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class SelectedHeritageMoreInfo extends AppCompatActivity {

    private TextView nameTextView = null;
    private TextView informationTextView = null;
    private TextView addressTextView = null;
    private TextView urlTextView = null;

    private Button webInfoButton;
    private Intent intent = null;

    private HeritageDetails data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_information);

        // get data from intent
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        data = (HeritageDetails) bundle.getSerializable("data");

        //wire and populate the fields with data.getName() etc
        nameTextView    = findViewById(R.id.textView5);
        addressTextView = findViewById(R.id.textView3);
        urlTextView     = findViewById(R.id.textView2);
        informationTextView = findViewById(R.id.textView4);

        nameTextView.setText(data.getName());
        addressTextView.setText(data.getAddress());
        urlTextView.setText(data.getUrl());
        informationTextView.setText(data.getInformation());
        webInfoButton = findViewById(R.id.button2);
        urlTextView.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), RedirectWebView.class);
                Log.d( "LOGCAT",  "URL= > "+data.getUrl() );
                intent.putExtra( "url",data.getUrl() );
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", data);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }
        }));
        webInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), RedirectWebView.class);
                Log.d( "LOGCAT",  "URL= > "+data.getUrl() );
                intent.putExtra( "url",data.getUrl() );
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", data);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }
        });

    }

}