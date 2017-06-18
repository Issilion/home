<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<div>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
        <form action="<c:url value="/logout"/>" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<h2 class="pull-right">${pageContext.request.userPrincipal.name} | <a
				href="#" onclick="$(this).closest('form').submit();"> Logout</a>
			</h2> 
		</form>
    </c:if>
</div>
