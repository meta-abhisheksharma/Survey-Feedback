package com.survey.service;

import java.io.Serializable;
import java.util.Calendar;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class OptionIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SessionImplementor si, Object o)
			throws HibernateException {
		Calendar calendar = Calendar.getInstance();
		String id="opt_" + calendar.get(Calendar.HOUR_OF_DAY)
				+ calendar.get(Calendar.SECOND) + calendar.get(Calendar.DATE)
				+ calendar.get(Calendar.YEAR) + calendar.get(Calendar.MONTH);
		
		return id;
	}
}