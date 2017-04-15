package com.example.nikita.smartphones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import java.util.UUID;

public class PhoneActivity extends SingleFragmentActivity {
    public static final String EXTRA_PHONE_ID = "com.example.nikita.phone_id";

    public static Intent newIntent(Context packageContext, UUID phoneId) {
        Intent intent = new Intent(packageContext, PhoneActivity.class);
        intent.putExtra(EXTRA_PHONE_ID, phoneId);
        return intent;
    }

    protected Fragment createFragment() {
        return new PhoneFragment();
    }
}

