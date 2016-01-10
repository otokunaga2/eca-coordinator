package jp.kobe_u.cs27.primitive_eca.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import jp.kobe_u.cs27.primitive_eca.action.Action;
import jp.kobe_u.cs27.primitive_eca.db_helper.MorphiaUtil;
import jp.kobe_u.cs27.primitive_eca.model.ActionModel;
import jp.kobe_u.cs27.primitive_eca.util.ApplicationConf;

/**
 * @author otokunaga
 * ActionModelとActionを紐付けるクラス
 * 方針:Modelと実際に実行するクラスは分離する
 * TODO:httpのバリデーション(jsでやるか？
 */
public class ActionDAO {
	private Datastore dataStore = null;
	private static final String ID_KEY = "_id"; 
	private static final String LASTINVOCATION ="lastInvocation";
	private ActionModel actionModel;
	
	public ActionDAO(){
		dataStore = MorphiaUtil.getInstance();
		actionModel = new ActionModel();
	}
	
	public ActionModel findActionAsModel(ObjectId id){
		return dataStore.find(ActionModel.class).field(ID_KEY).equal(id).get();
	}
	/**
	 * @param id
	 * @return
	 */
	public Action findAction(ObjectId id){
		ActionModel actionM = dataStore.find(ActionModel.class).field(ID_KEY).equal(id).get();
		Action action = new Action(actionM.getUrl());
		return action;
	}
	/**
	 * @param aid
	 * @return
	 */
	public boolean updateAction(ObjectId aid){
		DateTime dateTime = new DateTime();
		Query<ActionModel> udpateQuery = dataStore.createQuery(ActionModel.class).field("_id").equal(aid);
		final UpdateOperations<ActionModel> ops = dataStore.createUpdateOperations(ActionModel.class).set(LASTINVOCATION, dateTime.now().toString(ApplicationConf.DATEPATTERN));
		final UpdateResults results = dataStore.update(udpateQuery, ops);
		return results.getUpdatedExisting();
		
	}
	/**
	 * @param action
	 * @return
	 */
	public ObjectId save(Action action){
		actionModel.setUrl(action.getUrl());
		Key<ActionModel> key = dataStore.save(actionModel);
		return (ObjectId) key.getId();
	}
	/**
	 * @return
	 */
	public List<Action> getAllActin(){
		List<ActionModel> list = dataStore.find(ActionModel.class).asList();
		List<Action> lActionList = new ArrayList<Action>();
		for(ActionModel tempModel: list){
			Action action = new Action(tempModel.getUrl());
			System.out.println("here");
			lActionList.add(action);
		}
		return lActionList;
	}
	
}
