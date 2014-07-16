package atrujillomauro.samsung.comercialsuit;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

/**
 * Created by android on 16/07/2014.
 */
public class GananciasDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Ganancias").setMessage("Sus ganancias han sido de " + calcularGanancias() + "€.");

        return builder.create();
    }


    private int calcularGanancias() {
        int total = 0;
        String[] columna = {DBAdapter.Columns.COMISION_COL};
        DBAdapter dbAdapter = new DBAdapter(getActivity());
        DBAdapter.DBHelper dbHelper = dbAdapter.getDbHelper();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor comisiones = database.query(DBAdapter.TB_REGISTRO, columna, null, null, null, null, null);
        while (comisiones.moveToNext()) {
            total += comisiones.getInt(comisiones.getColumnIndex(DBAdapter.Columns.COMISION_COL));
        }
        return total;
    }
}
