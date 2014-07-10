package atrujillomauro.samsung.comercialsuit;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class AddClienteActivity extends Activity {

    Spinner comisionSpinner;
    EditText mNombreET, mApellidosET, mDireccionET, mCodigoPostalET, mTelefonoET;
    private String fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_layout);
        inicializarVistas();
        comisionSpinner = (Spinner) findViewById(R.id.comisionSpinner);
        ArrayAdapter<CharSequence> comisionAdapter = ArrayAdapter.createFromResource(this, R.array.comisiones_array, android.R.layout.simple_spinner_dropdown_item);
        comisionSpinner.setAdapter(comisionAdapter);

        //inicializando fecha
        Calendar calendar = Calendar.getInstance();
        fecha = calendar.get(Calendar.YEAR) + "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.DAY_OF_MONTH);

    }

    private void inicializarVistas() {
        mNombreET = (EditText) findViewById(R.id.nombreET);
        mApellidosET = (EditText) findViewById(R.id.apellidoET);
        mDireccionET = (EditText) findViewById(R.id.direccionET);
        mCodigoPostalET = (EditText) findViewById(R.id.cpET);
        mTelefonoET = (EditText) findViewById(R.id.telefonoET);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_cliente, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void escogerFecha(View view) {
        DataPickerFragment fechaPickFragment = new DataPickerFragment();
        fechaPickFragment.show(getFragmentManager(), "dataPicker");
    }

    protected void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void agregarClientes(View view) {
        if (todoEstaLleno()) {
            Toast.makeText(this, "Debe rellenar todos los campos", Toast.LENGTH_LONG).show();
        } else {
            insertarEnDb();
            finish();
        }
    }

    private void insertarEnDb() {
        DBAdapter.DBHelper dbHelper = new DBAdapter(this).getDbHelper();
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues valuesToInsert = new ContentValues();

        valuesToInsert.put(DBAdapter.Columns.NOMBRE_COL, mNombreET.getText().toString());
        valuesToInsert.put(DBAdapter.Columns.APELLIDOS_COL, mApellidosET.getText().toString());
        String spinnerValue = comisionSpinner.getSelectedItem().toString();
        int spinnerIntValue = Integer.parseInt(spinnerValue.substring(0, spinnerValue.indexOf("€")));
        valuesToInsert.put(DBAdapter.Columns.COMISION_COL, spinnerIntValue);
        valuesToInsert.put(DBAdapter.Columns.CP_COL, Integer.parseInt(mCodigoPostalET.getText().toString()));
        valuesToInsert.put(DBAdapter.Columns.FECHA_COL, fecha);
        valuesToInsert.put(DBAdapter.Columns.DIRECCION_COL, mDireccionET.getText().toString());
        valuesToInsert.put(DBAdapter.Columns.TLF_COL, mTelefonoET.getText().toString());

        database.insert(DBAdapter.TB_REGISTRO, null, valuesToInsert);
        database.close();
    }

    private boolean todoEstaLleno() {
        return !(mNombreET.length() != 0 && mApellidosET.length() != 0 && mDireccionET.length() != 0 && mCodigoPostalET.length() != 0 && mTelefonoET.length() != 0);
    }
}
