package co.mobilemaker.chooseyourownadventure;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

/**
 * Created by diany_000.
 */
public class RoomFragmentActivity extends Activity{

    private final static String LOG_TAG = RoomFragmentActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        Log.d(LOG_TAG, "Activity room created.");
        prepareDoor1Button();
        prepareDoor2Button();
    }

    private void prepareDoor2Button() {
        Button mDoor2Button = (Button)findViewById(R.id.button_door2);
        mDoor2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alleyIntent = new Intent(RoomFragmentActivity.this, AlleyFragmentActivity.class);
                Intent roomIntent = new Intent(RoomFragmentActivity.this, RoomFragmentActivity.class);
                Intent losingIntent = new Intent(RoomFragmentActivity.this,LosingFragmentActivity.class);
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

    private void prepareDoor1Button() {
        Button mDoor1Button = (Button)findViewById(R.id.button_door1);
        mDoor1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alleyIntent = new Intent(RoomFragmentActivity.this, AlleyFragmentActivity.class);
                Intent roomIntent = new Intent(RoomFragmentActivity.this, RoomFragmentActivity.class);
                Intent winningIntent = new Intent(RoomFragmentActivity.this, WinningFragmentActivity.class);
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
