package jp.co.whizztech.touchthenumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.TextView;

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
    }


}
