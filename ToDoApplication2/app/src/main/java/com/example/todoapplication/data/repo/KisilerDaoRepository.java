package com.example.todoapplication.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.todoapplication.data.entity.Kisiler;
import com.example.todoapplication.room.KisilerDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class KisilerDaoRepository {
    private MutableLiveData<List<Kisiler>> kisilerListesi;
    private KisilerDao kdao;

    public KisilerDaoRepository(KisilerDao kdao) {
        this.kdao = kdao;
        kisilerListesi = new MutableLiveData<>();
    }
    public MutableLiveData<List<Kisiler>> kisileriGetir(){
        return kisilerListesi;
    }

    public void kisiKayit(String kisi_ad){
        Log.e("Kişi Kayit",kisi_ad);
    }


    public void kisiGuncelle(int kisi_id, String kisi_ad){
        Log.e("Kişi Güncelle",kisi_id+" - "+kisi_ad);
    }

    public void kisiara(String aramaKelimesi){
        kdao.kisiAra(aramaKelimesi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Kisiler>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Kisiler> kisilers) {
                        kisilerListesi.setValue(kisilers);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void kisiSil(int kisi_id){
        Kisiler silinenKisi = new Kisiler(kisi_id,"");
        kdao.kisiSil(silinenKisi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        tumKisileriAl();

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                }); }





    public void tumKisileriAl(){
       kdao.tumKisiler().subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new SingleObserver<List<Kisiler>>() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onSuccess(List<Kisiler> kisilers) {
                       kisilerListesi.setValue(kisilers);

                   }

                   @Override
                   public void onError(Throwable e) {

                   }
               });


    }
}

