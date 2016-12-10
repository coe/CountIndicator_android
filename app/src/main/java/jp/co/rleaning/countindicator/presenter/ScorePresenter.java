package jp.co.rleaning.countindicator.presenter;

/**
 * Created by user on 2016/12/10.
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

    /**
     * スコアの-ボタンを押した時
     */
    void onClickScoreMinus();

    /**
     * Bボタンを押した時
     */
    void onClickB();

    /**
     * Sボタンを押した時
     */
    void onClickS();

    /**
     * Oボタンを押した時
     */
    void onClickO();

    /**
     * クリアボタンを押した時
     */
    void onClickClear();

    /**
     * チェックボタンを押した時
     */
    void onCheckedChangedGroup();

}
