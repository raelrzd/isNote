package rezende.israel.isnote.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import rezende.israel.isnote.R;
import rezende.israel.isnote.model.Nota;
import rezende.israel.isnote.recyclerview.adapter.listener.OnItemClickListener;

public class ListaNotasAdapter extends RecyclerView.Adapter<ListaNotasAdapter.NotaViewHolder> {

    private final List<Nota> notas;
    private final Context context;
    private OnItemClickListener onItemClickListener;

    public ListaNotasAdapter(Context context, List<Nota> notas) {
        this.notas = notas;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ListaNotasAdapter.NotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCriada = criaView(parent);
        return new NotaViewHolder(viewCriada);
    }

    private View criaView(@NonNull ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_nota, parent, false);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaNotasAdapter.NotaViewHolder holder, int position) {
        Nota nota = notas.get(position);
        holder.vincula(nota);
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }


    class NotaViewHolder extends RecyclerView.ViewHolder {

        private final TextView titulo;
        private final TextView descricao;

        public NotaViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.item_nota_titulo);
            descricao = itemView.findViewById(R.id.item_nota_descricao);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick();
                }
            });
        }

        public void vincula(Nota nota) {
            preencheCampos(nota);
        }

        private void preencheCampos(Nota nota) {
            titulo.setText(nota.getTitulo());
            descricao.setText(nota.getDescricao());
        }
    }

    public void adiciona(Nota nota) {
        notas.add(nota);
        notifyDataSetChanged();
    }

}


