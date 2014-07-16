package atrujillomauro.samsung.comercialsuit;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Nardy on 15/07/2014.
 */
public class DialogoLocalidad extends DialogFragment {
    final String[] localidades = {"Madrid", "Alcobendas y La Moraleja", "Pozuelo de Alarcón", "Alcalá de Henares", "Getafe", "Leganés", "Alcorcón", "Móstoles", "Fuenlabrada"};

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Escoja la localidad de Madrid:")
                .setItems(localidades, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((AddClienteActivity) getActivity()).setLocalidad(localidades[which]);
                        AddClienteActivity.downLatch.countDown();
                    }
                })
        ;

        return builder.create();

    }
}
