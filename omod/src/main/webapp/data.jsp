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
<script>
function saveChildHealthCard(){
var data=$j("#childHealthCardForm").serialize();
$j.ajax({
       type:"POST",
       url:"saveChildHealthCard.form?facility="+$j("#facility_name").val()+"&sdp="+$j("#delivery_point").val()+"&sex="+$j("#sex").val()+
       "&child_no="+$j("#child_no").val()+"&dfs="+$j("#date_first_seen").val()+"&dob="+$j("#dob").val()+"&pob="+$j("#place_of_birth").val()+
       "&father="+$j("#father").val()+"&mother="+$j("#mother").val()+"&tel="+$j("#telephone").val(),
       async:false,
       data:{values:JSON.stringify(data) },
       success:function (result) {}
        });
}
</script>
<div class="boxHeader">Child Health Card</div>
<form name="childHealthCardForm" id="childHealthCardForm" class="form">
<div class="form-inline">
<label for="facility_name">Health Facility Name:</label>
 <input type="text" class="form-control" name="facility_name" id="facility_name" style="width:90%;float:right;"/>
 </div>
 <div style="clear:both;"></div>
 <div class="form-inline">
 <label for="delivery_point">Service Point(SDP) NO:</label>
 <input type="text" class="form-control" name="delivery_point" id="delivery_point" style="width:90%;float:right;"/>
 </div>
 <div style="clear:both;"></div>
 <div class="form-inline">
 <label for="sex">Sex:</label>
 <input type="text" class="form-control" name="sex" id="sex" style="width:90%;float:right;"/>
 </div>
 <div style="clear:both;"></div>
 <div class="form-inline">
  <label for="child_no">Child No:</label>
  <input type="text" class="form-control" name="child_no" id="child_no" style="width:90%;float:right;"/>
  </div>
  <div style="clear:both;"></div>
  <div class="form-inline">
   <label for="date_first_seen">Date First Seen:</label>
   <input type="text" class="form-control" name="date_first_seen" id="date_first_seen"  style="width:90%;float:right;"/>
   </div>
   <div style="clear:both;"></div>
   <div class="form-inline">
    <label for="dob">DOB:</label>
    <input type="text" class="form-control" name="dob" id="dob" style="width:90%;float:right;"/>
    </div>
    <div style="clear:both;"></div>
    <div class="form-inline">
    <label for="place_of_birth">Place Of Birth:</label>
    <input type="text" class="form-control" name="place_of_birth" id="place_of_birth" style="width:90%;float:right;"/>
    </div>
    <div style="clear:both;"></div>
    <div class="form-inline">
     <label for="father">Father:</label>
     <input type="text" class="form-control" name="father" id="father" style="width:90%;float:right;"/>
     </div>
     <div style="clear:both;"></div>
     <div class="form-inline">
      <label for="mother">Mother:</label>
      <input type="text" class="form-control" name="mother" id="mother" style="width:90%;float:right;"/>
      </div>
      <div style="clear:both;"></div>
      <div class="form-inline">
       <label for="telephone">Telephone:</label>
       <input type="text" class="form-control" name="telephone" id="telephone" style="width:90%;float:right;"/>
       </div>
       <div style="clear:both;"></div>
       <input type="submit" class="btn btn-lg btn-primary btn-block" value="Save" name="save" onClick="saveChildHealthCard()"></input>
	</form>
<%@ include file="/WEB-INF/template/footer.jsp"%>