package com.example.todoapplication.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;

import com.example.todoapplication.data.entity.Kisiler;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface KisilerDao {
    @Query("SELECT * FROM kisiler")
    Single<List<Kisiler>> tumKisiler();

    @Query("SELECT * FROM kisiler WHERE kisi_ad like '%' || :aramaKelimesi || '%'")
    Single<List<Kisiler>> kisiAra(String aramaKelimesi);

    @Delete
    Completable kisiSil(Kisiler kisi);


 }
