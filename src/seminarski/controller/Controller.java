/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seminarski.controller;
import java.util.*;
import seminarski.db.DBBroker;
import seminarski.domain.*;

/**
 *
 * @author pc
 */
public class Controller {
    private static Controller instance;
    private DBBroker dbb;
    
    private Controller(){
        dbb=new DBBroker();
    }
    
    public static Controller getInstance(){
        if(instance==null){
            instance=new Controller();
        }
        return instance;
    }
    
    public String prijaviNastavnik(String korisnickoIme, String sifra){
        return dbb.prijaviNastavnik(korisnickoIme,sifra);
    }
    
    public long kreirajUcenik(Ucenik u){
        return dbb.krairajUcenik(u);
    }
    
    public long kreirajSkola(Skola s){
        return dbb.kreirajSkola(s);
    }
    
//    public long kreirajTerminDezurstva(TerminDezurstva td){
//        return dbb.kreirajTerminDezurstva(td);
//    }
    
    public long kreirajRazred(Razred r){
        return dbb.kreirajRazred(r);
    }
    
//    public long kreirajRang(Rang rr){
//        return dbb.kreirajRang(rr);
//    }
    
    public long kreirajNivo(NivoTakmicenja nt){
        return dbb.kreirajNivo(nt);
    }
    
    public long kreirajPredmet(Predmet p){
        return dbb.kreirajPredmet(p);
    }
    
    public long kreirajNastavnik(Nastavnik n){
        return dbb.kreirajNastavnik(n);
    }
    
    
    public long kreirajTakmicenje(Takmicenje t){
        return dbb.kreirajTakmicenje(t);
    }
    
    public long kreirajStavkuTakmicenja(Takmicenje t, StavkaTakmicenja st){
        return dbb.kreirajStavkuTakmicenja(t, st);
    }
    
    public long kreirajStavkuStavku(Takmicenje t, StavkaTakmicenja st, StavkaStavkeTakmicenja sst){
        return dbb.krairajStavkuStavke(t, st, sst);
    }
    
    public boolean UbaciSalaAsocijativna(Sala s){
        return dbb.UbaciSalaAsocijativna(s);
    }
    
    public ArrayList<Razred> vratiListuSviRazred(){
        return dbb.vratiListuSviRazred();
    }
    
    public ArrayList<NivoTakmicenja> vratiListuSviNivoiTakmicenja(){
        return dbb.vratiListusSviNivoiTakmicenja();
    }
    
    public ArrayList<Skola> vratiListuSviSkola(){
        return dbb.vratiListuSviSkola();
    }
    
    public ArrayList<Predmet> vratiListuSviPredmet(){
        return dbb.vratiListuSviPredmeti();
    }
    
    public ArrayList<Ucenik> vratiListuSviUcenici(){
        return dbb.vratiListuSviUcenik();
    }
    
    public ArrayList<Nastavnik> vratiListuSviNastavnik(){
        return dbb.vratiListaSviNastavnik();
    }
    
//    public ArrayList<TerminDezurstva> vratiListuSviTeminDezurstva(){
//        return dbb.vratiListuSviTerminDezurstva();
//    }
    
    public Takmicenje pretraziTakmicenje(long id){
        return dbb.pretraziTakmicenje(id);
    }
    
    public StavkaTakmicenja pretraziStavkuTakmicenja(long id){
        return dbb.pretraziStavkuTakmicenja(id);
    }
    
    public ArrayList<Sala> vratiListuSveSale(){
        return dbb.vratiListuSveSale();
    }
    
    public ArrayList<Takmicenje> vratiListuSviTakmicenja(){
        return dbb.vatiListuSviTakmicenje();
    }
    
    public ArrayList<StavkaTakmicenja> vratiListuSveStavkeTakmicenja(){
        return dbb.vratiListuSveStavkeTakmicenja();
    }
    
    public ArrayList<Ucenik> vratiListuUcenik(Razred r){
        return dbb.vratiListuUcenik(r);
    }
    
    public ArrayList<Skola> vratiListuSkola(String grad){
        return dbb.vratiListuSkola(grad);
    }
    
//    public ArrayList<TerminDezurstva> vratiListuTerminDezurstva(String vreme){
//        return dbb.vratiListuTerminDezurstva(vreme);
//    }
    
    public ArrayList<Takmicenje> vratiListuTakmicenja(Predmet p){
        return dbb.vratiListuTakmicenja(p);
    }
    
    public ArrayList<Takmicenje> vratiListuTakmicenja(NivoTakmicenja nt){
        return dbb.vratiListuTakmicenja(nt);
    }
    
    public ArrayList<Takmicenje> vratiListuTakmicenja(Skola sk){
        return dbb.vratiListuTakmicenja(sk);
    }
    
    public ArrayList<StavkaTakmicenja> vratiListuStvaki(Predmet p, NivoTakmicenja nt){
        return dbb.vratiListuStavki(p, nt);
    }
    
    public ArrayList<StavkaTakmicenja> vratiListuStavki(Razred r){
        return dbb.vratiListuStavki(r);
    }
    
    public ArrayList<StavkaTakmicenja> vratiListuStavkiTakmicenja(Takmicenje t){
        return dbb.vratiListuStavkiTakmicenja(t);
    }
    
    public ArrayList<StavkaStavkeTakmicenja> vratiListuSveStavkeStavki(StavkaTakmicenja st){
        return dbb.vratiListuSveStavkeStavki(st);
    }
    
    public boolean obrisiSkola(Skola s){
        return dbb.obrisiSkola(s);
    }
    
    public boolean obrisiRazred(Razred r){
        return dbb.obrisiRazred(r);
    }
    
//    public boolean obrisiTerminDezurtsva(TerminDezurstva td){
//        return dbb.obrisiTerminDezurstva(td);
//    }
    
    public boolean obrisiNivoTakmicenja(NivoTakmicenja nt){
        return dbb.obrisiNivoTakmicenja(nt);
    }
    
    public boolean obrisiUcenik(Ucenik u){
        return dbb.obrisiUcenik(u);
    }
    
    public boolean obrisiPredmet(Predmet p){
        return dbb.obrisiPredmet(p);
    }
    
    public boolean obrisiNastavnik(Nastavnik n){
        return dbb.obrisiNastavnik(n);
    }
    
    public boolean obrisiTakmicenje(Predmet p){
        return dbb.obrisiTakmicenje(p);
    }
    
    public boolean obrisiTakmicenje(NivoTakmicenja nt){
        return dbb.obrisiTakmicenje(nt);
    }
    
    public boolean obrisiTakmicenje(Skola sk){
        return dbb.obrisiTakmicenje(sk);
    }
    
    public boolean obrisiStavkuStavke(Ucenik u){
        return dbb.obrisiStvakuStavke(u);
    }
    
    
    public boolean obrisiStavkuTakmicenja(Razred r){
        return dbb.obrisiStavkuTakmicenja(r);
    }
    
    public boolean obrisiStavkuTakmicenja(Takmicenje t){
        return dbb.obrisiStavkuTakmicenja(t);
    }
    
    public boolean obrisiStavkuStavke(StavkaTakmicenja st){
        return dbb.obrisiStavkuStavke(st);
    }
    
    public boolean obrisiSalu(Sala s){
        return dbb.obrisiSalu(s);
    } 
    
    public boolean obrisiSala(Nastavnik n){
        return dbb.obrisiSala(n);
    }
    
    public boolean obrisiSala(Takmicenje t){
        return dbb.obrisiSala(t);
    }
    
    public boolean obrisiSala(StavkaTakmicenja st){
        return dbb.obrisiSala(st);
    }
    
    public Ucenik pretragaUcenik(String jmbg){
        return dbb.pretragaUcenik(jmbg);
    }
    
    public ArrayList<Nastavnik> pretragaNastavnikaIme(Nastavnik n){
        return dbb.pretragaNastvanikaIme(n);
    }
    
    public Nastavnik pretragaNastavnikaKompletno(Nastavnik n){
        return dbb.pretragaNastavnikaKompletno(n);
    }
    
    public long vratiTakmicenejId(StavkaTakmicenja st){
        return dbb.vratiTakmicenjeID(st);
    }
    
    public Takmicenje pretragTakmicenja(StavkaTakmicenja st){
        return dbb.pretragaTakmicenja(st);
    }
    
    public Takmicenje pretragaTakmicneja(Predmet p, NivoTakmicenja nt){
        return dbb.pretragaTakmicenja(p, nt);
    }
    
    public boolean promenaStavkeStavkeTakmicenja(StavkaStavkeTakmicenja sst){
        return dbb.promanaStavkeStavkeTakmicenja(sst);
    }
    
    public boolean promeniUcenik(Ucenik u){
        return dbb.promeniUcenik(u);
    }
    
    public boolean promeniPredmet(Predmet p){
        return dbb.promeniPredmet(p);
    }
    
    public boolean promeniSkola(Skola sk){
        return dbb.promeniSkola(sk);
    }
    
    public boolean promeniNastavnik(Nastavnik n){
        return dbb.promeniNastavnik(n);
    }
    
//    public boolean promeniTerminDezurstva(TerminDezurstva td){
//        return dbb.promeniTerminDezurstva(td);
//    }
    
    
    public boolean promeniSala(Sala sala){
        return dbb.promeniSala(sala);
    }
    
    public ArrayList<Sala> pretraziSala(Nastavnik n){
        return dbb.vratiListuPretraziSala(n);
    }
    
    public ArrayList<Sala> pretraziSala(StavkaTakmicenja stavka){
        return dbb.vratiListuSala(stavka);
    }
    
    public ArrayList<Predmet> vratiListuPredmet(Predmet p){
        return dbb.vratiListuPredmet(p);
    }
}
