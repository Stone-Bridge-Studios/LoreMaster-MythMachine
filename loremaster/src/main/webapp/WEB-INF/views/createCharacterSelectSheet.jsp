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

    button {
        background-color: #555;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    button:hover, button.selected {
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
            <a class="navbar-brand" href="/characters">LoreMaster | Select A Character Sheet</a>
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

    <!-- Sheet Cards -->
    <div class="container">
        <div class="row row-cols-auto justify-content-center">
            <c:forEach items="${userSheets}" var="userSheet">
                <div class="col">
                    <div class="card text-white bg-dark mb-3" style="max-width: 22rem;">
                        <div class="card-header">
                            <h3 class="character-name">${userSheet.sheetName}</h3>
                        </div>
                        <div class="card-body">                            
                            <button onclick="selectCharacterSheet('${userSheet.sheetID}')"><img src="\images\sheet.jpg" alt="Sheet Image"></button>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>    

    <!-- Bottom Navbar -->
    <nav class="navbar navbar-expand-lg bg-primary fixed-bottom" data-bs-theme="dark">
        <div class="bottom-nav">
            <a href="/characters"><button>Characters</button></a>
            <a href="/sheets"><button>Sheets</button></a>
            <a href="/create"><button class="selected">Create</button></a>
            <a href="/explore"><button>Explore</button></a>
        </div>
    </nav>

    <script>

        function selectCharacterSheet(sheetID) {
            
            var xhr = new XMLHttpRequest();
            xhr.open("POST","/selectCharacterSheet",true);
            xhr.setRequestHeader("Content-Type","application/json")
            xhr.send(JSON.stringify(sheetID));
            
            // TODO Find better way to refresh the page
            window.location.href = "/characterEditor";

        }

    </script>

</body>
</html>