package com.example.yevgen.myapplication;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileWriter;

public class MainActivity extends AppCompatActivity {
    TextView id_tv_hello;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id_tv_hello = (TextView)findViewById(R.id.id_tv_hello);




        saveToFile("test.txt","Hello world");


    }


    public static String saveToFile(String filename, String contents) {
        String storageState = Environment.getExternalStorageState();
        if(!storageState.equals(Environment.MEDIA_MOUNTED)) {
            throw new IllegalStateException("Media must be mounted");
        }
        File directory = Environment.getExternalStorageDirectory();
        File file = new File(directory, filename);
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file, false);
            fileWriter.write(contents);
            fileWriter.close();
            return file.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




}
