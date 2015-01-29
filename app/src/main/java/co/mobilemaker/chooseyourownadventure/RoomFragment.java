package co.mobilemaker.chooseyourownadventure;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class RoomFragment extends Fragment {

    private final static String LOG_TAG = RoomFragment.class.getSimpleName();

    public RoomFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(LOG_TAG, "Fragment view room being created.");
        View viewRoot = inflater.inflate(R.layout.fragment_room, container, false);
        prepareDoor1Button(viewRoot);
        prepareDoor2Button(viewRoot);
        return viewRoot;
    }

    private void prepareDoor2Button(final View viewRoot) {
        Button mDoor2Button = (Button)viewRoot.findViewById(R.id.button_door2);
        mDoor2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alleyIntent = new Intent(viewRoot.getContext(), AlleyActivity.class);
                Intent roomIntent = new Intent(viewRoot.getContext(), RoomActivity.class);
                Intent losingIntent = new Intent(viewRoot.getContext(),LosingActivity.class);
                Random random = new Random();
                int randNum = random.nextInt(11);
                if(randNum <= 2 && randNum >=0)
                    startActivity(losingIntent);
                else if(randNum > 4)
                    startActivity(roomIntent);
                else
                    startActivity(alleyIntent);
            }
        });
    }

    private void prepareDoor1Button(final View viewRoot) {
        Button mDoor1Button = (Button)viewRoot.findViewById(R.id.button_door1);
        mDoor1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alleyIntent = new Intent(viewRoot.getContext(), AlleyActivity.class);
                Intent roomIntent = new Intent(viewRoot.getContext(), RoomActivity.class);
                Intent winningIntent = new Intent(viewRoot.getContext(), WinningActivity.class);
                Random random = new Random();
                int randNum = random.nextInt(11);
                if(randNum <= 2 && randNum >=0)
                    startActivity(winningIntent);
                else if(randNum > 4)
                    startActivity(roomIntent);
                else
                    startActivity(alleyIntent);
            }
        });
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(LOG_TAG, "Fragment room being attached.");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "Fragment room being created.");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(LOG_TAG, "Fragment parent activity being created.");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "Fragment room being resumed.");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "Fragment room being paused.");
    }

}
