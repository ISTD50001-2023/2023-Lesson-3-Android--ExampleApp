package com.example.concurrentapplicationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    Button buttonGetImages;
    TextView textViewA;
    TextView textViewB;

    ProgressBar progressBarA;
    ProgressBar progressBarB;

    EditText editTextThreads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGetImages = findViewById(R.id.buttonGetImages);
        textViewA = findViewById(R.id.textViewA);
        textViewB = findViewById(R.id.textViewB);
        editTextThreads = findViewById(R.id.editTextThreads);
        progressBarA = findViewById(R.id.progressBarA);
        progressBarB = findViewById(R.id.progressBarB);

        buttonGetImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int numThreads = Integer.parseInt( editTextThreads.getText().toString());
                ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
                final Handler handler = new Handler(Looper.getMainLooper());

                // TODO 1 Initialize the ProgressBars to 0

                // TODO 2 See below
                // TODO 3 Call execute on executorService with new Demo objects


                executorService.shutdown();

            }
        } );


    }

    // TODO 2 Implement the run method with the algorithm given

    static class Demo implements Runnable{

        TextView t;
        ProgressBar p;
        Handler handler;


        Demo( TextView t, ProgressBar p, Handler handler){
            this.t = t;
            this.handler = handler;
            this.p = p;
        }

        @Override
        public void run() {

            /**
             * 1. Instantiate c as Container<Integer> object
             * 2. for i from 0 to 19
             *    a. c.set(i)
             *    b. Thread.sleep for a random number of mililseconds
             *    c. set the text of Textview t as i   (## on UI)
             *    d. increment ProgressBar p by 5  (## on UI)
             */

        }
    }

    static class Container<T>{

        T t;

        T get(){
            return t;
        }

        void set(T t){
            this.t = t;
        }
    }

}