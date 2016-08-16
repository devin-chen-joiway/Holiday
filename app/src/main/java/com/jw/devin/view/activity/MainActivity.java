package com.jw.devin.view.activity;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.jw.devin.R;
import com.jw.devin.module.tools.FileHelper;


public class MainActivity extends AppCompatActivity {
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"hello world ",Toast.LENGTH_LONG).show();
        tvContent = (TextView)findViewById(R.id.tv_content);
        tvContent.setText(String.valueOf(FileHelper.createFile(this,"hello")));
    }
}
