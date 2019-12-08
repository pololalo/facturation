package com.haili.yassine.facturation.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import com.haili.yassine.facturation.model.Client;
import com.haili.yassine.facturation.model.FactureDerails;
import com.haili.yassine.facturation.model.FactureEntete;
import com.haili.yassine.facturation.model.Ste;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface MpDao {

    //Ste
    @Insert(onConflict = REPLACE)
    long addSte(Ste ste);

    @Query("select * from Ste where idSte = :id")
    Ste selectSte(int id);

    //Client
    @Insert(onConflict = REPLACE)
    long addClient(Client client);

    @Insert
    void addClients(List<Client> clients);

    @Update
    void updtaeClient(Client client);

    @Delete
    int deleteClient(Client client);

    @Query("select * from Client where ID_CLIENT = :id")
    Client selectClient(int id);

    @Query("select * from Client ")
    List<Client> selectAllClient();



    @Query("select NOM_CLIENT from Client  order by ID_CLIENT desc")
    List<String> selectNomAllClient();



    @Query("select * from Client where NOM_CLIENT= :nomClient")
    Client selectClientByName(String nomClient);


    //////////////////////// Facture entete + Line

    @Insert(onConflict = REPLACE)
    long addFactureEntete(FactureEntete facture_entete);

    @Insert
    long addLineFacture(FactureDerails facture_details);


    @Query("delete from facturederails where idFacture= :idFacture")
    void deleteFactureDetail(String idFacture);

    @Delete
    void deleteFactureEntete(FactureEntete facture_entete);

    @Query("select * from FactureEntete where idFacture = :idFacture")
    FactureEntete selectFactureById(String idFacture);

    @Query("select * from FactureEntete ")
    List<FactureEntete> selectAllFacture();



    @Query("select * from FactureDerails where idFacture = :idFacture")
    List<FactureDerails> selectLinesFacture(String idFacture);

    @Query("select * from FactureDerails where idDetailFacture = :idDetail")
    FactureDerails selectLineFactureByIdDetail(String idDetail);

    @Update
    void updateFacture(FactureEntete facture_enteteToUpdate);

    @Query("delete from FactureDerails where idDetailFacture= :id_details")
    void deletelineFacture(String id_details);

    @Query("delete from FactureDerails where idDetailFacture= :idFacture")
    void deleteAllLineFacture(String idFacture);

}
