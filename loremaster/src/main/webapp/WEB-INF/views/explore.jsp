<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

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

    .container {
        margin-top: 90px;
        margin-bottom: 90px;
    }

    .character-name {
        text-align: center;
    }

</style>
</head>
<body>

    <!-- Top Navbar -->
    <nav class="navbar navbar-expand-lg bg-primary fixed-top" data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/characters">LoreMaster | Explore</a>
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
            <a href="/create"><button>Create</button></a>
            <a href="/explore"><button class="selected">Explore</button></a>
        </div>
    </nav>

    
      
    

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>    

</body>
</html>