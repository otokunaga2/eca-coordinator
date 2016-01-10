package jp.kobe_u.cs27.primitive_eca.webapi;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import jp.kobe_u.cs27.primitive_eca.db_helper.JacksonObjectMapperProvider;

public class MyApplication extends Application {
	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<Class<?>>();
        resources.add(JacksonObjectMapperProvider.class);
        resources.add(MyResource.class);
        return resources;
    }
}
