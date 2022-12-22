package com.example.todoapplication.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todoapplication.R;
import com.example.todoapplication.data.entity.Kisiler;
import com.example.todoapplication.databinding.CardTasarimBinding;
import com.example.todoapplication.ui.fragment.AnaSayfaFragmentDirections;
import com.example.todoapplication.ui.viewmodel.AnasayfaVievModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class KisilerAdapter extends  RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Kisiler> kisilerListesi;
    private AnasayfaVievModel vievModel;

    public KisilerAdapter(Context mContext, List<Kisiler> kisilerListesi, AnasayfaVievModel vievModel) {
        this.mContext = mContext;
        this.kisilerListesi = kisilerListesi;
        this.vievModel = vievModel;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardTasarimBinding binding = DataBindingUtil.inflate(layoutInflater,R.layout.card_tasarim,parent,false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Kisiler kisi = kisilerListesi.get(position);
        CardTasarimBinding t = holder.binding;

      t.setKisiNesnesi(kisi);
        t.imageView.setOnClickListener(view -> {
            Snackbar.make(view,kisi.getKisi_ad()+" Silinsin mi ",Snackbar.LENGTH_LONG)
                    .setAction("Evet",view1 -> {
                        vievModel.sil(kisi.getKisi_id());
                    }).show();

        });

        t.satirCard.setOnClickListener(view -> {
            AnaSayfaFragmentDirections.KisiDetayGecis gecis = AnaSayfaFragmentDirections.kisiDetayGecis(kisi );
            Navigation.findNavController(view).navigate(gecis);
        });

    }

    @Override
    public int getItemCount() {
        return kisilerListesi.size();
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardTasarimBinding binding;

        public CardTasarimTutucu(CardTasarimBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
