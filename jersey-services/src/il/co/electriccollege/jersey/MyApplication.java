package il.co.electriccollege.jersey;

import java.util.Map;

import javax.ws.rs.ApplicationPath;

import com.sun.jersey.api.core.ResourceConfig;

@ApplicationPath("rest")
public class MyApplication extends ResourceConfig{
	
	public MyApplication() {
		this.
	}

	@Override
	public Map<String, Boolean> getFeatures() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getFeature(String featureName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getProperty(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

}
