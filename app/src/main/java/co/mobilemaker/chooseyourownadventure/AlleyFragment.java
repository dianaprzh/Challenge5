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

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlleyFragment extends Fragment {


    private final static String LOG_TAG = AlleyFragment.class.getSimpleName();

    public AlleyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(LOG_TAG, "Fragment view alley being created");
        View rootView = inflater.inflate(R.layout.fragment_alley, container, false);
        prepareGoLeftButton(rootView);
        prepareContinueButton(rootView);
        prepareGoRightButton(rootView);
        return rootView;
    }

    private void prepareContinueButton(final View rootView) {
        Button mContinueButton = (Button) rootView.findViewById(R.id.button_continue);
        mContinueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent alleyIntent = new Intent(rootView.getContext(), AlleyActivity.class);
                Intent roomIntent = new Intent(rootView.getContext(), RoomActivity.class);
                Intent losingIntent = new Intent(rootView.getContext(),LosingActivity.class);
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

    private void prepareGoLeftButton(final View rootView) {
        Button mGoLeftButton = (Button) rootView.findViewById(R.id.button_goLeft);
        mGoLeftButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent alleyIntent = new Intent(rootView.getContext(), AlleyActivity.class);
                Intent roomIntent = new Intent(rootView.getContext(), RoomActivity.class);
                Intent winningIntent = new Intent(rootView.getContext(), WinningActivity.class);
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

    private void prepareGoRightButton(final View rootView) {
        Button mGoRightButton = (Button)rootView.findViewById(R.id.button_goRight);

        mGoRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alleyIntent = new Intent(rootView.getContext(), AlleyActivity.class);
                Intent roomIntent = new Intent(rootView.getContext(), RoomActivity.class);
                Random random = new Random();
                int randNum = random.nextInt(11);
                if(randNum > 5 )
                    startActivity(alleyIntent);
                else
                    startActivity(roomIntent);
            }
        });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(LOG_TAG, "Fragment alley being attached.");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "Fragment alley being created.");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(LOG_TAG, "Fragment parent activity being created.");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "Fragment alley being resumed.");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "Fragment alley being paused.");
    }

}
