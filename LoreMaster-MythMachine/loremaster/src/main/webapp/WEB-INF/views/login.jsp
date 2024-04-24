<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Myth Machine: Story Generator</title>
        <link rel="stylesheet" type="text/css" href="\css\bootstrap.min.css">
    </head>
    <style>
        @media (min-width: 370px) {
            .container{
                max-width: 370px;
                margin-top: 5%;
                padding: 8px;
            }
        }
        .errorMessage {
            font-size: 20px;
            color: red;
        }        
    </style>
    <body>
        <div class="container">
                <form method="post">
                <img class="mb-4" src="\images\SB_MM_Troll.jpg" alt="" width="348" height="348">
                <h1 class="h3 mb-3 fw-normal">Enter the Myth Machine</h1>
                <h2 class="h4 mb-3 fw-normal">Please sign in</h2>
                <h3 class="errorMessage">${errorMessage}</h3>      
                <div class="form-floating">
                    <input type="email" name="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                    <label for="floatingInput">Email address</label>
                </div>
                <div class="form-floating">
                    <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">Password</label>
                </div>            
                <br>
                <button class="btn btn-primary w-5 py-2" type="submit">Sign in</button>&nbsp;&nbsp;
                New user?&nbsp;&nbsp;<a href="/createAccount">Create an Account</a>
                <p class="mt-5 mb-3 text-body-secondary">&copy; 2024</p>
                
                </form>  
        </div>
        
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>             

    </body>
</html>

