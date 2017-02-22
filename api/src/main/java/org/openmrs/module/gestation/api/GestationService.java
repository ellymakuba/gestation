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
package org.openmrs.module.gestation.api;

import org.openmrs.Person;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.gestation.ChildHealthCard;
import org.openmrs.module.gestation.Gestation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * This service exposes module's core functionality. It is a Spring managed bean which is configured in moduleApplicationContext.xml.
 * <p>
 * It can be accessed only via Context:<br>
 * <code>
 * Context.getService(GestationService.class).someMethod();
 * </code>
 * 
 * @see org.openmrs.api.context.Context
 */
@Transactional
public interface GestationService extends OpenmrsService {
     
	public Gestation saveGestation(Gestation gestation);
	
	public List<Gestation> getGestation();
	
	public List<Gestation> getFilteredGestation(Date startDate, Date endDate);
	
	public List<Gestation> getPersonGestation(Person p);
	
	public List<Gestation> getGestation(int r);
	
	public Gestation checkPersonGestation(Person p);
	
	public Gestation checkStudyNo(String iden);
	
	public Gestation getGestationByUuid(String uuid);
	
	public List<Gestation> searchGestationPatients(String term);
	public ChildHealthCard saveChildHealthCard(ChildHealthCard card);
	public String  getPatientByIdentifier(String identifier);
}