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
    
    .sheet {
        display: flex;
        flex-direction: row;
        align-items: center;
        margin-bottom: 10px;
    }

    .sheet img {
        width: 100px;
        height: 100px;
        margin-right: 10px;
    }

    .buttons {
        display: flex;
        flex-direction: column;
        align-items: flex-start;
    }

    .buttons button {
        margin-bottom: 5px;
    }


</style>
</head>
<body>

    <header>
        <nav>
          <div class="logo">
            <img src="\images\loremaster_icon.jpg" alt="App Logo">
            <span>LoreMaster Character Creator | Your Sheets</span>
          </div>
          <div class="profile-icon">
            <span>${userName}</span>
            <a href="/profile"><img src="\images\default_pfp.png" alt="Profile Picture"></a>
          </div>
        </nav>
      </header>       

    <c:forEach items="${userSheets}" var="userSheet">
        <div class="sheet">
            <span>${userSheet.sheetName}</span> <!-- Move sheet name above the rest of the content -->
            <img src="\images\sheet.jpg" alt="Sheet Image">
            <div class="buttons">
                <button onclick="editExistingSheet('${userSheet.sheetID}')" class="edit-button">Edit</button>
                <button class="share-button">Share</button>
                <button onclick="deleteSheet('${userSheet.sheetID}')" class="delete-button">Delete</button>
            </div>
        </div>
    </c:forEach>
    

    <div class="bottom-nav">
        <a href="/characters"><button>Chracters</button></a>
        <a href="/sheets"><button class="selected">Sheets</button></a>
        <a href="/create"><button>Create</button></a>
        <a href="/explore"><button>Explore</button></a>
    </div>

    <script>

        function editExistingSheet(sheetID) {

            var xhr = new XMLHttpRequest();
            xhr.open("POST","/editExistingSheet",true);
            xhr.setRequestHeader("Content-Type","application/json")

            xhr.send(JSON.stringify(sheetID));

            // Redirect to Sheet Editor
            window.location.href = "/createSheetAttributeEditor";

        }

        function deleteSheet(sheetID) {
            var xhr = new XMLHttpRequest();
            xhr.open("POST","/deleteSheet",true);
            xhr.setRequestHeader("Content-Type","application/json")
            xhr.send(JSON.stringify(sheetID));
            
            // TODO Find better way to refresh the page
            window.location.href = "/create";
            window.location.href = "/sheets";
        }        

    </script>

</body>
</html>