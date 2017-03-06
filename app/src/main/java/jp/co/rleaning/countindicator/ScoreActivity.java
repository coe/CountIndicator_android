package jp.co.rleaning.countindicator;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import jp.co.rleaning.countindicator.databinding.ActivityMainBinding;
import jp.co.rleaning.countindicator.databinding.ActivityScoreBinding;
import jp.co.rleaning.countindicator.presenter.ScorePresenter;

public class ScoreActivity extends AppCompatActivity implements ScorePresenter {
    // Remove the below line after defining your own ad unit ID.

    private final int INNING_DEFAULT = 1;
    private final int SCORE_DEFAULT = 0;
    int mInning = INNING_DEFAULT;
    int mScore = SCORE_DEFAULT;
    ActivityScoreBinding binding;


    ActivityScoreBinding binding;
    int mInning = 1;
    int mScore = 0;
    int countB = 0;
    int countS = 0;
    int countO = 0;
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
        onInning(true);
    }

    @Override
    public void onClickInningMinus() {
        onInning(false);
    }

    @Override
    public void onClickScorePlus() {
        onScore(true);
    }

    @Override
    public void onClickScoreMinus(){
        onScore(false);
    }

    @Override
    public void onClear() {
        mScore = 0;
        mInning = 1;
        countO = 0;
        countB = 0;
        countS = 0;
        binding.inningTextView.setText(getString(R.string.inning,mInning));
        binding.scoreText.setText(getString(R.string.score,mScore));
        onClickBlackB();
        onClickBlackO();
        onClickBlackS();
        onRadioCheck();
    }


    @Override
    public void onClickB(){
        countB++;
        switch (countB){
            case 1:
                binding.view3.setBackgroundResource(R.drawable.circle_ball);
                break;
            case 2:
                binding.view2.setBackgroundResource(R.drawable.circle_ball);
                break;
            case 3:
                binding.view1.setBackgroundResource(R.drawable.circle_ball);
                break;
            default:
                onClickBlackB();
                onClickBlackS();
                break;
        }
    }

    @Override
    public void onClickS(){
        countS++;
        switch (countS) {
            case 1:
                binding.view6.setBackgroundResource(R.drawable.circle_strike);
                break;
            case 2:
                binding.view5.setBackgroundResource(R.drawable.circle_strike);
                break;
            default:
                onClickBlackS();
                onClickBlackB();
                countO++;
                if (countO == 1) {
                    binding.view8.setBackgroundResource(R.drawable.circle_out);
                } else if (countO == 2) {
                    binding.view7.setBackgroundResource(R.drawable.circle_out);
                } else {
                    onRadioCheck();
                    onClickBlackO();
                    break;
                }
        }
    }

    @Override
    public void onClickO(){
        countO++;
        switch (countO){
            case 1:
                binding.view8.setBackgroundResource(R.drawable.circle_out);
                onClickBlackB();
                onClickBlackS();
                break;
            case 2:
                binding.view7.setBackgroundResource(R.drawable.circle_out);
                onClickBlackB();
                onClickBlackS();
                break;
            default:
                onRadioCheck();
                onClickBlackB();
                onClickBlackS();
                onClickBlackO();
                break;
        }
    }
    //黒く塗りつぶし
    public void onClickBlackB(){
        countB = 0;
        binding.view3.setBackgroundResource(R.drawable.circle_black);
        binding.view2.setBackgroundResource(R.drawable.circle_black);
        binding.view1.setBackgroundResource(R.drawable.circle_black);
    }
    public void onClickBlackS(){
        countS = 0;
        binding.view6.setBackgroundResource(R.drawable.circle_black);
        binding.view5.setBackgroundResource(R.drawable.circle_black);
    }
    public void onClickBlackO(){
        countO = 0;
        binding.view8.setBackgroundResource(R.drawable.circle_black);
        binding.view7.setBackgroundResource(R.drawable.circle_black);
    }
    //表裏切り替え
    public void onRadioCheck(){
        if (binding.radiobuttonOnline.isChecked()){
            binding.radiobuttonOffline.toggle();
        }else {
            binding.radiobuttonOnline.toggle();
            onInning(true);
        }
    }
    //Inningプラス、マイナス
    public void onInning(boolean check){
        if (check){
            mInning++;
            if (mInning > 99) {
                mInning = 99;
            }
            binding.inningTextView.setText(getString(R.string.inning,mInning));
        }else {
            mInning--;
            if (mInning < 1) {
                mInning = 1;
            }
            binding.inningTextView.setText(getString(R.string.inning,mInning));
        }
    }
    //Scoreプラス、マイナス
    public void onScore(boolean check){
        if (check){
            mScore++;
            if (mScore > 99) {
                mScore = 99;
            }
            binding.scoreText.setText(getString(R.string.score,mScore));
        }else {
            mScore--;
            if (mScore < 1) {
                mScore = 1;
            }
            binding.scoreText.setText(getString(R.string.score,mScore));
        }
    }
}