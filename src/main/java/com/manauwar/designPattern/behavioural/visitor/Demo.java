package com.manauwar.designPattern.behavioural.visitor;

public class Demo {
	
	
	
	private MacConfigurator macConfigurator;
    private LinuxConfigurator linuxConfigurator;
    private DLinkRouter dlink;
    private TPLinkRouter tplink;
    private NetgearRouter netgear;

	public static void main(String[] args) {
		
		Demo demo = new Demo();
		
		demo.setUp();
		demo.testDlink();
		demo.testNetgear();
		demo.testTPLink();
		
	}
	

     
    public void setUp()
    {
        macConfigurator = new MacConfigurator();
        linuxConfigurator = new LinuxConfigurator();
         
        dlink = new DLinkRouter();
        tplink = new TPLinkRouter();
        netgear = new NetgearRouter();
    }
     
    public void testDlink()
    {
        dlink.accept(macConfigurator);
        dlink.accept(linuxConfigurator);
    }
     
    public void testTPLink()
    {
        tplink.accept(macConfigurator);
        tplink.accept(linuxConfigurator);
    }
     
    public void testNetgear()
    {
    	netgear.accept(macConfigurator);
    	netgear.accept(linuxConfigurator);
    }

}
