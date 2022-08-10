package com.example.cardview.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardview.Model.Postagem;
import com.example.cardview.R;

import org.w3c.dom.Text;

import java.util.List;

public class PostagemAdapter extends RecyclerView.Adapter<PostagemAdapter.MyviewHolder> {

    private List<Postagem> postagens;

    public PostagemAdapter(List<Postagem> p ) {
        this.postagens = p;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.postagem_detalhe,parent, false);

        return new MyviewHolder(itemLista);

    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        Postagem postagem = postagens.get(position);
        holder.nome.setText(postagem.getNome());
        holder.postagem.setText(postagem.getPostagem());
        holder.imagem.setImageResource(postagem.getImagem());
    }

    @Override
    public int getItemCount() {
        return postagens.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{



        private TextView nome;
        private ImageView imagem;
        private TextView postagem;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.textAutor);
            postagem = itemView.findViewById(R.id.textDescricao);
            imagem = itemView.findViewById(R.id.imagemPostagem);
        }
    }

}
