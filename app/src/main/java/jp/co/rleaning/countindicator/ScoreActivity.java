package jp.co.rleaning.countindicator;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import jp.co.rleaning.countindicator.databinding.ActivityScoreBinding;
import jp.co.rleaning.countindicator.presenter.ScorePresenter;
import jp.co.rleaning.countindicator.vo.Inning;
import jp.co.rleaning.countindicator.vo.Score;
import timber.log.Timber;

public class ScoreActivity extends AppCompatActivity implements ScorePresenter {
    // Remove the below line after defining your own ad unit ID.
    private static final String TOAST_TEXT = "Test ads are being shown. "
            + "To show live ads, replace the ad unit ID in res/values/strings.xml with your own ad unit ID.";
    private final int INNING_DEFAULT = 1;
    private final int SCORE_DEFAULT = 0;
    Inning mInning = new Inning(INNING_DEFAULT);
    Score mScore = new Score(SCORE_DEFAULT);
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
        Toast.makeText(this, TOAST_TEXT, Toast.LENGTH_LONG).show();
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
        binding.inningTextView.setText(getString(R.string.inning,mInning.increment()));
    }

    /**
     * イニングの-ボタンを押した時
     */
    @Override
    public void onClickInningMinus() {
        binding.inningTextView.setText(getString(R.string.inning,mInning.decrement()));
    }

    /**
     * スコアの+ボタンを押した時
     */
    @Override
    public void onClickScorePlus() {
        binding.scoreTextView.setText(getString(R.string.score, mScore.increment()));


    }

    /**
     * スコアの-ボタンを押した時
     */
    @Override
    public void onClickScoreMinus() {
        binding.scoreTextView.setText(getString(R.string.score, mScore.decrement()));

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
