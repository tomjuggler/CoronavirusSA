package za.co.tomjuggler.CoronaVirusSA;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import processing.android.PFragment;
import processing.android.CompatUtils;
import processing.core.PApplet;
import za.co.tomjuggler.CoronaVirusSA.R;
import android.widget.Toast;


public class MapStarter extends AppCompatActivity {
    //for Processing sketch:
    private PApplet sketch;

    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.activity_test_1);
        //so toolbar not showing in this implementation. Makes it pretty redundant...
        //todo: what is minimum code to set this up showing Processing Sketch?
//        Toolbar toolbar = findViewById(R.id.toolbar);

//        setSupportActionBar(toolbar);

//       getSupportActionBar().show();
        //from Processing Generated code:
        FrameLayout frame = new FrameLayout(this);
        frame.setId(CompatUtils.getUniqueViewId());
        setContentView(frame, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        sketch = new Map();

        PFragment fragment = new PFragment(sketch);
        fragment.setView(frame, this);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().show();
    }

    @Override
    public void onBackPressed() {

        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }

    @Override
    public void onNewIntent(Intent intent) {
        if (sketch != null) {
            sketch.onNewIntent(intent);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (sketch != null) {
            sketch.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
