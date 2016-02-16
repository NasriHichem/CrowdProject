
package project.client.models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import project.client.locators.ProjectDelegate;
import projects.serveur.entites.Project;



public class Projcts_Model extends AbstractTableModel {
    
    
    String [] colunmTab= {"Name","Title","Funding target","Date publish","Creator name"};
	ArrayList<Project>projects=new ArrayList<>() ;
    public Projcts_Model(ArrayList<Project>projects) {  	
		 this.projects=projects;		  						
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
        case 3: 
        return projects.get(rowIndex).getDate_publish() ;
        case 4: 
        return projects.get(rowIndex).getCreator().getFirstname()+" "+ projects.get(rowIndex).getCreator().getLastname();                 
         default:
           return null;
    }
    
}

    @Override
    public String getColumnName(int column) {
        return colunmTab[column];
    }


}
