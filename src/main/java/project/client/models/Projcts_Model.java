
package project.client.models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import project.client.locators.UserDelegate;
import projects.serveur.entites.Project;



public class Projcts_Model extends AbstractTableModel {
    
    
    String [] colunmTab= {"Name","Title","Objectif"};
	ArrayList<Project>projects=new ArrayList<>() ;
    public Projcts_Model() {  	
		 projects=	UserDelegate.getList();	  						
    }
    

    @Override
    public int getRowCount() {
     return projects.size();
    }

    @Override
    public int getColumnCount() {
       return   colunmTab.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {   
        switch(columnIndex){
        case 0:
        return  projects.get(rowIndex).getName();
        case 1 :
                return projects.get(rowIndex).getTitle();
            case 2: 
                return projects.get(rowIndex).getTurget_funding() ;
                    
            default:
                return null;
    }
    
}

    @Override
    public String getColumnName(int column) {
        return colunmTab[column];
    }


}
