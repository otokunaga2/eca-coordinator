package jp.kobe_u.cs27.primitive_eca.rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.bson.types.ObjectId;

import jp.kobe_u.cs27.primitive_eca.action.Action;
import jp.kobe_u.cs27.primitive_eca.http_handler.HttpHelper;
import jp.kobe_u.cs27.primitive_eca.model.ECAModel;
import jp.kobe_u.cs27.primitive_eca.model.ConditionModel;
import jp.kobe_u.cs27.primitive_eca.service.Event;

public class Rule implements Observer,RuleInterface {

	private HttpHelper httpHelper; 
	private Event context = null;
	private ConditionModel conditon = null;
	private ECAModel eca = new ECAModel();
	private CopyOnWriteArrayList<ECAModel> ecaList;
	
	public Rule() {
		httpHelper = new HttpHelper();
		ecaList = new CopyOnWriteArrayList<>();
	}
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * updateがあった時点でfalse->trueは確定
	 */
	@Override
	public void update(Event primitiveEvent) {
		// TODO Auto-generated method stub
		
		//updateされた際に、conditionの条件をチェックする
		boolean flag = false;
		Map<ObjectId,Boolean> resultMap = new HashMap<ObjectId,Boolean>();
		
		
		for(ECAModel eca: this.ecaList){
			if(eca.getCondList() != null){
				for(ConditionModel condition: eca.getCondList()){
					boolean isCondition = httpHelper.parseHttpEndpoint(condition.getUrl());
					resultMap.put(eca.getEcaId(), isCondition);
				}
			}else{/*conditionが空の場合はそのまま発火する*/
				resultMap.put(eca.getEcaId(), true);
			}
		}
		boolean conditonTotalResult = true;
		for(Map.Entry<ObjectId, Boolean> e: resultMap.entrySet()){/*全部のconditionがtrueの時のみ*/
			System.out.println(e.getKey()+ ":" + e.getValue());
			conditonTotalResult = conditonTotalResult&&e.getValue();/*conditonの条件を掛けあわせる*/
		}
		if(conditonTotalResult){
			
		}
		
		
	}
	/**
	 * idを利用してActionを取得、もしデータがなければnullを返す
	 * @param id
	 * @return
	 */
	public Action getActionWithId(String id){
		for(ECAModel eca: ecaList){
			if(eca.getEcaId().equals(id)){
				return eca.getAction();
			}
		}
		return null;/**/
	}
	
	public void executeAction(Action action){
		
	}
	public boolean startMonitoring(){
		for(ECAModel eca: this.ecaList){
			
			Event event = eca.getEvent();
			event.setTimer(1000);
		}
		return true;
	}
	
	public Action findActionWithEventId(String id){
		
		return null;
	}
	
	public void createRule(Event event, ArrayList<ConditionModel> cond, Action action){
		ECAModel eca = new ECAModel(event, cond, action);
		this.ecaList.add(eca);
	}
	public void addECA(ECAModel eca){
		this.ecaList.add(eca);
	}
	




	@Override
	public boolean isEnable() {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public ArrayList<ConditionModel> getConditionList() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public boolean isExecute(Action action) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
	
}
