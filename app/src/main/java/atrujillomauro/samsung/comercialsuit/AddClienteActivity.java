package atrujillomauro.samsung.comercialsuit;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Calendar;

public class AddClienteActivity extends Activity {

    Spinner comisionSpinner;
    private String fecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_layout);
        comisionSpinner = (Spinner) findViewById(R.id.comisionSpinner);
        ArrayAdapter<CharSequence> comisionAdapter = ArrayAdapter.createFromResource(this, R.array.comisiones_array, android.R.layout.simple_spinner_dropdown_item);
        comisionSpinner.setAdapter(comisionAdapter);

        //inicializando fecha
        Calendar calendar = Calendar.getInstance();
        fecha = calendar.get(Calendar.YEAR) + "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.DAY_OF_MONTH);

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
}
