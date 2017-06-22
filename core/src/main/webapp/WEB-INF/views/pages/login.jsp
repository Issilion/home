
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"  %>

<html xmlns:th="http://www.thymeleaf.org" xmlns:tiles="http://www.thymeleaf.org">
  <head>
    <title tiles:fragment="title">Messages : Create</title>
  <body>
	<div class="container">
	    <div class="row">
			<div class="col-md-4 col-md-offset-4">
	    		<div class="panel panel-default">
				  	<div class="panel-heading">
				    	<h3 class="panel-title">Please sign in</h3>
				 	</div>
				 	<div style="${param.error ? '' : 'display: none'}" class="alert alert-error">    
                    	Invalid username and password.
                	</div>
                	<div style="${param.logout ? '' : 'display: none'}"class="alert alert-success"> 
                    	You have been logged out.
                	</div>
				  	<div class="panel-body" tiles:fragment="content">
				    	<form name="f" th:action="@{/login}" method="post">
	                    <fieldset>
				    	  	<div class="form-group">
				    		    <input class="form-control" placeholder="Username" name="username" type="text">
				    		</div>
				    		<div class="form-group">
				    			<input class="form-control" placeholder="Password" name="password" type="password" value="">
				    		</div>
				    		<table style="border-collapse: separate; border-spacing: 2px">
							    <tr>
							        <td><a th:href="@{/auth/linkedin}" class="..."><i class="..."></i>LinkedIn</a></td>
							        <td><a th:href="@{/auth/facebook}" class="..."><i class="..."></i>Facebook</a></td>
							    </tr>
							    <tr>
							        <td><a th:href="@{/auth/twitter}" class="..."><i class="..."></i>Twitter</a></td>
							        <td><a th:href="@{/auth/live(scope='wl.signin,wl.basic')}" class="..."><i class="..."></i>Microsoft</a></td>
							    </tr>
							    <tr>
							        <td><a th:href="@{/auth/github}" class="..."><i class="..."></i>Github</a></td>
							        <td><a th:href="@{/auth/google(scope='profile')}" class="..."><i class="..."></i>Google+</a></td>
							    </tr>
							</table>
				    		<div class="checkbox">
				    	    	<label>
				    	    		<input name="remember" type="checkbox" value="Remember Me"> Remember Me
				    	    	</label>
				    	    </div>
				    		<input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
				    	</fieldset>
				    	<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
				      	</form>
				    </div>
				</div>
			</div>
		</div>
	</div>
  </body>
</html>
