package dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by huixing on 2016/10/24.
 */

public class SqlHelper  extends SQLiteOpenHelper {
    public SqlHelper(Context context) {
        super(context, "account.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table account3(_id integer primary key autoincrement, " +
                "input decimal(10,2) default(0.00),output decimal(10,2) default(0.00)," +
                "account_name,account_icon,account_note)";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
