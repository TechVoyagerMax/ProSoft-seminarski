/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seminarski.domain;

/**
 *
 * @author pc
 */
public class Razred {
    private long id;
    private int redni_broj;
    
    public Razred(){
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRedni_broj() {
        return redni_broj;
    }

    public void setRedni_broj(int redni_broj) {
        this.redni_broj = redni_broj;
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
        final Razred other = (Razred) obj;
        if (this.id != other.id) {
            return false;
        }
        return this.redni_broj == other.redni_broj;
    }

    @Override
    public String toString() {
        return redni_broj+"";
    }
    
    
}
