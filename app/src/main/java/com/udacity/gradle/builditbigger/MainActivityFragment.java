package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.robo.libjokeactivity.JokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    private String strJoke;
    private Button mButtonJoke;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mButtonJoke = (Button) root.findViewById(R.id.btnJoke);
        mButtonJoke.setOnClickListener(this);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

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
        protected void onPostExecute(String result) {
            strJoke = result;
        }
    }
}
