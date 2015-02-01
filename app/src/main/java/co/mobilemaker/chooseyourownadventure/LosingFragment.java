package co.mobilemaker.chooseyourownadventure;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LosingFragment extends Fragment {

    private final static String LOG_TAG = WinningFragment.class.getSimpleName();
    private final static String USERNAME_PREFERENCE = "username_preference";
    View mRootView;
    TextView mTextViewLoseMsg;

    public LosingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(LOG_TAG, "Fragment view losing being created");
        mRootView = inflater.inflate(R.layout.fragment_losing, container, false);
        mTextViewLoseMsg = (TextView)mRootView.findViewById(R.id.textView_loseMsg);
        personalizedMessage();
        return mRootView;
    }

    private void personalizedMessage() {
        String username = getUsername();
        String user_losing = String.format(getString(R.string.user_losing), username);
        mTextViewLoseMsg.setText(user_losing);
    }

    private String getUsername() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        return sharedPreferences.getString(USERNAME_PREFERENCE, getString(R.string.default_username));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(LOG_TAG, "Fragment losing being attached.");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "Fragment losing being created.");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(LOG_TAG, "Fragment parent activity being created.");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "Fragment losing being resumed.");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "Fragment losing being paused.");
    }
}
