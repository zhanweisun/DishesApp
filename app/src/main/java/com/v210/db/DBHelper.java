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
        insertData(db, "鸭梨萌萌雷", "3900", "3600");
        insertData(db, "草包牛肉", "3900", "3600");
        insertData(db, "蓝莓山药", "3200", "2800");
        insertData(db, "奶香豆腐鱼", "1800", "1500");
        insertData(db, "鸭梨白切鸡", "3600", "3200");
        insertData(db, "老北京肉皮冻", "1800", "1500");
        insertData(db, "四川腊肠", "3200", "2800");
        insertData(db, "麦穗红薯", "2800", "2600");
        insertData(db, "招牌吱吱盒", "3600", "3200");
        insertData(db, "甜筒沙拉(3个起卖)", "800", "700");
        insertData(db, "四喜烤麸", "1800", "1600");
        insertData(db, "桂花莲藕", "2800", "2600");
        insertData(db, "黄瓜沾酱", "400", "300");
        insertData(db, "酱肘花", "3800", "3500");
        insertData(db, "川式钵钵鸡", "4200", "3800");
        insertData(db, "老醋花生", "900", "800");
        insertData(db, "蛰皮白菜心", "2600", "2200");
        insertData(db, "美极黑木耳", "2000", "1800");
        insertData(db, "糟香小黄鱼", "2800", "2600");
        insertData(db, "钢管鸡", "6800", "5800");
        insertData(db, "钢管鸡(半只)", "3500", "2900");
        insertData(db, "芥末鸭掌", "3600", "3200");
        insertData(db, "东北大拉皮", "1900", "1600");
        insertData(db, "酱鸭头", "400", "300");
        insertData(db, "夫妻肺片", "4200", "3800");
        insertData(db, "巧拌豆腐丝", "1900", "1600");
        insertData(db, "香椿苗核桃仁", "2800", "2500");
        insertData(db, "山药炖排骨", "5200", "4600");
        insertData(db, "红烧狮子头（个）", "1000", "800");
        insertData(db, "青椒拆骨肉", "4200", "3800");
        insertData(db, "大碗有机花菜", "3200", "2900");
        insertData(db, "鸭梨黄金豆焖肉", "5600", "4900");
        insertData(db, "东坡肉", "8800", "7800");
        insertData(db, "石锅千页豆腐", "4200", "3800");
        insertData(db, "小炒脆肠", "4600", "4200");
        insertData(db, "海参过油肉", "7600", "6800");
        insertData(db, "咸蛋黄焗南瓜", "3200", "2800");
        insertData(db, "老北京炖吊子", "6800", "5800");
        insertData(db, "竹香烤牛柳", "5600", "4800");
        insertData(db, "卤耳尖炒香干", "3200", "2800");
        insertData(db, "风味羊排", "7800", "6800");
        insertData(db, "酱爆桃仁鸡丁", "4200", "3900");
        insertData(db, "田园小炒", "2500", "2200");
        insertData(db, "干炸丸子", "4200", "3600");
        insertData(db, "京味爆三样", "4800", "4200");
        insertData(db, "宫保鸡丁", "2200", "2000");
        insertData(db, "木耳山药", "2900", "2600");
        insertData(db, "罐闷带鱼", "5600", "4800");
        insertData(db, "溜肝尖", "3200", "2800");
        insertData(db, "宫保虾球", "8600", "7800");
        insertData(db, "一品鲈鱼", "8800", "7800");
        insertData(db, "京酱肉丝", "3000", "2800");
        insertData(db, "蟹黄豆腐", "4200", "3800");
        insertData(db, "馋嘴蛙", "7600", "6800");
        insertData(db, "农家小炒肉", "3200", "2900");
        insertData(db, "炒合菜", "2200", "1900");
        insertData(db, "鲜椒肥牛", "5200", "4800");
        insertData(db, "风味毛血旺", "5900", "5600");
        insertData(db, "西芹百合", "2800", "2500");
        insertData(db, "鲍汁豆腐", "3200", "2800");
        insertData(db, "钵子娃娃菜", "2600", "2200");
        insertData(db, "酱香茄子", "2900", "2600");
        insertData(db, "金汤脆笋", "5600", "4800");
        insertData(db, "铁板牛仔骨", "8800", "7800");
        insertData(db, "锅包肉", "4200", "3800");
        insertData(db, "干煸四季豆", "2800", "2500");
        insertData(db, "醋溜木须", "4800", "4500");
        insertData(db, "酸菜鱼", "6800", "5800");
        insertData(db, "家常土豆丝", "1800", "1600");
        insertData(db, "水煮肉", "4200", "3800");
        insertData(db, "手撕炝炒圆白菜", "2200", "1900");
        insertData(db, "铁板全家福", "5200", "4800");
        insertData(db, "白灼秋葵", "3200", "2900");
        insertData(db, "鱼香肉丝", "2200", "2000");
        insertData(db, "滋补酱蹄花/只", "900", "900");
        insertData(db, "滋补酱蹄花/份", "6800", "6800");
        insertData(db, "干锅土豆片", "2200", "1900");
        insertData(db, "笋干千张煲", "5200", "4800");
        insertData(db, "西红柿炖牛腩", "6200", "5800");
        insertData(db, "铁板粉丝包菜", "2900", "2600");
        insertData(db, "风味荞面包", "3200", "2800");
        insertData(db, "耗油山珍菌", "3600", "3200");
        insertData(db, "多宝鱼(清蒸,豉汁,红烧)", "12800", "11800");
        insertData(db, "鲈鱼(清蒸,豉汁,红烧)", "8800", "7800");
        insertData(db, "蒜蓉蒸扇贝(豉汁蒸)/只", "1600", "1200");
        insertData(db, "白虾", "12800", "11800");
        insertData(db, "桂鱼(清蒸)", "8800", "7800");
        insertData(db, "桂鱼(豉汁)", "8800", "7800");
        insertData(db, "桂鱼(红烧)", "8800", "7800");
//        insertData(db, "梨香酥皮虾", "7800", "6800");
        insertData(db, "小笼米粉肉", "4200", "3600");
        insertData(db, "白灼芥兰", "2800", "2500");
        insertData(db, "松仁玉米", "2800", "2600");
        insertData(db, "清炒菜尖", "2200", "1900");
        insertData(db, "五谷杂粮", "3200", "2800");
        insertData(db, "梅菜扣肉", "4200", "3600");
        insertData(db, "蒜蓉粉丝娃娃菜", "2600", "2200");
        insertData(db, "鲜虾蒸水蛋", "2600", "2200");
        insertData(db, "莲藕排骨汤", "6800", "5800");
        insertData(db, "酸辣汤", "2000", "1800");
        insertData(db, "农家土鸡野山菌", "5600", "5200");
        insertData(db, "原汁山菌汤", "5200", "4600");
        insertData(db, "疙瘩汤", "2000", "1800");
        insertData(db, "西红柿鸡蛋面", "900", "800");
        insertData(db, "农家打卤面", "900", "800");
        insertData(db, "炸酱面", "900", "800");
        insertData(db, "绿野蘑踪/个", "600", "500");
        insertData(db, "牛肉炒饭", "2600", "2200");
        insertData(db, "鸡蛋炒饭", "2600", "2200");
        insertData(db, "酱油炒饭", "2600", "2200");
        insertData(db, "香芋卷", "2200", "1800");
        insertData(db, "家常葱花饼", "1800", "1500");
        insertData(db, "美味状元饼", "2200", "2000");
        insertData(db, "懒笼", "2600", "2200");
        insertData(db, "鸭梨杂粮饼", "3200", "2800");
        insertData(db, "猪肉水饺", "2200", "2000");
        insertData(db, "三鲜水饺", "2200", "2000");
        insertData(db, "牛肉水饺", "2200", "2000");
        insertData(db, "金牌烤鸭（含2套鸭料）", "14800", "13800");
        insertData(db, "标准烤鸭（含1套鸭料）", "12800", "11800");
        insertData(db, "标准烤鸭（半套,含1套鸭料）", "7800", "6800");
        insertData(db, "京葱爆鸭心", "3600", "3200");
        insertData(db, "妈妈炖菜", "3200", "2900");
        insertData(db, "鸡鸭杂", "2600", "2200");
        insertData(db, "铜壶吊梨汤", "3800", "2800");
        insertData(db, "金鸭梨", "500", "400");
        insertData(db, "贝勒爷烤肉", "6200", "5600");
        insertData(db, "2斤半鱼头王/斤", "4800", "4500");
        insertData(db, "3.8斤-5斤鱼头王/斤", "5200", "4800");
        insertData(db, "单加饼/份", "1000", "1000");
        insertData(db, "水煮江团鱼", "6200", "5800");
        insertData(db, "水煮草鱼", "4200", "3800");
        insertData(db, "辣子鸡配芒果蛋", "4200", "3900");
        insertData(db, "糯香咸鸭蛋/个", "600", "500");
        insertData(db, "老北京自制酸奶", "1000", "800");
        insertData(db, "养颜西瓜汁", "3800", "3200");
        insertData(db, "冰爽酸梅汤", "2200", "2200");
        insertData(db, "野生蓝莓汁", "4600", "3800");
        insertData(db, "枸杞沙棘汁", "5600", "4800");
        insertData(db, "茅根甘蔗马蹄露", "3800", "3800");
        insertData(db, "卤水拼盘", "5800", "4800");
        insertData(db, "川味凉面", "1900", "1600");
        insertData(db, "鸭梨大拌菜", "2200", "1900");
        insertData(db, "老醋蛰头", "4200", "3800");
        insertData(db, "小二(100ml)", "800", "800");
        insertData(db, "燕京鲜啤", "800", "800");
        insertData(db, "燕京纯生", "1300", "1300");
        insertData(db, "燕京冰纯", "1600", "1600");
        insertData(db, "燕京原浆白啤", "2000", "2000");
        insertData(db, "燕京无醇", "1600", "1600");
        insertData(db, "大可乐", "1000", "1000");
        insertData(db, "大雪碧", "1000", "1000");
        insertData(db, "小可乐", "500", "500");
        insertData(db, "小雪碧", "500", "500");
        insertData(db, "露露", "600", "600");
        insertData(db, "椰汁", "600", "600");
        insertData(db, "汇源桃汁", "4200", "3800");
        insertData(db, "汇源橙汁", "4200", "3800");
        insertData(db, "北冰洋", "900", "900");
        insertData(db, "酸奶", "2500", "2500");
        insertData(db, "矿泉水", "300", "300");
        insertData(db, "加多宝", "600", "600");
        insertData(db, "果粒橙", "1800", "1800");
        insertData(db, "红牛", "1000", "1000");
        insertData(db, "麻婆豆腐", "1800", "900");
        insertData(db, "花仁菠菜", "1500", "1200");
        insertData(db, "蓝莓山药", "3200", "2800");
        insertData(db, "咸蛋黄焗黄瓜", "3200", "2800");
        insertData(db, "川味香肠", "2900", "2600");
        insertData(db, "盐菜小肘", "5600", "2800");
        insertData(db, "文蛤烩丝瓜", "3800", "1900");
        insertData(db, "石锅南瓜", "3200", "2800");
        insertData(db, "肉末豆嘴炒粉条", "1900", "1600");
        insertData(db, "钵子豆角", "2800", "2600");
        insertData(db, "滑蛋虾仁", "4200", "3600");
        insertData(db, "清炒（蒜蓉）西兰花", "2800", "2600");
        insertData(db, "小炒黄牛肉", "4800", "4200");
        insertData(db, "东坡肘子", "8800", "7800");
        insertData(db, "水煮肉片", "4200", "3800");
        insertData(db, "江南小炒", "3600", "3200");
        insertData(db, "土豆丝炒粉条", "1800", "1600");
        insertData(db, "糖醋里脊", "2600", "2200");
        insertData(db, "烧汁四宝", "2900", "2600");
        insertData(db, "鱼香肉丝", "2200", "2000");
        insertData(db, "干锅肥肠", "5200", "4600");
        insertData(db, "酱爆鱿鱼须", "4600", "3800");
        insertData(db, "石锅牛腩", "7600", "6800");
        insertData(db, "铁板黑椒牛柳", "5200", "4800");
        insertData(db, "自制石锅豆腐", "3200", "2800");
        insertData(db, "干煸土豆片", "2000", "1800");
        insertData(db, "蒜蓉粉丝金针菇", "2800", "2600");
        insertData(db, "笋干千张煲", "5200", "4800");
        insertData(db, "白米饭", "200", "200");
        insertData(db, "湘西手工粉", "2900", "2600");
        insertData(db, "红烧鲤鱼", "3900", "3900");
        insertData(db, "排骨土豆烧豆角", "5200", "4800");
        insertData(db, "春笋炒咸肉", "3600", "3600");
        insertData(db, "香椿摊鸡蛋", "2600", "2600");
        insertData(db, "干锅腊肉", "4200", "3800");
        insertData(db, "钵子莴笋", "2600", "2200");
        insertData(db, "滋补酱蹄花/份", "6800", "6800");
        insertData(db, "养生豆干丝", "2600", "2200");
        insertData(db, "烧椒小皮蛋", "2600", "2200");
        insertData(db, "鸭梨吊烧鸡", "6200", "5800");
        insertData(db, "臭桂鱼", "8800", "7800");
        insertData(db, "青椒肥肠鸭血", "3800", "3600");
        insertData(db, "压锅牛蛙", "7800", "6800");
        insertData(db, "压锅鸡", "4800", "4200");
        insertData(db, "干锅豆笋", "3200", "3900");
        insertData(db, "蒜蓉粉丝鸡尾虾", "5600", "4800");
        insertData(db, "成都冒菜", "5800", "5600");
        insertData(db, "干锅牛三宝", "6200", "5800");
        insertData(db, "小炒鸡鸭杂", "2600", "2200");
        insertData(db, "酸菜芦笋", "4200", "3200");
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


    public DishBean getByName(String name)
    {
        Cursor cursor=null;
        SQLiteDatabase db =this.getReadableDatabase();
        cursor=db.rawQuery("select * from " + DBHelper.TABLE_NAME + " where name = '"+name.trim()+ "'",null);
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
