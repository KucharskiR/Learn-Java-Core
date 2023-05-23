package com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.helpdesk.enteties.impl;

import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.helpdesk.enteties.Priority;
import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.helpdesk.enteties.RequestType;
import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.helpdesk.enteties.SupportTicket;

public class DefaultSupportTicket implements SupportTicket {

	static int id;
	int sequentionalNumber;

	RequestType type;

	{
		sequentionalNumber = ++id;
	}

	public DefaultSupportTicket() {
	}

	public DefaultSupportTicket(RequestType type) {
		super();
		this.type = type;
	}

	@Override
	public Priority getPriority() {
		if (type == null) {
			return null;
		}
		return this.type.getPriority();
	}

	@Override
	public int getSequentialNumber() {
		return this.sequentionalNumber;
	}

	@Override
	public RequestType getRequestType() {
		return this.type;
	}

//    <write your code here>

}
