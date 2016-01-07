package jp.kobe_u.cs27.primitive_eca;

import jp.kobe_u.cs27.primitive_eca.event.PrimitiveEvent;
import jp.kobe_u.cs27.primitive_eca.rule.ContextObserver;

public class Main {
	public static void main(String args[]){
		ContextObserver observer = new ContextObserver();
		PrimitiveEvent ctx  = new PrimitiveEvent(observer, "http://192.168.100.107:8080/test-execution/webapi/myresource/test");
		ctx.setTimer(1000);
	}
}
