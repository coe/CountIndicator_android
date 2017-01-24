package jp.co.rleaning.countindicator.vo;

/**
 * イニングを表現する
 * Created by atsushiyonenaga on 2017/01/24.
 */

public class Inning extends rangeInt{

    public Inning(int value) {
        super(99, 1, value);
    }
}
