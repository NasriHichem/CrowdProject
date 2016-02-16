package project.client.locators;

import java.util.ArrayList;
import java.util.Date;

import projects.serveur.entites.Category;
import projects.serveur.entites.Project;
import projects.serveur.sessionbeans.CategoryservicesRemote;
import projects.serveur.sessionbeans.ProjectsServicesRemote;

public class ProjectDelegate {
	private static ProjectsServicesRemote remoteprojectservices;
	
	private static final String jndi = "projects.serveur/ProjectsServices!projects.serveur.sessionbeans.ProjectsServicesRemote";
	
	private static ProjectsServicesRemote getProxyProjectServices() {
		if (remoteprojectservices == null) {
			remoteprojectservices = (ProjectsServicesRemote) ServiceLocator.getInstance()
			.getRemoteProxy(jndi);
		}
		return remoteprojectservices;
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
	
	public static int getNumberProjects(String date1,String date2)
	{
		return  getProxyProjectServices().getNumberProjectsByDate(date1,date2);
	}
	
	public static void remove(Project p)
	{
		 getProxyProjectServices().removeProject(p);
	}
	
}
