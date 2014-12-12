package com.budgily.alfred.example;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ubiquoid.alfred.example.R;

import alfred.weaving.CheckThread;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    private class CheckThreadAsyncTask extends AsyncTask<Void, Void, Void> {

        @CheckThread
        @Override protected void onPreExecute() {

            super.onPreExecute();
            Log.d(TAG, "onPreExecute()");
        }

        @CheckThread
        protected Void doInBackground(Void... params) {

            Log.d(TAG, "doInBackground()");
            return null;
        }

        @CheckThread
        @Override protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            Log.d(TAG, "onPostExecute()");
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
