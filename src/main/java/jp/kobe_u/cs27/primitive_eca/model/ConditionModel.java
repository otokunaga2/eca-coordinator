package jp.kobe_u.cs27.primitive_eca.model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;

/**
 * @author otokunaga
 *
 */
@Entity("condition")
@Indexes(@Index(value = "value", fields = @Field("value") ))
public class ConditionModel {
	@Id
	private String id;
	private String url;
	public ConditionModel(String url) {
		this.url = url;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
