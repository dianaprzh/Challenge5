package co.mobilemaker.chooseyourownadventure;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
    private String mDifficulty;
    FragmentTransaction mFragmentTransaction;
    Bundle mBundle;

    public RoomFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "Fragment view room being created.");
        mDifficulty = getArguments().getString(MainActivity.DIFFICULTY);
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
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack();
                mFragmentTransaction = fragmentManager.beginTransaction();
                mBundle = new Bundle();
                mBundle.putString(MainActivity.DIFFICULTY,mDifficulty);
                if(mDifficulty.equals(MainActivity.EASY))
                    goToLosingEasy();
                else if(mDifficulty.equals(MainActivity.MEDIUM))
                    goToLosingMedium();
                else if(mDifficulty.equals(MainActivity.HARD))
                    goToLosingHard();
            }
        });
    }

    private void prepareDoor1Button(final View viewRoot) {
        Button mDoor1Button = (Button)viewRoot.findViewById(R.id.button_door1);
        mDoor1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack();
                mFragmentTransaction = fragmentManager.beginTransaction();
                mBundle = new Bundle();
                mBundle.putString(MainActivity.DIFFICULTY,mDifficulty);
                if(mDifficulty.equals(MainActivity.EASY))
                    goToWinningEasy();
                else if(mDifficulty.equals(MainActivity.MEDIUM))
                    goToWinningMedium();
                else if(mDifficulty.equals(MainActivity.HARD))
                    goToWinningHard();
            }
        });
    }

    private void goToScreen(Fragment fragment, String key){
        fragment.setArguments(mBundle);
        mFragmentTransaction.replace(R.id.screen, fragment, key);
        mFragmentTransaction.addToBackStack(key);
        mFragmentTransaction.commit();
    }


    public void goToWinningEasy(){
        Random random = new Random();
        int randNum = random.nextInt(101);
        if(randNum <= 40 && randNum >= 0)
            goToScreen(new WinningFragment(), MainActivity.WINNING);
        else if(randNum > 40 && randNum <= 70)
            goToScreen(new RoomFragment(), MainActivity.ROOM);
        else
            goToScreen(new AlleyFragment(), MainActivity.ALLEY);
    }

    public void goToWinningMedium(){
        Random random = new Random();
        int randNum = random.nextInt(101);
        if(randNum <= 30 && randNum >= 0)
            goToScreen(new WinningFragment(), MainActivity.WINNING);
        else if(randNum > 30 && randNum <= 65)
            goToScreen(new RoomFragment(), MainActivity.ROOM);
        else
            goToScreen(new AlleyFragment(), MainActivity.ALLEY);
    }

    public void goToWinningHard(){
        Random random = new Random();
        int randNum = random.nextInt(101);
        if(randNum <= 20 && randNum >= 0)
            goToScreen(new WinningFragment(), MainActivity.WINNING);
        else if(randNum > 20 && randNum <= 60)
            goToScreen(new RoomFragment(), MainActivity.ROOM);
        else
            goToScreen(new AlleyFragment(), MainActivity.ALLEY);
    }


    public void goToLosingEasy(){
        Random random = new Random();
        int randNum = random.nextInt(101);
        if(randNum <= 20 && randNum >= 0)
            goToScreen(new LosingFragment(), MainActivity.LOSING);
        else if(randNum > 20 && randNum <= 60)
            goToScreen(new RoomFragment(), MainActivity.ROOM);
        else
            goToScreen(new AlleyFragment(), MainActivity.ALLEY);
    }

    public void goToLosingMedium(){
        Random random = new Random();
        int randNum = random.nextInt(101);
        if(randNum <= 30 && randNum >= 0)
            goToScreen(new LosingFragment(), MainActivity.LOSING);
        else if(randNum > 30 && randNum <= 65)
            goToScreen(new RoomFragment(), MainActivity.ROOM);
        else
            goToScreen(new AlleyFragment(), MainActivity.ALLEY);
    }

    public void goToLosingHard(){
        Random random = new Random();
        int randNum = random.nextInt(101);
        if(randNum <= 40 && randNum >= 0)
            goToScreen(new LosingFragment(), MainActivity.LOSING);
        else if(randNum > 40 && randNum <= 70)
            goToScreen(new RoomFragment(), MainActivity.ROOM);
        else
            goToScreen(new AlleyFragment(), MainActivity.ALLEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
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
