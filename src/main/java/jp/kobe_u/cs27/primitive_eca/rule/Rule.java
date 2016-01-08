package jp.kobe_u.cs27.primitive_eca.rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import jp.kobe_u.cs27.primitive_eca.action.Action;

import jp.kobe_u.cs27.primitive_eca.dao.PrimitiveCondition;
import jp.kobe_u.cs27.primitive_eca.dao.PrimitiveECA;
import jp.kobe_u.cs27.primitive_eca.dao.PrimitiveEvent;
import jp.kobe_u.cs27.primitive_eca.http_handler.HttpHelper;

public class Rule implements Observer,RuleInterface {

	private HttpHelper httpHelper; 
	private PrimitiveEvent context = null;
	private PrimitiveCondition conditon = null;
	private PrimitiveECA eca = new PrimitiveECA();
	private CopyOnWriteArrayList<PrimitiveECA> ecaList;
	
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
	public void update(PrimitiveEvent primitiveEvent) {
		// TODO Auto-generated method stub
		
		//updateされた際に、conditionの条件をチェックする
		boolean flag = false;
		HashMap<String,Boolean> resultMap = new HashMap<String,Boolean>();
		
		
		for(PrimitiveECA eca: this.ecaList){
			if(eca.getCondList() != null){
				for(PrimitiveCondition condition: eca.getCondList()){
					boolean isCondition = httpHelper.parseHttpEndpoint(condition.getUrl());
					resultMap.put(eca.getEcaId(), isCondition);
				}
			}else{/*conditionが空の場合はそのまま発火する*/
				resultMap.put(eca.getEcaId(), true);
			}
		}
		for(Map.Entry<String, Boolean> e: resultMap.entrySet()){
			System.out.println(e.getKey()+ ":" + e.getValue());
			
		}
		
		
	}
	/**
	 * idを利用してActionを取得、もしデータがなければnullを返す
	 * @param id
	 * @return
	 */
	public Action getActionWithId(String id){
		for(PrimitiveECA eca: ecaList){
			if(eca.getEcaId().equals(id)){
				return eca.getAction();
			}
		}
		return null;/**/
	}
	
	public void executeAction(Action action){
		
	}
	public boolean startMonitoring(){
		for(PrimitiveECA eca: this.ecaList){
			
			PrimitiveEvent event = eca.getEvent();
			event.setTimer(1000);
		}
		return true;
	}
	
	public Action findActionWithEventId(String id){
		
		return null;
	}
	
	public void createRule(PrimitiveEvent event, ArrayList<PrimitiveCondition> cond, Action action){
		PrimitiveECA eca = new PrimitiveECA(event, cond, action);
		this.ecaList.add(eca);
	}
	public void addECA(PrimitiveECA eca){
		this.ecaList.add(eca);
	}
	




	@Override
	public boolean isEnable() {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public ArrayList<PrimitiveCondition> getConditionList() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public boolean isExecute(Action action) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
	
}
