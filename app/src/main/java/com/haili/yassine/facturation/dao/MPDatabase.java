package com.haili.yassine.facturation.dao;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.haili.yassine.facturation.model.Client;
import com.haili.yassine.facturation.model.FactureDerails;
import com.haili.yassine.facturation.model.FactureEntete;
import com.haili.yassine.facturation.model.Ste;


@Database(entities = {Ste.class, FactureEntete.class, FactureDerails.class, Client.class}, version = 1, exportSchema = false)
//@TypeConverters({Converter.class}

public abstract class MPDatabase extends RoomDatabase {
    private static volatile MPDatabase INSTANCE;

    // --- INSTANCE ---
    public static MPDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (MPDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MPDatabase.class, "database.db")
                            .allowMainThreadQueries()
                            .addCallback(prepopulateDatabase())
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static Callback prepopulateDatabase() {
        return new Callback() {

            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);

            }
        };
    }

    // ---

    // --- DAO ---
    public abstract MpDao MpDao();

}
