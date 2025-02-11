/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seminarski.table_model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import seminarski.controller.Controller;
import seminarski.domain.Nastavnik;

/**
 *
 * @author pc
 */
public class NastavniciTableModel extends AbstractTableModel {
    
    private ArrayList<Nastavnik> nastavnici=new ArrayList<Nastavnik>();
    private String[] columns={"ime","prezime","korisnicko ime"};

    public NastavniciTableModel(){
        nastavnici=Controller.getInstance().vratiListuSviNastavnik();
    }
    
    public NastavniciTableModel(Nastavnik n) throws Exception{
        nastavnici=Controller.getInstance().pretragaNastavnikaIme(n);
        if(nastavnici.isEmpty()){
            throw new Exception();
        }
    }
    
    @Override
    public int getRowCount() {
        return nastavnici.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Nastavnik n=nastavnici.get(rowIndex);
        switch(columnIndex){
            case 0:
                return n.getIme();
            case 1:
                return n.getPrezime();
            case 2:
                return n.getUsername();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    public Nastavnik get(int index){
        if(index<0){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return nastavnici.get(index);
    }
    
}
