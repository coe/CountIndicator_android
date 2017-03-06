package jp.co.rleaning.countindicator.presenter;

/**
 * Created by RLCL-217 on 2016/12/15.
 */

public interface ScorePresenter {

    /**
     * イニングの+ボタンを押した時
     */
    void onClickInningPlus();


    /**
     * イニングの-ボタンを押した時
     */
    void onClickInningMinus();


    /**
     * スコアの+ボタンを押した時
     */
    void onClickScorePlus();


    void onClickScoreMinus();


    void onClear();

    void onClickB();

    void onClickS();

    void onClickO();

}
