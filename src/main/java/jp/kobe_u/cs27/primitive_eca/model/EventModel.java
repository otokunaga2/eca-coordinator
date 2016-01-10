package jp.kobe_u.cs27.primitive_eca.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;
import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import jp.kobe_u.cs27.primitive_eca.webapi.ObjectIdSerializerModule.ObjectIdJsonSerializer;



@XmlRootElement
@Entity("event")
//@Indexes(@Index(value = "value", fields = @Field("value") ))
public class EventModel {

	@Id
	private String id = new ObjectId().toHexString();
	private String url;
	private long monitoringInterval;
	public long getSeepTime() {
		return monitoringInterval;
	}
	public void setSeepTime(long seepTime) {
		this.monitoringInterval = seepTime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@JsonSerialize(using=ObjectIdJsonSerializer.class)
	public String getId() {
		return id;
	}
	@JsonSerialize(using=ObjectIdJsonSerializer.class)
	public void setId(String id) {
		this.id = id;
	}
}
