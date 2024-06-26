<!DOCTYPE html>
<html>
<head>
    <title>LoreMaster Character Creator</title>
    <link rel="stylesheet" type="text/css" href="\css\bootstrap.min.css">
</head>
<style>

    .bottom-nav {
        position: fixed;
        bottom: 0;
        left: 0;
        width: 100%;
        background-color: #333;
        display: flex;
        justify-content: space-around;
        padding: 10px 0;
    }

    .bottom-nav button {
        background-color: #555;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .bottom-nav button:hover, .bottom-nav button.selected {
        background-color: #777;
    }

    .profile-nav {
        right: 30px;
        margin-top: -28px;
        position: fixed;
    }
    
    .center-buttons {
        margin-top: 90px;
        display: flex;
        justify-content: center;
        align-items: center;
    }   

    .container {
        margin-top: 120px;
        display: flex;
        justify-content: center;
        align-items: center;
        
        text-align: center;
    }

    #title {
        width: 300px;
        text-align: center;
    }    
 
    #char-button {
        margin-top: 30px;
        width: 300px;
        height: 100px;
        
    }

    #sheet-button {
        margin-top: 30px;
        width: 300px;
        height: 100px;
    }    

</style>
</head>
<body>

    <!-- Top Navbar -->
    <nav class="navbar navbar-expand-lg bg-primary fixed-top" data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/characters">LoreMaster | Create</a>
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <div class="profile-nav">
                            <span>${userName}</span>
                            <a href="/profile"><img src="\images\default_pfp.png" alt="Profile Picture" width="56" height="56"></a>
                        </div>
                    </li>
                </ul>
        </div>
    </nav>

    <!-- Bottom Navbar -->
    <nav class="navbar navbar-expand-lg bg-primary fixed-bottom" data-bs-theme="dark">
        <div class="bottom-nav">
            <a href="/characters"><button>Characters</button></a>
            <a href="/sheets"><button>Sheets</button></a>
            <a href="/create"><button class="selected">Create</button></a>
            <a href="/explore"><button>Explore</button></a>
        </div>
    </nav>
    <div class="container">
        <!-- Title Card -->
        <div class="card text-white bg-dark mb-3" style="min-width: 70rem; min-height: 18rem;">
            <div class="card-header"><h1>What would you like to create?</h1></div>
            <div class="card-body">                
                
                <a href="/createCharacterSelectSheet"><button id="char-button" class="btn btn-lg btn-primary" type="button">A New Character</button></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/createNewSheet"><button id="sheet-button" class="btn btn-lg btn-primary" type="button">A New Sheet</button></a>   
                
            </div>
        </div>    
    </div>   
    
</body>
</html>