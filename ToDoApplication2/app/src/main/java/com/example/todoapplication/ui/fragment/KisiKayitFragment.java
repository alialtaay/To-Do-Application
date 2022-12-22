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
import com.example.todoapplication.databinding.FragmentKisiKayitBinding;
import com.example.todoapplication.ui.viewmodel.KisiKayitViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class KisiKayitFragment extends Fragment {

    private FragmentKisiKayitBinding binding;
    private KisiKayitViewModel viewModel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_kayit,container,false);
        binding.setKisiKayitFragment(this);
        binding.setKisiKayitToolbarBaslik("Kişi Kayıt");


        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(KisiKayitViewModel.class);
    }

    public void buttonKayit(String kisi_ad){
        viewModel.kisiKayit(kisi_ad);
    }
}