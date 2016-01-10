package jp.kobe_u.cs27.primitive_eca.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import jp.kobe_u.cs27.primitive_eca.db_helper.MorphiaUtil;
import jp.kobe_u.cs27.primitive_eca.model.ActionModel;
import jp.kobe_u.cs27.primitive_eca.model.ECAModel;
import jp.kobe_u.cs27.primitive_eca.model.EventModel;
import jp.kobe_u.cs27.primitive_eca.service.Event;

public class ECADAO {
	private Datastore dataStore;
	private final String KEY = "_id";
	public ECADAO(){
		dataStore = MorphiaUtil.getInstance();
	}
	
	public ObjectId save(ECAModel eca){
		ECAModel ecaModel = eca;
		Key<ECAModel> model = dataStore.save(ecaModel);
		return (ObjectId)model.getId();
	}
	public boolean update(ECAModel eca){
		return true;
	}
	public ECAModel findECA(){
		
		return null;
	}
	public List<ECAModel> getAllECA(){
		return null;
	}
	
	public ECAModel getECAModelWithId(ObjectId id){
		Query<EventModel> udpateQuery = dataStore.createQuery(EventModel.class).field("_id").equal(id);
		//final UpdateOperations<EventModel> ops = dataStore.createUpdateOperations(EventModel.class).set(URL, url);
		ECAModel model = (ECAModel) dataStore.find(ECAModel.class).field(KEY).equal(id);
		System.out.println(model.getEcaId()); 
		return model;
	}
	/**
	 * @param event
	 * @return
	 */
	public boolean deleteECA(ECAModel event){
		try{
			ECAModel model = getECAModelWithId(event.getEcaId());
			
			
		}catch (NullPointerException e){
			e.printStackTrace();
			return false;	
		}
		return false;
	}
}
