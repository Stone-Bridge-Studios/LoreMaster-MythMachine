<!DOCTYPE html>
<html>
    <head>
        <title>LoreMaster Character Creator</title>
        <link rel="stylesheet" type="text/css" href="\css\style.css">
    </head>
    <body>
        <div class="login">
            <div class="loginForm">
                <div class="loginHeading">
                    <h1>Welcome to LoreMaster</h1>
                    <h3>The Ultimate Character Design Tool</h3>
                </div>                    
                <h2>Please Enter Your Login Information</h2>
                <h3 class="errorMessage">${errorMessage}</h3>                
                <form method="post">
                    Email : <br><input type="text" name="email" class="form" /><br><br>
                    Password  : <br><input type="password" name="password" class="form"  /><br><br>                    
                    <input value="Log In" class="submitInput" type="submit"/>
                    <a href="/createAccount"><input value="Create Account" class="submitInput"/></a>
                </form>            
            </div>
            <div class="loginImages">
                <img src="\images\loremaster_icon.jpg">
            </div>
        </div>
    </body>
</html>