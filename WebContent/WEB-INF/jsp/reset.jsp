
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Reset Password</title>
 </head>
        <body>
        
            <form:form id="resetForm" modelAttribute="reset" action="resetProcess" method="post">
           
          
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="username">Username: </form:label>
                        </td>
                        <td>
                            <form:input path="username" name="username" id="username" />
                        </td>
                         <td><form:errors path="username" cssClass="error" /></td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password">password: </form:label>
                        </td>
                        <td>
                            <form:input path="password" name="password" id="password" />
                        </td>
                         <td><form:errors path="password" cssClass="error" /></td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="newpassword">new password:</form:label>
                        </td>
                        <td>
                            <form:password path="newpassword" name="newpassword" id="newpassword" />
                        </td>
                                <td><form:errors path="newpassword" cssClass="error" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td align="left">
                            <form:button id="submit" name="submit">Submit</form:button>
                        </td>
                        <td><a href="/AppRegistration/home">Home</a>
                    </tr>
                    </table>
            </form:form>
            <table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>
        </body>
</html>
