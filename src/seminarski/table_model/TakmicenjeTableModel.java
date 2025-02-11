/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seminarski.table_model;
import seminarski.domain.*;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import seminarski.controller.Controller;

/**
 *
 * @author pc
 */
public class TakmicenjeTableModel extends AbstractTableModel {
    ArrayList<Takmicenje> list=new ArrayList<Takmicenje>();
    String[] columns={"nivo","predmet","datum_odrzavanja","mesto odrzavanja"};
    
    public TakmicenjeTableModel(Predmet p) throws Exception{
        list=Controller.getInstance().vratiListuTakmicenja(p);
        if(list.isEmpty()){
            throw new Exception();
        }
    }
    
    public TakmicenjeTableModel(NivoTakmicenja n) throws Exception{
        list=Controller.getInstance().vratiListuTakmicenja(n);
        if(list.isEmpty()){
            throw new Exception();
        }
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Takmicenje t=list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return t.getNivo().getNaziv();
            case 1:
                return t.getPredmet().getNaziv();
            case 2:
                return t.getDatum_odrzavanja();
            case 3:
                return t.getMesto_odrzavanja().toString();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    
    
}
