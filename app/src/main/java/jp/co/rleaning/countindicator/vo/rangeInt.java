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
        // TODO: valueが範囲外なら例外を投げる
        this.max = max;
        this.min = min;
        this.value = value;
        Log.d(TAG, "max:" + max);
        Log.d(TAG, "min:" + min);
        Log.d(TAG, "value:" + value);

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
        Log.d("hoge", value + "");
        if (value > max) {
            Log.d("hoge", "overshoot!");
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
        Log.d("hoge", value + "");
        if (value < min) {
            Log.d("hoge", "overshoot!");
            value = min;
        }
        return value;
    }
}
