package jp.kobe_u.cs27.primitive_eca.webapi;

import java.io.IOException;

import org.bson.types.ObjectId;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.module.SimpleModule;

public class ObjectIdSerializerModule extends SimpleModule {
	
	  public ObjectIdSerializerModule() {
	        super("ObjectIdSerializerModule", new Version(0, 1, 0, "alpha"));
	        this.addSerializer(ObjectId.class, new ObjectIdJsonSerializer());
	    }

	public class ObjectIdJsonSerializer extends JsonSerializer<ObjectId> {

	
		@Override
		public void serialize(ObjectId arg0, JsonGenerator jsonGen, SerializerProvider arg2)
				throws IOException, JsonProcessingException {
			
			jsonGen.writeStartObject();
			jsonGen.writeFieldName("_id");
			jsonGen.writeRawValue(arg0.toString());
			System.out.println("json serialize"+arg0.toString());
			jsonGen.writeEndObject();
			// TODO Auto-generated method stub
			
		}
	}

}

