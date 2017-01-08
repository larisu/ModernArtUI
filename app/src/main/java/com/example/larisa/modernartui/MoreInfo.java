package com.example.larisa.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.widget.Button;

/**
 * Created by Larisa on 08-Jan-17.
 */
public class MoreInfo extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Build the dialog and set up the button click handlers
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        // Inflate and set the layout for the dialog.
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.moma, null));
        // Add Dialog Buttons
        builder.setPositiveButton(R.string.moma_open, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.moma.org"));
                startActivity(intent);
            }
        });
        builder.setNegativeButton(R.string.moma_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        // Create the Alert Dialog
        return builder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        Button pozButton =  ((AlertDialog) getDialog()).getButton(DialogInterface.BUTTON_POSITIVE);
        Button negButton =  ((AlertDialog) getDialog()).getButton(DialogInterface.BUTTON_NEGATIVE);
        pozButton.setTextColor(Color.BLACK);
        negButton.setTextColor(Color.BLACK);
    }
}