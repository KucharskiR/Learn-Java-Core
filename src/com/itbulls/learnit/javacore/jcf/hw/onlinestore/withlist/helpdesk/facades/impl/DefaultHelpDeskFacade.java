package com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.helpdesk.facades.impl;

import java.util.PriorityQueue;
import java.util.Queue;

import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.helpdesk.enteties.SupportTicket;
import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.helpdesk.facades.HelpDeskFacade;
import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.helpdesk.utils.CustomSupportTicketsComparator;

public class DefaultHelpDeskFacade implements HelpDeskFacade {
	
	Queue<SupportTicket> queue;
	
	{
		queue = new PriorityQueue<>(new CustomSupportTicketsComparator());
	}

	@Override
	public void addNewSupportTicket(SupportTicket supportTicket) {
		queue.offer(supportTicket);
	}

	@Override
	public SupportTicket getNextSupportTicket() {
		return queue.poll();
	}

	@Override
	public int getNumberOfTickets() {
		return queue.size();
	}
	
//    <write your code here>

}

