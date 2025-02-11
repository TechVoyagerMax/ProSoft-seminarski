/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seminarski.domain;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author pc
 */
public class Takmicenje {
    private long id;
    private LocalDate datum_odrzavanja;
    private Predmet predmet;
    private NivoTakmicenja nivo;
    private Skola mesto_odrzavanja;
    
    
    public Takmicenje(){
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDatum_odrzavanja() {
        return datum_odrzavanja;
    }

    public void setDatum_odrzavanja(LocalDate datum_odrzavanja) {
        this.datum_odrzavanja = datum_odrzavanja;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public NivoTakmicenja getNivo() {
        return nivo;
    }

    public void setNivo(NivoTakmicenja nivo) {
        this.nivo = nivo;
    }

    public Skola getMesto_odrzavanja() {
        return mesto_odrzavanja;
    }

    public void setMesto_odrzavanja(Skola mesto_odrzavanja) {
        this.mesto_odrzavanja = mesto_odrzavanja;
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
        final Takmicenje other = (Takmicenje) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.datum_odrzavanja, other.datum_odrzavanja)) {
            return false;
        }
        if (!Objects.equals(this.predmet, other.predmet)) {
            return false;
        }
        if (!Objects.equals(this.nivo, other.nivo)) {
            return false;
        }
        return Objects.equals(this.mesto_odrzavanja, other.mesto_odrzavanja);
    }

    @Override
    public String toString() {
        return  nivo+" iz "+predmet;
    }
    
    
}
