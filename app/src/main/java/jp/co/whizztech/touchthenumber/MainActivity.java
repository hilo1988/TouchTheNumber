package jp.co.whizztech.touchthenumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * メインアクティビティ
 * 表示するものは、ヘッダ用テキスト・GridView・スタートボタン
 * 最初はGridViewにはなにも表示されていないが、スタートボタンを押すことで
 * 1〜25の数字が表示される。
 * 最後の25が押されると、ヘッダテキストにかかった時間(秒)が表示される
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
        numberGridView.setOnItemClickListener(onItemClickListener);
        timeText = (TextView) findViewById(R.id.mainActivity_timeText);

        findViewById(R.id.mainActivity_startButton)
                .setOnClickListener(onclickStartButton);
    }


    /**
     * 数字をおした時の動作
     */
    private final AdapterView.OnItemClickListener onItemClickListener =
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Log.d(TAG, "onItemClick");
                    if (adapter.getCurrentNumber() == MAX_NUMBER) {
                        Log.d(TAG, "最大値に到達済み");
                        return;
                    }

                    NumberData data = adapter.getElement(position);
                    Log.d(TAG, String.format("data:%s, currentNumber:%s", data, adapter.getCurrentNumber()));
                    if (data.getNumber() == adapter.getCurrentNumber() + 1) {
                        data.setTouched(true);
                        adapter.incrementCurrentNumber();
                        if (adapter.getCurrentNumber() == MAX_NUMBER) {
                            Toast.makeText(getApplicationContext(),
                                    "目標達成！",
                                    Toast.LENGTH_SHORT)
                                    .show();
                            long time = System.currentTimeMillis() - startTime;
                            timeText.setText(String.format("%s秒でクリアしました！", time / 1000));
                        } else {
                            timeText.setText(String.valueOf(data.getNumber()));
                        }
                        adapter.notifyDataSetChanged();
                    }
                }
            };

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
