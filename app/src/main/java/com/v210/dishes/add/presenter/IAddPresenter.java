package com.v210.dishes.add.presenter;

import android.widget.EditText;
import com.v210.db.DBHelper;

/**
 * Created by Jack on 16/2/19.
 */
public interface IAddPresenter
{
    public void writeToDatabase(DBHelper dbHelper, String dishName, int price, int vipPrice, String pinyinFullStr, String pinyinHeadStr);

    public void createPinYin(EditText name,EditText pinyin,EditText pinyinHead,boolean focus);
}
