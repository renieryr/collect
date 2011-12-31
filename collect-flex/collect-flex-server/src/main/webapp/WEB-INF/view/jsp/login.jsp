<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>

<html>
  <head>
  	<meta http-equiv="Pragma" content="no-cache">
  	<style type="text/css" media="screen"> 
		html, body	{ height:100%; }
		body {
			font-family: verdana, serif, monospace;
			font-size: 1.0em;
			margin:5;
			padding:10;
			overflow: hidden;
			text-align:center;
		    background-color: #ffffff;
		}
		fieldset {
			width: 80%;
		}
		legend {
			font-weight: bold;
			font-size: 0.8em;
		}
		.login td {
			font-size: small;
			font-family: verdana, serif, monospace;
			line-height: 1em;
			font-size: 0.7em;
			padding-top: 10;
		}
		input.button {
			font-family: verdana, serif, monospace;
			line-height: 1em;
			font-size: 1em;
			padding: 3 8 5 8;
			background-color: #DDDDDD;
    		border: 1px outset #DDDDDD;
    		color: #000000;
    		border-style: outset;
		}

		.login input {
			height: 20;
			border: 1px solid #DDDDDD;
			font-family: verdana, serif, monospace;
			line-height: 1em;
			font-size: 1em;
		}
		
		div.error {
			font-weight: bold;
			font-size: 0.8em;
			color: red;
		}
	</style>
    <title>OpenForis Collect</title>
  </head>

  <body onload="document.f.j_username.focus();">
    <h3>OpenForis Collect</h3>

    <%-- this form-login-page form is also used as the
         form-error-page to ask for a login again.
         --%>
    <c:if test="${not empty param.login_error}">
      <div class="error">
        Your login attempt was not successful, try again.<br/><br/>
        Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
      </div>
    </c:if>
	<form name="f" action="<c:url value='j_spring_security_check'/>" method="POST">
    <table width="100%">
    	<tr>
    		<td width="33%">&nbsp;</td>
    		<td width="33%">
    			<fieldset>
					<legend>Please Log In</legend>
				      <table class="login" >
				        <tr>
				        	<td width="50%" align="right">User:</td>
				        	<td width="50%" align="left"><input type='text' name='j_username' value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'/></td>
				        </tr>
				        <tr>
				        	<td width="50%" align="right">Password:</td>
				        	<td width="50%" align="left"><input type='password' name='j_password'></td>
				        </tr>
				        <!-- tr><td><input type="checkbox" name="_spring_security_remember_me"></td><td>Don't ask for my password for two weeks</td></tr-->
				
				        <tr>
				        	<td colspan='2' width="100%" style="text-align: center;">
				        		<input name="submit" type="submit" class="button" value="Submit" />
				        		<input name="reset" type="reset" class="button" value="Reset"/>
			        		</td>
		        		</tr>
				      </table>
				</fieldset>
    		</td>
    		<td width="33%">&nbsp;</td>
    	</tr>
    </table>
    </form>
  </body>
</html>