package com.example.gilangk.gethtmlresource;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by cipowela on 14/10/17.
 */

public class GetHTMLSource extends AsyncTask<String,Void,String> {
    private Context ctx;

    public GetHTMLSource(Context ctx) {
        this.ctx = ctx;
    }


    @Override
    protected String doInBackground(String... params) {
        String link = params[0];
        InputStream in;

        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(20000);
            connection.setRequestMethod("GET");
            connection.connect();

            in = connection.getInputStream();

            BufferedReader buff = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line = "";

            while ((line = buff.readLine()) != null) {
                sb.append(line + "\n");
            }

            buff.close();
            in.close();

            return sb.toString();


        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(ctx,"Kesalahan dalam akses URL\nCoba ubah protokol",Toast.LENGTH_LONG).show();
        }


        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        MainActivity.result_HTML.setText(s);
    }
}
