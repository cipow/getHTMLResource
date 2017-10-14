package com.example.gilangk.gethtmlresource;

import android.content.Context;
import android.os.AsyncTask;

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


        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
