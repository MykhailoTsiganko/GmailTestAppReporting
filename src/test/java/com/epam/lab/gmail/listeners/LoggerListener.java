package com.epam.lab.gmail.listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LoggerListener implements ITestListener{
	public static Logger logger = Logger.getLogger(LoggerListener.class);

	@Override
	public void onTestStart(ITestResult result) {
		logger.info(result.toString());
		
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info(result.toString());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.warn(result.toString());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info(result.toString());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		logger.info(result.toString());
		
	}

	@Override
	public void onStart(ITestContext context) {
		logger.info(context.toString());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info(context.toString());

		
	}

}
