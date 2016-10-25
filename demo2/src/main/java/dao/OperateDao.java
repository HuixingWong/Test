package dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by huixing on 2016/10/24.
 */

public class OperateDao {

    private SqlHelper helper;
    private SQLiteDatabase db;

    String ACCOUNTTABLE = "account3";

    private Context context;

    public OperateDao(Context context) {

        this.context = context;
        helper = new SqlHelper(context);

    }

    //插入数据的方法
    public void insert(){

        db = helper.getWritableDatabase();
        String sql = "";

    }


    //删除数据




    //修改数据



    //查询数据








}
