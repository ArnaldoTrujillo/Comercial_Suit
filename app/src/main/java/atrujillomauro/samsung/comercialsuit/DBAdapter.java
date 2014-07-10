package atrujillomauro.samsung.comercialsuit;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DBAdapter {
    public final static String DB_NAME = "registroDB";
    public final static String TB_REGISTRO = "clientesTable";
    private final static String CR_TABLE = "CREATE TABLE "
            + TB_REGISTRO + " (" + Columns.ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Columns.NOMBRE_COL
            + " TEXT, " + Columns.APELLIDOS_COL + " TEXT NOT NULL, " + Columns.DIRECCION_COL
            + " TEXT NOT NULL, " + Columns.CP_COL + " INTEGER NOT NULL, " + Columns.COMISION_COL
            + " INTENGER NOT NULL DEFAULT '0', " + Columns.TLF_COL + " TEXT, "
            + Columns.FECHA_COL + " DATE DEFAULT CURRENT_TIMESTAMP)";
    private final static int DB_VERSION = 1;
    private final static String[] COLUMNS = {Columns.ID, Columns.NOMBRE_COL, Columns.APELLIDOS_COL, Columns.DIRECCION_COL,
            Columns.CP_COL, Columns.COMISION_COL, Columns.TLF_COL, Columns.FECHA_COL};

    private DBHelper dbHelper;

    public DBAdapter(Context context) {
        dbHelper = new DBHelper(context);
    }

    public DBHelper getDbHelper() {
        return dbHelper;
    }

    public class Columns implements BaseColumns {
        public final static String ID = "_id";
        public final static String NOMBRE_COL = "nombre";
        public final static String APELLIDOS_COL = "apellidos";
        public final static String DIRECCION_COL = "direccion";
        public final static String CP_COL = "codigoPostal";
        public final static String COMISION_COL = "comision";
        public final static String TLF_COL = "tlf";
        public final static String FECHA_COL = "fechaLlamada";
    }

    public class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CR_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DB_NAME);
            onCreate(db);
        }
    }
}

