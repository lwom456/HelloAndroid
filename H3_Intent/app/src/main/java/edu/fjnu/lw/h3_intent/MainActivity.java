package edu.fjnu.lw.h3_intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void browseBtn(View view){
        Intent intent = new Intent();
        EditText editText = (EditText) findViewById(R.id.editText);
        String data = editText.getText().toString();
        Uri uri = Uri.parse(data);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(uri);
        startActivity(intent);
    }
}
