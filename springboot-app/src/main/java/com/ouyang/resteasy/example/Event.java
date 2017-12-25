package com.ouyang.resteasy.example;

public class Event {

	@Override
	public String toString() {
		return "Event [timestamp=" + timestamp + ", name=" + name + "]";
	}

	private long timestamp;
	private String name;

	public Event() {
		super();
	}

	public Event(String name) {
		super();
		this.name = name;
		this.timestamp = System.currentTimeMillis();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public long getTimestamp() {
		return timestamp;
	}

}
