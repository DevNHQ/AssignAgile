package androidagile.it.thanh.assignagile.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper {
    private static final String DB_NAME="LuuKQ";
    private static final String TB_Name="KQ";
    private static final int DB_VERSION=1;
    private SQLiteDatabase database;
    private SQLiteDatabase dataBase;

    public DatabaseHelper (Context context){
        OpenHelper openHelper=new OpenHelper(context);
        dataBase=openHelper.getWritableDatabase();
    }


    public class OpenHelper extends SQLiteOpenHelper{

        public OpenHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String lenhtaobang="CREATE TABLE IF NOT EXISTS KQ(_id INTEGER PRIMARY KEY AUTOINCREMENT,name NVARCHAR,monhoc NVARCHAR,diem NVARCHAR)";
            db.execSQL(lenhtaobang);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+TB_Name);
        }
    }


    public void insert(String name,String monhoc,String diem){
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("monhoc",monhoc);
        values.put("diem",diem);
        dataBase.insert(TB_Name,null,values);
    }

    public void update(String name,String monhoc,String diem,int i){

        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("monhoc",monhoc);
        values.put("diem",diem);
        dataBase.update(TB_Name,values,"_id="+i,null);
    }

    public void delete(int i){
        dataBase.delete(TB_Name,"_id="+i,null);

    }

    public Cursor getdata(){
        return   dataBase.query(TB_Name,null
                ,null
                ,null
                ,null
                ,null
                ,null);
    }

}
