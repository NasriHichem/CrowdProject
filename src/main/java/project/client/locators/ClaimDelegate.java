package project.client.locators;

import java.util.ArrayList;

import projects.serveur.entites.Category;
import projects.serveur.entites.Claim;
import projects.serveur.entites.Project;
import projects.serveur.sessionbeans.CategoryservicesRemote;
import projects.serveur.sessionbeans.ClaimservicesRemote;
import projects.serveur.sessionbeans.ProjectsServicesRemote;

public class ClaimDelegate {
	
	private static ClaimservicesRemote   remoteclaimservices;
	private static final String jndiclaim="projects.serveur/Claimservices!projects.serveur.sessionbeans.ClaimservicesRemote";
		
	private static ClaimservicesRemote getProxyClaimServices() {
		if (remoteclaimservices== null) {
			remoteclaimservices = (ClaimservicesRemote) ServiceLocator.getInstance()
			.getRemoteProxy(jndiclaim);
		}
		return remoteclaimservices;
	}
	
	public static void removeClaim(Claim c){
		getProxyClaimServices().removeClaim(c);
	};
	public static ArrayList<Claim> getListclaim_non_confirm(){
		return getProxyClaimServices().getListclaimnonconfirm();
	}
	public static void UpdateClaim(Claim c){
		getProxyClaimServices().update(c);;
	};
	 public static ArrayList<Claim> getclaimByclaiming(String txtclaiming)
	 {
		return getProxyClaimServices().getclaimByclaiming(txtclaiming);
		 
	 }
	 public static Long getclaimbymonth(String date1, String date2) {
		return getProxyClaimServices().getclaimbymonth(date1, date2);
		 
	 };
}
