package com.example.todoapplication.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.todoapplication.data.repo.KisilerDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class KisiKayitViewModel extends ViewModel {
    private KisilerDaoRepository krepo ;

    @Inject
    public KisiKayitViewModel(KisilerDaoRepository krepo){
        this.krepo = krepo;
    }


    public void kisiKayit(String kisi_ad){
        krepo.kisiKayit(kisi_ad);
    }
}

