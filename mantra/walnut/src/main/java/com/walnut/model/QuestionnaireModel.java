package com.walnut.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "questionnaire")
public class QuestionnaireModel extends AbstractResponse {
	@Id
	String id;
	
	String duration;
    public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getBundle_id() {
		return bundle_id;
	}

	public void setBundle_id(String bundle_id) {
		this.bundle_id = bundle_id;
	}

	String bundle_id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Question_set> getQuestion_set() {
		return question_set;
	}

	public void setQuestion_set(List<Question_set> question_set) {
		this.question_set = question_set;
	}

	List<Question_set> question_set;

	public class Question_set {

		
		public String getQuestion() {
			return question;
		}
		public void setQuestion(String question) {
			this.question = question;
		}
		public String getQuestion_type() {
			return question_type;
		}
		public void setQuestion_type(String question_type) {
			this.question_type = question_type;
		}
		public String getAnswer_type() {
			return answer_type;
		}
		public void setAnswer_type(String answer_type) {
			this.answer_type = answer_type;
		}
		public List<Options> getOptions() {
			return options;
		}
		public void setOptions(List<Options> options) {
			this.options = options;
		}
		List<Options> options;
	
		 String question ;
         String question_type;
         String answer_type;
         public class Options{
     		String option_text;
     		public String getOption_text() {
     			return option_text;
     		}
     		public void setOption_text(String option_text) {
     			this.option_text = option_text;
     		}
     		public String getOptionId() {
     			return optionId;
     		}
     		public void setOptionId(String optionId) {
     			this.optionId = optionId;
     		}
     		String optionId;

     	}

	}

	

}
