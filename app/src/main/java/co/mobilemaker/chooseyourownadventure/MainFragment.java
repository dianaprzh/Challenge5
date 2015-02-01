package co.mobilemaker.chooseyourownadventure;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    RadioGroup mRadioGroup;
    RadioButton mRadioButtonEasy;
    RadioButton mRadioButtonMedium;
    RadioButton mRadioButtonHard;
    boolean mEasy = false;
    boolean mMedium = false;
    boolean mHard = false;
    View mRootView;
    FragmentTransaction mFragmentTransaction;
    Bundle mBundle;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRootView = inflater.inflate(R.layout.fragment_main, container, false);
        prepareButton();
        return mRootView;
    }

    private void prepareDifficulty() {
        mRadioGroup = (RadioGroup)mRootView.findViewById(R.id.radioGroup_difficulty);
        mRadioButtonEasy = (RadioButton)mRootView.findViewById(R.id.radioButton_easy);
        mRadioButtonMedium = (RadioButton)mRootView.findViewById(R.id.radioButton_medium);
        mRadioButtonHard = (RadioButton)mRootView.findViewById(R.id.radioButton_hard);
        if(mRadioGroup.getCheckedRadioButtonId() != -1) {
            if(mRadioButtonEasy.isChecked())
                mEasy = true;
            else if(mRadioButtonMedium.isChecked())
                mMedium = true;
            else if(mRadioButtonHard.isChecked())
                mHard = true;
        }
    }

    private void prepareButton() {
        Button mStartTravelingButton = (Button)mRootView.findViewById(R.id.button_startTraveling);
        mStartTravelingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareDifficulty();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack();
                mFragmentTransaction = fragmentManager.beginTransaction();
                mBundle = new Bundle();
                if(mEasy)
                    mBundle.putString(MainActivity.DIFFICULTY, MainActivity.EASY);
                else if(mMedium)
                    mBundle.putString(MainActivity.DIFFICULTY, MainActivity.MEDIUM);
                else if(mHard)
                    mBundle.putString(MainActivity.DIFFICULTY, MainActivity.HARD);
                Random random = new Random();
                int randNum = random.nextInt(11);
                if(randNum > 5 )
                   goToScreen(new AlleyFragment(), MainActivity.ALLEY);
                else
                   goToScreen(new RoomFragment(), MainActivity.ROOM);
            }
        });
    }

    private void goToScreen(Fragment fragment, String key){
        fragment.setArguments(mBundle);
        mFragmentTransaction.replace(R.id.screen, fragment, key);
        mFragmentTransaction.addToBackStack(key);
        mFragmentTransaction.commit();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
