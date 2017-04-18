package jp.co.whizztech.touchthenumber;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * 数字を表示するView
 * Created by hilo on 2017/04/09.
 */

public class NumberDataView extends RelativeLayout {


    public NumberDataView(Context context) {
        super(context);
    }

    public NumberDataView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NumberDataView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public NumberDataView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void bindView(NumberData data) {
    }

    private int getTouchableColor(NumberData data) {
        if (data.isTouched()) {
            return R.color.untouchable;
        }
        return R.color.touchable;
    }

}
