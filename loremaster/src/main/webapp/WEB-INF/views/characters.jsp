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

    .topnav {
        background-color: #5b1f83;
    }
    
</style>
</head>
<body>

    <!-- Top Navbar -->
    <div class="topnav">
    <nav class="navbar navbar-expand-lg bg-primary fixed-top" data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/characters">LoreMaster | Your Characters</a>
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
    </div>

    <!-- Character Cards -->
    <div class="container">
        <div class="row row-cols-auto justify-content-center">
            <c:forEach items="${userCharacters}" var="userChar">
                <div class="col">
                    <div class="card text-white bg-primary mb-3" style="max-width: 17rem;">
                        <div class="card-header">
                            <h3 class="character-name">${userChar.characterName}</h3>
                        </div>
                        <div class="card-body">
                            <button onclick="viewCharacter('${userChar.characterID}')">
                                <img src="\images\character.jpg" alt="Character Image">
                            </button>
                            <br>
                            <br>
                            <div class="character-name">
                                <button class="btn btn-secondary" onclick="editExistingCharacter('${userChar.characterID}')">Edit</button>
                                <button class="btn btn-secondary">Share</button>                            
                                <button class="btn btn-danger btn-block" onclick="deleteCharacter('${userChar.characterID}')">Delete</button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- Bottom Navbar -->
    <nav class="navbar navbar-expand-lg bg-primary fixed-bottom" data-bs-theme="dark">
        <div class="bottom-nav">
            <a href="/characters"><button class="selected">Characters</button></a>
            <a href="/sheets"><button>Sheets</button></a>
            <a href="/create"><button>Create</button></a>
            <a href="/explore"><button>Explore</button></a>
        </div>
    </nav>
    <script>

        function editExistingCharacter(charID) {

            var xhr = new XMLHttpRequest();
            xhr.open("POST","/editExistingCharacter",true);
            xhr.setRequestHeader("Content-Type","application/json")

            xhr.send(JSON.stringify(charID));

            // Redirect to Sheet Editor
            window.location.href = "/characterEditor";

        }

        function deleteCharacter(charID) {
            var xhr = new XMLHttpRequest();
            xhr.open("POST","/deleteCharacter",true);
            xhr.setRequestHeader("Content-Type","application/json")
            xhr.send(JSON.stringify(charID));
            
            // TODO Find better way to refresh the page
            window.location.href = "/create";
            window.location.href = "/characters";
        }

        function viewCharacter(charID) {
            var xhr = new XMLHttpRequest();
            xhr.open("POST","/viewCharacter",true);
            xhr.setRequestHeader("Content-Type","application/json")
            xhr.send(JSON.stringify(charID));
            
            // TODO Find better way to refresh the page
            window.location.href = "/characterViewer";
        }        

    </script>

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>    

</body>
</html>