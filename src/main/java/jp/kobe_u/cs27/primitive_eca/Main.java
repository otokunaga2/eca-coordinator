package jp.kobe_u.cs27.primitive_eca;

import jp.kobe_u.cs27.primitive_eca.dao.EventDAO;
import jp.kobe_u.cs27.primitive_eca.model.EventModel;
import jp.kobe_u.cs27.primitive_eca.rule.Rule;
import jp.kobe_u.cs27.primitive_eca.service.Event;

public class Main {
	public static void main(String args[]){
		Rule observer = new Rule();
		Event ctx  = new Event(observer, "http://192.168.100.107:8080/test-execution/webapi/myresource/test");
		ctx.setTimer(1000);
//		EventDAO dao =new EventDAO();
//		EventModel model =new EventModel();
//		model.setUrl("http://test.example.com");
//		dao.save(model);
	}
}
