package com.example.cipowela.gethtmlresource;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static TextView result_HTML;
    Spinner spin;
    EditText text_url;
    ArrayAdapter<CharSequence> list_spinner;
    GetHTMLSource yolo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin = (Spinner) findViewById(R.id.spinner_protokol);
        text_url = (EditText) findViewById(R.id.input_link);
        result_HTML = (TextView) findViewById(R.id.sumber_HTML);

        list_spinner = ArrayAdapter.createFromResource(this, R.array.protokol, android.R.layout.simple_spinner_item);
        list_spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(list_spinner);

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
                Log.e("Error"+Thread.currentThread().getStackTrace()[2],paramThrowable.getLocalizedMessage());
            }
        });

    }

    public void yolooo(View view) {
        String link_url;

        link_url = spin.getSelectedItem().toString() + text_url.getText().toString();


        if (checkConnection()) {
            yolo = new GetHTMLSource();
            yolo.execute(link_url);
        } else {
            Toast.makeText(this,"check your internet connection", Toast.LENGTH_SHORT).show();
            result_HTML.setText("No Internet Connection");
        }
    }

    public boolean checkConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();
    }
}
