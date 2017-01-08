package com.example.larisa.modernartui;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.view.Menu;
import android.view.MenuItem;

import static com.example.larisa.modernartui.R.styleable.MenuItem;

public class ModernArtUI extends AppCompatActivity {
    private SeekBar changeColor = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modern_art_ui);

        final LinearLayout cell1 = (LinearLayout)findViewById(R.id.cell1);
        final LinearLayout cell3 = (LinearLayout)findViewById(R.id.cell3);
        final LinearLayout cell5 = (LinearLayout)findViewById(R.id.cell5);
        final LinearLayout cell6 = (LinearLayout)findViewById(R.id.cell6);
        final LinearLayout cell7 = (LinearLayout)findViewById(R.id.cell7);

        final int blueForm = ((ColorDrawable) cell1.getBackground()).getColor();
        final int yellowForm = ((ColorDrawable) cell3.getBackground()).getColor();
        final int redForm = ((ColorDrawable) cell5.getBackground()).getColor();
        final int whiteForm = ((ColorDrawable) cell6.getBackground()).getColor();
        final int greenForm = ((ColorDrawable) cell7.getBackground()).getColor();

        changeColor = (SeekBar)findViewById(R.id.changeColor);
        changeColor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int change = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                change = progress;
                setProgressBasedBackgroundColor(cell1,blueForm);
                setProgressBasedBackgroundColor(cell3,yellowForm);
                setProgressBasedBackgroundColor(cell5,redForm);
                setProgressBasedBackgroundColor(cell6,whiteForm);
                setProgressBasedBackgroundColor(cell7,greenForm);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            private void setProgressBasedBackgroundColor(LinearLayout box, int OriginalBoxColor) {
                float[] hsvColor = new float[3];
                Color.colorToHSV(OriginalBoxColor, hsvColor);
                hsvColor[0] = hsvColor[0] + change;
                hsvColor[0] = hsvColor[0] % 360;
                box.setBackgroundColor(Color.HSVToColor(Color.alpha(OriginalBoxColor), hsvColor));
            }
        });}


       @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_modernartui, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_more_info) {
                DialogFragment moreInfoFragment = new MoreInfo();
               // moreInfoFragment.show(FragmentManager this, moreInfoFragment);
                moreInfoFragment.show(getSupportFragmentManager(), "moreInfo");
                return true;
            }

            return super.onOptionsItemSelected(item);

        }
}
