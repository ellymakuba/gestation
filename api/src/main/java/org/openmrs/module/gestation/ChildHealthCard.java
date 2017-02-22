package org.openmrs.module.gestation;

import org.openmrs.BaseOpenmrsData;
import java.util.Date;

/**
 * Created by root on 1/9/17.
 */
public class ChildHealthCard extends BaseOpenmrsData{
    private Integer id;
    private String facilityName;
    private Integer deliveryPointNo;
    private String sex;
    private Integer childClinicNo;
    private Date dateFirstSeen;
    private Date dOB;
    private String placeOfBirth;
    private String father;
    private String mother;
    private Integer telephone;

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeliveryPointNo() {
        return deliveryPointNo;
    }

    public void setDeliveryPointNo(Integer deliveryPointNo) {
        this.deliveryPointNo = deliveryPointNo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getChildClinicNo() {
        return childClinicNo;
    }

    public void setChildClinicNo(Integer childClinicNo) {
        this.childClinicNo = childClinicNo;
    }

    public Date getDateFirstSeen() {
        return dateFirstSeen;
    }

    public void setDateFirstSeen(Date dateFirstSeen) {
        this.dateFirstSeen = dateFirstSeen;
    }

    public Date getdOB() {
        return dOB;
    }

    public void setdOB(Date dOB) {
        this.dOB = dOB;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }
}
