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
public class StavkaTakmicenja {
    private long id;
    private Takmicenje takmicenje;
    private Razred razred;
    private int broj_nagrada;
    
    public StavkaTakmicenja(){
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Takmicenje getTakmicenje() {
        return takmicenje;
    }

    public void setTakmicenje(Takmicenje takmicenje) {
        this.takmicenje = takmicenje;
    }

    public Razred getRazred() {
        return razred;
    }

    public void setRazred(Razred razred) {
        this.razred = razred;
    }

    public int getBroj_nagrada() {
        return broj_nagrada;
    }

    public void setBroj_nagrada(int broj_nagrada) {
        this.broj_nagrada = broj_nagrada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final StavkaTakmicenja other = (StavkaTakmicenja) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.broj_nagrada != other.broj_nagrada) {
            return false;
        }
        if (!Objects.equals(this.takmicenje, other.takmicenje)) {
            return false;
        }
        return Objects.equals(this.razred, other.razred);
    }

    @Override
    public String toString() {
       // return "TAKMICENJE IZ NECEGA ZA NEKI RAZRED";
        return takmicenje.getNivo().getNaziv()+" iz "+takmicenje.getPredmet().getNaziv()+" za "+razred.getRedni_broj()+". razred";
    }
    
    
}
