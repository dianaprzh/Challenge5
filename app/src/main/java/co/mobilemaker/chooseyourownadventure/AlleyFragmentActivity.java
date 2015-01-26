package co.mobilemaker.chooseyourownadventure;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

/**
 * Created by diany_000.
 */
public class AlleyFragmentActivity extends Activity{

    private final static String LOG_TAG = AlleyFragmentActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alley);
        Log.d(LOG_TAG, "Activity Alley created.");
        prepareGoLeftButton();
        prepareContinueButton();
        prepareGoRightButton();
    }

    private void prepareContinueButton() {
        Button mContinueButton = (Button)findViewById(R.id.button_continue);
        mContinueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent alleyIntent = new Intent(AlleyFragmentActivity.this, AlleyFragmentActivity.class);
                Intent roomIntent = new Intent(AlleyFragmentActivity.this, RoomFragmentActivity.class);
                Intent losingIntent = new Intent(AlleyFragmentActivity.this,LosingFragmentActivity.class);
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

    private void prepareGoLeftButton() {
        Button mGoLeftButton = (Button)findViewById(R.id.button_goLeft);
        mGoLeftButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent alleyIntent = new Intent(AlleyFragmentActivity.this, AlleyFragmentActivity.class);
                Intent roomIntent = new Intent(AlleyFragmentActivity.this, RoomFragmentActivity.class);
                Intent winningIntent = new Intent(AlleyFragmentActivity.this, WinningFragmentActivity.class);
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

    private void prepareGoRightButton() {
        Button mGoRightButton = (Button)findViewById(R.id.button_goRight);

        mGoRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alleyIntent = new Intent(AlleyFragmentActivity.this, AlleyFragmentActivity.class);
                Intent roomIntent = new Intent(AlleyFragmentActivity.this, RoomFragmentActivity.class);
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
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "Alley Activity paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "Alley Activity resumed");
    }
}