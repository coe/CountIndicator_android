package jp.co.rleaning.countindicator;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import jp.co.rleaning.countindicator.databinding.ActivityScoreBinding;
import jp.co.rleaning.countindicator.presenter.ScorePresenter;

public class ScoreActivity extends AppCompatActivity implements ScorePresenter {
    // Remove the below line after defining your own ad unit ID.
    private final int INNING_DEFAULT = 1;
    private final int SCORE_DEFAULT = 0;
    int mInning = INNING_DEFAULT;
    int mScore = SCORE_DEFAULT;
    ActivityScoreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_score);
        binding.setPresenter(this);


        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        // Toasts the test ad message on the screen. Remove this after defining your own ad unit ID.
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_score, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClickInningPlus() {
        mInning++;
        if (mInning > 99) {
            mInning = 99;
        }
        binding.inningTextView.setText(getString(R.string.inning,mInning));
    }

    /**
     * イニングの-ボタンを押した時
     */
    @Override
    public void onClickInningMinus() {
        mInning--;
        if (mInning < 1) {
            mInning = 1;
        }
        binding.inningTextView.setText(getString(R.string.inning,mInning));
    }

    /**
     * スコアの+ボタンを押した時
     */
    @Override
    public void onClickScorePlus() {
        mScore++;
        if (mScore > 99) {
            mScore =99;
        }
        binding.scoreTextView.setText(getString(R.string.score, mScore));


    }

    /**
     * スコアの-ボタンを押した時
     */
    @Override
    public void onClickScoreMinus() {
        mScore--;
        if (mScore < 0) {
            mScore = 0;
        }
        binding.scoreTextView.setText(getString(R.string.score, mScore));

    }

    /**
     * Bボタンを押した時
     */
    @Override
    public void onClickB() {

    }

    /**
     * Sボタンを押した時
     */
    @Override
    public void onClickS() {

    }

    /**
     * Oボタンを押した時
     */
    @Override
    public void onClickO() {

    }

    /**
     * クリアボタンを押した時
     */
    @Override
    public void onClickClear() {

    }

    /**
     * チェックボタンを押した時
     */
    @Override
    public void onCheckedChangedGroup() {

    }
}
