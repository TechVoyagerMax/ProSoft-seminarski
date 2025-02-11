/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seminarski.table_model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import seminarski.controller.Controller;
import seminarski.domain.Skola;

/**
 *
 * @author pc
 */
public class SkolaTableModel extends AbstractTableModel {
    
    private ArrayList<Skola> skole=new ArrayList<Skola>();
    String[] columns={"naziv","grad"};
    
    public SkolaTableModel(){
        skole=Controller.getInstance().vratiListuSviSkola();
    }
    
    public SkolaTableModel(String grad) throws Exception{
        skole=Controller.getInstance().vratiListuSkola(grad);
        if(skole.isEmpty()){
            throw new Exception();
        }
    }

    @Override
    public int getRowCount() {
        return skole.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Skola s=skole.get(rowIndex);
        switch(columnIndex){
            case 0:
                return s.getNaziv();
            case 1:
                return s.getGrad();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    public Skola get(int index){
        if(index<0){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return skole.get(index);
    }
    
}
