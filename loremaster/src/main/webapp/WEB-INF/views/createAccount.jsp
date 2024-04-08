<!DOCTYPE html>
<html>
    <head>
        <title>LoreMaster Character Creator</title>
        <link rel="stylesheet" type="text/css" href="\css\style.css">
    </head>
    <center>
        <h1>Create An Account</h1>
        <h2>Please Enter Your Email, Username, & Password for your LoreMaster Account</h2>
        <font color="red">${errorMessage}</font>
        <form method="post">
            Email : <input type="text" name="email" /><br><br>
            User Name : <input type="text" name="name" /><br><br>
            Password  : <input type="password" name="password" /><br><br>
            <a href="/login"><input value="Back" class="submitInput"/></a>
            <input value="Create Account" class="submitInput" type="submit"/>
        </form>
    </center>
</html>