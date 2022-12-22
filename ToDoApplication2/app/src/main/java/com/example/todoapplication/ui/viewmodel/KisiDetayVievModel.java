package com.example.todoapplication.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.todoapplication.data.repo.KisilerDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class KisiDetayVievModel extends ViewModel {
    private KisilerDaoRepository krepo;

    @Inject
    public KisiDetayVievModel(KisilerDaoRepository krepo){
        this.krepo = krepo;
    }

    public void guncelle(int kisi_id, String kisi_ad){
        krepo.kisiGuncelle(kisi_id,kisi_ad);
    }
}
