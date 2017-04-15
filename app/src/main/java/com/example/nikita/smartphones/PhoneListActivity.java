package com.example.nikita.smartphones;

import android.support.v4.app.Fragment;

public class PhoneListActivity extends SingleFragmentActivity {
    protected Fragment createFragment() {
        return new PhoneListFragment();
    }
}

