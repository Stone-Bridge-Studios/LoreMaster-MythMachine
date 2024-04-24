
  function sendClaudePrompt(prompt,sysSpec) {
    $.ajax({
      url: "http://localhost:5000/api/anthropic",
      type: "POST",
      data: JSON.stringify({ prompt: prompt, sysSpec: sysSpec }),
      contentType: "application/json; charset=utf-8",
      dataType: "json",
      success: function(response) {
          console.log(response)          
          $("#response").text(response.result);
      }
    });
  }


  function generateStory() {

    var genreBox = document.getElementById("genre-box");
    
    var prompt = "Generate a short story using the genre \""+ genreBox.value +"\". Respond with only the story content.";

    var sysSpec = "Respond with a short story";

    document.getElementById("loading-tag").innerHTML = "Generating Story...";

    $.ajax({
      url: "http://localhost:5000/api/anthropic",
      type: "POST",
      data: JSON.stringify({ prompt: prompt, sysSpec: sysSpec }),
      contentType: "application/json; charset=utf-8",
      dataType: "json",
      success: function(response) {          
        var textArea = document.getElementById("storyTextBox");          
        textArea.value = response.result;
        document.getElementById("loading-tag").innerHTML = "";
      }
    });     

  }

  // Character Editor Suggestion Buttons


  function loadAISuggestions(response) {
    
    // Get Suggestions
    var suggestions = splitByComma(response);
    var container = document.getElementById("suggestion-box")
    
    console.log(container)
    for (var i = 0; i < suggestions.length; i++) {      
      var suggestionButton = document.createElement("button");
      suggestionButton.className = "suggestion-button";
      suggestionButton.innerHTML = suggestions[i];
      suggestionButton.onclick = selectSuggestion.bind(null,suggestionButton);
      container.appendChild(suggestionButton)
    }


  }

  function selectSuggestion(button) {
    var textArea = document.getElementById("attTextBox");          
    textArea.value = button.innerHTML;
  }

  // String Tokenizer Provided by Claude
  function splitByComma(str) {
    return str.split(',').map(item => item.trim());
  }

  // <button onclick="selectSuggestion(this)" class="suggestion-button">AI Suggestion Here</button>
  // <button onclick="getAISuggestions()">Gogo Gadget</button>