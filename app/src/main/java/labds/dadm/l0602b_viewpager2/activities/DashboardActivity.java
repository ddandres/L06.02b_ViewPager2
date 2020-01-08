/*
 * Copyright (c) 2020. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labds.dadm.l0602b_viewpager2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import labds.dadm.l0602b_viewpager2.R;

/**
 * Gives access to an activity showing different Fragments through a ViewPager.
 * The titles identifying each Fragment can be displayed using different components.
 */
public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    /**
     * Starts the different activities of the application.
     */
    public void buttonClicked(View view) {

        Intent intent = new Intent(this, ViewPager2Activity.class);
        // Determine what to do depending on the Button clicked
        switch (view.getId()) {

            // View Pager 2 with horizontal swiping
            case R.id.bViewPager2Horizontal:
                intent.putExtra("orientation", ViewPager2.ORIENTATION_HORIZONTAL);
                break;

            // View Pager 2 with vertical swiping
            case R.id.bViewPager2Vertical:
                intent.putExtra("orientation", ViewPager2.ORIENTATION_VERTICAL);
                break;

        }
        // Launch the activity containing the ViewPager2
        startActivity(intent);
    }

}
