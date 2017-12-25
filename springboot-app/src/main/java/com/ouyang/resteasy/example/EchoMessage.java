package com.ouyang.resteasy.example;

public class EchoMessage {
	
	public EchoMessage() {
        super();
    }
	
    @Override
	public String toString() {
		return "EchoMessage [timestamp=" + timestamp + ", echoText=" + echoText
				+ "]";
	}

	private long timestamp;
    private String echoText;

    public EchoMessage(String echoText) {
        timestamp = System.currentTimeMillis();
        this.echoText = echoText;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getEchoText() {
        return echoText;
    }

}
