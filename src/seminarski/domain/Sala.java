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
public class Sala {
    private Nastavnik nastavnik;
    private Takmicenje takmicenje;
    private StavkaTakmicenja stavka;
    private int broj_sale;
    private String vreme_pocetka;
    private String trajanje;

    public Sala() {
    }

    public Nastavnik getNastavnik() {
        return nastavnik;
    }

    public void setNastavnik(Nastavnik nastavnik) {
        this.nastavnik = nastavnik;
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

    public int getBroj_sale() {
        return broj_sale;
    }

    public void setBroj_sale(int broj_sale) {
        this.broj_sale = broj_sale;
    }

    public String getVreme_pocetka() {
        return vreme_pocetka;
    }

    public void setVreme_pocetka(String vreme_pocetka) {
        this.vreme_pocetka = vreme_pocetka;
    }

    public String getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(String trajanje) {
        this.trajanje = trajanje;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Sala other = (Sala) obj;
        if (this.broj_sale != other.broj_sale) {
            return false;
        }
        if (!Objects.equals(this.vreme_pocetka, other.vreme_pocetka)) {
            return false;
        }
        if (!Objects.equals(this.trajanje, other.trajanje)) {
            return false;
        }
        if (!Objects.equals(this.nastavnik, other.nastavnik)) {
            return false;
        }
        if (!Objects.equals(this.takmicenje, other.takmicenje)) {
            return false;
        }
        return Objects.equals(this.stavka, other.stavka);
    }

    @Override
    public String toString() {
        return "Sala{" + "nastavnik=" + nastavnik + ", takmicenje=" + takmicenje + ", stavka=" + stavka + ", broj_sale=" + broj_sale + ", vreme_pocetka=" + vreme_pocetka + ", trajanje=" + trajanje + '}';
    }

    

    
    
}
