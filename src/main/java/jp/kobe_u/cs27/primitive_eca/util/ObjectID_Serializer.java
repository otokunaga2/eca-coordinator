//package jp.kobe_u.cs27.primitive_eca.util;
//
//import java.io.IOException;
//
//import org.bson.types.ObjectId;
//
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.SerializerProvider;
//
//public class ObjectID_Serializer extends JsonSerializer<ObjectId>{
//	 
//	@Override
//	public void serialize(ObjectId objid, JsonGenerator jsongen, SerializerProvider arg2)
//			throws IOException, JsonProcessingException {
//		// TODO Auto-generated method stub
//		if(objid == null ){
//			jsongen.writeNull();
//		}else{
//			
//			jsongen.writeString(objid.toString());
//		}
//	}
//	
//	
//	
//	
// 
//}
