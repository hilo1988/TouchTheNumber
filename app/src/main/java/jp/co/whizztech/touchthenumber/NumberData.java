package jp.co.whizztech.touchthenumber;

import java.util.Locale;

/**
 * タッチザナンバー用数値データ
 * Created by hilo on 2017/04/08.
 */

public class NumberData {

    /**
     * 数値
     */
    private final int number;

    /**
     * タッチされたかどうか。
     * されていたらtrue
     */
    private boolean isTouched;

    public NumberData(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isTouched() {
        return isTouched;
    }

    public void setTouched(boolean touched) {
        isTouched = touched;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "number:%d, isTouched:%s", number, isTouched);
    }
}
