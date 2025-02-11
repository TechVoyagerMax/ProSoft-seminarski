/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seminarski.domain;

import java.util.Objects;

/**
 *
 * @author pc
 */
public class StavkaStavkeTakmicenja {
    private long id;
    private Takmicenje takmicenje;
    private StavkaTakmicenja stavka;
    private Ucenik ucenik;
    private Rang rang;
    private int br_poena;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Ucenik getUcenik() {
        return ucenik;
    }

    public void setUcenik(Ucenik ucenik) {
        this.ucenik = ucenik;
    }

    public Rang getRang(){
        return rang;
    }
    
    public void setRang(Rang rang){
        this.rang=rang;
    }

    public int getBr_poena() {
        return br_poena;
    }

    public void setBr_poena(int br_poena) {
        this.br_poena = br_poena;
    }

    public Takmicenje getTakmicenje() {
        return takmicenje;
    }

    public void setTakmicenje(Takmicenje takmicenje) {
        this.takmicenje = takmicenje;
    }

    public StavkaTakmicenja getStavka() {
        return stavka;
    }

    public void setStavka(StavkaTakmicenja stavka) {
        this.stavka = stavka;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StavkaStavkeTakmicenja other = (StavkaStavkeTakmicenja) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.br_poena != other.br_poena) {
            return false;
        }
        if (!Objects.equals(this.takmicenje, other.takmicenje)) {
            return false;
        }
        if (!Objects.equals(this.stavka, other.stavka)) {
            return false;
        }
        if (!Objects.equals(this.ucenik, other.ucenik)) {
            return false;
        }
        return Objects.equals(this.rang, other.rang);
    }

    @Override
    public String toString() {
        return id +" "+ucenik.toString()+" "+stavka.getRazred().toString()+" ";
       // return "StavkaStavkeTakmicenja{" + "id=" + id + ", takmicenje=" + takmicenje + ", stavka=" + stavka + ", ucenik=" + ucenik + ", rand=" + rand + ", br_poena=" + br_poena + '}';
    }
    
    
}
