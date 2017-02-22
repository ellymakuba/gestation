<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<openmrs:htmlInclude file="/scripts/jquery/dataTables/js/jquery.dataTables.min.js" />
<openmrs:htmlInclude file="/scripts/jquery-ui/js/jquery-ui.custom.min.js" />
<openmrs:htmlInclude file="/scripts/jquery/dataTables/css/dataTables.css" />
<openmrs:htmlInclude file="/scripts/calendar/calendar.js" />
<openmrs:htmlInclude file="/scripts/jquery/highlight/jquery.highlight-3.js" />
<openmrs:htmlInclude file="/scripts/jquery/dataTables/js/jquery.dataTables.filteringDelay.js" />
<link href="<openmrs:contextPath/>/scripts/jquery-ui/css/<spring:theme code='jqueryui.theme.name' />/jquery-ui.custom.css" type="text/css" rel="stylesheet" />
<openmrs:htmlInclude file="/scripts/jquery/dataTables/css/dataTables_jui.css" />


<openmrs:htmlInclude file="/moduleResources/gestation/js/jquery.corner.js" />
<openmrs:htmlInclude file="/moduleResources/gestation/js/ColVis.js" />

<openmrs:htmlInclude file="/moduleResources/gestation/css/ColVis.css" />
<script>
	$j(document).ready(function() {
		// set up table tools
		$j("button#download").click(function() {
			//window.open("download.htm?checkId=${check.id}", 'Download');
			window.open('data:application/vnd.ms-excel;base64,' + document.getElementById('resultsTable').outerHTML.replace(/ /g, '%20'));
			return false;
		});
		$j("button#print").click(function() {
			var p = window.open();
			p.document.write($j('#resultsTable')[0].outerHTML);
			p.document.close();
			p.focus();
			p.print();
			p.close();
			return false;
		});

        $j("button#filter").click(function() {

            return false;
        });

        // format the results datatable
        resultsTable = $j("#resultsTable").dataTable({
            sScrollX: "100%",
            sScrollXInner: "110%",
            sDom: '<"H"Clf>rt<"F"ip>',
            bJQueryUI: true,
            lengthMenu: [[50, 200, 400, -1], [50, 200, 400, "All"]],
            iDisplayLength : 50,
            bScrollCollapse: true,
            "oTableTools": {
                sSwfPath: "/swf/copy_csv_xls_pdf.swf"
            }
        });

    });
	var tableToExcel = (function() {
			var uri = 'data:application/vnd.ms-excel;base64,'
					, template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>'
					, base64 = function(s) {
				return window.btoa(unescape(encodeURIComponent(s)))
			}
			, format = function(s, c) {
				return s.replace(/{(\w+)}/g, function(m, p) {
					return c[p];
				})
			}
			return function(table, name) {
				if (!table.nodeType)
					table = document.getElementById(table)
				var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML}
				window.location.href = uri + base64(format(template, ctx))
			}
		}()
	);
</script>
				
<div class="boxHeader">Gestation Data</div>
<div class="box">

	<input type="button" onclick="tableToExcel('resultsTable', 'Export Gestation Data')" value="Export to Excel"/><!--button id="download">Download</button-->&nbsp;&nbsp;&nbsp;<button id="print">Print</button>

    <br/>

    <a href="${pageContext.request.contextPath}/module/gestation/patientdata.form?id=1">
        Positive Gestation
    </a>
    <a href="${pageContext.request.contextPath}/module/gestation/patientdata.form?id=2">
        Delivered
    </a>
    <a href="${pageContext.request.contextPath}/module/gestation/patientdata.form?id=3">
        Children with>4
    </a>
     <br/>

	<br/>
	<table id="resultsTable">
		<thead>
			<tr>
				<th>Id</th>
				<th>AMRS#</th>
				<th>Name</th>
				<th>Hospital#</th>
				<th>Study#</th>
				<th>Phone#</th>
				<th>Age</th>
				<th>BP</th>
				<th>Weight</th>
				<th>Height</th>
				<th>BMI</th>
				<th>RBS p.o.c.</th>
				<th>Hrs-Last meal</th>
				<th>1Hr post 50g Glucose challenge test p.o.c.</th>
				<th>HbA1c p.o.c</th>
				<th>Venous HbA1c</th>
				<th>FBS p.o.c</th>
				<th>Venous</th>
				<th>1 hour post 75g OGTT p.o.c</th>
				<th>Venous 1Hr post 75gOGTT p.o.c</th>

                <th>2 hour post 75g OGTT p.o.c</th>
               <th>Venous 1Hr post 75gOGTT p.o.c</th>

				<th>FHG Hb</th>
				<th>WBC</th>
				<th>Neutrophil</th>
				<th>Platelets</th>
				<th>RBC</th>
				<th>Baby birth weight</th>
				<th>F.B.S p.o.c</th>
				<th>Venous F.B.S</th>
				<th>Diagnosed with Diabetes</th>
				<th>Diagnosed with Diabetes during Pregnancy</th>
				<th>Immediate family with a history of diabetes</th>
				<th>Who had diabetes?</th>
				<th>Est. Pregancy Weight(kg)</th>
				<th>Est. Pregancy Height(cm)</th>
                <th>Weeks</th>
                <th>a1c</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allData}" var="column" varStatus="index">
				<tr>
					<td>${column[0]}</td>
					<td>${column[1]}</td>
					<td>${column[2]}</td>
					<td>${column[3]}</td>
					<td>${column[4]}</td>
					<td>${column[5]}</td>
					<td>${column[6]}</td>
					<td>${column[7]}</td>
					<td>${column[8]}</td>
					<td>${column[9]}</td>
					<td>${column[10]}</td>
					<td>${column[11]}</td>
					<td>${column[12]}</td>
					<td>${column[13]}</td>
					<td>${column[14]}</td>
					<td>${column[15]}</td>
					<td>${column[16]}</td>
					<td>${column[17]}</td>
					<td>${column[18]}</td>
					<td>${column[19]}</td>
					<td>${column[20]}</td>
					<td>${column[21]}</td>

					<td>${column[22]}</td>
					<td>${column[23]}</td>
					<td>${column[24]}</td>
					<td>${column[25]}</td>
					<td>${column[26]}</td>
					<td>${column[27]}</td>
					<td>${column[28]}</td>
					<td>${column[29]}</td>
					<td>${column[30]}</td>
					<td>${column[31]}</td>
					<td>${column[32]}</td>
					<td>${column[33]}</td>
                    <td>${column[39]}</td>
                    <td>${column[40]}</td>
                    <td>${column[41]}</td>
                    <td>${column[42]}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="/WEB-INF/template/footer.jsp"%>