package org.auvua.model;

import java.util.HashMap;
import java.util.Map;

import org.auvua.model.actuators.Motor;
import org.auvua.model.sensors.Compass;
import org.auvua.model.sensors.DepthGauge;
import org.auvua.model.sensors.Switch;
import org.auvua.sim.MockHardware;

public class Model {
	
	public Map<String,Object> robot = new HashMap<String,Object>();
	
	private static final Model instance = new Model();
	
	public Model() {
		Map<String,Object> hardware = newMap();
		hardware.put("surgeLeft",     ComponentFactory.create(Component.MOTOR));
		hardware.put("surgeRight",    ComponentFactory.create(Component.MOTOR));
		hardware.put("heaveLeft",     ComponentFactory.create(Component.MOTOR));
		hardware.put("heaveRight",    ComponentFactory.create(Component.MOTOR));
		hardware.put("sway",          ComponentFactory.create(Component.MOTOR));
		hardware.put("depthGauge",    ComponentFactory.create(Component.DEPTHGAUGE));
		hardware.put("compass",       ComponentFactory.create(Component.COMPASS));
		hardware.put("missionSwitch", ComponentFactory.create(Component.SWITCH));
		hardware.put("killSwitch",    ComponentFactory.create(Component.SWITCH));
		
		Map<String,Object> imageFilters = newMap();
		
		Map<String,Object> controlLoops = newMap();
		
		robot = newMap();
		robot.put("hardware", hardware);
		robot.put("imageFilters", imageFilters);
		robot.put("controlLoops", controlLoops);
	}
	
	public static Model getInstance() {
		return instance;
	}
	
	public static Map<String,Object> newMap() {
		return new HashMap<String,Object>();
	}
	
	public void getState() {
		// Receive hardware update via ZMQ
		MockHardware.getInstance().getState();
	}

	public void setState() {
		// Send hardware update via ZMQ
		MockHardware.getInstance().setState();
	}

}
