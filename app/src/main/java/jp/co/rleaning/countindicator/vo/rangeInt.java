package jp.co.rleaning.countindicator.vo;

import android.util.Log;

/**
 * 上限と加減を持つ数値。上限・下限を越えるときは貼り着き制御
 * Created by atsushiyonenaga on 2017/01/24.
 */

public class rangeInt {
    private int value;
    private final int max;
    private final int min;
    private final String TAG = "rangeInt";


    public rangeInt(int max, int min, int value) {
        this.max = max;
        this.min = min;
        this.value = value;
    }


    public int get() {
        return value;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    /**
     *
     * @return
     */
    public int increment() {
        value++;
        if (value > max) {
            value = max;
        }
        return value;
    }

    /**
     *
     * @return
     */
    public int decrement() {
        value--;
        if (value < min) {
            value = min;
        }
        return value;
    }
}
