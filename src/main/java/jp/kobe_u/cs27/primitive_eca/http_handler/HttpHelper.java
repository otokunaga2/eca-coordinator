package jp.kobe_u.cs27.primitive_eca.http_handler;

import java.io.IOException;

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
	public boolean parseHttpEndpoint(String url){
		Document document = null;
		try {
			document = Jsoup.connect(url).parser(Parser.xmlParser()).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * todo タグ名は柔軟にやりたい
		 * 
		 */
		Element element = document.getElementById("value");
		String result = null;
		for(Element e: document.select("value")){
			result = e.text();
		}
		this.result = Boolean.parseBoolean(result);
		return this.result;
	}
}
