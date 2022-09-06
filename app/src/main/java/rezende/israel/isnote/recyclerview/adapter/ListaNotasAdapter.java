package rezende.israel.isnote.recyclerview.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import rezende.israel.isnote.model.Nota;

public class ListaNotasAdapter extends RecyclerView.Adapter {

    private final List<Nota> notas;

    public ListaNotasAdapter(List<Nota> notas) {
        this.notas = notas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return notas.size();
    }
}
