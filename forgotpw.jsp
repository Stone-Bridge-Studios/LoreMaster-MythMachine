<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
    <head>
        <title>Myth Machine Forgot Password
        </title>
    </head>
    <body>
        <h1>${message}</h1>    
        <a href="/login">Login</a>
    <form action="forgotpw" method="post">
        <h2>Forgot Password</h2>
        <font color="red">${errorMessage}</font
        <p>
            <label for="email">Enter your email:</label>
            <input type="text" id="email" name="email" required>
        </p>
        <p>
            <input type="submit" value="Submit">
        </p>
    </body>
</html>