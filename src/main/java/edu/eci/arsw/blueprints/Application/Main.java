package edu.eci.arsw.blueprints.Application;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;

public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		BlueprintsServices bps = ac.getBean(BlueprintsServices.class);
		
		registerBlueprint(bps, "Structure", "john");
		registerBlueprint(bps, "Design", "johan");
		registerBlueprint(bps, "Build", "john");
		consultBlueprints(bps);
		consultBlueprintByValues(bps, "the design", "johan");
		consultBlueprintsByAuthor(bps, "john");
		
	}

	private static void consultBlueprintsByAuthor(BlueprintsServices bps, String author){
		// TODO Auto-generated method stub
		try {
			System.out.println("Result of author : " + author);
			Set<Blueprint> set = bps.getBlueprintsByAuthor(author);
			for (Blueprint b : set) {
				System.out.println(b.toString());
				System.out.println();
			}
		} catch (BlueprintNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

	private static void consultBlueprintByValues(BlueprintsServices bps, String name, String author){
		// TODO Auto-generated method stub
		try {
			System.out.println("Result of : " + name + " by author " + author);
			Blueprint bp = bps.getBlueprint(author, name);
			System.out.println(bp.toString());
		} catch (BlueprintNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println();
		
	}

	private static void consultBlueprints(BlueprintsServices bps) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Existing Blueprints");
			HashSet<Blueprint> set = bps.getAllBlueprints();
			set.forEach(System.out::println);
			System.out.println();
		} catch (BlueprintNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	private static void registerBlueprint(BlueprintsServices bps, String name, String author) {
		// TODO Auto-generated method stub
		try {
			Point[] pts = new Point[] {new Point(0,0), new Point(10,10)};
			bps.registerBlueprint(new Blueprint(author,name,pts));
			System.out.println("Succesfull registration");
			System.out.println();
		} catch (BlueprintPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
