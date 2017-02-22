package org.openmrs.module.gestation.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.gestation.Gestation;
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
public class GestationManageController {
    static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    protected final Log log = LogFactory.getLog(getClass());
    GestationService service;
    private JSONArray jsonArray;
    private JSONObject jsonObject;

    private static Date dateHelper(String value) throws ParseException {
        if (value == null || value.length() == 0) {
            return null;
        } else {
            return df.parse(value);
        }
    }
    @RequestMapping(value = "/module/gestation/patientSearch", method = RequestMethod.GET)
    public synchronized void patientSearch(HttpServletRequest request, HttpServletResponse response){
        service = Context.getService(GestationService.class);
        String search = request.getParameter("patientSearch");
        jsonArray = new JSONArray();
        try {
            String patient = service.getPatientByIdentifier(search);
            jsonArray.put(Context.getPatientService().getPatient(Integer.parseInt(patient)).getPatientIdentifier());
            response.getWriter().print(jsonArray);
            response.flushBuffer();
        }
        catch (Exception e) {
            // drugs
            log.error("Error generated", e);
        }
    }
    @RequestMapping(method = RequestMethod.GET, value = "module/gestation/patientLastName")
    public synchronized void patientLastName(HttpServletRequest request, HttpServletResponse response) {
        String patientToFind=request.getParameter("patientToFind");
        service = Context.getService(GestationService.class);
        jsonArray = new JSONArray();
        jsonObject = new JSONObject();
        try {
            String  patient= service.getPatientByIdentifier(patientToFind);
            jsonArray.put(Context.getPatientService().getPatient(Integer.parseInt(patient)).getNames());
            jsonArray.put(Context.getPatientService().getPatient(Integer.parseInt(patient)).getAge());
            response.getWriter().print(jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/module/gestation/ANC", method = RequestMethod.GET)
    public void manage(ModelMap model) {
        model.addAttribute("user", Context.getAuthenticatedUser());
    }
    @RequestMapping(value = "/module/gestation/data", method = RequestMethod.GET)
    public void data(ModelMap model, HttpServletRequest request) {
        try {
            String s = request.getParameter("patientId");
            Patient p = Context.getPatientService().getPatient(Integer.parseInt(s));

            //search for a patient record
            service = Context.getService(GestationService.class);
            Gestation g = service.checkPersonGestation(p);
            if (g != null) {
                            //16/01/2014

                SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

                String date = DATE_FORMAT.format(g.getExpectedDateOfBirth());

                DateTime dateTime1 = new DateTime(date);


                g.setExpectedDateOfBirth(dateTime1.toDate());

                model.addAttribute("gestation", g);
                if (g.getFamilyMemberIndex() != null) {
                    String sf = g.getFamilyMemberIndex();
                    String[] fs = null;
                    try {
                        fs = sf.split(",");
                    } catch (Exception ex) {
                        fs[0] = sf;
                    }
                    int x0 = 0, x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0, x6 = 0, x7 = 0, x8 = 0;


                    for (int f = 0; f < fs.length; f++) {
                          if (Double.parseDouble(fs[f]) == 0) {
                            x0 = 1;
                        } else if (Double.parseDouble(fs[f]) == 1) {
                            x1 = 1;
                        } else if (Double.parseDouble(fs[f]) == 2) {
                            x2 = 1;
                        } else if (Double.parseDouble(fs[f]) == 3) {
                            x3 = 1;
                        } else if (Double.parseDouble(fs[f]) == 4) {
                            x4 = 1;
                        } else if (Double.parseDouble(fs[f]) == 5) {
                            x5 = 1;
                        } else if (Double.parseDouble(fs[f]) == 6) {
                            x6 = 1;
                        } else if (Double.parseDouble(fs[f]) == 7) {
                            x7 = 1;
                        } else if (Double.parseDouble(fs[f]) == 8) {
                            x8 = 1;
                        }
                    }

                    model.addAttribute("gestationFamilyMemberIndex0", x0);
                    model.addAttribute("gestationFamilyMemberIndex1", x1);
                    model.addAttribute("gestationFamilyMemberIndex2", x2);
                    model.addAttribute("gestationFamilyMemberIndex3", x3);
                    model.addAttribute("gestationFamilyMemberIndex4", x4);
                    model.addAttribute("gestationFamilyMemberIndex5", x5);
                    model.addAttribute("gestationFamilyMemberIndex6", x6);
                    model.addAttribute("gestationFamilyMemberIndex7", x7);
                    model.addAttribute("gestationFamilyMemberIndex8", x8);
                }
            } else {
                model.addAttribute("gestation", new Gestation());
            }

            //if(p.getAge()==0)

            model.addAttribute("patient", p);
            //model.addAttribute("patientName",p.getNames().toString().substring(1, p.getNames().toString().length() - 1));
            model.addAttribute("patientIden", p.getActiveIdentifiers().get(0));
            model.addAttribute("patientUid", p.getUuid());
        } catch (Exception e) {
            //search for a patient record
            service = Context.getService(GestationService.class);
            Gestation g = service.getGestationByUuid(request.getParameter("recuid"));
            if (g != null) {



                model.addAttribute("gestation", g);
                if (g.getFamilyMemberIndex() != null) {
                    String sf = g.getFamilyMemberIndex();
                    String[] fs = null;
                    try {
                        fs = sf.split(",");
                    } catch (Exception ex) {
                        fs[0] = sf;
                    }
                int x0 = 0, x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0, x6 = 0, x7 = 0, x8 = 0;


                    for (int f = 0; f < fs.length; f++) {
                        if (Double.parseDouble(fs[f]) == 0) {
                            x0 = 1;
                        } else if (Double.parseDouble(fs[f]) == 1) {
                            x1 = 1;
                        } else if (Double.parseDouble(fs[f]) == 2) {
                            x2 = 1;
                        } else if (Double.parseDouble(fs[f]) == 3) {
                            x3 = 1;
                        } else if (Double.parseDouble(fs[f]) == 4) {
                            x4 = 1;
                        } else if (Double.parseDouble(fs[f]) == 5) {
                            x5 = 1;
                        } else if (Double.parseDouble(fs[f]) == 6) {
                            x6 = 1;
                        } else if (Double.parseDouble(fs[f]) == 7) {
                            x7 = 1;
                        } else if (Double.parseDouble(fs[f]) == 8) {
                            x8 = 1;
                        }
                    }

                    model.addAttribute("gestationFamilyMemberIndex0", x0);
                    model.addAttribute("gestationFamilyMemberIndex1", x1);
                    model.addAttribute("gestationFamilyMemberIndex2", x2);
                    model.addAttribute("gestationFamilyMemberIndex3", x3);
                    model.addAttribute("gestationFamilyMemberIndex4", x4);
                    model.addAttribute("gestationFamilyMemberIndex5", x5);
                    model.addAttribute("gestationFamilyMemberIndex6", x6);
                    model.addAttribute("gestationFamilyMemberIndex7", x7);
                    model.addAttribute("gestationFamilyMemberIndex8", x8);
                }
            } else {
                g = service.checkStudyNo(request.getParameter("patNo"));
                if (g != null) {


                    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

                    String date = DATE_FORMAT.format(g.getExpectedDateOfBirth());


                    g.setDate(date);




                    model.addAttribute("gestation", g);
                    if (g.getFamilyMemberIndex() != null) {
                        String sf = g.getFamilyMemberIndex();
                        String[] fs = null;
                        try {
                            fs = sf.split(",");
                        } catch (Exception ex) {
                            fs[0] = sf;
                        }
                        int x0 = 0, x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0, x6 = 0, x7 = 0, x8 = 0;

                        for (int f = 0; f < fs.length; f++) {
                             if (Double.parseDouble(fs[f]) == 0) {
                                x0 = 1;
                            } else if (Double.parseDouble(fs[f]) == 1) {
                                x1 = 1;
                            } else if (Double.parseDouble(fs[f]) == 2) {
                                x2 = 1;
                            } else if (Double.parseDouble(fs[f]) == 3) {
                                x3 = 1;
                            } else if (Double.parseDouble(fs[f]) == 4) {
                                x4 = 1;
                            } else if (Double.parseDouble(fs[f]) == 5) {
                                x5 = 1;
                            } else if (Double.parseDouble(fs[f]) == 6) {
                                x6 = 1;
                            } else if (Double.parseDouble(fs[f]) == 7) {
                                x7 = 1;
                            } else if (Double.parseDouble(fs[f]) == 8) {
                                x8 = 1;
                            }
                        }

                        model.addAttribute("gestationFamilyMemberIndex0", x0);
                        model.addAttribute("gestationFamilyMemberIndex1", x1);
                        model.addAttribute("gestationFamilyMemberIndex2", x2);
                        model.addAttribute("gestationFamilyMemberIndex3", x3);
                        model.addAttribute("gestationFamilyMemberIndex4", x4);
                        model.addAttribute("gestationFamilyMemberIndex5", x5);
                        model.addAttribute("gestationFamilyMemberIndex6", x6);
                        model.addAttribute("gestationFamilyMemberIndex7", x7);
                        model.addAttribute("gestationFamilyMemberIndex8", x8);
                    }
                } else {
                    model.addAttribute("gestation", new Gestation());
                }
            }
            //model.addAttribute("patientName", request.getParameter("patName"));
            model.addAttribute("patientIdentifier", request.getParameter("patNo"));
        }
    }

}
