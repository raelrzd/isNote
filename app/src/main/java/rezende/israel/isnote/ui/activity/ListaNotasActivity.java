package rezende.israel.isnote.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import rezende.israel.isnote.R;
import rezende.israel.isnote.dao.NotaDAO;
import rezende.israel.isnote.model.Nota;
import rezende.israel.isnote.ui.adapter.ListaNotasAdapter;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        ListView listaNotas = findViewById(R.id.listview);
        NotaDAO dao = new NotaDAO();
        for (int i = 1; i < 10000; i++){
            dao.insere(new Nota("Titulo "+ i, "Descrição "+i));
        }
        List<Nota> todasNotas = dao.todos();
        listaNotas.setAdapter(new ListaNotasAdapter(this, todasNotas));

    }
}