package com.example.todoapplication.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.todoapplication.R;
import com.example.todoapplication.data.entity.Kisiler;
import com.example.todoapplication.databinding.FragmentKisiDetayBinding;
import com.example.todoapplication.ui.viewmodel.KisiDetayVievModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class KisiDetayFragment extends Fragment {
    private FragmentKisiDetayBinding binding;
    private KisiDetayVievModel viewModel;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_detay,container,false);
        binding.setKisiDetayFragment(this);
        binding.setKisiDetayToolbarBaslik("Kişi Detay");

        KisiDetayFragmentArgs bundle = KisiDetayFragmentArgs.fromBundle(getArguments());
        Kisiler geleKisi = bundle.getKisi();

        binding.setKisiNesnesi(geleKisi);



        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(KisiDetayVievModel.class);
    }

    public void button(int kisi_id, String kisi_ad){
        viewModel.guncelle(kisi_id,kisi_ad);
    }
}