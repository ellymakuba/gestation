package org.openmrs.module.gestation;

import java.util.Date;
import org.openmrs.BaseOpenmrsData;
import org.openmrs.BaseOpenmrsMetadata;
import org.openmrs.Person;


/**
 * It is a model class. It should extend either {@link BaseOpenmrsObject} or {@link BaseOpenmrsMetadata}.
 */
public class Gestation extends BaseOpenmrsData {

	private Integer id;
	private String  hospNo;
    private String studyNo;
	private double height, hoursLastMeal, hba1cPoc, fhgHb, diagnisedDiabetes, diagnisedDiabetesPg, familyDiabetesHistory, estPrepgHeight, age;
	private String phoneNo, sbp, dbp, weight, rbsPoc, oneHour50gGCTPoc, fbsPoc, fbsVenous, oneHourP75gGTTPoc, oneHourVenous, twoHourP75gGTTPoc, twoHourVenous, venousHba1c, wbc,
			neutrophil, platelets, rbc, babyWeight, postFbsPoc, postFbsVenous, familyMemberIndex, estPrepgWeight, identifier, patientName;
	private Date dateCaptured, fbsDate, oneHourP75Date, twoHourP75Date;

    private double gestational;
	private Person person;
    private Date expectedDateOfBirth;
    private String date;
    private String a1cnow;

    @Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the age
	 */
	public double getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(double age) {
		this.age = age;
	}

	/**
	 * @return the hospNo
	 */
	public String getHospNo() {
		return hospNo;
	}

	/**
	 * @param hospNo the hospNo to set
	 */
	public void setHospNo(String hospNo) {
		this.hospNo = hospNo;
	}

	/**
	 * @return the studyNo
	 */
	public String getStudyNo() {
		return studyNo;
	}

	/**
	 * @param studyNo the studyNo to set
	 */
	public void setStudyNo(String studyNo) {
		this.studyNo = studyNo;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the hoursLastMeal
	 */
	public double getHoursLastMeal() {
		return hoursLastMeal;
	}

	/**
	 * @param hoursLastMeal the hoursLastMeal to set
	 */
	public void setHoursLastMeal(double hoursLastMeal) {
		this.hoursLastMeal = hoursLastMeal;
	}

	/**
	 * @return the hba1cPoc
	 */
	public double getHba1cPoc() {
		return hba1cPoc;
	}

	/**
	 * @param hba1cPoc the hba1cPoc to set
	 */
	public void setHba1cPoc(double hba1cPoc) {
		this.hba1cPoc = hba1cPoc;
	}

	/**
	 * @return the fhgHb
	 */
	public double getFhgHb() {
		return fhgHb;
	}

	/**
	 * @param fhgHb the fhgHb to set
	 */
	public void setFhgHb(double fhgHb) {
		this.fhgHb = fhgHb;
	}

	/**
	 * @return the diagnisedDiabetes
	 */
	public double getDiagnisedDiabetes() {
		return diagnisedDiabetes;
	}

	/**
	 * @param diagnisedDiabetes the diagnisedDiabetes to set
	 */
	public void setDiagnisedDiabetes(double diagnisedDiabetes) {
		this.diagnisedDiabetes = diagnisedDiabetes;
	}

	/**
	 * @return the diagnisedDiabetesPg
	 */
	public double getDiagnisedDiabetesPg() {
		return diagnisedDiabetesPg;
	}

	/**
	 * @param diagnisedDiabetesPg the diagnisedDiabetesPg to set
	 */
	public void setDiagnisedDiabetesPg(double diagnisedDiabetesPg) {
		this.diagnisedDiabetesPg = diagnisedDiabetesPg;
	}

	/**
	 * @return the familyDiabetesHistory
	 */
	public double getFamilyDiabetesHistory() {
		return familyDiabetesHistory;
	}

	/**
	 * @param familyDiabetesHistory the familyDiabetesHistory to set
	 */
	public void setFamilyDiabetesHistory(double familyDiabetesHistory) {
		this.familyDiabetesHistory = familyDiabetesHistory;
	}

	/**
	 * @return the estPrepgHeight
	 */
	public double getEstPrepgHeight() {
		return estPrepgHeight;
	}

	/**
	 * @param estPrepgHeight the estPrepgHeight to set
	 */
	public void setEstPrepgHeight(double estPrepgHeight) {
		this.estPrepgHeight = estPrepgHeight;
	}

	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * @return the sbp
	 */
	public String getSbp() {
		return sbp;
	}

	/**
	 * @param sbp the sbp to set
	 */
	public void setSbp(String sbp) {
		this.sbp = sbp;
	}

	/**
	 * @return the dbp
	 */
	public String getDbp() {
		return dbp;
	}

	/**
	 * @param dbp the dbp to set
	 */
	public void setDbp(String dbp) {
		this.dbp = dbp;
	}


	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}

	/**
	 * @return the rbsPoc
	 */
	public String getRbsPoc() {
		return rbsPoc;
	}

	/**
	 * @param rbsPoc the rbsPoc to set
	 */
	public void setRbsPoc(String rbsPoc) {
		this.rbsPoc = rbsPoc;
	}

	/**
	 * @return the oneHour50gGCTPoc
	 */
	public String getOneHour50gGCTPoc() {
		return oneHour50gGCTPoc;
	}

	/**
	 * @param oneHour50gGCTPoc the oneHour50gGCTPoc to set
	 */
	public void setOneHour50gGCTPoc(String oneHour50gGCTPoc) {
		this.oneHour50gGCTPoc = oneHour50gGCTPoc;
	}

	/**
	 * @return the fbsPoc
	 */
	public String getFbsPoc() {
		return fbsPoc;
	}

	/**
	 * @param fbsPoc the fbsPoc to set
	 */
	public void setFbsPoc(String fbsPoc) {
		this.fbsPoc = fbsPoc;
	}

	/**
	 * @return the fbsVenous
	 */
	public String getFbsVenous() {
		return fbsVenous;
	}

	/**
	 * @param fbsVenous the fbsVenous to set
	 */
	public void setFbsVenous(String fbsVenous) {
		this.fbsVenous = fbsVenous;
	}

	/**
	 * @return the oneHourP75gGTTPoc
	 */
	public String getOneHourP75gGTTPoc() {
		return oneHourP75gGTTPoc;
	}

	/**
	 * @param oneHourP75gGTTPoc the oneHourP75gGTTPoc to set
	 */
	public void setOneHourP75gGTTPoc(String oneHourP75gGTTPoc) {
		this.oneHourP75gGTTPoc = oneHourP75gGTTPoc;
	}

	/**
	 * @return the oneHourVenous
	 */
	public String getOneHourVenous() {
		return oneHourVenous;
	}

	/**
	 * @param oneHourVenous the oneHourVenous to set
	 */
	public void setOneHourVenous(String oneHourVenous) {
		this.oneHourVenous = oneHourVenous;
	}

	/**
	 * @return the twoHourP75gGTTPoc
	 */
	public String getTwoHourP75gGTTPoc() {
		return twoHourP75gGTTPoc;
	}

	/**
	 * @param twoHourP75gGTTPoc the twoHourP75gGTTPoc to set
	 */
	public void setTwoHourP75gGTTPoc(String twoHourP75gGTTPoc) {
		this.twoHourP75gGTTPoc = twoHourP75gGTTPoc;
	}

	/**
	 * @return the twoHourVenous
	 */
	public String getTwoHourVenous() {
		return twoHourVenous;
	}

	/**
	 * @param twoHourVenous the twoHourVenous to set
	 */
	public void setTwoHourVenous(String twoHourVenous) {
		this.twoHourVenous = twoHourVenous;
	}

	/**
	 * @return the venousHba1c
	 */
	public String getVenousHba1c() {
		return venousHba1c;
	}

	/**
	 * @param venousHba1c the venousHba1c to set
	 */
	public void setVenousHba1c(String venousHba1c) {
		this.venousHba1c = venousHba1c;
	}

	/**
	 * @return the wbc
	 */
	public String getWbc() {
		return wbc;
	}

	/**
	 * @param wbc the wbc to set
	 */
	public void setWbc(String wbc) {
		this.wbc = wbc;
	}

	/**
	 * @return the neutrophil
	 */
	public String getNeutrophil() {
		return neutrophil;
	}

	/**
	 * @param neutrophil the neutrophil to set
	 */
	public void setNeutrophil(String neutrophil) {
		this.neutrophil = neutrophil;
	}

	/**
	 * @return the platelets
	 */
	public String getPlatelets() {
		return platelets;
	}

	/**
	 * @param platelets the platelets to set
	 */
	public void setPlatelets(String platelets) {
		this.platelets = platelets;
	}

	/**
	 * @return the rbc
	 */
	public String getRbc() {
		return rbc;
	}

	/**
	 * @param rbc the rbc to set
	 */
	public void setRbc(String rbc) {
		this.rbc = rbc;
	}

	/**
	 * @return the babyWeight
	 */
	public String getBabyWeight() {
		return babyWeight;
	}

	/**
	 * @param babyWeight the babyWeight to set
	 */
	public void setBabyWeight(String babyWeight) {
		this.babyWeight = babyWeight;
	}

	/**
	 * @return the postFbsPoc
	 */
	public String getPostFbsPoc() {
		return postFbsPoc;
	}

	/**
	 * @param postFbsPoc the postFbsPoc to set
	 */
	public void setPostFbsPoc(String postFbsPoc) {
		this.postFbsPoc = postFbsPoc;
	}

	/**
	 * @return the postFbsVenous
	 */
	public String getPostFbsVenous() {
		return postFbsVenous;
	}

	/**
	 * @param postFbsVenous the postFbsVenous to set
	 */
	public void setPostFbsVenous(String postFbsVenous) {
		this.postFbsVenous = postFbsVenous;
	}

	/**
	 * @return the familyMemberIndex
	 */
	public String getFamilyMemberIndex() {
		return familyMemberIndex;
	}

	/**
	 * @param familyMemberIndex the familyMemberIndex to set
	 */
	public void setFamilyMemberIndex(String familyMemberIndex) {
		this.familyMemberIndex = familyMemberIndex;
	}

	/**
	 * @return the estPrepgWeight
	 */
	public String getEstPrepgWeight() {
		return estPrepgWeight;
	}

	/**
	 * @param estPrepgWeight the estPrepgWeight to set
	 */
	public void setEstPrepgWeight(String estPrepgWeight) {
		this.estPrepgWeight = estPrepgWeight;
	}

	/**
	 * @return the dateCaptured
	 */
	public Date getDateCaptured() {
		return dateCaptured;
	}

	/**
	 * @param dateCaptured the dateCaptured to set
	 */
	public void setDateCaptured(Date dateCaptured) {
		this.dateCaptured = dateCaptured;
	}
	//fbsDate, oneHourP75Date, twoHourP75Date
	/**
	 * @return the fbsDate
	 */
	public Date getFbsDate() {
		return fbsDate;
	}

	/**
	 * @param fbsDate the fbsDate to set
	 */
	public void setFbsDate(Date fbsDate) {
		this.fbsDate = fbsDate;
	}
	/**
	 * @return the oneHourP75Date
	 */
	public Date getOneHourP75Date() {
		return oneHourP75Date;
	}

	/**
	 * @param oneHourP75Date the oneHourP75Date to set
	 */
	public void setOneHourP75Date(Date oneHourP75Date) {
		this.oneHourP75Date = oneHourP75Date;
	}
	/**
	 * @return the twoHourP75Date
	 */
	public Date getTwoHourP75Date() {
		return twoHourP75Date;
	}

	/**
	 * @param twoHourP75Date the twoHourP75Date to set
	 */
	public void setTwoHourP75Date(Date twoHourP75Date) {
		this.twoHourP75Date = twoHourP75Date;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	//identifier, patientName
	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	/**
	 * @return the patientName
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * @param patientName the patientName to set
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

    public double getGestational() {
        return gestational;
    }

    public void setGestational(double gestational) {
        this.gestational = gestational;
    }
    public Date getExpectedDateOfBirth() {
        return expectedDateOfBirth;
    }

    public void setExpectedDateOfBirth(Date expectedDateOfBirth) {
        this.expectedDateOfBirth = expectedDateOfBirth;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getA1cnow() {
        return a1cnow;
    }

    public void setA1cnow(String a1cnow) {
        this.a1cnow = a1cnow;
    }
}