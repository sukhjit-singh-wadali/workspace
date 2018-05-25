package com.walnut.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mapping")
public class MappingModel extends AbstractResponse {

	List<Flow> flow;

	public List<Flow> getFlow() {
		return flow;
	}

	public void setFlow(List<Flow> flow) {
		this.flow = flow;
	}

	public class Flow {

		String current_question;
		String next_question;

		public String getCurrent_question() {
			return current_question;
		}

		public void setCurrent_question(String current_question) {
			this.current_question = current_question;
		}

		public String getNext_question() {
			return next_question;
		}

		public void setNext_question(String next_question) {
			this.next_question = next_question;
		}

	}

}
