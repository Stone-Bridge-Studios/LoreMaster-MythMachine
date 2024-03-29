<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
    <title>LoreMaster Character Creator</title>
    <link rel="stylesheet" type="text/css" href="\css\style.css">
</head>
<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
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
    .bottom-nav button {
        background-color: #555;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }
    .bottom-nav button:hover,
    .bottom-nav button.selected {
        background-color: #777;
    }
</style>
</head>
<body>

    <c:forEach items="${userCharacters}" var="userChar">
        <div class="character">
            <span>${userChar.characterName}</span>
            <button onclick="viewCharacter('${userChar.characterID}')"><img src="\images\character.jpg" alt="Character Image"></button>
            <div class="buttons">
                <button onclick="editExistingCharacter('${userChar.characterID}')" class="edit-button">Edit</button>
                <button class="share-button">Share</button>
                <button onclick="deleteCharacter('${userChar.characterID}')" class="delete-button">Delete</button>                
            </div>
        </div>
    </c:forEach>    

    <div class="bottom-nav">
        <a href="/characters"><button class="selected">Chracters</button></a>
        <a href="/sheets"><button>Sheets</button></a>
        <a href="/create"><button>Create</button></a>
        <a href="/explore"><button>Explore</button></a>
    </div>

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

</body>
</html>