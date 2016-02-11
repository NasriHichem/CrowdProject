package project.client.Presentation;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import projects.serveur.entites.Project;
import projects.serveur.sessionbeans.ProjectsServicesRemote;

public class Test {
	
	public static void main(String[] args) {
		

	    
			Context context;
			ArrayList<Project>projects=new ArrayList<>() ;
			
			try {
				context = new InitialContext();
				
		    ProjectsServicesRemote gl= 
			(ProjectsServicesRemote) 
			context.lookup("projects.serveur/ProjectsServices!projects.serveur.sessionbeans.ProjectsServicesRemote");
			 projects=(ArrayList<Project>) gl.getListProjects();
		  
			  
			} catch (NamingException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(Project p :projects)
			{
				System.out.println(p.getName());
			}
			

	}
}
