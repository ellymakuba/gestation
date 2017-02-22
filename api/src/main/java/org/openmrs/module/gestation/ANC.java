package org.openmrs.module.gestation;

import org.openmrs.BaseOpenmrsData;

/**
 * Created by root on 2/17/17.
 */
public class ANC extends BaseOpenmrsData{
    private Integer id;
    private String bloodPressure;
    private String general;
    private String CVS;
    private String height;
    private String respiration;
    private String breasts;
    private String abdomen;
    private String vaginalExamination;
    private String genitalUlcer;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getGeneral() {
        return general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    public String getCVS() {
        return CVS;
    }

    public void setCVS(String CVS) {
        this.CVS = CVS;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getRespiration() {
        return respiration;
    }

    public void setRespiration(String respiration) {
        this.respiration = respiration;
    }

    public String getBreasts() {
        return breasts;
    }

    public void setBreasts(String breasts) {
        this.breasts = breasts;
    }

    public String getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(String abdomen) {
        this.abdomen = abdomen;
    }

    public String getVaginalExamination() {
        return vaginalExamination;
    }

    public void setVaginalExamination(String vaginalExamination) {
        this.vaginalExamination = vaginalExamination;
    }

    public String getGenitalUlcer() {
        return genitalUlcer;
    }

    public void setGenitalUlcer(String genitalUlcer) {
        this.genitalUlcer = genitalUlcer;
    }
}
