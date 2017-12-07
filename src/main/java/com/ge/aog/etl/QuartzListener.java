package com.ge.aog.etl;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 
 * @author Nadeem.Ahmed
 *
 */
public class QuartzListener implements ServletContextListener {

	Scheduler scheduler = null;

	/**
	 * 
	 */
	public void contextInitialized(ServletContextEvent servletContext) {

		System.out.println("Context Initialized");

		// One minute job
		try {
			// Setup the Job class and the Job group
			JobDetail job = newJob(JobOneMinute.class).withIdentity("CronQuartzJob1", "Group1").build();

			// Create a Trigger that fires every minute.
			Trigger trigger = newTrigger().withIdentity("TriggerName1", "Group1").withSchedule(CronScheduleBuilder.cronSchedule("30 0/1 * * * ?")).build();

			// Setup the Job and Trigger with Scheduler & schedule jobs
			scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);

		} catch (SchedulerException e) {
			e.printStackTrace();
		}

		// Eight hours job
		try {
			// Setup the Job class and the Job group
			JobDetail job = newJob(JobEightHours.class).withIdentity("CronQuartzJob2", "Group2").build();

			// Create a Trigger that fires every minute.
			Trigger trigger = newTrigger().withIdentity("TriggerName2", "Group2").withSchedule(CronScheduleBuilder.cronSchedule("0 30 7 1/1 * ?")).build();

			// Setup the Job and Trigger with Scheduler & schedule jobs
			scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);

		} catch (SchedulerException e) {
			e.printStackTrace();
		}

		// One day/24 hours job
		try {
			// Setup the Job class and the Job group
			JobDetail job = newJob(JobOneDay.class).withIdentity("CronQuartzJob3", "Group3").build();

			// Create a Trigger that fires every minute.
			Trigger trigger = newTrigger().withIdentity("TriggerName3", "Group3").withSchedule(CronScheduleBuilder.cronSchedule("0 30 7 1/1 * ?")).build();

			// Setup the Job and Trigger with Scheduler & schedule jobs
			scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);

		} catch (SchedulerException e) {
			e.printStackTrace();
		}

		//Weekly job
		try {
			// Setup the Job class and the Job group
			JobDetail job = newJob(JobOneWeek.class).withIdentity("CronQuartzJob4", "Group4").build();

			// Create a Trigger that fires every minute.
			//Trigger trigger = newTrigger().withIdentity("TriggerName4", "Group4").withSchedule(CronScheduleBuilder.cronSchedule("0 0 11 ? * SUN *")).build();
			Trigger trigger = newTrigger().withIdentity("TriggerName4", "Group4").withSchedule(CronScheduleBuilder.cronSchedule("0 0 16 1/1 * ?")).build();

			// Setup the Job and Trigger with Scheduler & schedule jobs
			scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);

		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void contextDestroyed(ServletContextEvent servletContext) {

		System.out.println("Context Destroyed");
		try {
			scheduler.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}
