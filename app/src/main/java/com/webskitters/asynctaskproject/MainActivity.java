package com.webskitters.asynctaskproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText = (EditText) findViewById(R.id.editText);
        Button btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(editText.getText().toString());
                new task().execute(num,null,null);
            }
        });

    }

    private class task extends AsyncTask<Integer, Integer, String> {

        String data;
        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = ProgressDialog.show(MainActivity.this,
                    "", "", true);
            data = "";
            data+=": Output :\n\n\n";
        }

        @Override
        protected String doInBackground(Integer... integers) {
            try {
                for (int i=0; i<integers[0] ; i++)
                {
                    for (int j=0; j<=i; j++ )
                    {
                        data+=" * ";
                    }
                    data+="\n";
                    publishProgress((int) (((i+1) / (float) integers[0]) * 100));
                }
            } catch (Exception e){
                data = "Something went wrong!";
            }



            return data;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            pd.setMessage(values[0] + "%" + "  completed...");
        }

        @Override
        protected void onPostExecute(String result){
            pd.dismiss();
            Intent intent = new Intent(MainActivity.this, Second.class);
            intent.putExtra("k",result);
            startActivity(intent);
        }
    }
}
