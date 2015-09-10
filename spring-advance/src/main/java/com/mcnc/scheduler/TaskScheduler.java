package com.mcnc.scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class TaskScheduler {
	private static Logger logger = LoggerFactory.getLogger(TaskScheduler.class);
	public void run() {
		//logger.setLevel(Level.INFO);
		//logger.setLevel(Level.DEBUG);
		logger.debug("Schedule!!!");
		logger.info("schedule!!!");
	}

}
