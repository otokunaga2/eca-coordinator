package jp.kobe_u.cs27.primitive_eca;

import jp.kobe_u.cs27.primitive_eca.dao.PrimitiveEvent;
import jp.kobe_u.cs27.primitive_eca.rule.Rule;

public class Main {
	public static void main(String args[]){
		Rule observer = new Rule();
		PrimitiveEvent ctx  = new PrimitiveEvent(observer, "http://192.168.100.107:8080/test-execution/webapi/myresource/test");
		ctx.setTimer(1000);
	}
}
