package org.auvua.sim;

public class MockHardware {
	
	public double[] pos = {0,0,0};
	public double[] vel = {0,0,0};
	
	public double[] angle = {0,0,0};
	public double[] omega = {0,0,0};
	
	public double[] force = {0,0,0};
	public double[] tau = {0,0,0};
	
	public long lastTime = System.currentTimeMillis();
	public long currTime = System.currentTimeMillis();
	
	private static final MockHardware instance = new MockHardware();
	
	public MockHardware() {}
	
	public static MockHardware getInstance() {
		return instance;
	}

	public void getState() {
		// TODO Auto-generated method stub
		
	}
	
	public void setState() {
		// TODO Auto-generated method stub
		
	}
}
