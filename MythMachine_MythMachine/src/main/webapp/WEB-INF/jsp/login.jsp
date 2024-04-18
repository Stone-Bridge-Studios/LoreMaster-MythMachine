<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, 
    initial-scale=1.0">
        <title>Myth Machine Story Generator </title>
        <link rel="stylesheet" type="text/css" href="\css\style.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
    <div class="wrapper">
        <h1>Login</h1>
        <font color="red">${errorMessage}</font>
        <form method="post">
            <div class="input-box">
            <input type="text" name="name" placeholder="Username" required/>
            <i class='bx bxs-user'></i>
            </div>
            <div class="input-box">
            <input type="password" name="password" placeholder="Password" required/>
            <i class='bx bxs-lock-alt' ></i>
            </div>
            
            <!-- do not need forgot pw-->
            
            <button type="submit" class="btn">Login</button>
            
            <div class="register-link">
            <p>Don't have an account? <a href="#">Register</a></p>
            </div>
        </form>
     </div>
    </body>
</html>