package jp.kobe_u.cs27.primitive_eca.db_helper;

import java.net.UnknownHostException;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import com.mongodb.MongoClient;



public class MorphiaUtil {
	private static Morphia morphia = null;
	public static Datastore getInstance(){
		 if(morphia == null){
			 morphia = new Morphia();
		 }
		 /*モデルに利用するパッケージ名*/
		morphia.mapPackage("jp.kobe_u.cs27.memory.coordinator.model");

		Datastore datastore = null;
		try {
			datastore = morphia.createDatastore(new MongoClient("192.168.0.21" , 27017), "eca_coordinator");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datastore;
	}
}
