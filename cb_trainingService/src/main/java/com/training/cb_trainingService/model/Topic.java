package com.training.cb_trainingService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Topic {
	private int id;
	private int trainingId;
	private String topics;
	public Topic(int id, int trainingId, String topics) {
		super();
		this.id = id;
		this.trainingId = trainingId;
		this.topics = topics;
	}
	public Topic() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	public String getTopics() {
		return topics;
	}
	public void setTopics(String topics) {
		this.topics = topics;
	}
	@Override
	public String toString() {
		return "Topic [id=" + id + ", trainingId=" + trainingId + ", topics=" + topics + "]";
	}
	
	
}
