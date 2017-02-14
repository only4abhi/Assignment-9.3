package com.example.abhishek.assignment93;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText);

    }

    public void read(View view) {
        String fname ="myText.txt";
        File file = getBaseContext().getFileStreamPath(fname);
        if(file.exists()){
            Toast.makeText(getApplicationContext(),"File exist", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(),"File not exist", Toast.LENGTH_LONG).show();
        }

    }

    public void write(View view) {
        String Mytextmessage  = editText.getText().toString();
        try {
            FileOutputStream fileOutputStream = openFileOutput("myText.txt",MODE_PRIVATE);
            fileOutputStream.write(Mytextmessage.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(),"Text Saved", Toast.LENGTH_LONG).show();
            editText.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
