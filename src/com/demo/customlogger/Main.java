package com.demo.customlogger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	
	private static final Logger log = LogManager.getLogger(Main.class.getName());

	public static void main(String[] args) {
		log.trace("tracing");
        log.debug("debugging");
        log.info("For your info!");
        log.warn("Warnings");
        log.error("Errors");
        log.fatal("Fatal");
	}
}
