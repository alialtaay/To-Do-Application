package com.example.todoapplication.di;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.todoapplication.data.repo.KisilerDaoRepository;
import com.example.todoapplication.room.KisilerDao;
import com.example.todoapplication.room.Veritabani;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public KisilerDaoRepository provideKisilerDaoRepository(KisilerDao kdao){
        return new KisilerDaoRepository(kdao);
    }
    @Provides
    @Singleton
    public KisilerDao provideKisilerDao(@ApplicationContext Context context){
        Veritabani vt = Room.databaseBuilder(context,Veritabani.class,"rehber.db")
                .createFromAsset("rehber.db").build();
        return vt.getKisilerDao();
    }

}
