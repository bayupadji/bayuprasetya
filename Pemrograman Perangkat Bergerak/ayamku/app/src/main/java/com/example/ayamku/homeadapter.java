package com.example.ayamku;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class homeadapter extends RecyclerView.Adapter<homeadapter.ViewHolder> {
    ArrayList<home> data;
    OnNoteListener mOnNoteListener;
    Context mContext;

    @NonNull
    @Override
    public homeadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_main, parent, false);
        return new ViewHolder(view,mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull homeadapter.ViewHolder holder, int position) {
        TextView text_nama = holder.textNama;
        TextView text_harga = holder.textHarga;
        ImageView i_gambar = holder.gambar;
        text_nama.setText(data.get(position).getTitle());
        text_harga.setText("RP."+data.get(position).getHarga());

        i_gambar.setImageResource(data.get(position).getImage());

        holder.textNama.setOnClickListener(v ->{
//            Toast.makeText(mContext,data.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            if (data.get(position).getTitle().equals("Paket JukBal")){
                Intent i = new Intent(mContext, DetailProduk.class);
                i.putExtra("GAMBAR_DEFAULT", R.drawable.jerukbali);
                i.putExtra("TEKS_DEFAULT", "Paket JukBal");
                i.putExtra("DESC_DEFAULT", "Berisi Tiket kebun jeruk bali, 1kg buah jeruk bali dan Tour guide kebun jeruk bali");
                mContext.startActivity(i);
            }

            if (data.get(position).getTitle().equals("Paket Mancing")){
                Intent i = new Intent(mContext, DetailProduk.class);
                i.putExtra("GAMBAR_DEFAULT", R.drawable.mancing);
                i.putExtra("TEKS_DEFAULT", "Paket Mancing");
                i.putExtra("DESC_DEFAULT", "Berisi Tiket Mancing dan Sewa Alat pancing");
                mContext.startActivity(i);
            }

            if (data.get(position).getTitle().equals("Tiket Outbound")){
                Intent i = new Intent(mContext, DetailProduk.class);
                i.putExtra("GAMBAR_DEFAULT", R.drawable.outbound);
                i.putExtra("TEKS_DEFAULT", "Tiket Outbound");
                i.putExtra("DESC_DEFAULT", "Berisi Tiket Outbound untuk 1 Orang ");
                mContext.startActivity(i);
            }

            if (data.get(position).getTitle().equals("Tiket Bukit Serut")){
                Intent i = new Intent(mContext, DetailProduk.class);
                i.putExtra("GAMBAR_DEFAULT", R.drawable.puncakserut);
                i.putExtra("TEKS_DEFAULT", "Tiket Bukit Serut");
                i.putExtra("DESC_DEFAULT", "Berisi Tiket Bukit Serut untuk 1 orang");
                mContext.startActivity(i);
            }

            if (data.get(position).getTitle().equals("Tiket Bukit Kunci")){
                Intent i = new Intent(mContext, DetailProduk.class);
                i.putExtra("GAMBAR_DEFAULT", R.drawable.bukitkunci);
                i.putExtra("TEKS_DEFAULT", "Tiket Bukit Kunci");
                i.putExtra("DESC_DEFAULT", "Berisi Tiket Bukit Kunci untuk 1 orang");
                mContext.startActivity(i);
            }

            if (data.get(position).getTitle().equals("Sewa Trail")){
                Intent i = new Intent(mContext, DetailProduk.class);
                i.putExtra("GAMBAR_DEFAULT", R.drawable.trail);
                i.putExtra("TEKS_DEFAULT", "Sewa Trail");
                i.putExtra("DESC_DEFAULT", "Harga Sewa Motor Trail per jam");
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {

        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textNama,textHarga;
        ImageView gambar;

        OnNoteListener onNoteListener;
        private OnNoteListener mOnNoteListener;

        public ViewHolder (@NonNull View itemView, OnNoteListener onNoteListener){
            super(itemView);
            gambar = itemView.findViewById(R.id.image);
            textNama = itemView.findViewById(R.id.title);
            textHarga = itemView.findViewById(R.id.harga);
            this.onNoteListener = onNoteListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    homeadapter(ArrayList<home> data, OnNoteListener onNoteListener, Context context){
        this.data = data;
        this.mContext = context;
        this.mOnNoteListener = onNoteListener;
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}
