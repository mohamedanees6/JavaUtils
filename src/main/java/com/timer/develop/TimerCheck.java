package com.timer.develop;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TimerCheck {
	public static void main(String[] args) {
		ScheduledFuture<?> scheduledFuture = null;
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
		while (true) {
			scheduledFuture = scheduledExecutorService.schedule(new Callable<String>() {
				public String call() throws Exception {
					Thread.currentThread().setName("My thread");
					if (Thread.currentThread().getName().equals("My Thread")) {
						System.out.println("Name is same");
					} else {
						System.out.println(Thread.currentThread().getName());
					}
					String result = "Result retrieved.";
					return result;
				}
			}, 2, TimeUnit.SECONDS);

			try {
				// result
				System.out.println("result = " + scheduledFuture.get());
			} catch (Exception e) {
				System.err.println("Caught exception: " + e.getMessage());
			}
		}

	}
}
