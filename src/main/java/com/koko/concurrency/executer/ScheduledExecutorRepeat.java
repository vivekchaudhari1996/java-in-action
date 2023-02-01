package com.koko.concurrency.executer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorRepeat {

	private static int count = 0;

	public static void main(String[] args) throws InterruptedException {

		String strDateFormat = "hh:mm:ss a";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);

		ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

		Runnable task1 = () -> {
			System.out.println("ScheduledExecutorRepeat.main()");
			count++;
			if (count == 2) {
				try {
					TimeUnit.SECONDS.sleep(4);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Running...task1 - count : " + count + " time" + dateFormat.format(new Date()));
		};

		// init Delay = 5, repeat the task every 1 second
		ScheduledFuture<?> scheduledFuture = ses.scheduleAtFixedRate(task1, 5, 2, TimeUnit.SECONDS);

		while (true) {
			// System.out.println("count :" + count);
			Thread.sleep(1000);
			if (count == 5) {
				System.out.println("Count is 5, cancel the scheduledFuture!");
				scheduledFuture.cancel(true);
				ses.shutdown();
				break;
			}
		}
	}
}
