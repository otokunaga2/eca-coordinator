package jp.kobe_u.cs27.primitive_eca.action;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * @author otokunaga
 *
 */
public class Action {
	private String url;
	private String actionId;
	

	public Action(String actionid, String url) {
		this.actionId = actionid;
		this.url = url;
	}

	/**
	 * DBの更新
	 *
	 * @return
	 */
	public boolean update() {
		return new ActionDAO().update();
	}
	

	/**
	 * URLを叩く
	 *
	 * @param urltext
	 */
	public void invokeUrl() {
		String text = this.url;
		String urltext = "";
		/*
		 * URLに日本語が含まれる場合の処理 "?"以降(=引数)を切り取って、UTF-8エンコード
		 * その後、"?"以前の文字列の後ろに結合させ、叩く
		 */
		try {
			if (text.indexOf("?") != -1) {
				// System.out.println("text:" + text);
				int index = text.indexOf("?") + 1;
				String endtext = URLEncoder.encode(text.substring(index),
						"UTF-8");
				// System.out.println("endtext:" + endtext);
				// エンコードの必要のない=と&を元に戻す
				endtext = endtext.replaceAll("%3D", "=");
				endtext = endtext.replaceAll("%26", "&");
				urltext = (text.substring(0, (index)) + endtext);
				// System.out.println("urltext:" + urltext);
			} else {
				urltext = text;
			}

			URL url = new URL(urltext);
			URLConnection connection = url.openConnection();
			connection.setDoInput(true);
			@SuppressWarnings("unused")
			InputStream inStream = connection.getInputStream();
		} catch (IOException | NullPointerException e) {
			e.printStackTrace();
		}
	}

	
	public String getUrl() {
		return url;
	}

	
	
	public void setUrl(String url) {
		this.url = url;
	}

	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

}
