
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
