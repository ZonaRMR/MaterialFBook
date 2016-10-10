/**
 * Code taken from:
 * - FaceSlim by indywidualny. Thanks. 
 * - Toffed by JakeLane. Thanks.
 */
package me.zeeroooo.materialfb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import me.zeeroooo.materialfb.Fragments.SettingsFragment;

public class SettingsActivity extends AppCompatActivity {
    public static final String KEY_PREF_STOP_IMAGES = "stop_images";
    public static final String KEY_PREF_FAB_SCROLL = "hide_fab_on_scroll";
    public static final String KEY_PREF_MESSAGING = "messaging_enabled";
    public static final String KEY_PREF_LOCATION = "location_enabled";
    public static final String KEY_PREF_HIDE_MENU_BAR = "hide_menu_bar";
    public static final String KEY_PREF_HIDE_EDITOR = "hide_editor_newsfeed";
    public static final String KEY_PREF_HIDE_SPONSORED = "hide_sponsored";
    public static final String KEY_PREF_HIDE_BIRTHDAYS = "hide_birthdays";
    public static final String KEY_PREF_HIDE_MESSENGERDOWN = "messenger_download";
    public static final String KEY_PREF_GROUPS = "nav_groups";
    public static final String KEY_PREF_NAV_SEARCH = "nav_search";
    public static final String KEY_PREF_NAV_MAINMENU = "nav_mainmenu";
    public static final String KEY_PREF_NAV_MOST_RECENT = "nav_most_recent";
    public static final String KEY_PREF_NAV_NEWS = "nav_news";
    public static final String KEY_PREF_NAV_FBLOGOUT = "nav_fblogout";
    public static final String KEY_PREF_NAV_EXITAPP = "nav_exitapp";
    public static final String KEY_PREF_NAV_EVENTS = "nav_events";
    public static final String KEY_PREF_NAV_PHOTOS = "nav_photos";

    private static final String TAG = SettingsActivity.class.getSimpleName();
    private static final int REQUEST_STORAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        getFragmentManager().beginTransaction().replace(R.id.content_frame,
                new SettingsFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else
            getFragmentManager().popBackStack();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }

}