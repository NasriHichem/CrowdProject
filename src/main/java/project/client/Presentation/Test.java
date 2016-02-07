package project.client.Presentation;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import projects.serveur.entites.Category;
import projects.serveur.entites.Creator;
import projects.serveur.entites.Project;
import projects.serveur.sessionbeans.ProjectsServicesRemote;

public class Test {

	public static void main(String[] args) {
		
		Creator c =new Creator();
		Category cat =new Category();
		cat.setId(1);
		c.setId(1);
		Project p =new Project("Caffe theatre","projet interissant", "decouvrez ce projet", 30,
		100.000, "Tunis",
		c,cat);				
		try {
	    Context context = new InitialContext();			
	    ProjectsServicesRemote gl= 
		(ProjectsServicesRemote)
		context.lookup("projects.serveur/ProjectsServices!projects.serveur.sessionbeans.ProjectsServicesRemote");
		  
	     gl.addProject(p);
		  
		} catch (NamingException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
