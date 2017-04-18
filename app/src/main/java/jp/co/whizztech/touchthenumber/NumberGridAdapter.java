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
        return convertView;
    }

}
