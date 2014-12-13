package com.budgily.alfred.example;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.ubiquoid.alfred.example.R;

import alfred.weaving.CheckThread;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    private class CheckThreadAsyncTask extends AsyncTask<Void, Void, Void> {

        @CheckThread
        @Override protected void onPreExecute() {

            super.onPreExecute();
        }

        @CheckThread
        protected Void doInBackground(Void... params) {

            return null;
        }

        @CheckThread
        @Override protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
        }
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        findViewById(R.id.async_task).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                new CheckThreadAsyncTask().execute();
            }
        });
    }
}
