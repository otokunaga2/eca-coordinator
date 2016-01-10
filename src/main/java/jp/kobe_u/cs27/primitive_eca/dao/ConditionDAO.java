package jp.kobe_u.cs27.primitive_eca.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import jp.kobe_u.cs27.primitive_eca.db_helper.MorphiaUtil;
import jp.kobe_u.cs27.primitive_eca.model.ConditionModel;
import jp.kobe_u.cs27.primitive_eca.rule.Rule;

/**
 * @author otokunaga
 *　開発方針:Modelと実際に実行するクラスは分離する
 * TODO:httpのバリデーション(jsでやるか？
 */
public class ConditionDAO {

	private Datastore dataStore = null;
	private static final String ID_KEY = "_id"; 
	private static final String URL = "url";
	public ConditionDAO(){
		dataStore = MorphiaUtil.getInstance();
	}
	
	public ConditionModel findCondition(ObjectId id){
		ConditionModel conditon = dataStore.find(ConditionModel.class).field(ID_KEY).equal(id).get();
		return conditon;
	}
	public boolean updateCondition(ObjectId aid, String url){
		Query<ConditionModel> udpateQuery = dataStore.createQuery(ConditionModel.class).field("_id").equal(aid);
		final UpdateOperations<ConditionModel> ops = dataStore.createUpdateOperations(ConditionModel.class).set(URL, url);
		final UpdateResults results = dataStore.update(udpateQuery, ops);
		return results.getUpdatedExisting();
		
	}
	public ObjectId save(ConditionModel condtion){
		Key<ConditionModel> key = dataStore.save(condtion);
		return (ObjectId) key.getId();
	}
	public List<ConditionModel> getEventAll(Rule rule){
		List<ConditionModel> conditonList = dataStore.find(ConditionModel.class).asList();
		return conditonList;
	}

	public ConditionModel find(ObjectId cid) {
		ConditionModel conditon = dataStore.find(ConditionModel.class).field(ID_KEY).equal(cid).get();
		return conditon;
		
	}
	
}

