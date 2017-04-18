package jp.co.whizztech.touchthenumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Step3
 * 数字がクリックされたら、色を反転しよう！
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

        findViewById(R.id.mainActivity_startButton)
                .setOnClickListener(onclickStartButton);
    }


    /**
     * スタートボタンを押したときの処理
     */
    private final View.OnClickListener onclickStartButton =
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startTime = System.currentTimeMillis();
                    adapter.startGame(createNumberDataList());
                    timeText.setText("0");
                }
            };

    /**
     * 数値データの初期化
     */
    private List<NumberData> createNumberDataList() {
        List<NumberData> numberDataList = new ArrayList<>(MAX_NUMBER);
        for (int number = 1; number <= MAX_NUMBER; number++) {
            numberDataList.add(new NumberData(number));
        }
        Collections.shuffle(numberDataList);
        return numberDataList;
    }
}
