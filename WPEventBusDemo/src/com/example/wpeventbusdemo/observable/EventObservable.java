package com.example.wpeventbusdemo.observable;

import java.util.ArrayList;
import java.util.List;

import com.example.wpeventbusdemo.observer.IEventObserver;

/**
 * 具体得被观察者实现
 * 
 * @author whiskeyfei
 * 
 */
public class EventObservable implements IEventObservable {
	List<IEventObserver> mEventObservers = new ArrayList<IEventObserver>();

	@Override
	public synchronized void register(IEventObserver observer) {
		if (observer != null) {
			if (!mEventObservers.contains(observer)) {
				mEventObservers.add(observer);
			}
		}
	}

	@Override
	public synchronized void unregister(IEventObserver observer) {
		int index = mEventObservers.indexOf(observer);
		if (index >= 0) {
			mEventObservers.remove(observer);
		}
	}

	@Override
	public synchronized void notify(String eventType) {
		if (mEventObservers != null && mEventObservers.size() > 0 && eventType != null) {
			for (IEventObserver observer : mEventObservers) {
				observer.update(eventType);
			}
		}
	}

}