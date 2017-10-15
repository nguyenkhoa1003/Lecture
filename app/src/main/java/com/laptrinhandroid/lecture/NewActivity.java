package com.laptrinhandroid.lecture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * A login screen that offers login via email/password.
 */
public class NewActivity extends Activity {

    public static final String TAG = NewActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity2);

        Intent intent = getIntent();

        if (intent != null) {
            if (intent.hasExtra(Intent.EXTRA_TEXT)) {
                String email = intent.getExtras().getString(Intent.EXTRA_TEXT);

                Log.d(TAG, "Email from extra = " + email);

                TextView tvEmail = (TextView) findViewById(R.id.tvEmail);
                tvEmail.setText(email);
            } else  {
                Log.e(TAG, "Invalid Email from extra");
            }
        }
    }
}

