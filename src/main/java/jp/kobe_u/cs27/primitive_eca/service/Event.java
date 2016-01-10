package jp.kobe_u.cs27.primitive_eca.service;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import jp.kobe_u.cs27.primitive_eca.http_handler.HttpHelper;
import jp.kobe_u.cs27.primitive_eca.model.ConditionModel;
import jp.kobe_u.cs27.primitive_eca.rule.Rule;
import jp.kobe_u.cs27.primitive_eca.rule.Observer;

/**
 * @author otokunaga
 *
 */
public class Event extends TimerTask {
	private String url;
	private boolean contextFlag = false;
	private Observer contextObserver;
	private long montoringInterval = 1000;
	HttpHelper httpHelper;
	private ArrayList<ConditionModel> conditionList;
	public Event(Observer observer,String url){/*conditionを持たないコンストラクタ*/
		httpHelper = new HttpHelper();
		this.contextObserver = observer;
		this.setUrl(url);
		this.setConditionList(null);
	}
	public Event(Observer observer,String url,ArrayList<ConditionModel> conditionList){/*conditionを持つコンストラクタ*/
		httpHelper = new HttpHelper();
		this.contextObserver = observer;
		this.setUrl(url);
		this.setConditionList(conditionList);
	}
	
	
	ArrayList<Rule> observerList;
	public void addObserver(Rule o){
		if(observerList == null){
			observerList = new ArrayList<Rule>();
		}
		observerList.add(o);
	}
	
	
	public void notifyObservers(Observer o){
		System.out.println("notify");
		o.update(this);
	}
	@Override
	public void run() {
		boolean contextIsTrue = httpHelper.parseHttpEndpoint(getUrl());
		
		if(this.contextFlag == false && contextIsTrue){/*false->trueが成立した時*/
			notifyObservers(this.contextObserver);
			this.contextFlag = true;
		}else if(this.contextFlag && !contextIsTrue){/*true->falseが成立した時*/
			//notifyObservers(this.contextObserver);
			this.contextFlag = false;
		}else if(!this.contextFlag && !contextIsTrue){ /*false->false*/
			this.contextFlag = false;
		}
	}
	
	public void setTimer(long interval){
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(this, 0, this.getMontoringInterval());
	}
	public void timerTaskStop() {
		this.cancel();
	}
	public ArrayList<ConditionModel> getConditionList() {
		return conditionList;
	}
	public void setConditionList(ArrayList<ConditionModel> conditionList) {
		this.conditionList = conditionList;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getMontorInterval() {
		return getMontoringInterval();
	}
	public long getMontoringInterval() {
		return montoringInterval;
	}
}
