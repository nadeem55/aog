package com.ge.aog.etl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import local_project.weeklyxml_0_1.WeeklyXML;

public class JobOneWeek implements Job  {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	private WeeklyXML etlWeeklyXML = new WeeklyXML();
	
	/**
	 * 
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException {

		try {
			System.out.println("Time is :[" + dateFormat.format(new Date()) + "] :[JobOneWeek started]");
			
			// Run the XML file producer
			String[] args1 = {""};
			int exitCode = etlWeeklyXML.runJobInTOS(args1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
