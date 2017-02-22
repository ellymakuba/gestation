<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<openmrs:htmlInclude file="/moduleResources/gestation/bootstrap/css/bootstrap.min.css"/>
<openmrs:htmlInclude file="/scripts/calendar/calendar.js" />
<style type="text/css">
.form
      	{
          padding: 15px;
          margin: 0 auto;
          margin-bottom:20px;
          }
 .form input,.form select
      {
             display: block;
             margin-bottom: 1em;
      }

</style>
<div class="boxHeader">First Visit: Physical Examination</div>
<div class="container">
<form id="ancForm" class="form">
<div class="form-inline">
 <label for="patientId">Patient ID:</label>
 <input type="text" class="form-control" name="patientId" id="patientId"/>
 <label for="patientName">patient Name:</label>
  <input type="text" class="form-control" name="patientName" id="patientName" readonly="" style="width:40%;"/>
</div>
<div id="anc">
 <div class="form-inline">
 <label for="general_appearence">General Appearence:</label>
 <input type="text" class="form-control" name="general_appearence" id="general_appearence" style="width:80%;float:right;"/>
 </div>
 <div style="clear:both;"></div>
 <div class="form-inline">
 <label for="blood_pressure">Blood Pressure:</label>
 <input type="text" class="form-control" name="blood_pressure" id="blood_pressure" style="width:80%;float:right;"/>
 </div>
 <div style="clear:both;"></div>
 <div class="form-inline">
 <label for="height">Height:</label>
 <input type="text" class="form-control" name="height" id="height" style="width:80%;float:right;"/>
</div>
<div style="clear:both;"></div>
<div class="form-inline">
<label for="cvs">cvs:</label>
<input type="text" class="form-control" name="cvs" id="cvs" style="width:80%;float:right;"/>
</div>
<div style="clear:both;"></div>
<div class="form-inline">
<label for="respiration">Respiration:</label>
<input type="text" class="form-control" name="respiration" id="respiration" style="width:80%;float:right;"/>
</div>
<div style="clear:both;"></div>
<div class="form-inline">
<label for="breasts">Breasts:</label>
<input type="text" class="form-control" name="breasts" id="breasts" style="width:80%;float:right;"/>
</div>
<div style="clear:both;"></div>
<div class="form-inline">
<label for="abdomen">Abdomen:</label>
<input type="text" class="form-control" name="abdomen" id="abdomen" style="width:80%;float:right;"/>
</div>
<div style="clear:both;"></div>
<div class="form-inline">
<label for="vaginal_examination">Vaginal Examination:</label>
<input type="text" class="form-control" name="vaginal_examination" id="vaginal_examination" style="width:80%;float:right;"/>
</div>
<div style="clear:both;"></div>
<div class="form-inline">
<label for="genital_ulcer">Discharge/Genital ulcer:</label>
<input type="text" class="form-control" name="genital_ulcer" id="genital_ulcer" style="width:80%;float:right;"/>
</div>
<div style="clear:both;"></div>
<input type="submit" class="btn btn-lg btn-primary btn-block" value="Save" name="save" onClick="saveANC()"></input>
</div>
</form>
<div id="history">
<table class="table Stripped">
<thead>
<tr>
<th colspan=14>Present pregnancy condition</th>
</tr>
<tr>
<th>No of visit</th>
<th>Date</th>
<th>Urine</th>
<th>Weight</th>
<th>BP</th>
<th>HB</th>
<th>Pallor</th>
<th>Maturity</th>
<th>Fundal Height</th>
<th>Presentation</th>
<th>Lie</th>
<th>Foetal Height</th>
<th>Foetal Movement</th>
<th>Next Visit</th>
</tr>
</thead>
<tbody>
</tbody>
</table>
</div>
</div>
<openmrs:htmlInclude file="/moduleResources/gestation/customjs/gestation.js"/>