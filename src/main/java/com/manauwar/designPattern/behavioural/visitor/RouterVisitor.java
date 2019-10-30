package com.manauwar.designPattern.behavioural.visitor;

public interface RouterVisitor {
	
	public void visit(DLinkRouter router);
	public void visit(TPLinkRouter router);
	public void visit(NetgearRouter router);
	

}
