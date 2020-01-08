/*
 * Copyright (c) 2020. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labds.dadm.l0602b_viewpager2.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import labds.dadm.l0602b_viewpager2.fragments.GridImageFragment;
import labds.dadm.l0602b_viewpager2.fragments.ListStringFragment;
import labds.dadm.l0602b_viewpager2.fragments.LogInFragment;
import labds.dadm.l0602b_viewpager2.fragments.SignInFragment;

/**
 * Uses a Fragment to manage each page and handles saving and restoring of fragment's state.
 */
public class CustomFragmentStateAdapter extends FragmentStateAdapter {

    public CustomFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    /*
     * Provides a new Fragment associated to the given position.
     */
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment result;

        switch (position) {
            case 1:
                result = new SignInFragment();
                break;
            case 2:
                result = new ListStringFragment();
                break;
            case 3:
                result = new GridImageFragment();
                break;
            // Default case includes position == 0
            default:
                result = LogInFragment.newInstance("David");
                break;
        }
        return result;
    }

    /*
     * Total number of elements kept by the adapter.
     */
    @Override
    public int getItemCount() {
        return 4;
    }


}
