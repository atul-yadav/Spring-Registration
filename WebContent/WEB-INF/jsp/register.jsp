<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Registration</title>
        </head>
        <body>
            <form id="regForm" modelAttribute="user" action="registerProcess" method="post">
                <table align="center">
                    <tr>
                       <td>
                            <label >Username</label>
                        </td> 
                        <td>
                            <input  name="username" id="username" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Password</label>
                        </td>
                        <td>
                            <input name="password" id="password" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Name</label>
                        </td>
                        <td>
                            <input name="name" id="name" />
                        </td>
                    </tr>
               
                   
                    <tr>
                        <td>
                            <label>Mobile</label>
                        </td>
                        <td>
                            <input name="mobile" id="mobile" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <button id="register" name="register">Register<button>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td></td>
                        <td><a href="home.jsp">Home</a>
                        </td>
                    </tr>
                </table>
            </form>
        </body>
        </html>