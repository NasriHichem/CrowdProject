package project.client.models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import projects.serveur.entites.Claim;
import projects.serveur.entites.Project;;

public class Claim_Model  extends AbstractTableModel{

    String [] colunmTab= {"claiming","objet","cause"};
	ArrayList<Claim>claims=new ArrayList<>() ;
	
    

	public Claim_Model(ArrayList<Claim>claims) {
		super();
		this.claims=claims ;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return claims.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunmTab.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
        case 0:
        return  claims.get(rowIndex).getClaiming().getFirstname()+" "+claims.get(rowIndex).getClaiming().getLastname();
        case 1 :
                return claims.get(rowIndex).getObject();
            case 2: 
                return claims.get(rowIndex).getCause() ;
                    
            default:
                return null;
    }
		
	}

}
