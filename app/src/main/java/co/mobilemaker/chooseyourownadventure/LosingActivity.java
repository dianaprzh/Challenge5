package co.mobilemaker.chooseyourownadventure;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by diany_000.
 */
public class LosingActivity extends Activity{

    private final static String LOG_TAG = LosingActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_losing);
        Log.d(LOG_TAG, "Activity losing created.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "Losing Activity paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "Losing Activity resumed");
    }
}
