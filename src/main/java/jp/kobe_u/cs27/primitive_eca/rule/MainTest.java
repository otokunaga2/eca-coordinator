package jp.kobe_u.cs27.primitive_eca.rule;

import jp.kobe_u.cs27.primitive_eca.action.Action;
import jp.kobe_u.cs27.primitive_eca.dao.PrimitiveEvent;

public class MainTest {

	public static void main(String args[]){
		Rule rule = new Rule();
		PrimitiveEvent event = new PrimitiveEvent(rule, "http://192.168.100.107:8080/LOCS4Beacon/api/isthere?userid=tokunaga&location=tktk%20desk"
);
		Action action = new Action();
		rule.createRule(event, null, null);
		rule.startMonitoring();
	}
}
