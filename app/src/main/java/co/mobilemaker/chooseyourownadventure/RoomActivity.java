package co.mobilemaker.chooseyourownadventure;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

/**
 * Created by diany_000.
 */
public class RoomActivity extends Activity{

    private final static String LOG_TAG = RoomActivity.class.getSimpleName();
    private final static String ROOM = "ROOM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        Log.d(LOG_TAG, "Activity room created.");
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().
                add(R.id.screen, new RoomFragment()).addToBackStack(ROOM).
                commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "Room Activity paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "Room Activity resumed");
    }
}
