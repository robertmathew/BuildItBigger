package com.udacity.gradle.builditbigger;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.robo.libjokeactivity.JokeActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    private String strJoke;
    private Button mButtonJoke;
    private ProgressBar mProgressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mButtonJoke = (Button) root.findViewById(R.id.btnJoke);
        mButtonJoke.setOnClickListener(this);

        mProgressBar = (ProgressBar) root.findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.GONE);

        new GetGcmJoke().execute();

        return root;
    }

    @Override
    public void onClick(View v) {
        //Toast.makeText(this, strJoke, Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getActivity(), JokeActivity.class);
        i.putExtra("joke", strJoke);
        startActivity(i);
    }

    private class GetGcmJoke extends EndpointsAsyncTask {

        @Override
        protected void onPreExecute() {
            mProgressBar.setVisibility(View.VISIBLE);
            Toast.makeText(getActivity(), "Loading joke..", Toast.LENGTH_SHORT).show();
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String result) {
            mProgressBar.setVisibility(View.GONE);
            strJoke = result;
        }
    }
}
