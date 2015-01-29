package co.mobilemaker.chooseyourownadventure;


import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        prepareButton(rootView);
        return rootView;
    }

    private void prepareButton(final View rootView) {
        Button mStartTravelingButton = (Button)rootView.findViewById(R.id.button_startTraveling);
        mStartTravelingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity)getActivity();
                Random random = new Random();
                int randNum = random.nextInt(11);
                if(randNum > 5 )
                    mainActivity.goToAlley(new AlleyFragment());
                else
                    mainActivity.goToRoom(new RoomFragment());
            }
        });
    }

}
