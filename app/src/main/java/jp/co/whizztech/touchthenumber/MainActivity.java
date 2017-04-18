package jp.co.whizztech.touchthenumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Collections;

/**
 * STEP2
 * ボタンをクリックしてGridViewを表示させよう！
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    /**
     * タッチザナンバーの最大数
     */
    private static final int MAX_NUMBER = 25;

    /**
     * グリッドView
     */
    private GridView numberGridView;

    /**
     * アダプタ
     */
    private NumberGridAdapter adapter;

    /**
     * 時間を表示するテキスト
     */
    private TextView timeText;

    /**
     * 開始時間(UNIX時間)
     */
    private long startTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberGridView = (GridView) findViewById(R.id.mainActivity_gridView);
        adapter = new NumberGridAdapter(this, Collections.<NumberData>emptyList());
        numberGridView.setAdapter(adapter);
        timeText = (TextView) findViewById(R.id.mainActivity_timeText);

    }


}
