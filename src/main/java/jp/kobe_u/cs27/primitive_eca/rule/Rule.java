package jp.kobe_u.cs27.primitive_eca.rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import jp.kobe_u.cs27.primitive_eca.action.Action;
import jp.kobe_u.cs27.primitive_eca.action.ActionDAO;
import jp.kobe_u.cs27.primitive_eca.dao.PrimitiveCondition;
import jp.kobe_u.cs27.primitive_eca.dao.PrimitiveECA;
import jp.kobe_u.cs27.primitive_eca.event.PrimitiveEvent;
import jp.kobe_u.cs27.primitive_eca.http_handler.HttpHelper;

public class Rule implements Observer {

	private HttpHelper httpHelper; 
	private PrimitiveEvent context = null;
	private PrimitiveCondition conditon = null;
	private PrimitiveECA eca = new PrimitiveECA();
	private CopyOnWriteArrayList<PrimitiveECA> ecaList;
	private ActionDAO actionDAO;
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
		ArrayList<Boolean> resultList = new ArrayList<Boolean>();
		for(PrimitiveECA eca: this.ecaList){
			if(eca.getCondList() != null){
				for(PrimitiveCondition condition: eca.getCondList()){
					boolean isCondition = httpHelper.parseHttpEndpoint(condition.getUrl());
					resultList.add(isCondition);
				}
			}
		}
		
		
		for(boolean tempResult:resultList){
			System.out.println(tempResult);
		}
	}
	
	public Action findActionWithEventId(String id){
		
		return null;
	}
	
	public String createRule(PrimitiveEvent event, PrimitiveCondition cond, Action action){
		event.addObserver(this);
		
		return null;
	}
	
	
	
	
	
	
}
