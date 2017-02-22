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
package org.openmrs.module.gestation.api.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Person;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.gestation.ChildHealthCard;
import org.openmrs.module.gestation.Gestation;
import org.openmrs.module.gestation.api.GestationService;
import org.openmrs.module.gestation.api.db.GestationDAO;

import java.util.Date;
import java.util.List;

/**
 * It is a default implementation of {@link GestationService}.
 */
public class GestationServiceImpl extends BaseOpenmrsService implements GestationService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private GestationDAO dao;
	
	/**
     * @param dao the dao to set
     */
    public void setDao(GestationDAO dao) {
	    this.dao = dao;
    }
    
    /**
     * @return the dao
     */
    public GestationDAO getDao() {
	    return dao;
    }
	
	@Override
	public Gestation saveGestation(Gestation gestation){
		return dao.saveGestation(gestation);
	}
	@Override
	public List<Gestation> getGestation(){
		return dao.getGestation();
	}
	@Override
	public List<Gestation> getFilteredGestation(Date startDate, Date endDate){
		return dao.getFilteredGestation(startDate, endDate);
	}
	@Override
	public List<Gestation> getPersonGestation(Person p){
		return dao.getPersonGestation(p);
	}
	
	@Override
	public List<Gestation> getGestation(int r){
		return dao.getGestation(r);
	}
	
	@Override
	public Gestation checkPersonGestation(Person p){
		return dao.checkPersonGestation(p);
	}
	
	@Override
	public Gestation checkStudyNo(String iden){
		return dao.checkStudyNo(iden);
	}
	
	@Override
	public Gestation getGestationByUuid(String uuid){
		return dao.getGestationByUuid(uuid);
	}
	@Override
	public List<Gestation> searchGestationPatients(String term){
		return dao.searchGestationPatients(term);
	}
	public ChildHealthCard saveChildHealthCard(ChildHealthCard card){
		return dao.saveChildHealthCard(card);
	}
	public String  getPatientByIdentifier(String identifier){
		return dao.getPatientByIdentifier(identifier);
	}
}