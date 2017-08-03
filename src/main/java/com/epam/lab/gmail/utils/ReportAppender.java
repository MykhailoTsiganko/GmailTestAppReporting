package com.epam.lab.gmail.utils;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.testng.Reporter;

public class ReportAppender extends AppenderSkeleton {

	@Override
	protected void append(final LoggingEvent event) {
		Reporter.log(eventToString(event));
	}

	private String eventToString(final LoggingEvent event) {
		final StringBuilder buff = new StringBuilder(layout.format(event));

		if (layout.ignoresThrowable()) {
			final String[] s = event.getThrowableStrRep();
			if (s != null) {
				for (final String value : s) {
					buff.append(value).append(Layout.LINE_SEP);
				}
			}
		}
		String result = buff.toString();
		if (event.getLevel().equals(Level.WARN) || event.getLevel().equals(Level.FATAL)
				|| event.getLevel().equals(Level.ERROR)) {
			result = "<span style='color:red'>" + result + "</span>";
		} else if(event.getLevel().equals(Level.DEBUG) || event.getLevel().equals(Level.INFO)
				|| event.getLevel().equals(Level.TRACE)) {
			result = "<span style='color:green'>" + result + "</span>";
		}		
	
		return "<br>" + result ;
	}

	@Override
	public void close() {

	}

	@Override
	public boolean requiresLayout() {
		return true;
	}
}
