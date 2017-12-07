package com.ge.aog.etl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import local_project.etlxml24hr_0_1.ETLXML24HR;
import local_project.prodetlxml_0_1.ProdETLXML;

public class JobOneDay implements Job {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	private ETLXML24HR etlXML24HR = new ETLXML24HR();
	
	/**
	 * 
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException {

		try {
			System.out.println("Time is :[" + dateFormat.format(new Date()) + "] :[JobOneDay started]");
			
			// Run the XML file producer
			String[] args1 = {""};
			int exitCode = etlXML24HR.runJobInTOS(args1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
