package com.demo.customlogger;

import java.nio.charset.Charset;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;

@Plugin(name = "CustomAppender", category = Core.CATEGORY_NAME, elementType = Appender.ELEMENT_TYPE, printObject = true)
public class CustomAppender extends AbstractStringLayout {

	protected CustomAppender(Charset charset) {
		super(charset);
	}
	
	@PluginFactory
	public static CustomAppender createLayout(
			@PluginAttribute(value = "charset", defaultString = "UTF-8") Charset charset) {
		return new CustomAppender(charset);
	}

	@Override
	public String toSerializable(LogEvent event) {
		System.out.println("Serializing...");
		return event.getMessage().getFormattedMessage().concat("\n");
	}

}
