package com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.helpdesk.utils;

import java.util.Comparator;

import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.helpdesk.enteties.SupportTicket;

public class CustomSupportTicketsComparator implements Comparator<SupportTicket> {

		@Override
		public int compare(SupportTicket t1, SupportTicket t2) {
			if (t1 == null || t2 == null || t1.getPriority() == null ||  
					t1.getPriority() == null) {
				return 0;
			}
			
			int a = t2.getPriority().compareTo(t1.getPriority());
			int b = t1.getSequentialNumber()-t2.getSequentialNumber();
			return (a == 0) ? b : a;
		}

	}
//     <write your code here>


