<spring:htmlEscape defaultHtmlEscape="true" />
<ul id="menu">
	<li class="first"><a
		href="${pageContext.request.contextPath}/admin"><spring:message
				code="admin.title.short" /></a></li>

	<li>
		<a href="${pageContext.request.contextPath}/module/gestation/patientsearch.form"><spring:message
				code="Data Entry" /></a>
		
	</li>
	<!--li>
		<a href="$ {pageContext.request.contextPath}/module/gestation/data.form">< spring:message
				code="gestation.manage" /></a>
	</li-->
	<li>
		<a href="${pageContext.request.contextPath}/module/gestation/patientdata.form"><spring:message
				code="Export Data" /></a>
	</li>
	
	<!-- Add further links here -->
</ul>
<h2>
	<spring:message code="gestation.title" />
</h2>
