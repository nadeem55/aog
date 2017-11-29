package com.ge.aog.etl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import local_project.etlxml8hr_0_1.ETLXML8HR;


/**
 * To generate shift wise data.
 * @author Nadeem.Ahmed
 *
 */
public class JobEightHours implements Job {
	
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	private ETLXML8HR etlXML8HR = new ETLXML8HR();
	
	/**
	 * 
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException {

		try {
			System.out.println("Time is :[" + dateFormat.format(new Date()) + "] :[JobEightHours started]");
			
			// Run the XML file producer
			String[] args1 = {""};
			int exitCode = etlXML8HR.runJobInTOS(args1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
