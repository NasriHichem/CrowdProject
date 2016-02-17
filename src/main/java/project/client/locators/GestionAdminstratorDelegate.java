package project.client.locators;
import projects.serveur.entites.Adminstrator;
import projects.serveur.sessionbeans.AdminstratorServicesRemote;



public class GestionAdminstratorDelegate {
	
   private static AdminstratorServicesRemote remote;
   private static final String jndi="projects.serveur/AdminstratorServices!projects.serveur.sessionbeans.AdminstratorServicesRemote";
	
   private static AdminstratorServicesRemote getProxy(){
	   return (AdminstratorServicesRemote) ServiceLocator.getInstance().getRemoteProxy(jndi);
   }
	
	
	public static Adminstrator doAuthentificate(String login, String password){
		return getProxy().authentificate(login, password);
	}

}