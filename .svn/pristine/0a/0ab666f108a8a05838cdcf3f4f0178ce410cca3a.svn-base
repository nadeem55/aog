package com.ge.aog.etl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import local_project.prodetlxml_0_1.ProdETLXML;

/**
 * 
 * @author Nadeem.Ahmed
 *
 */
public class JobOneMinute implements Job {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	private ProdETLXML prodETLXML = new ProdETLXML();

	/**
	 * 
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException {

		try {
			System.out.println("Time is :[" + dateFormat.format(new Date()) + "] :[JobOneMinute started]");

			// Run the XML file producer
			String[] args1 = { "" };
			int exitCode = prodETLXML.runJobInTOS(args1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
