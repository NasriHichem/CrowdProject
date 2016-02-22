package project.client.Presentation;

import java.util.ArrayList;

import project.client.locators.ClaimDelegate;
import projects.serveur.entites.Claim;

public class test_affi {
	public static void main(String[] args) {
   ArrayList<Claim> list=new ArrayList<>();
		list= ClaimDelegate.getclaimByclaiming("s");
	System.out.println(list.size());
	
	
	
	
	}
}
