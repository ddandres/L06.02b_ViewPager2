/*
 * Copyright (c) 2020. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labds.dadm.l0602b_viewpager2.activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import labds.dadm.l0602b_viewpager2.R;
import labds.dadm.l0602b_viewpager2.adapters.CustomFragmentStateAdapter;

/**
 * Displays different Fragments using a ViewPager2 to enable vertical/horizontal navigation (swipe).
 */
public class ViewPager2Activity extends AppCompatActivity {

    // Hold a reference to the ViewPager2
    ViewPager2 pager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        // Get a reference to the ViewPager2
        pager2 = findViewById(R.id.pager2);

        // Get the requested swipe direction (orientation)
        final int orientation = getIntent().getIntExtra("orientation", ViewPager2.ORIENTATION_HORIZONTAL);
        // Set the swipe orientation for the ViewPager2
        pager2.setOrientation(orientation);

        // Set the title of the ActionBar
        if (orientation == ViewPager2.ORIENTATION_HORIZONTAL) {
            getSupportActionBar().setTitle(R.string.horizontal_orientation);
        } else {
            getSupportActionBar().setTitle(R.string.vertical_orientation);
        }
        // Create a new FragmentStateAdapter and associate it to the ViewPager2
        pager2.setAdapter(new CustomFragmentStateAdapter(ViewPager2Activity.this));

        // Get a reference to the TabLayout component that displays the labels for each tab
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        // Associate the TabLayout with the ViewPager2 using a TabLayoutMediator,
        // so any changes in one of them are automatically reflected on the other
        new TabLayoutMediator(tabLayout, pager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                // Set the text for each tab
                switch (position) {
                    case 1:
                        tab.setText(R.string.title_signin_fragment);
                        break;
                    case 2:
                        tab.setText(R.string.title_list_fragment);
                        break;
                    case 3:
                        tab.setText(R.string.title_grid_fragment);
                        break;
                    // Default case includes position == 0
                    default:
                        tab.setText(R.string.title_login_fragment);
                        break;
                }
            }
        }).attach(); // link the TabLayout and the Viewpager2
    }
}
