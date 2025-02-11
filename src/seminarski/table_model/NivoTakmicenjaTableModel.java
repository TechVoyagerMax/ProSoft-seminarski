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
public class NivoTakmicenjaTableModel extends AbstractTableModel {
    
    private ArrayList<NivoTakmicenja> nivoi=new ArrayList<NivoTakmicenja>();
    private String[] columns={"nivo"};
    
    public NivoTakmicenjaTableModel(){
        nivoi=Controller.getInstance().vratiListuSviNivoiTakmicenja();
    }

    @Override
    public int getRowCount() {
        return nivoi.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NivoTakmicenja nt=nivoi.get(rowIndex);
        switch(columnIndex){
            case 0:
                return nt.getNaziv();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    public NivoTakmicenja get(int index){
        if(index<0){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return nivoi.get(index);
    }
    
}
