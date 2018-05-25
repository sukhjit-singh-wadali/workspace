package com.walnut.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "languages")
public class PracticeModel extends AbstractResponse {
	@Id
	String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	List<Properties> properties;

	public List<Properties> getProperties() {
		return properties;
	}

	public void setProperties(List<Properties> properties) {
		this.properties = properties;
	}

	public class Properties {

		String types;

		public String getTypes() {
			return types;
		}

		public void setTypes(String types) {
			this.types = types;
		}

	}

}
