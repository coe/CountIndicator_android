package jp.co.rleaning.countindicator.vo;

/**
 * 得点を表現する
 * Created by atsushiyonenaga on 2017/01/24.
 */

public class Score extends rangeInt{
    public Score(int value) {
        super(99, 0, value);
    }
}
