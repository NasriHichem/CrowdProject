package project.client.locators;

import java.util.ArrayList;

import projects.serveur.entites.Category;
import projects.serveur.sessionbeans.CategoryservicesRemote;

public class CategoryDelegate {
	
	private static CategoryservicesRemote remotecategoryservices;
	private static final String jndi = "projects.serveur/Categoryservices!projects.serveur.sessionbeans.CategoryservicesRemote";

	
	private static CategoryservicesRemote getProxyCategoryservices() {
		if (remotecategoryservices == null) {
			remotecategoryservices = (CategoryservicesRemote) ServiceLocator.getInstance()
			.getRemoteProxy(jndi);
		}
		return remotecategoryservices;
	}
	
	public static ArrayList<Category>  getListCategory(){
	    return  getProxyCategoryservices().getList();
		}
}
