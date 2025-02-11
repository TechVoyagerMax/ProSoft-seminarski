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
public class StavkeStavkiTableModel extends AbstractTableModel{
    
    ArrayList<StavkaStavkeTakmicenja> list=new ArrayList<StavkaStavkeTakmicenja>();
    String[] columns={"ucenik","ostvaren broj poena","ostvaren rang"};
    
    public StavkeStavkiTableModel(StavkaTakmicenja st){
        list=Controller.getInstance().vratiListuSveStavkeStavki(st);
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
        StavkaStavkeTakmicenja sst=list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return sst.getUcenik().toString();
            case 1:
                return sst.getBr_poena();
            case 2:
                if(sst.getRang().equals(Rang.PRVO_MESTO)){
                    return "Prvo mesto";
                }else if(sst.getRang().equals(Rang.DRUGO_MESTO)){
                    return "Drugo mesto";
                }else if(sst.getRang().equals(Rang.TRECE_MESTO)){
                    return "Trece mesto";
                }else{
                    return "Bez ranga";
                }
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    public StavkaStavkeTakmicenja get(int index){
        if(index<0){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return list.get(index);

    }
    
}
