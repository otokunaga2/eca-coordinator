//package jp.kobe_u.cs27.primitive_eca.webapi;
//
//import static org.junit.Assert.*;
//
//import java.io.IOException;
//import java.io.StringWriter;
//
//import org.bson.types.ObjectId;
//import org.codehaus.jackson.JsonGenerationException;
//import org.codehaus.jackson.annotate.JsonValue;
//import org.codehaus.jackson.map.JsonMappingException;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.codehaus.jackson.map.annotate.JsonSerialize;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import jp.kobe_u.cs27.primitive_eca.model.EventModel;
//
//public class ObjectIdJsonSerializerTest {
//	private ObjectIdJsonSerializer serializer;
//	private EventModel model;
//	@Before
//	public void setUp() throws Exception {
//		serializer = new ObjectIdJsonSerializer();
//		model = new EventModel();
//		model.setUrl("http://example.com");
//		ObjectId lId =new ObjectId("5692330515c641b3624a59f5");
//		model.setId(lId);
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}
//
//	@JsonSerialize(using=ObjectIdJsonSerializer.class)
//	private ObjectId getId(EventModel em){
//		return em.getId();
//	}
//	@JsonSerialize(using=ObjectIdJsonSerializer.class)
//	
//	
//	@Test
//	public void testSerializeObjectIdJsonGeneratorSerializerProvider() {
//		ObjectMapper objectmapper =new ObjectMapper();
//		StringWriter writer =new StringWriter();
//		try {
//			objectmapper.writeValue(writer, model);
//			System.out.println(writer);
//		} catch (JsonGenerationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//			
//	}
//
//}
