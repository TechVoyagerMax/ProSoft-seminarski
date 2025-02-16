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
public class StavkaTableModel extends AbstractTableModel {
    ArrayList<StavkaTakmicenja> list=new ArrayList<StavkaTakmicenja>();
    String[] columns={"nivo takmicenja","predmet","razred"};
    
    public StavkaTableModel(Razred r) throws Exception{
        list=Controller.getInstance().vratiListuStavki(r);
        if(list.isEmpty()){
            throw new Exception();
        }
    }
    
    public StavkaTableModel(Takmicenje t) throws Exception{
        list=Controller.getInstance().vratiListuStavkiTakmicenja(t);
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
        StavkaTakmicenja st=list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return st.getTakmicenje().getNivo().getNaziv();
            case 1:
                return st.getTakmicenje().getPredmet().getNaziv();
            case 2:
                return st.getRazred().getRedni_broj();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    public StavkaTakmicenja get(int index){
        if(index<0){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return list.get(index);
    }
    
}
