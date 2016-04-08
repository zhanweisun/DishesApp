package com.v210.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.v210.dishes.home.model.DishBean;
import com.v210.utils.ChineseToEnglish;

import java.util.ArrayList;

/**
 * Created by mtime on 15/10/17.
 */
public class DBHelper extends SQLiteOpenHelper
{
    private static final int VERSION = 1;
    public static final String TABLE_NAME = "DishesList";
    public static final String DB_NAME = "DishesDB";
    public static final String[] COLUMNS =
        {
            "id",
            "name",
            "price",
            "vipprice",
            "value",
            "img_path",
            "pinyin",
            "py_head"
        };

    /**
     * 在SQLiteOpenHelper的子类当中，必须有该构造函数
     *
     * @param context
     *     上下文对象
     * @param name
     *     数据库名称
     * @param factory
     * @param version
     *     当前数据库的版本，值必须是整数并且是递增的状态
     */
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        //必须通过super调用父类当中的构造函数
        super(context, name, factory, version);
    }

    public DBHelper(Context context, String name, int version)
    {
        this(context, name, null, version);
    }

    public DBHelper(Context context)
    {
        this(context, DB_NAME, VERSION);
    }

    //该函数是在第一次创建的时候执行，实际上是第一次得到SQLiteDatabase对象的时候才会调用这个方法
    public void onCreate(SQLiteDatabase db)
    {
        //execSQL用于执行SQL语句
        db.execSQL("CREATE TABLE " + TABLE_NAME +
                       " (id integer  PRIMARY KEY AUTOINCREMENT DEFAULT NULL," +
                       "name varchar(50) DEFAULT NULL," +
                       "price INTEGER," +
                       "vipprice INTEGER," +
                       "value INTEGER," +
                       "img_path varchar(255)," +
                       "pinyin varchar(50) DEFAULT NULL," +
                       "py_head varchar(50) DEFAULT NULL)");
        initData(db);
    }


    public void initData(SQLiteDatabase db)
    {
        insertData(db, "金牌烤鸭（套）", "12800", "11800");
        insertData(db, "标准烤鸭（套）", "11800", "10800");
        insertData(db, "标准烤鸭（半套）", "6800", "5800");
        insertData(db, "鸭饼", "600", "600");
        insertData(db, "鸭酱", "200", "200");
        insertData(db, "葱丝", "200", "200");
        insertData(db, "瓜条", "200", "200");
        insertData(db, "鸭架（孜然、椒盐、炖汤）", "1200", "1200");
        insertData(db, "麻婆豆腐", "1800", "900");
        insertData(db, "蟹黄豆腐", "5600", "2800");
        insertData(db, "盐菜小肘", "5600", "2800");
        insertData(db, "文蛤烩丝瓜", "3800", "1900");
        insertData(db, "蒜茸粉丝蒸扇贝（只）", "800", "800");
        insertData(db, "红烧狮子头（个）", "800", "800");
        insertData(db, "香辣土豆丝", "1800", "1800");
        insertData(db, "鸭梨拌菜", "2200", "1900");
        insertData(db, "老北京肉皮冻", "1800", "1500");
        insertData(db, "花仁菠菜", "1500", "1200");
        insertData(db, "黄瓜沾酱（根）", "400", "300");
        insertData(db, "夫妻肺片", "3500", "3200");
        insertData(db, "桂花莲藕", "2800", "2600");
        insertData(db, "老醋蛰头", "4200", "3800");
        insertData(db, "招牌素三样", "2600", "2200");
        insertData(db, "酱香鸭头（只）", "400", "300");
        insertData(db, "香椿苗拌豆腐丝", "1800", "1500");
        insertData(db, "川味凉面", "1900", "1600");
        insertData(db, "酱香鸡翅", "1900", "1600");
        insertData(db, "蛰皮白菜心", "2200", "1800");
        insertData(db, "水果沙拉", "2600", "2200");
        insertData(db, "口水鸡", "3500", "3200");
        insertData(db, "老醋花生米", "900", "800");
        insertData(db, "香椿苗核桃仁", "2800", "2500");
        insertData(db, "东北大拉皮", "1900", "1600");
        insertData(db, "川味香肠", "2900", "2600");
        insertData(db, "芥末鸭掌", "2900", "2600");
        insertData(db, "四喜烤麸", "1500", "1200");
        insertData(db, "鸭梨白切鸡（半只）", "3600", "3200");
        insertData(db, "蓝莓山药", "3200", "2800");
        insertData(db, "风味凉皮", "1800", "1500");
        insertData(db, "特色腌黄瓜", "1500", "1200");
        insertData(db, "盐水鸭肝", "2500", "2200");
        insertData(db, "野笋拌猪耳", "2900", "2600");
        insertData(db, "迷你珍菇", "2200", "1800");
        insertData(db, "爽口西葫芦丝", "1900", "1600");
        insertData(db, "美味留客菜", "1000", "900");
        insertData(db, "酱香肘花", "3800", "3500");
        insertData(db, "美极小秋耳", "2000", "1800");
        insertData(db, "招牌吱吱盒", "2900", "2600");
        insertData(db, "酱香牛肉", "3800", "3500");
        insertData(db, "卤水拼盘", "5600", "4800");
        insertData(db, "糟香小黄鱼", "2800", "2600");
        insertData(db, "水晶红果", "1900", "1600");
        insertData(db, "京味烧豆腐", "1800", "1500");
        insertData(db, "葱油三脆", "2900", "2600");
        insertData(db, "手撕炝炒圆白菜", "2200", "1900");
        insertData(db, "咸蛋黄焗黄瓜", "3200", "2800");
        insertData(db, "小炒鸡鸭砸", "2600", "2200");
        insertData(db, "石锅南瓜", "3200", "2800");
        insertData(db, "宫保鸡丁", "2000", "1800");
        insertData(db, "小笼米粉肉", "4200", "3600");
        insertData(db, "酥皮虾", "7300", "6900");
        insertData(db, "西红柿炖牛腩", "5600", "4800");
        insertData(db, "农家小炒肉", "3200", "2800");
        insertData(db, "肉末豆嘴炒粉条", "1900", "1600");
        insertData(db, "鸭梨椒麻鸡", "7200", "6800");
        insertData(db, "风味荞面包", "3200", "2800");
        insertData(db, "鸡汤木耳", "1800", "1500");
        insertData(db, "大碗有机花菜", "2900", "2600");
        insertData(db, "金汤脆笋", "5600", "4800");
        insertData(db, "大碗冬瓜", "2800", "2600");
        insertData(db, "清炒菜尖", "2200", "1900");
        insertData(db, "贝勒爷烤羊肉", "6200", "5600");
        insertData(db, "山药木耳", "2900", "2600");
        insertData(db, "红烧肉辣子鸡", "4800", "4200");
        insertData(db, "锅包肉", "4200", "3800");
        insertData(db, "钵子豆角", "2800", "2600");
        insertData(db, "剁椒鱼头", "7600", "6800");
        insertData(db, "双椒鱼头", "7600", "6800");
        insertData(db, "滑蛋虾仁", "4200", "3600");
        insertData(db, "清炒（蒜蓉）西兰花", "2800", "2600");
        insertData(db, "小炒黄牛肉", "4800", "4200");
        insertData(db, "蚝油野山菌", "3600", "3200");
        insertData(db, "东坡肘子", "8800", "7800");
        insertData(db, "卤耳尖炒香干", "3200", "2800");
        insertData(db, "炒合菜", "2200", "1900");
        insertData(db, "鲜花椒炝鱼片", "5200", "4800");
        insertData(db, "一品鲈鱼", "8800", "7800");
        insertData(db, "水煮肉片（牛肉）", "4200", "3800");
        insertData(db, "口味江团", "5800", "5600");
        insertData(db, "石锅江团", "5800", "5600");
        insertData(db, "江南小炒", "3600", "3200");
        insertData(db, "老北京炖吊子", "6800", "5800");
        insertData(db, "干炸丸子", "3200", "2800");
        insertData(db, "田园小炒", "2500", "2200");
        insertData(db, "土豆丝炒粉条", "1800", "1600");
        insertData(db, "西芹百合", "2600", "2200");
        insertData(db, "口味鸭脖", "3200", "2800");
        insertData(db, "福寿金沙虾", "5600", "4800");
        insertData(db, "铁板牛仔骨", "8800", "7800");
        insertData(db, "松蘑炖柴鸡", "5200", "4800");
        insertData(db, "鲜椒肥牛", "5200", "4800");
        insertData(db, "白灼秋葵", "2200", "1900");
        insertData(db, "坛煨东坡肉", "7800", "6800");
        insertData(db, "京酱肉丝", "2900", "2600");
        insertData(db, "糖醋里脊", "2600", "2200");
        insertData(db, "香芹鱼丸", "3200", "2800");
        insertData(db, "葱香虾球", "8600", "7800");
        insertData(db, "宫爆虾球", "8600", "7800");
        insertData(db, "钵子娃娃菜", "2600", "2200");
        insertData(db, "爆三样", "4800", "4200");
        insertData(db, "烧汁四宝", "2900", "2600");
        insertData(db, "馋嘴蛙", "7600", "6800");
        insertData(db, "海参过油肉", "5200", "4800");
        insertData(db, "芋儿烧排骨", "4800", "4200");
        insertData(db, "钵子胡萝卜丝", "1900", "1600");
        insertData(db, "青椒拆骨肉", "4200", "3800");
        insertData(db, "风味毛血旺", "5600", "4800");
        insertData(db, "白灼芥兰", "2600", "2200");
        insertData(db, "竹香烤牛柳", "5600", "4800");
        insertData(db, "风味羊排", "7800", "6800");
        insertData(db, "山药炖排骨", "5200", "4600");
        insertData(db, "鱼香肉丝", "2000", "1800");
        insertData(db, "葱烧海参", "8800", "7800");
        insertData(db, "酸菜鱼", "7800", "6800");
        insertData(db, "青椒豆腐炖河鲜", "5200", "4600");
        insertData(db, "干锅肥肠", "5200", "4600");
        insertData(db, "酱爆鱿鱼须", "4600", "3800");
        insertData(db, "松仁玉米", "2800", "2600");
        insertData(db, "桃仁酱爆鸡丁", "4200", "3800");
        insertData(db, "养生穿心莲", "2200", "1900");
        insertData(db, "石锅牛腩", "7600", "6800");
        insertData(db, "麻辣鸭头", "4200", "3600");
        insertData(db, "铁板全家福", "5200", "4800");
        insertData(db, "干煸四季豆", "2600", "2200");
        insertData(db, "鸭血肥肠", "4200", "3800");
        insertData(db, "铁板黑椒牛柳", "5200", "4800");
        insertData(db, "自制石锅豆腐", "3200", "2800");
        insertData(db, "鸭梨海鲜汇", "5600", "4800");
        insertData(db, "醋溜木须", "4800", "4500");
        insertData(db, "干煸土豆片", "2000", "1800");
        insertData(db, "老豆腐炖带鱼", "3600", "3200");
        insertData(db, "铁板粉丝包菜", "2900", "2600");
        insertData(db, "酱香茄子", "3200", "2800");
        insertData(db, "腊八蒜烧肥肠", "5200", "4600");
        insertData(db, "鲜虾蒸水蛋", "2600", "2200");
        insertData(db, "蒜蓉粉丝蒸生蚝（只）", "1200", "1000");
        insertData(db, "蒜蓉粉丝墨鱼花", "4200", "3800");
        insertData(db, "梅菜扣肉", "4200", "3600");
        insertData(db, "五谷杂粮", "3200", "2800");
        insertData(db, "蒜蓉粉丝娃娃菜", "2600", "2200");
        insertData(db, "蒜蓉粉丝金针菇", "2800", "2600");
        insertData(db, "清蒸海鲈鱼", "8800", "7800");
//        insertData(db, "鲈鱼", "000", "000");
//        insertData(db, "海白虾", "000", "000");
        insertData(db, "原汁鲜菌汤", "5200", "4600");
        insertData(db, "莲藕炖排骨", "6800", "5800");
        insertData(db, "农家土鸡野生菌", "6800", "5800");
        insertData(db, "笋干千张煲", "5200", "4800");
        insertData(db, "肉松饼", "2200", "1900");
        insertData(db, "鸭梨杂粮饼", "2800", "2600");
        insertData(db, "炸酱面", "900", "800");
        insertData(db, "西红柿鸡蛋面", "900", "800");
        insertData(db, "茄子打卤面", "900", "800");
        insertData(db, "水饺", "2200", "2000");
        insertData(db, "金鸭梨", "500", "400");
        insertData(db, "葱花饼", "1800", "1600");
        insertData(db, "糯香黑米糕", "1900", "1600");
        insertData(db, "武大郎馅饼", "2200", "2000");
        insertData(db, "孙姐炒饭", "2200", "1900");
        insertData(db, "白米饭", "200", "200");
        insertData(db, "家常饼", "1500", "1200");
        insertData(db, "香芋芝麻卷", "2000", "1800");
        insertData(db, "酸辣汤", "1800", "1600");
        insertData(db, "西红柿鸡蛋汤", "1800", "1600");
        insertData(db, "疙瘩汤", "1800", "1600");
        insertData(db, "湘西手工粉", "2900", "2600");
        insertData(db, "妈妈炖菜", "2200", "1900");
        insertData(db, "石锅千页豆腐", "4200", "3800");
        insertData(db,"红烧鲤鱼","3900","3900");
        insertData(db,"排骨土豆烧豆角","5200","4800");
    }


    public void insertData(SQLiteDatabase db, String name, String price, String vipPrice)
    {
        String insert = "insert into " + TABLE_NAME +
            " (name,price,vipprice,value,pinyin,py_head) values(\'" +
            name + "\'," + price + "," + vipPrice + "," + 0 + ",\'" +
            ChineseToEnglish.getPingYin(name) + "\',\'" + ChineseToEnglish.getPinYinHeadChar(name) + "\');";
        db.execSQL(insert);
    }


    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2)
    {
    }


    public void writeToDatabase(DishBean bean)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", bean.getName());
        values.put("price", bean.getPrice());
        values.put("vipprice", bean.getVipprice());
        values.put("value", bean.getValue());
        values.put("img_path", bean.getImgPath());
        values.put("pinyin", bean.getPinyin());
        values.put("py_head", bean.getPinyinHead());
        db.insert(DBHelper.TABLE_NAME, null, values);
        db.close();
    }


    public DishBean getByCreateTime(long createTime)
    {
        Cursor cursor = null;
        SQLiteDatabase db = this.getWritableDatabase();
        cursor = db.rawQuery("select * from " + DBHelper.TABLE_NAME + " where createTime=" + String.valueOf(createTime), null);
        if (cursor != null && cursor.getCount() > 0)
        {
            if (cursor.moveToNext())
            {
                DishBean bean = new DishBean();

                fillBean(cursor, bean);

                return bean;
            }
            cursor.close();
            db.close();
        }
        return null;
    }


    /**
     * 将cursor数据填充到bean
     *
     * @param pCursor
     * @param pBean
     */
    private void fillBean(Cursor pCursor, DishBean pBean)
    {
        if (pCursor != null && pBean != null)
        {
            int id = pCursor.getInt(pCursor.getColumnIndex(DBHelper.COLUMNS[0]));
            String name = pCursor.getString(pCursor.getColumnIndex(DBHelper.COLUMNS[1]));
            int price = pCursor.getInt(pCursor.getColumnIndex(DBHelper.COLUMNS[2]));
            int vipPrice = pCursor.getInt(pCursor.getColumnIndex((DBHelper.COLUMNS[3])));
            int value = pCursor.getInt(pCursor.getColumnIndex(DBHelper.COLUMNS[4]));
            String img_path = pCursor.getString(pCursor.getColumnIndex(DBHelper.COLUMNS[5]));
            String pinyin = pCursor.getString(pCursor.getColumnIndex(DBHelper.COLUMNS[6]));
            String py_head = pCursor.getString(pCursor.getColumnIndex(DBHelper.COLUMNS[7]));
            pBean.setId(id);
            pBean.setName(name);
            pBean.setPrice(price);
            pBean.setVipprice(vipPrice);
            pBean.setValue(value);
            pBean.setImgPath(img_path);
            pBean.setPinyin(pinyin);
            pBean.setPinyinHead(py_head);
        }
    }

    /**
     * 获取数据库内的数据列表
     *
     * @return
     */
    public ArrayList<DishBean> getFromDatabase()
    {
        int pageSize = 20;
        int offVal = 0;
        Cursor cursor = null;
        SQLiteDatabase db = this.getWritableDatabase();
        cursor = db.query(DBHelper.TABLE_NAME, null, null, null, null, null,
                          null,
                          null);
        if (cursor != null && cursor.getCount() > 0)
        {
            ArrayList<DishBean> data = new ArrayList<DishBean>();
            while (cursor.moveToNext())
            {
                DishBean bean = new DishBean();
                fillBean(cursor, bean);
                data.add(bean);
            }
            cursor.close();
            db.close();
            return data;
        }
        return null;
    }

    public void updateToDatabase(ContentValues values, int id)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        database.update(TABLE_NAME, values, "id=?", new String[]{String.valueOf(id)});
        database.close();
    }
}
