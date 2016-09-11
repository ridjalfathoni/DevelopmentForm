package id.sch.smktelkom_mlg.tugas01.xirpl4023.developmentform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etTahun, etEmail;
    Button bOk;
    TextView tvHasil, tvAV;
    RadioButton LK, PR;
    CheckBox cbMW, cbLP, cbNG;
    RadioGroup rgStatus;
    Spinner Kota;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        rgStatus = (RadioGroup) findViewById (R.id.radioGroupJK);

        etNama = (EditText) findViewById (R.id.editTextNama);
        etTahun = (EditText) findViewById (R.id.editTextTahun);
        etEmail = (EditText) findViewById (R.id.editTextEmail);

        tvHasil = (TextView) findViewById (R.id.textViewHasil);
        tvAV = (TextView) findViewById (R.id.textViewAV);

        cbLP = (CheckBox) findViewById (R.id.checkBoxLP);
        cbMW = (CheckBox) findViewById (R.id.checkBoxMW);
        cbNG = (CheckBox) findViewById (R.id.checkBoxNG);

        LK = (RadioButton) findViewById (R.id.radioButtonL);
        PR = (RadioButton) findViewById (R.id.radioButtonP);

        Kota = (Spinner) findViewById (R.id.spinnerKota);

        bOk = (Button) findViewById (R.id.buttonOK);
        bOk.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                if (isValid ()) ;

                String nama = etNama.getText ().toString ();
                String hasil = "\n\nAndroid:\n";
                String kelamin = null;
                String kelamin1 = null;
                int startlen = hasil.length ();
                if (cbLP.isChecked ()) hasil += cbLP.getText () + "\n";
                if (cbMW.isChecked ()) hasil += cbMW.getText () + "\n";
                if (cbNG.isChecked ()) hasil += cbNG.getText () + "\n";
                if (PR.isChecked ()) {
                    kelamin1 = PR.getText ().toString ();
                } else if (LK.isChecked ()) ;
                {
                    kelamin = LK.getText ().toString ();
                }

                if (hasil.length () == startlen) hasil += "Tidak Memilih";

                tvHasil.setText ("\nNama :" + nama
                                         + "\n\nKota :"
                                         + Kota.getSelectedItem ().toString ()
                                         + hasil + "\n\nJenis Kelamin:" + kelamin);
            }


        });
    }

    private boolean isValid () {
        boolean valid = true;
        String nama = etNama.getText ().toString ();
        String tahun = etTahun.getText ().toString ();
        String email = etEmail.getText ().toString ();

        if (nama.isEmpty ()) {
            etNama.setError ("Nama Belum Diisi");
            valid = false;
        } else if (nama.length () < 3) {
            etNama.setError ("Nama Minimal 3 Karakter");
        } else {
            etNama.setError (null);
        }
        if (email.isEmpty ()) {
            etEmail.setError ("Email Tidak Valid");
            valid = false;
        } else {
            etEmail.setError (null);
        }
        if (tahun.isEmpty ()) {
            etTahun.setError ("Tahun Kelahiran Belum Diisi");
            valid = false;
        } else if (tahun.length () != 4) {
            etTahun.setError ("Format Tahun Kelahiran bukan yyyy");
            valid = false;
        } else {
            etTahun.setError (null);
        }
        return valid;
    }
}
