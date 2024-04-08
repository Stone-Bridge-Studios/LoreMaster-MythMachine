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

    <header>
        <nav>
          <div class="logo">
            <img src="\images\loremaster_icon.jpg" alt="App Logo">
            <span>LoreMaster Character Creator | Viewing ${characterName}</span>
          </div>
          <div class="profile-icon">
            <span>${userName}</span>
            <a href="/profile"><img src="\images\default_pfp.png" alt="Profile Picture"></a>
          </div>
        </nav>
      </header>   

    <div>
        <!-- Character Attributes Will Be Displayed Here -->
        <h2>Name: ${characterName}</h2>        
        <ul id="charAttList">
            
        </ul>            
        <h4>Character Photo:</h4>
        <img src="\images\character.jpg" alt="Character Image">
    </div>   

    <div class="bottom-nav">        
        <a href="/characters"><button>Back</button></a>
    </div>

    <script>

        // Get the character & sheet attributes to display
        var sheetAttributes = JSON.parse('${characterSheetAttributes}');
        var characterAttributes = JSON.parse('${characterAttributes}');

        // Append to <ul>
        for (var i = 0; i < sheetAttributes.length; i++) {
            appendDisplayAtt(sheetAttributes[i],characterAttributes[i]);
        }

        function appendDisplayAtt(sheetAtt,charAtt) {

            var displayItem = document.createElement("li");            
            
            var displayText = document.createElement("p");
            displayText.innerHTML = sheetAtt.name + " : " + charAtt.ca_value;
            displayItem.appendChild(displayText);

            document.getElementById("charAttList").appendChild(displayItem);
        }


    </script>

</body>
</html>