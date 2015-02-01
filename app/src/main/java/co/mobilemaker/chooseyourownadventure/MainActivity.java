package co.mobilemaker.chooseyourownadventure;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Random;


public class MainActivity extends ActionBarActivity{

    public final static String MAIN = "MAIN";
    public final static String ALLEY = "ALLEY";
    public final static String ROOM = "ROOM";
    public final static String LOSING = "LOSING";
    public final static String WINNING = "WINNING";
    public final static String EASY = "EASY";
    public final static String MEDIUM = "MEDIUM";
    public final static String HARD = "HARD";
    public final static String DIFFICULTY = "DIFFICULTY";
    public static final int RESULT_SETTINGS = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        customizeActionBar();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.screen, new MainFragment()).addToBackStack(MAIN)
                .commit();
    }

    private void customizeActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.action_bar_title);
        actionBar.setIcon(R.drawable.ic_launcher);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                Intent intent = new Intent(this, AppSettingsActivity.class);
                startActivityForResult(intent, RESULT_SETTINGS);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
