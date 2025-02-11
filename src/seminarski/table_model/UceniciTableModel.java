/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seminarski.table_model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import seminarski.controller.Controller;
import seminarski.domain.*;

/**
 *
 * @author pc
 */
public class UceniciTableModel extends AbstractTableModel{

    private ArrayList<Ucenik> ucenici=new ArrayList<Ucenik>();
    String[] columns={"ime","prezime","JMBG","razred"};
    
    public UceniciTableModel(){
         ucenici=Controller.getInstance().vratiListuSviUcenici();
    }
    
    
    public UceniciTableModel(Razred r) throws Exception{
        ucenici=Controller.getInstance().vratiListuUcenik(r);
        if(ucenici.isEmpty()){
            throw new Exception();
        }
    }
    
    @Override
    public int getRowCount() {
        return ucenici.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ucenik u=ucenici.get(rowIndex);
        switch(columnIndex){
            case 0:
                return u.getIme();
            case 1:
                return u.getPrezime();
            case 2:
                return u.getJmbg();
            case 3:
                return u.getRazred().getRedni_broj();
            default:
                    return null;
        }
    }
    
     @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    public Ucenik get(int index){
        if(index<0){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return ucenici.get(index);
    }
    
}
