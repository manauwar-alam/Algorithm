package com.manauwar.unitTest.designPattern;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.manauwar.designPattern.behavioural.visitor.*;

public class TestVisitorPattern {

	private static MacConfigurator macConfigurator;
	private static LinuxConfigurator linuxConfigurator;
	private static DLinkRouter dlink;
	private static TPLinkRouter tplink;
	private static NetgearRouter netgear;

	@BeforeAll
	public static void setUp() {

		System.out.println("Setup Started ...");
		macConfigurator = new MacConfigurator();
		linuxConfigurator = new LinuxConfigurator();

		dlink = new DLinkRouter();
		tplink = new TPLinkRouter();
		netgear = new NetgearRouter();

	}

	@Test
	public void testDlink() {
		dlink.accept(macConfigurator);
		dlink.accept(linuxConfigurator);
	}

	@Test
	public void testTPLink() {
		tplink.accept(macConfigurator);
		tplink.accept(linuxConfigurator);
	}

	@Test
	public void testNetGear() {
		netgear.accept(macConfigurator);
		netgear.accept(linuxConfigurator);
	}

}
