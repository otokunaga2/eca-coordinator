package jp.kobe_u.cs27.primitive_eca.event;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import jp.kobe_u.cs27.primitive_eca.dao.PrimitiveCondition;
import jp.kobe_u.cs27.primitive_eca.http_handler.HttpHelper;
import jp.kobe_u.cs27.primitive_eca.rule.ContextObserver;
import jp.kobe_u.cs27.primitive_eca.rule.Observer;

/**
 * @author otokunaga
 *
 */
public class PrimitiveEvent extends TimerTask {
	private String url;
	private boolean contextFlag;
	private Observer contextObserver;
	HttpHelper httpHelper;
	private ArrayList<PrimitiveCondition> conditionList;
	public PrimitiveEvent(Observer observer,String url){/*conditionを持たないコンストラクタ*/
		httpHelper = new HttpHelper();
		this.contextObserver = observer;
		this.url = url;
		this.setConditionList(null);
	}
	public PrimitiveEvent(Observer observer,String url,ArrayList<PrimitiveCondition> conditionList){/*conditionを持つコンストラクタ*/
		httpHelper = new HttpHelper();
		this.contextObserver = observer;
		this.url = url;
		this.setConditionList(conditionList);
	}
	
	
	ArrayList<Observer> observerList;
	public void addObserver(Observer o){
		if(observerList == null){
			new ArrayList<ContextObserver>();
		}
		observerList.add(o);
	}
	
	
	public void notifyObservers(Observer o){
		System.out.println("notify");
		o.update(this);
	}
	@Override
	public void run() {
		boolean contextIsTrue = httpHelper.parseHttpEndpoint(url);
		
		if(this.contextFlag == false && contextIsTrue){/*false->trueが成立した時*/
			notifyObservers(this.contextObserver);
//			for(Observer o: observerList){
//				try{
//					notifyObservers(o);
//				}catch(NullPointerException e){
//					e.printStackTrace();
//				}
//			}
			this.contextFlag = true;
		}else if(this.contextFlag && !contextIsTrue){/*true->falseが成立した時*/
			notifyObservers(this.contextObserver);
			this.contextFlag = false;
		}
	}
	
	public void setTimer(long interval){
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(this, 0, interval);
	}
	public void timerTaskStop() {
		this.cancel();
	}
	public ArrayList<PrimitiveCondition> getConditionList() {
		return conditionList;
	}
	public void setConditionList(ArrayList<PrimitiveCondition> conditionList) {
		this.conditionList = conditionList;
	}
	

}
