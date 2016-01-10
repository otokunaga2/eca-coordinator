package jp.kobe_u.cs27.primitive_eca.http_handler;

import java.io.IOException;
import java.net.SocketTimeoutException;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

/**
 * @author otokunaga
 *
 */
public class HttpHelper {
	private boolean result = false;
	private static final String tagName = "result";

	public boolean fakeGetHttpResponse(){
		return true;
	}
	public boolean parseHttpEndpoint(String url){
		Document document = null;
		try {
			document = Jsoup.connect(url).parser(Parser.xmlParser()).get();
		}catch(SocketTimeoutException e){
			return false;
		}catch (HttpStatusException e){
			e.printStackTrace();
			return false;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		} finally {
			
		}
		/**
		 * todo タグ名は柔軟にやりたい
		 * 
		 */
		Element element;
		try{
			element = document.getElementById(tagName);
		}catch(NullPointerException e){
			return false;
		}
		String result = null;
		for(Element e: document.select(tagName)){
			result = e.text();
		}
		this.result = Boolean.parseBoolean(result);
		return this.result;
	}
}
