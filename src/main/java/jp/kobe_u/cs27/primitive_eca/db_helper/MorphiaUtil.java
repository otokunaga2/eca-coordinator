package jp.kobe_u.cs27.primitive_eca.db_helper;

import java.net.UnknownHostException;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;



public class MorphiaUtil {
	private static MorphiaUtil morphiaUtil = null;
	
	private static Morphia morphia = null;
	public static Datastore getInstance(){
		 if(morphia == null){
			 morphia = new Morphia();
		 }
		// tell Morphia where to find your classes
		// can be called multiple times with different packages or classes
		morphia.mapPackage("jp.kobe_u.cs27.memory.coordinator.model");

		// create the Datastore connecting to the default port on the local host
		Datastore datastore = null;
		try {
			datastore = morphia.createDatastore(new MongoClient("localhost" , 27017), "eca_coordinator");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datastore;
	}
}
