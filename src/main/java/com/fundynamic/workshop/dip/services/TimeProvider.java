package com.fundynamic.workshop.dip.services;

public interface TimeProvider {

	static TimeProvider getInstanceWithCurrentTimeInMilis() {
		return new TimeProvider() {
			@Override
			public long getCurrentTimeInMs() {
				return System.currentTimeMillis();
			}
		};
	}

	long getCurrentTimeInMs();
}
