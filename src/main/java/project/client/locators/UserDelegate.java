package project.client.locators;

import java.util.ArrayList;

import projects.serveur.entites.Category;
import projects.serveur.entites.Project;
import projects.serveur.sessionbeans.CategoryservicesRemote;
import projects.serveur.sessionbeans.ProjectsServicesRemote;

public class UserDelegate {
	private static ProjectsServicesRemote remoteprojectservices;
	private static CategoryservicesRemote remotecategoryservices;
	private static final String jndi = "projects.serveur/ProjectsServices!projects.serveur.sessionbeans.ProjectsServicesRemote";
	private static final String jndicategory = "projects.serveur/Categoryservices!projects.serveur.sessionbeans.CategoryservicesRemote";
	private static ProjectsServicesRemote getProxyProjectServices() {
		if (remoteprojectservices == null) {
			remoteprojectservices = (ProjectsServicesRemote) ServiceLocator.getInstance()
			.getRemoteProxy(jndi);
		}
		return remoteprojectservices;
	}
	
	private static CategoryservicesRemote getProxyCategoryservices() {
		if (remotecategoryservices == null) {
			remotecategoryservices = (CategoryservicesRemote) ServiceLocator.getInstance()
			.getRemoteProxy(jndicategory);
		}
		return remotecategoryservices;
	}
	public static ArrayList<Project>  getList(){
    return  getProxyProjectServices().getListProjects();
	}
	public static ArrayList<Project>  getListprojectsnomconfirmed(int value){
	    return  getProxyProjectServices().getProjectsnoConfirmed(value);
		}
	public static ArrayList<Project>  getListByCategory(String category){
	    return  getProxyProjectServices().findProjectsByCategory(category);
		}
	public static ArrayList<Category>  getListCategory(){
	    return  getProxyCategoryservices().getList();
		}
	
}
