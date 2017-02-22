$j("#anc").hide();
$j("#history").hide();
function saveANC(){
var data=$j("#ancForm").serialize();
$j.ajax({
       type:"POST",
       url:"ANC.form",
       async:false,
       data:{values:JSON.stringify(data) },
       success:function (result) {}
        });
}
$j("#patientId").live("focus", function () {
    $j(this).autocomplete({
        source:function (request, response) {
            $j.getJSON("patientSearch.form?patientSearch=" + request.term, function (result) {
                response($j.each(result, function (index, item) {
                    return {
                        label:item,
                        value:item
                    }
                }));
            });
        },
        minLength:3,
        select:function(event,ui){
            var details={};
            var name;
            var patient=ui.item.value;
            $j.ajax({
                type:"GET",
                url:"patientLastName.form?patientToFind="+patient,
                data:patient,
                dataType:"json",
                success:function (result) {
                    details= result.toString().split(",");
                    name=details[0];
                    document.getElementById("patientName").value=name;
                    $j("#anc").show();
                    $j("#history").show();
                }
            });
        }
    });
});
if($j("#patientName").val() !=""){
$j("#anc").show();
$j("#history").show();
}