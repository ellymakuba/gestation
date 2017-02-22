package org.openmrs.module.gestation.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openmrs.api.context.Context;
import org.openmrs.module.gestation.ChildHealthCard;
import org.openmrs.module.gestation.api.GestationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The
 * main
 * controller.
 */
@Controller
public class ChildHealthCardController {

    static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    protected final Log log = LogFactory.getLog(ChildHealthCard.class);
    GestationService service;
    private JSONObject jsonObject;
    private JSONArray jsonArray;
    private ChildHealthCard card;

    @RequestMapping(value = "/module/gestation/saveChildHealthCard", method = RequestMethod.POST)
    public void saveChildHealthCard(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        service = Context.getService(GestationService.class);
        String facility=request.getParameter("facility");
        String sdp=request.getParameter("sdp");
        String sex=request.getParameter("sex");
        String childNo=request.getParameter("child_no");
        String dfs=request.getParameter("dfs");
        String dob=request.getParameter("dob");
        String pob=request.getParameter("pob");
        String father=request.getParameter("father");
        String mother=request.getParameter("mother");
        String telephone=request.getParameter("tel");
        card=new ChildHealthCard();
        card.setFacilityName(facility);
        card.setSex(sex);
        card.setDeliveryPointNo(Integer.valueOf(sdp));
        card.setPlaceOfBirth(pob);
        card.setFather(father);
        card.setMother(mother);
        card.setChildClinicNo(Integer.valueOf(childNo));

        Date dateFirstSeen=null;
        try {
            dateFirstSeen=df.parse(dfs);
            card.setDateFirstSeen(dateFirstSeen);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date dateOfBirth=null;
        try {
            dateOfBirth=df.parse(dob);
            card.setdOB(dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        card.setTelephone(Integer.valueOf(telephone));
        service.saveChildHealthCard(card);
    }
}
