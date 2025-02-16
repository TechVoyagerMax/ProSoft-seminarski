/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seminarski.db;
import java.time.LocalDate;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import seminarski.controller.Controller;
import seminarski.domain.*;


/**
 *
 * @author pc
 */
public class DBBroker {
    
    public String prijaviNastavnik(String korisnickoIme, String sifra){
        String upit="SELECT * FROM nastavnik WHERE username='"+korisnickoIme+"' AND password='"+sifra+"'";
        Connection conn=DBConnection.getInstance().getConnection();
        String rezultat=null;
        try{
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery(upit);
            while(rs.next()){
                rezultat=rs.getString("ime");
            }
            s.close();
            rs.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return "";
        }
        return rezultat;
    }
    
    public long krairajUcenik(Ucenik u){
       String upit="INSERT INTO ucenik (ime, prezime, jmbg, id_razred) VALUES (?, ?, ?, ?)";
       Connection conn=DBConnection.getInstance().getConnection();
       long id=0l;
       try{
           PreparedStatement ps=conn.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, u.getIme());
           ps.setString(2, u.getPrezime());
           ps.setString(3, u.getJmbg());
           ps.setLong(4, u.getRazred().getId());
           ps.executeUpdate();
           ResultSet rs=ps.getGeneratedKeys();
           while(rs.next()){
               id=rs.getLong(1);
           }
           ps.close();
           rs.close();
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
       return id;
    }
    
    public long kreirajRazred(Razred r){
        String upit="INSERT INTO razred (redni_broj) VALUES (?)";
        Connection conn=DBConnection.getInstance().getConnection();
        long l=0l;
        try{
            PreparedStatement ps=conn.prepareStatement(upit,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, r.getRedni_broj());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            while(rs.next()){
                l=rs.getLong(1);
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return l;
    }
    
    
    public long kreirajNivo(NivoTakmicenja nt){
        String upit="INSERT INTO nivo_takmicenja (naziv) VALUES (?)";
        Connection conn=DBConnection.getInstance().getConnection();
        long id=0l;
        try{
            PreparedStatement ps=conn.prepareStatement(upit,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nt.getNaziv());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            while(rs.next()){
                id=rs.getLong(1);
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return id;
    }
    
//    public long kreirajRang(Rang r){
//        String upit="";
//        Connection conn=DBConnection.getInstance().getConnection();
//        long i=0l;
//        if(r.isPrvo_mesto()){
//                upit="INSERT INTO rang (prvo_mesto, prolaz_dalje) VALUES (?,?)";
//            }else if(r.isDrugo_mesto()){
//                upit="INSERT INTO rang (drugo_mesto,prolaz_dalje) VALUES (?,?)";
//            }else if(r.isTrece_mesto()){
//                upit="INSERT INTO rang (trece_mesto,prolaz_dalje) VALUES (?,?)";
//            }
//        try{
//            PreparedStatement ps=conn.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
//            ps.setInt(1, 1);
//            ps.setInt(2, 1);
//            ps.executeUpdate();
//            ResultSet rs=ps.getGeneratedKeys();
//            while(rs.next()){
//                i=rs.getLong(1);
//            }
//            ps.close();
//            rs.close();
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//        return i;
//    }
    
    public long kreirajSkola(Skola s){
        String upit="INSERT INTO skola (naziv, grad) VALUES (?, ?)";
        Connection conn=DBConnection.getInstance().getConnection();
        long id=0l;
        try{
           PreparedStatement ps=conn.prepareStatement(upit,Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, s.getNaziv());
           ps.setString(2, s.getGrad());
           ps.executeUpdate();
           ResultSet rs=ps.getGeneratedKeys();
           while(rs.next()){
               id=rs.getLong(1);
           }
           ps.close();
           rs.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return id;
    }
    
//    public long kreirajTerminDezurstva(TerminDezurstva td){
//        String upit="INSERT INTO termin_dezurstva (vreme_pocetka, trajanje) VALUES (?, ?)";
//        Connection conn=DBConnection.getInstance().getConnection();
//        long id=0l;
//        try{
//            PreparedStatement ps=conn.prepareStatement(upit,Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, td.getVreme_pocetka());
//            ps.setString(2, td.getTrajanje());
//            ps.executeUpdate();
//            ResultSet rs=ps.getGeneratedKeys();
//            while(rs.next()){
//                id=rs.getLong(1);
//            }
//            ps.close();
//            rs.close();
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//        return id;
//    }
    
    
    public long kreirajPredmet(Predmet p){
        String upit="INSERT INTO predmet (naziv) VALUES (?)";
        Connection conn=DBConnection.getInstance().getConnection();
        long id=0l;
        try{
            PreparedStatement ps=conn.prepareStatement(upit,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getNaziv());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            while(rs.next()){
                id=rs.getLong(1);
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return id;
    }
    
    
    public long kreirajNastavnik(Nastavnik n){
        String upit="INSERT INTO nastavnik (ime, prezime, username, password) VALUES (?, ?, ?, ?)";
        Connection conn=DBConnection.getInstance().getConnection();
        long id=0l;
        try{
            PreparedStatement ps=conn.prepareStatement(upit,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, n.getIme());
            ps.setString(2, n.getPrezime());
            ps.setString(3, n.getUsername());
            ps.setString(4, n.getPassword());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            while(rs.next()){
                id=rs.getLong(1);
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return id;
    }
    
    public long kreirajTakmicenje(Takmicenje t){
        String upit="INSERT INTO takmicenje (datum_odrzavanja, id_nivoa, id_predmeta, id_skole) VALUES (?, ?, ?, ?)";
        Connection conn=DBConnection.getInstance().getConnection();
        long id=0l;
        try{
            PreparedStatement ps=conn.prepareStatement(upit,Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, java.sql.Date.valueOf(t.getDatum_odrzavanja()));
            ps.setLong(2, t.getNivo().getId());
            ps.setLong(3, t.getPredmet().getId());
            ps.setLong(4, t.getMesto_odrzavanja().getId());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            while(rs.next()){
                id=rs.getLong(1);
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return id;
    }
    
    public long kreirajStavkuTakmicenja(Takmicenje t, StavkaTakmicenja st){
        String upit="INSERT INTO stavka_takmicenja (id_takmicenja, id_razreda, broj_nagrada) VALUES (?, ?, ?)";
        Connection conn=DBConnection.getInstance().getConnection();
        long id=0l;
        try{
            PreparedStatement ps=conn.prepareStatement(upit,Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, t.getId());
            ps.setLong(2, st.getRazred().getId());
            ps.setInt(3, 0);
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            while(rs.next()){
                id=rs.getLong(1);
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return id;
    }
    
    public long krairajStavkuStavke(Takmicenje t, StavkaTakmicenja st, StavkaStavkeTakmicenja sst){
        String upit="INSERT INTO stavka_stavke_takmicenja (id_takmicenja, id_stavke, id_ucenik, broj_poena, rang) VALUES (?, ?, ?, ?, ?)";
        Connection conn=DBConnection.getInstance().getConnection();
        long id=0l;
        try{
            PreparedStatement ps=conn.prepareStatement(upit,Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, t.getId());
            ps.setLong(2, st.getId());
            ps.setLong(3, sst.getUcenik().getId());
            ps.setInt(4, 0);
            ps.setString(5, String.valueOf(sst.getRang()));
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            while(rs.next()){
                id=rs.getLong(1);
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return id;
    }
    
    public boolean UbaciSalaAsocijativna(Sala s){
        String upit="INSERT INTO sala (id_nastavnik, id_takmicenja, id_stavka, broj_sale, vreme_pocetka_dezurstva, trajanje_dezurstva) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn=DBConnection.getInstance().getConnection();
        try{
            PreparedStatement ps=conn.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, s.getNastavnik().getId());
            ps.setLong(2, s.getTakmicenje().getId());
            ps.setLong(3, s.getStavka().getId());
            ps.setInt(4, s.getBroj_sale());
            ps.setString(5, s.getVreme_pocetka());
            ps.setString(6, s.getTrajanje());
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public ArrayList<Razred> vratiListuSviRazred(){
        ArrayList<Razred> razredi=new ArrayList<Razred>();
        String upit="SELECT * FROM razred";
        Connection conn=DBConnection.getInstance().getConnection();
        try{
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery(upit);
            while(rs.next()){
                Razred r=new Razred();
                r.setId(rs.getLong(1));
                r.setRedni_broj(rs.getInt(2));
                razredi.add(r);
            }
            s.close();
            rs.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return razredi;
    }
    
    public ArrayList<NivoTakmicenja> vratiListusSviNivoiTakmicenja(){
        ArrayList<NivoTakmicenja> lista=new ArrayList<NivoTakmicenja>();
        String upit="SELECT * FROM nivo_takmicenja";
        Connection conn=DBConnection.getInstance().getConnection();
        try{
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery(upit);
            while(rs.next()){
                NivoTakmicenja nt=new NivoTakmicenja();
                nt.setId(rs.getLong(1));
                nt.setNaziv(rs.getString(2));
                lista.add(nt);
            }
            s.close();
            rs.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    public ArrayList<Skola> vratiListuSviSkola(){
        ArrayList<Skola> list=new ArrayList<Skola>();
        String upit="SELECT * FROM skola";
        Connection conn=DBConnection.getInstance().getConnection();
        try{
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery(upit);
            while(rs.next()){
                Skola ss=new Skola();
                ss.setId(rs.getLong("id"));
                ss.setNaziv(rs.getString("naziv"));
                ss.setGrad(rs.getString("grad"));
                list.add(ss);
            }
            s.close();
            rs.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }
    
     public ArrayList<Predmet> vratiListuSviPredmeti(){
        ArrayList<Predmet> list=new ArrayList<Predmet>();
        String upit="SELECT * FROM predmet";
        Connection conn=DBConnection.getInstance().getConnection();
        try{
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery(upit);
            while(rs.next()){
                Predmet pp=new Predmet();
                pp.setId(rs.getLong("id"));
                pp.setNaziv(rs.getString("naziv"));
                list.add(pp);
            }
            s.close();
            rs.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return list;
    }
     
     public ArrayList<Ucenik> vratiListuSviUcenik(){
        ArrayList<Ucenik> list=new ArrayList<Ucenik>();
        String upit="SELECT u.*,r.* FROM ucenik u JOIN razred r ON u.id_razred=r.id";
        Connection conn=DBConnection.getInstance().getConnection();
        try{
            Statement stat=conn.createStatement();
            ResultSet rs=stat.executeQuery(upit);
            while(rs.next()){
                Ucenik u=new Ucenik();
                u.setId(rs.getLong("u.id"));
                u.setIme(rs.getString("u.ime"));
                u.setPrezime(rs.getString("u.prezime"));
                u.setJmbg(rs.getString("u.jmbg"));
                Razred r=new Razred();
                r.setId(rs.getLong("r.id"));
                r.setRedni_broj(rs.getInt("r.redni_broj"));
                u.setRazred(r);
                list.add(u);
            }
            stat.close();
            rs.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }
     
     public ArrayList<Nastavnik> vratiListaSviNastavnik(){
         ArrayList<Nastavnik> lista=new ArrayList<Nastavnik>();
         String upit="SELECT * FROM nastavnik";
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                 Nastavnik n=new Nastavnik();
                 n.setId(rs.getLong("id"));
                 n.setIme(rs.getString("ime"));
                 n.setPrezime(rs.getString("prezime"));
                 n.setUsername(rs.getString("username"));
                 lista.add(n);
             }
             s.close();
             rs.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return lista;
     }
     
     
//     public ArrayList<TerminDezurstva> vratiListuSviTerminDezurstva(){
//         ArrayList<TerminDezurstva> list=new ArrayList<TerminDezurstva>();
//         String upit="SELECT * FROM termin_dezurstva";
//         Connection conn=DBConnection.getInstance().getConnection();
//         try{
//             Statement s=conn.createStatement();
//             ResultSet rs=s.executeQuery(upit);
//             while(rs.next()){
//                 TerminDezurstva td=new TerminDezurstva();
//                 td.setId(rs.getLong("id"));
//                 td.setTrajanje(rs.getString("trajanje"));
//                 td.setVreme_pocetka(rs.getString("vreme_pocetka"));
//                 list.add(td);
//             }
//             s.close();
//             rs.close();
//         }catch(SQLException e){
//             System.out.println(e.getMessage());
//         }
//         return list;
//     }
     
     public Takmicenje pretraziTakmicenje(long id){
         Takmicenje t=new Takmicenje();
         String upit="SELECT t.*,nt.*,p.*,sk.* FROM takmicenje t JOIN nivo_takmicenja nt ON t.id_nivoa=nt.id JOIN predmet p ON t.id_predmeta=p.id JOIN skola sk ON t.id_skole=sk.id WHERE t.id="+id;
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                 NivoTakmicenja nivo=new NivoTakmicenja();
                 nivo.setId(rs.getLong("nt.id"));
                 nivo.setNaziv(rs.getString("nt.naziv"));
                 t.setNivo(nivo);
                 Predmet p=new Predmet();
                 p.setId(rs.getLong("p.id"));
                 p.setNaziv(rs.getString("p.naziv"));
                 t.setPredmet(p);
                 Skola sk=new Skola();
                 sk.setId(rs.getLong("sk.id"));
                 sk.setNaziv(rs.getString("sk.naziv"));
                 sk.setGrad(rs.getString("sk.grad"));
                 t.setMesto_odrzavanja(sk);
                 t.setId(id);
                 LocalDate ld=new java.sql.Date(rs.getDate("t.datum_odrzavanja").getTime()).toLocalDate();
                 t.setDatum_odrzavanja(ld);
             }
             s.close();
             rs.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return t;
     }
     
     
     public StavkaTakmicenja pretraziStavkuTakmicenja(long id){
         StavkaTakmicenja st=new StavkaTakmicenja();
         String upit="SELECT st.*,t.*,r.* FROM stavka_takmicenja st JOIN takmicenje t ON st.id_takmicenja=t.id JOIN razred r ON st.id_razreda=r.id WHERE st.id="+id;
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                 Takmicenje t=Controller.getInstance().pretraziTakmicenje(rs.getLong("t.id"));
                 st.setTakmicenje(t);
                 Razred r=new Razred();
                 r.setId(rs.getLong("r.id"));
                 r.setRedni_broj(rs.getInt("r.redni_broj"));
                 st.setRazred(r);
                 st.setId(id);
                 st.setBroj_nagrada(rs.getInt("st.broj_nagrada"));
             }
             s.close();
             rs.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return st;
     }
     
     public ArrayList<Sala> vratiListuSveSale(){
         ArrayList<Sala> list=new ArrayList<Sala>();
         String upit="SELECT s.*,t.*,n.*,st.* FROM sala s JOIN nastavnik n ON s.id_nastavnik=n.id JOIN takmicenje t ON s.id_takmicenja=t.id JOIN stavka_takmicenja st ON s.id_stavka=st.id";
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                 Sala sala=new Sala();
                 sala.setBroj_sale(rs.getInt("s.broj_sale"));
                 sala.setTrajanje(rs.getString("s.trajanje_dezurstva"));
                 sala.setVreme_pocetka(rs.getString("s.vreme_pocetka_dezurstva"));
                 Nastavnik n=new Nastavnik();
                 n.setId(rs.getLong("n.id"));
                 n.setIme(rs.getString("n.ime"));
                 n.setPrezime(rs.getString("n.prezime"));
                 n.setUsername(rs.getString("n.username"));
                 sala.setNastavnik(n);
                 Takmicenje t=Controller.getInstance().pretraziTakmicenje(rs.getLong("t.id"));
                 StavkaTakmicenja st=Controller.getInstance().pretraziStavkuTakmicenja(rs.getLong("st.id"));
                 sala.setTakmicenje(t);
                 sala.setStavka(st);
                 list.add(sala);
             }
             s.close();
             rs.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return list;
     }
     
     
     
     public ArrayList<Takmicenje> vatiListuSviTakmicenje(){
         ArrayList<Takmicenje> list=new ArrayList<Takmicenje>();
         String upit="SELECT t.*,nt.*,p.*,sk.* FROM takmicenje t JOIN nivo_takmicenja nt ON t.id_nivoa=nt.id JOIN predmet p ON t.id_predmeta=p.id JOIN skola sk ON t.id_skole=sk.id";
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                 Takmicenje t=new Takmicenje();
                 t.setId(rs.getLong("t.id"));
                 LocalDate ld=new java.sql.Date(rs.getDate("t.datum_odrzavanja").getTime()).toLocalDate();
                 t.setDatum_odrzavanja(ld);
                 NivoTakmicenja nt=new NivoTakmicenja();
                 nt.setId(rs.getLong("nt.id"));
                 nt.setNaziv(rs.getString("nt.naziv"));
                 t.setNivo(nt);
                 Predmet p=new Predmet();
                 p.setId(rs.getLong("p.id"));
                 p.setNaziv(rs.getString("p.naziv"));
                 t.setPredmet(p);
                 Skola sk=new Skola();
                 sk.setId(rs.getLong("sk.id"));
                 sk.setNaziv(rs.getString("sk.naziv"));
                 sk.setGrad(rs.getString("sk.grad"));
                 t.setMesto_odrzavanja(sk);
                 list.add(t);
             }
             s.close();
             rs.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return list;
     }
     
     public ArrayList<StavkaTakmicenja> vratiListuSveStavkeTakmicenja(){
         ArrayList<StavkaTakmicenja> list=new ArrayList<StavkaTakmicenja>();
         String upit="SELECT st.*,t.*,r.* FROM stavka_takmicenja st JOIN razred r ON st.id_razreda=r.id JOIN takmicenje t ON st.id_takmicenja=t.id";
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                 StavkaTakmicenja st=new StavkaTakmicenja();
                 st.setId(rs.getLong("st.id"));
                 st.setBroj_nagrada(rs.getInt("st.broj_nagrada"));
                 Razred r=new Razred();
                 r.setId(rs.getLong("r.id"));
                 r.setRedni_broj(rs.getInt("r.redni_broj"));
                 st.setRazred(r);
                 Takmicenje t=new Takmicenje();
                 t.setId(rs.getLong("t.id"));
                 st.setTakmicenje(t);
                 list.add(st);
             }
             s.close();
             rs.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return list;
     }
     
     public ArrayList<Ucenik> vratiListuUcenik(Razred razred){
         ArrayList<Ucenik> lista=new ArrayList<Ucenik>();
         String upit="SELECT u.*,r.* FROM ucenik u JOIN razred r ON u.id_razred=r.id WHERE u.id_razred="+razred.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                 Ucenik u=new Ucenik();
                 u.setId(rs.getLong("u.id"));
                 u.setIme(rs.getString("u.ime"));
                 u.setJmbg(rs.getString("u.jmbg"));
                 u.setPrezime(rs.getString("u.prezime"));
                 Razred r=new Razred();
                 r.setId(rs.getLong("r.id"));
                 r.setRedni_broj(rs.getInt("r.redni_broj"));
                 u.setRazred(r);
                 lista.add(u);
             }
             s.close();
             rs.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return lista;
     }
     
     public ArrayList<Skola> vratiListuSkola(String grad){
         ArrayList<Skola> list=new ArrayList<Skola>();
         String upit="SELECT * FROM skola WHERE grad LIKE '"+grad+"%'";
         Connection con=DBConnection.getInstance().getConnection();
         try{
             Statement s=con.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                 Skola skola=new Skola();
                 skola.setId(rs.getLong("id"));
                 skola.setNaziv(rs.getString("naziv"));
                 skola.setGrad(rs.getString("grad"));
                 list.add(skola);
             }
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return list;
    }
     
//     public ArrayList<TerminDezurstva> vratiListuTerminDezurstva(String vreme){
//         ArrayList<TerminDezurstva> list=new ArrayList<TerminDezurstva>();
//         String upit="SELECT * FROM termin_dezurstva WHERE vreme_pocetka='"+vreme+"'";
//         Connection conn=DBConnection.getInstance().getConnection();
//         try{
//             Statement s=conn.createStatement();
//             ResultSet rs=s.executeQuery(upit);
//             while(rs.next()){
//                 TerminDezurstva dez=new TerminDezurstva();
//                 dez.setId(rs.getLong("id"));
//                 dez.setVreme_pocetka(rs.getString("vreme_pocetka"));
//                 dez.setTrajanje(rs.getString("trajanje"));
//                 list.add(dez);
//             }
//             s.close();
//             rs.close();
//         }catch(SQLException e){
//             System.out.println(e.getMessage());
//         }
//         return list;
//     }
     
     public ArrayList<Takmicenje> vratiListuTakmicenja(Predmet predmet){
         ArrayList<Takmicenje> list=new ArrayList<Takmicenje>();
         String upit="SELECT t.*,p.*,nt.*,sk.* FROM takmicenje t JOIN nivo_takmicenja nt ON t.id_nivoa=nt.id JOIN predmet p ON t.id_predmeta=p.id JOIN skola sk ON t.id_skole=sk.id WHERE t.id_predmeta="+predmet.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                 Takmicenje t=new Takmicenje();
                 t.setId(rs.getLong("t.id"));
                 LocalDate datum=new java.sql.Date(rs.getDate("t.datum_odrzavanja").getTime()).toLocalDate();
                 t.setDatum_odrzavanja(datum);
                 Skola skola=new Skola();
                 skola.setId(rs.getLong("sk.id"));
                 skola.setNaziv(rs.getString("sk.naziv"));
                 skola.setGrad(rs.getString("sk.grad"));
                 t.setMesto_odrzavanja(skola);
                 NivoTakmicenja nivo=new NivoTakmicenja();
                 nivo.setId(rs.getLong("nt.id"));
                 nivo.setNaziv(rs.getString("nt.naziv"));
                 t.setNivo(nivo);
                 Predmet p=new Predmet();
                 p.setId(rs.getLong("p.id"));
                 p.setNaziv(rs.getString("p.naziv"));
                 t.setPredmet(p);
                 list.add(t);
             }
             s.close();
             rs.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return list;
     }
     
     
     public ArrayList<StavkaTakmicenja> vratiListuStavki(Predmet p, NivoTakmicenja nt){
         ArrayList<StavkaTakmicenja> list=new ArrayList<StavkaTakmicenja>();
         String upit="SELECT st.*,t.*,r.* FROM stavka_takmicenja st JOIN takmicenje t ON st.id_takmicenja=t.id JOIN razred r ON st.id_razreda=r.id WHERE t.id_predmeta="+p.getId()+" AND t.id_nivoa="+nt.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                 StavkaTakmicenja st=new StavkaTakmicenja();
                 st.setId(rs.getLong("st.id"));
                 Razred r=new Razred();
                 r.setId(rs.getLong("r.id"));
                 r.setRedni_broj(rs.getInt("r.redni_broj"));
                 st.setRazred(r);
                 Takmicenje t=Controller.getInstance().pretragaTakmicneja(p, nt);
                 st.setTakmicenje(t);
                 list.add(st);
             }
             s.close();
             rs.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return list;
     }
     
     
     
     
     public ArrayList<Takmicenje> vratiListuTakmicenja(NivoTakmicenja nivo){
         ArrayList<Takmicenje> list=new ArrayList<Takmicenje>();
         String upit="SELECT t.*,p.*,nt.*,sk.* FROM takmicenje t JOIN nivo_takmicenja nt ON t.id_nivoa=nt.id JOIN predmet p ON t.id_predmeta=p.id JOIN skola sk ON t.id_skole=sk.id WHERE t.id_nivoa="+nivo.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                 Takmicenje t=new Takmicenje();
                 t.setId(rs.getLong("t.id"));
                 LocalDate datum=new java.sql.Date(rs.getDate("t.datum_odrzavanja").getTime()).toLocalDate();
                 t.setDatum_odrzavanja(datum);
                 Skola skola=new Skola();
                 skola.setId(rs.getLong("sk.id"));
                 skola.setNaziv(rs.getString("sk.naziv"));
                 skola.setGrad(rs.getString("sk.grad"));
                 t.setMesto_odrzavanja(skola);
                 NivoTakmicenja nivoTakm=new NivoTakmicenja();
                 nivoTakm.setId(rs.getLong("nt.id"));
                 nivoTakm.setNaziv(rs.getString("nt.naziv"));
                 t.setNivo(nivo);
                 Predmet p=new Predmet();
                 p.setId(rs.getLong("p.id"));
                 p.setNaziv(rs.getString("p.naziv"));
                 t.setPredmet(p);
                 list.add(t);
             }
             s.close();
             rs.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return list;
     }
     
     
     public ArrayList<Takmicenje> vratiListuTakmicenja(Skola sk){
         ArrayList<Takmicenje> list=new ArrayList<Takmicenje>();
         String upit="SELECT sk.*,t.* FROM takmicenje t JOIN skola sk ON t.id_skole=sk.id WHERE t.id_skole="+sk.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                 Takmicenje tak=new Takmicenje();
                 tak.setId(rs.getLong("t.id"));
                 Skola skola=new Skola();
                 skola.setId(rs.getLong("sk.id"));
                 skola.setNaziv(rs.getString("sk.naziv"));
                 list.add(tak);
             }
             s.close();
             rs.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return list;
     }
     
     
     public ArrayList<StavkaTakmicenja> vratiListuStavki(Razred razred){
         ArrayList<StavkaTakmicenja> list=new ArrayList<StavkaTakmicenja>();
         String upit="SELECT st.*,r.*,t.*,nt.*,p.* FROM stavka_takmicenja st JOIN razred r ON st.id_razreda=r.id JOIN takmicenje t ON st.id_takmicenja=t.id JOIN nivo_takmicenja nt ON t.id_nivoa=nt.id JOIN predmet p ON p.id=t.id_predmeta WHERE r.id="+razred.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                 StavkaTakmicenja stavka=new StavkaTakmicenja();
                 stavka.setId(rs.getLong("st.id"));
                 stavka.setBroj_nagrada(rs.getInt("st.broj_nagrada"));
                 Razred r=new Razred();
                 r.setId(rs.getLong("r.id"));
                 r.setRedni_broj(rs.getInt("r.redni_broj"));
                 stavka.setRazred(r);
                 Takmicenje t=new Takmicenje();
                 t.setId(rs.getLong("t.id"));
                 NivoTakmicenja ntt=new NivoTakmicenja();
                 ntt.setId(rs.getLong("nt.id"));
                 ntt.setNaziv(rs.getString("nt.naziv"));
                 t.setNivo(ntt);
                 Predmet pr=new Predmet();
                 pr.setId(rs.getLong("p.id"));
                 pr.setNaziv(rs.getString("p.naziv"));
                 t.setPredmet(pr);
                 stavka.setTakmicenje(t);
                 list.add(stavka);
             }
             s.close();
             rs.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return list;
     }
     
     public ArrayList<StavkaTakmicenja> vratiListuStavkiTakmicenja(Takmicenje t){
         ArrayList<StavkaTakmicenja> list=new ArrayList<StavkaTakmicenja>();
         String upit="SELECT st.*,t.*,r.* FROM stavka_takmicenja st JOIN takmicenje t ON st.id_takmicenja=t.id JOIN razred r ON st.id_razreda=r.id WHERE st.id_takmicenja="+t.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                StavkaTakmicenja st=new StavkaTakmicenja();
                st.setId(rs.getLong("st.id"));
                st.setTakmicenje(t);
                Razred r=new Razred();
                r.setId(rs.getLong("r.id"));
                r.setRedni_broj(rs.getInt("r.redni_broj"));
                st.setRazred(r);
                list.add(st);
             }
             s.close();
             rs.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return list;
     }
     
     
     public ArrayList<StavkaStavkeTakmicenja> vratiListuSveStavkeStavki(StavkaTakmicenja st){
         ArrayList<StavkaStavkeTakmicenja> list=new ArrayList<StavkaStavkeTakmicenja>();
         String upit="SELECT sst.*,u.* FROM stavka_stavke_takmicenja sst JOIN ucenik u ON sst.id_ucenik=u.id WHERE sst.id_stavke="+st.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                 StavkaStavkeTakmicenja sst=new StavkaStavkeTakmicenja();
                 sst.setId(rs.getLong("sst.rb"));
                 sst.setBr_poena(rs.getInt("sst.broj_poena"));
                 Ucenik u=new Ucenik();
                 u.setId(rs.getLong("u.id"));
                 u.setIme(rs.getString("u.ime"));
                 u.setPrezime(rs.getString("u.prezime"));
                 u.setJmbg(rs.getString("u.jmbg"));
                 sst.setUcenik(u);
                 sst.setRang(Rang.valueOf(rs.getString("sst.rang")));
                 sst.setStavka(st);
                 Takmicenje t=Controller.getInstance().pretragTakmicenja(st);
                 sst.setTakmicenje(t);
                 list.add(sst);
             }
             s.close();
             rs.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return list;
     }
     
     public boolean obrisiSkola(Skola sk){
         String upit="DELETE FROM skola WHERE id="+sk.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             s.executeUpdate(upit);
             s.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     public boolean obrisiRazred(Razred r){
         String upit="DELETE FROM razred WHERE id="+r.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             s.executeUpdate(upit);
             s.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
//     public boolean obrisiTerminDezurstva(TerminDezurstva td){
//         String upit="DELETE FROM termin_dezurstva WHERE id="+td.getId();
//         Connection conn=DBConnection.getInstance().getConnection();
//         try{
//             Statement s=conn.createStatement();
//             s.executeUpdate(upit);
//             s.close();
//         }catch(SQLException e){
//             System.out.println(e.getMessage());
//             return false;
//         }
//         return true;
//     }
     
     public boolean obrisiNivoTakmicenja(NivoTakmicenja nt){
         String upit="DELETE FROM nivo_takmicenja WHERE id="+nt.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             s.executeUpdate(upit);
             s.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     public boolean obrisiUcenik(Ucenik u){
         String upit="DELETE FROM ucenik WHERE id="+u.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             s.executeUpdate(upit);
             s.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     public boolean obrisiPredmet(Predmet p){
         String upit="DELETE FROM predmet WHERE id="+p.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             s.executeUpdate(upit);
             s.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     public boolean obrisiNastavnik(Nastavnik n){
         String upit="DELETE FROM nastavnik WHERE id="+n.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             s.executeUpdate(upit);
             s.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     public boolean obrisiTakmicenje(Predmet p){
         String upit="DELETE FROM takmicenje WHERE id_predmeta="+p.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             s.executeUpdate(upit);
             s.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     public boolean obrisiTakmicenje(NivoTakmicenja nt){
         String upit="DELETE FROM takmicenje WHERE id_nivoa="+nt.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
            Statement s=conn.createStatement();
            s.executeUpdate(upit);
            s.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     
     public boolean obrisiTakmicenje(Skola sk){
         String upit="DELETE FROM takmicenje WHERE id_skole="+sk.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             s.executeUpdate(upit);
             s.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     public boolean obrisiStvakuStavke(Ucenik u){
         String upit="DELETE FROM stavka_stavke_takmicenja WHERE id_ucenik="+u.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             s.executeUpdate(upit);
             s.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     public boolean obrisiStavkuTakmicenja(Razred r){
         String upit="DELETE FROM stavka_takmicenja WHERE id_razreda="+r.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             s.executeUpdate(upit);
             s.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     public boolean obrisiStavkuTakmicenja(Takmicenje t){
         String upit="DELETE FROM stavka_takmicenja WHERE id_takmicenja="+t.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             s.executeUpdate(upit);
             s.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     public boolean obrisiStavkuStavke(StavkaTakmicenja st){
         String upit="DELETE FROM stavka_stavke_takmicenja WHERE id_stavke="+st.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             s.executeUpdate(upit);
             s.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     
     public boolean obrisiSalu(Sala sala){
         String upit="DELETE FROM sala WHERE id_nastavnik="+sala.getNastavnik().getId()+" AND id_takmicenja="+sala.getTakmicenje().getId()+" AND id_stavka="+sala.getStavka().getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             s.executeUpdate(upit);
             s.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     public boolean obrisiSala(Nastavnik n){
         String upit="DELETE FROM sala WHERE id_nastavnik="+n.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             s.executeUpdate(upit);
             s.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     public boolean obrisiSala(Takmicenje t){
         String upit="DELETE FROM sala WHERE id_takmicenja="+t.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             s.executeUpdate(upit);
             s.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     public boolean obrisiSala(StavkaTakmicenja st){
         String upit="DELETE FROM sala WHERE id_stavka="+st.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             s.executeUpdate(upit);
             s.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     
     public Ucenik pretragaUcenik(String jmbg){
         Ucenik u=new Ucenik();
         String upit="SELECT u.*,r.* FROM ucenik u JOIN razred r ON u.id_razred=r.id WHERE u.jmbg='"+jmbg+"'";
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                 u.setId(rs.getLong("u.id"));
                 u.setIme(rs.getString("u.ime"));
                 u.setPrezime(rs.getString("u.prezime"));
                 u.setJmbg(rs.getString("u.jmbg"));
                 Razred rr=new Razred();
                 rr.setId(rs.getLong("r.id"));
                 rr.setRedni_broj(rs.getInt("r.redni_broj"));
                 u.setRazred(rr);
             }
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return null;
         }
         return u;
     }
     
     public ArrayList<Nastavnik> pretragaNastvanikaIme(Nastavnik prosledjen){
         String upit="SELECT * FROM nastavnik WHERE ime='"+prosledjen.getIme()+"'";
         Connection conn=DBConnection.getInstance().getConnection();
         ArrayList<Nastavnik> list=new ArrayList<Nastavnik>();
         try{
             Statement s=conn.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                 Nastavnik n= new Nastavnik();
                 n.setId(rs.getLong("id"));
                 n.setIme(rs.getString("ime"));
                 n.setPrezime(rs.getString("prezime"));
                 n.setUsername(rs.getString("username"));
                 list.add(n);
             }
             s.close();
             rs.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return list;
     }
     
     public Nastavnik pretragaNastavnikaKompletno(Nastavnik prosledjen){
         String upit="SELECT * FROM nastavnik WHERE ime='"+prosledjen.getIme()+"' AND prezime='"+prosledjen.getPrezime()+"'";
         Connection conn=DBConnection.getInstance().getConnection();
         Nastavnik n=null;
         try{
             Statement s=conn.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                 n=new Nastavnik();
                 n.setId(rs.getLong("id"));
                 n.setIme(rs.getString("ime"));
                 n.setPrezime(rs.getString("prezime"));
                 n.setUsername(rs.getString("username"));
             }
             s.close();
             rs.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return null;
         }
         return n;
     }
     
     public long vratiTakmicenjeID(StavkaTakmicenja st){
         long i=0l;
         String upit="SELECT id_takmicenja FROM stavka_takmicenja WHERE id="+st.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                 i=rs.getLong("id_takmicenja");
             }
             s.close();
             rs.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return i;
         }
         return i;
     }
     
     
     public Takmicenje pretragaTakmicenja(StavkaTakmicenja st){
         Takmicenje pronadjen=new Takmicenje();
         String upit="SELECT t.*,nt.*,p.* FROM takmicenje t JOIN nivo_takmicenja nt ON t.id_nivoa=nt.id JOIN predmet p ON t.id_predmeta=p.id WHERE t.id="+Controller.getInstance().vratiTakmicenejId(st);
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                 pronadjen.setId(rs.getLong("t.id"));
                 NivoTakmicenja nivo=new NivoTakmicenja();
                 nivo.setId(rs.getLong("nt.id"));
                 nivo.setNaziv(rs.getString("nt.naziv"));
                 Predmet p=new Predmet();
                 p.setId(rs.getLong("p.id"));
                 p.setNaziv(rs.getString("p.naziv"));
                 pronadjen.setNivo(nivo);
                 pronadjen.setPredmet(p);
             }
             s.close();
             rs.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return pronadjen;
        }
     
     public Takmicenje pretragaTakmicenja(Predmet p, NivoTakmicenja nt){
         Takmicenje pronadjen=new Takmicenje();
         String upit="SELECT t.*,p.*,nt.* FROM takmicenje t JOIN predmet p ON t.id_predmeta=p.id JOIN nivo_takmicenja nt ON t.id_nivoa=nt.id WHERE t.id_predmeta="+p.getId()+" AND t.id_nivoa="+nt.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                 pronadjen.setId(rs.getLong("t.id"));
                 Predmet pp=new Predmet();
                 pp.setId(rs.getLong("p.id"));
                 pp.setNaziv(rs.getString("p.naziv"));
                 pronadjen.setPredmet(pp);
                 NivoTakmicenja nnt=new NivoTakmicenja();
                 nnt.setId(rs.getLong("nt.id"));
                 nnt.setNaziv(rs.getString("nt.naziv"));
                 pronadjen.setNivo(nnt);
             }
             s.close();
             rs.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return pronadjen;
     }
     
     public boolean promanaStavkeStavkeTakmicenja(StavkaStavkeTakmicenja sst){
         String upit="UPDATE stavka_stavke_takmicenja SET broj_poena=?, rang=? WHERE rb="+sst.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             PreparedStatement ps=conn.prepareStatement(upit);
             ps.setInt(1, sst.getBr_poena());
             ps.setString(2, String.valueOf(sst.getRang()));
             ps.executeUpdate();
             ps.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     public boolean promeniUcenik(Ucenik u){
         String upit="UPDATE ucenik SET ime=?, prezime=?, id_razred=? WHERE jmbg='"+u.getJmbg()+"'";
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             PreparedStatement ps=conn.prepareStatement(upit);
             ps.setString(1, u.getIme());
             ps.setString(2, u.getPrezime());
             ps.setLong(3, u.getRazred().getId());
             ps.executeUpdate();
             ps.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     
     public boolean promeniPredmet(Predmet p){
         String upit="UPDATE predmet SET naziv=? WHERE id="+p.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             PreparedStatement ps=conn.prepareStatement(upit);
             ps.setString(1, p.getNaziv());
             ps.executeUpdate();
             ps.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     
     public boolean promeniSkola(Skola sk){
         String upit="UPDATE skola SET naziv=? WHERE id="+sk.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             PreparedStatement ps=conn.prepareStatement(upit);
             ps.setString(1, sk.getNaziv());
             ps.executeUpdate();
             ps.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     public boolean promeniNastavnik(Nastavnik n){
         String upit="UPDATE nastavnik SET ime=?, prezime=?, username=? WHERE id="+n.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             PreparedStatement ps=conn.prepareStatement(upit);
             ps.setString(1, n.getIme());
             ps.setString(2, n.getPrezime());
             ps.setString(3, n.getUsername());
             ps.executeUpdate();
             ps.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     
     
//     public boolean promeniTerminDezurstva(TerminDezurstva td){
//         String upit="UPDATE termin_dezurstva SET vreme_pocetka=?, trajanje=? WHERE id="+td.getId();
//         Connection conn=DBConnection.getInstance().getConnection();
//         try{
//             PreparedStatement ps=conn.prepareStatement(upit);
//             ps.setString(1, td.getVreme_pocetka());
//             ps.setString(2, td.getTrajanje());
//             ps.executeUpdate();
//             ps.close();
//         }catch(SQLException e){
//             System.out.println(e.getMessage());
//             return false;
//         }
//         return true;
//     }
     
     public boolean promeniSala(Sala sala){
         String upit="UPDATE sala SET vreme_pocetka_dezurstva=?, trajanje_dezurstva=?, broj_sale=? WHERE id_nastavnik="+sala.getNastavnik().getId()+" AND id_takmicenja="+sala.getTakmicenje().getId()+" AND id_stavka="+sala.getStavka().getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             PreparedStatement ps=conn.prepareStatement(upit);
             ps.setString(1, sala.getVreme_pocetka());
             ps.setString(2, sala.getTrajanje());
             ps.setInt(3, sala.getBroj_sale());
             ps.executeUpdate();
             ps.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
             return false;
         }
         return true;
     }
     
     
     public ArrayList<Sala> vratiListuPretraziSala(Nastavnik nast){
         ArrayList<Sala> pronadjena=new ArrayList<Sala>();
         String upit="SELECT s.*,t.*,n.*,st.* FROM sala s JOIN nastavnik n ON s.id_nastavnik=n.id JOIN takmicenje t ON s.id_takmicenja=t.id JOIN stavka_takmicenja st ON s.id_stavka=st.id WHERE id_nastavnik="+nast.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement stat=conn.createStatement();
             ResultSet rs=stat.executeQuery(upit);
             while(rs.next()){
                 Sala sala=new Sala();
                 sala.setBroj_sale(rs.getInt("s.broj_sale"));
                 sala.setTrajanje(rs.getString("s.trajanje_dezurstva"));
                 sala.setVreme_pocetka(rs.getString("s.vreme_pocetka_dezurstva"));
                 Nastavnik n=new Nastavnik();
                 n.setId(rs.getLong("n.id"));
                 n.setIme(rs.getString("n.ime"));
                 n.setPrezime(rs.getString("n.prezime"));
                 n.setUsername(rs.getString("n.username"));
                 sala.setNastavnik(n);
                 Takmicenje t=Controller.getInstance().pretraziTakmicenje(rs.getLong("t.id"));
                 StavkaTakmicenja st=Controller.getInstance().pretraziStavkuTakmicenja(rs.getLong("st.id"));
                 sala.setTakmicenje(t);
                 sala.setStavka(st);
                 pronadjena.add(sala);
             }
             stat.close();
             rs.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return pronadjena;
     }
     
     public ArrayList<Sala> vratiListuSala(StavkaTakmicenja stavka){
         ArrayList<Sala> pronadjena=new ArrayList<Sala>();
         String upit="SELECT s.*,t.*,n.*,st.* FROM sala s JOIN nastavnik n ON s.id_nastavnik=n.id JOIN takmicenje t ON s.id_takmicenja=t.id JOIN stavka_takmicenja st ON s.id_stavka=st.id WHERE id_stavka="+stavka.getId();
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement stat=conn.createStatement();
             ResultSet rs=stat.executeQuery(upit);
             while(rs.next()){
                 Sala sala=new Sala();
                 sala.setBroj_sale(rs.getInt("s.broj_sale"));
                 sala.setTrajanje(rs.getString("s.trajanje_dezurstva"));
                 sala.setVreme_pocetka(rs.getString("s.vreme_pocetka_dezurstva"));
                 Nastavnik n=new Nastavnik();
                 n.setId(rs.getLong("n.id"));
                 n.setIme(rs.getString("n.ime"));
                 n.setPrezime(rs.getString("n.prezime"));
                 n.setUsername(rs.getString("n.username"));
                 sala.setNastavnik(n);
                 Takmicenje t=Controller.getInstance().pretraziTakmicenje(rs.getLong("t.id"));
                 StavkaTakmicenja st=Controller.getInstance().pretraziStavkuTakmicenja(rs.getLong("st.id"));
                 sala.setTakmicenje(t);
                 sala.setStavka(st);
                 pronadjena.add(sala);
             }
             stat.close();
             rs.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return pronadjena;
     }
    
     
     public ArrayList<Predmet> vratiListuPredmet(Predmet p){
         ArrayList<Predmet> list=new ArrayList<Predmet>();
         String upit="SELECT * FROM predmet WHERE naziv LIKE '%"+p.getNaziv().trim()+"%'";
         Connection conn=DBConnection.getInstance().getConnection();
         try{
             Statement s=conn.createStatement();
             ResultSet rs=s.executeQuery(upit);
             while(rs.next()){
                 Predmet pr=new Predmet();
                 pr.setId(rs.getLong("id"));
                 pr.setNaziv(rs.getString("naziv"));
                 list.add(pr);
             }
             rs.close();
             s.close();
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return list;
     }
     
   }
