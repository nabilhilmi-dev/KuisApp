package com.nabil.kuis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView kuis;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD, PilihanE;
    int nomer = 0;
    public static int hasil, benar, salah;

    String[] pertanyaan_kuis = new String[]{
            "1. Hokage Pertama Di Naruto Adalah",
            "2. Apaarti Desa Konoha?",
            "3. Siapa Yang Mengajarkan Sharinggan Kepada Naruto?",
            "4. Siapa Bapaknya Naruto",
            "5. Jinchuriki Ekor Berapa yang didapatkan Naruto"

    };

    String[] Jawaban_Kuis = new String[]{
            "Yamato", "Hashirama", "Sarutobi", "Tsunade",
            "Batu", "Daun", "Laut", "Pasir",
            "Itachi", "Sasuke", "Jiraiya", "Kakashi",
            "Minato", "Asuma", "Zabuza", "Danzo",
            "7", "9", "10", "1"
    };

    String[] Jawaban_Benar = new String[]{
            "Hashirama",
            "Daun",
            "Jiraiya",
            "Minato",
            "9"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kuis = (TextView) findViewById(R.id.kuis);
        rg = (RadioGroup) findViewById(R.id.pilihan);
        PilihanA = (RadioButton) findViewById(R.id.PilihanA);
        PilihanB = (RadioButton) findViewById(R.id.PilihanB);
        PilihanC = (RadioButton) findViewById(R.id.PilihanC);
        PilihanD = (RadioButton) findViewById(R.id.PilihanD);
        PilihanE = (RadioButton) findViewById(R.id.PilihanE);

        kuis.setText(pertanyaan_kuis[nomer]);
        PilihanA.setText(Jawaban_Kuis[0]);
        PilihanB.setText(Jawaban_Kuis[1]);
        PilihanC.setText(Jawaban_Kuis[2]);
        PilihanD.setText(Jawaban_Kuis[3]);
        PilihanE.setText(Jawaban_Kuis[4]);

        rg.check(0);
        benar = 0;
        salah = 0;
    }

    public void next (View view) {
        if (PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() || PilihanD.isChecked() || PilihanE.isChecked()) {

            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban.equalsIgnoreCase(Jawaban_Benar[nomer])) benar++;
            else salah++;
            nomer++;
            if (nomer < pertanyaan_kuis.length) {
                kuis.setText(pertanyaan_kuis[nomer]);
                PilihanA.setText(Jawaban_Kuis[(nomer * 4) + 0]);
                PilihanB.setText(Jawaban_Kuis[(nomer * 4) + 1]);
                PilihanC.setText(Jawaban_Kuis[(nomer * 4) + 2]);
                PilihanD.setText(Jawaban_Kuis[(nomer * 4) + 3]);
                PilihanE.setText(Jawaban_Kuis[(nomer * 4) + 4]);
            } else  {
                hasil = benar * 20;
                Intent selesai = new Intent(getApplicationContext(), HasilKuis.class);
                startActivity(selesai);
            }

        }
        else {
            Toast.makeText(this, "Jawab Dulu Gan",Toast.LENGTH_LONG).show();
        }
    }
}