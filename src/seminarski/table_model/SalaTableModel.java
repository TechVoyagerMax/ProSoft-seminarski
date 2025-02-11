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
public class SalaTableModel extends AbstractTableModel {
    ArrayList<Sala> sale=new ArrayList<Sala>();
    String[] columns={"nastavnik","nivo takmicenja","predmet","za razred","broj sale","vreme pocetka","trajanje"};
    
    public SalaTableModel(){
        sale=Controller.getInstance().vratiListuSveSale();
    }
    
    @Override
    public int getRowCount() {
        return sale.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sala s=sale.get(rowIndex);
        switch(columnIndex){
            case 0:
                return s.getNastavnik();
            case 1:
                return s.getTakmicenje().getNivo();
            case 2:
                return s.getTakmicenje().getPredmet();
            case 3:
                return s.getStavka().getRazred().getRedni_broj();
            case 4 :
                return s.getBroj_sale();
            case 5:
                return s.getVreme_pocetka();
            case 6:
                return s.getTrajanje();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    public Sala get(int index){
        if(index<0){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return sale.get(index);
    }
    
}
