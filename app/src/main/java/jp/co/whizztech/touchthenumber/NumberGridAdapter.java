package jp.co.whizztech.touchthenumber;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by hilo on 2017/04/08.
 */

public class NumberGridAdapter extends BaseAdapter {

    /**
     * コンテキスト
     */
    private final Context context;

    /**
     * 表示データリスト
     */
    private List<NumberData> numberList;

    /**
     * 現在選択中の数値
     */
    private int currentNumber = 0;

    public NumberGridAdapter(Context context, List<NumberData> numberList) {
        this.context = context;
        this.numberList = numberList;
    }


    @Override
    public int getCount() {
        return numberList.size();
    }

    @Override
    public Object getItem(int position) {
        return getElement(position);
    }

    /**
     * 現在選択中の数値を取得
     */
    public int getCurrentNumber() {
        return currentNumber;
    }

    /**
     * 現在選択中の数値をインクリメント
     */
    public void incrementCurrentNumber() {
        currentNumber++;
    }

    /**
     * データの取得
     *
     * @param position ポジション
     * @return 指定ポジションのデータ
     */
    public NumberData getElement(int position) {
        return numberList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getElement(position).getNumber();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final NumberDataView view;
        if (convertView == null) {
            view = (NumberDataView) View.inflate(context, R.layout.adapter_number_data, null);
        } else {
            view = (NumberDataView) convertView;
        }
        view.bindView(getElement(position));
        return view;
    }

    /**
     * ゲームの開始
     */
    public void startGame(List<NumberData> numberList) {
        this.numberList = numberList;
        this.currentNumber = 0;
        notifyDataSetChanged();
    }
}
