package com.webskitters.asynctaskproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle bundle = getIntent().getExtras();
        s = bundle.getString("k");
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(s);
    }
}
