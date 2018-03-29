package kelompok8.com.jembook_apps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class tambahBuku extends AppCompatActivity {

    EditText judul;
    EditText penulis;
    Spinner spinnerGenres;
    Button buttonTambah;

    DatabaseReference databaseBuku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahbuku);

        databaseBuku = FirebaseDatabase.getInstance().getReference("Buku");

        judul = (EditText) findViewById(R.id.judul);
        penulis = (EditText) findViewById(R.id.penulis);
        spinnerGenres = (Spinner) findViewById(R.id.spinnerGenres);
        buttonTambah = (Button) findViewById(R.id.buttonTambah);

        buttonTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void addBuku() {
        String addJudul = judul.getText().toString().trim();
        String addPenulis = penulis.getText().toString().trim();
        String addGenre = spinnerGenres.getSelectedItem().toString();

        if (!TextUtils.isEmpty(addJudul)) {

            String id = databaseBuku.push().getKey();

            Buku buku = new Buku(id, addJudul, addPenulis, addGenre);

            databaseBuku.child(id).setValue(buku);

            Toast.makeText(this, "Buku masuk", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }

}
