/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.gestation.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.openmrs.Person;
import org.openmrs.api.db.DAOException;
import org.openmrs.module.gestation.ChildHealthCard;
import org.openmrs.module.gestation.Gestation;
import org.openmrs.module.gestation.api.db.GestationDAO;

import java.util.Date;
import java.util.List;

/**
 * It is a default implementation of  {@link GestationDAO}.
 */
public class HibernateGestationDAO implements GestationDAO {
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private SessionFactory sessionFactory;
	
	/**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
    }
    
	/**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
	    return sessionFactory;
    }
	
	@Override
	public Gestation saveGestation(Gestation gestation) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(gestation);
			return gestation;
		} catch (Throwable t) {
			throw new DAOException(t);
		}
	}
	
	@Override
	public List<Gestation> getGestation() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Gestation.class)
				.addOrder(Order.desc("id")) .add(Expression.eq("voided", false));

		return criteria.list();
	}
	
	@Override
	public List<Gestation> getFilteredGestation(Date startDate, Date endDate) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Gestation.class)
				.addOrder(Order.desc("id"))
                .add(Expression.eq("voided", false))

        .add(Expression.between("dateCaptured", startDate, endDate));

		return criteria.list();
	}
	
	@Override
	public List<Gestation> getPersonGestation(Person p) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Gestation.class)
				.addOrder(Order.desc("id"))
				.add(Expression.eq("person", p)) .add(Expression.eq("voided", false));


        return criteria.list();
	}
	
	@Override
	public List<Gestation> getGestation(int r) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Gestation.class)
				.addOrder(Order.desc("id"))
				.add(Expression.eq("id", r))
                .add(Expression.eq("voided", false));


        return criteria.list();
	}
	
	@Override
	public Gestation checkPersonGestation(Person p) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Gestation.class)
				.addOrder(Order.desc("id"))
				.add(Expression.eq("person", p))
                .add(Expression.eq("voided", false));


        @SuppressWarnings("unchecked")
		List<Gestation> g = criteria.list();
		if (null == g || g.isEmpty()) {
			return null;
		}
		return g.get(0);
	}
	
	@Override
	public Gestation checkStudyNo(String iden) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Gestation.class)
				.addOrder(Order.desc("id"))
				.add(Expression.eq("studyNo", iden))
                .add(Expression.eq("voided", false));


        @SuppressWarnings("unchecked")
		List<Gestation> g = criteria.list();
		if (null == g || g.isEmpty()) {
			return null;
		}
		return g.get(0);
	}
	
	@Override
	public Gestation getGestationByUuid(String uuid){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Gestation.class)
				.addOrder(Order.desc("id"))
				.add(Expression.eq("uuid", uuid))
                .add(Expression.eq("voided", false));



		@SuppressWarnings("unchecked")
		List<Gestation> g = criteria.list();
		if (null == g || g.isEmpty()) {
			return null;
		}
		return g.get(0);
	}
	
	public List<Gestation> searchGestationPatients(String term){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Gestation.class)
				.addOrder(Order.desc("patient_name"))
				.add(Expression.like("patient_name", term))
				.add(Expression.like("identifier", term))
                .add(Expression.eq("voided", false));


        return criteria.list();
	}
	public ChildHealthCard saveChildHealthCard(ChildHealthCard card){
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(card);
			return card;
		} catch (Throwable t) {
			throw new DAOException(t);
		}
	}
	public String  getPatientByIdentifier(String identifier){
		String sql="SELECT patient_id FROM patient_identifier WHERE identifier LIKE :patient_identifier ";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("patient_identifier",identifier+"%");
		return query.uniqueResult().toString();

	}
}