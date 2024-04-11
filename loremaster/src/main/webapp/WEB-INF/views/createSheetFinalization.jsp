
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
    .center-buttons {
        display: flex;
        justify-content: center;
        align-items: center;
    }    
</style>
</head>
<body>

    <p1>Sheet Title:</p1>
    <form method="post", action="/finalizeNewSheet" autocomplete="off">
        <br><input id="title" type="text" name="sheetTitle" class="form" value="${sheetTitle}" /><br><br>        
        <div class="bottom-nav">
            <a href="/createSheetAttributeEditor">Back</a>
            <input value="Finish" class="submitInput" type="submit">
        </div>
    </form>

    <script src="\js\sheetEditor.js">

    </script>

    <script>
        function restoreQuotes(str) {
            return str.replace(/@/g, "'").replace(/%/g, '"');
        } 
        console.warn(document.getElementById("title").value)
        document.getElementById("title").value = restoreQuotes(document.getElementById("title").value)
    </script>

</body>
</html>