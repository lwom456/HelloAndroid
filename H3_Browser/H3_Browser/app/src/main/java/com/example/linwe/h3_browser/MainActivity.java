package com.example.linwe.h3_browser;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        Intent intent = new Intent(this,Browser.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String url = "http://"+editText.getText().toString();
        Uri uri = Uri.parse(url);
        intent.setData(uri);
        startActivity(intent);
    }
}
