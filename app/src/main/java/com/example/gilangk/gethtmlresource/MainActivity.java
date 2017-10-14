package com.example.gilangk.gethtmlresource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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
        text_url = (EditText) findViewById(R.id.url_input);
        result_HTML = (TextView) findViewById(R.id.sumber_HTML);

        list_spinner = ArrayAdapter.createFromResource(this, R.array.protokol, android.R.layout.simple_spinner_item);
        list_spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(list_spinner);

    }

    public void yolooo(View view) {
        String link_url;

        link_url = spin.getSelectedItem().toString() + text_url.getText().toString();

        yolo = new GetHTMLSource(this);
        yolo.execute(link_url);
    }
}
