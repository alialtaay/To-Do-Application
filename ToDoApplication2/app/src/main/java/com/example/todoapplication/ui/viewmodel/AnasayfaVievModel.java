package com.example.todoapplication.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.todoapplication.data.entity.Kisiler;
import com.example.todoapplication.data.repo.KisilerDaoRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaVievModel extends ViewModel {
    private  KisilerDaoRepository krepo;
    public MutableLiveData<List<Kisiler>> kisilerListesi = new MutableLiveData();


    @Inject
    public  AnasayfaVievModel(KisilerDaoRepository krepo){
        this.krepo = krepo;
        kisilerYukle();
        kisilerListesi = krepo.kisileriGetir();

    }

    public void ara(String aramaKelimesi){
        krepo.kisiara(aramaKelimesi);
    }
    public void sil(int kisi_id){
        krepo.kisiSil(kisi_id);
}
    public void kisilerYukle(){
       krepo.tumKisileriAl();

    }
}
