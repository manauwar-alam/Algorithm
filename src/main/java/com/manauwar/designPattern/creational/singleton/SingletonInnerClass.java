package com.manauwar.designPattern.creational.singleton;

import java.io.Serializable;

public class SingletonInnerClass implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	protected Object clone() throws CloneNotSupportedException {

		return new CloneNotSupportedException();
	}

	protected Object readResolve() {
		return createInstance();
	}

	private SingletonInnerClass() {

	}

	/*
	 * public String toString() { return "SingletonUsingInnerClass"; }
	 */

	private static class LazyInit {
		private static final SingletonInnerClass instance = new SingletonInnerClass();

	}

	static SingletonInnerClass createInstance() {
		return LazyInit.instance;
	}

}
