package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));

        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addbtn =(Button) findViewById(R.id.button);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText num1 = (EditText) findViewById(R.id.FirstNumEditText);
                EditText num2 = (EditText) findViewById(R.id.SecondNumEditText);
                TextView result = (TextView) findViewById(R.id.textView);
                int  one = Integer.parseInt(num1.getText().toString());
                int  two = Integer.parseInt(num2.getText().toString());
                int res= one + two ;

                Python py=Python.getInstance();
                PyObject pyobj=py.getModule("my script");
                PyObject obj=pyobj.callAttr("main");
                result.setText(obj.toString());

            }

        });
    }
}