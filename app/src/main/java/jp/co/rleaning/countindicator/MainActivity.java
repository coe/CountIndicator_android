package jp.co.rleaning.countindicator;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import de.psdev.licensesdialog.LicensesDialog;
import jp.co.rleaning.countindicator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // Remove the below line after defining your own ad unit ID.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setMainactivity(this);

        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_acknowledgements:
                //ライセンス表示
                new LicensesDialog.Builder(this).setNotices(R.raw.notices)
                        .build()
                        .show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickCountIndicator(View view) {
        Intent intent = new Intent(this,ScoreActivity.class);
        startActivity(intent);
    }
}
