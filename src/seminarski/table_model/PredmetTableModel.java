/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seminarski.table_model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import seminarski.controller.Controller;
import seminarski.domain.Predmet;

/**
 *
 * @author pc
 */
public class PredmetTableModel extends AbstractTableModel {
    
    private ArrayList<Predmet> predmeti=new ArrayList<Predmet>();
    String[] columns={"naziv"};
    
    public PredmetTableModel(){
        predmeti=Controller.getInstance().vratiListuSviPredmet();
    }
    
    public PredmetTableModel(ArrayList<Predmet> lista) throws Exception{
        predmeti=lista;
    }

    @Override
    public int getRowCount() {
        return predmeti.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Predmet p=predmeti.get(rowIndex);
        switch(columnIndex){
            case 0:
                return p.getNaziv();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    public Predmet get(int index){
        if(index<0){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return predmeti.get(index);
    }
    
}
