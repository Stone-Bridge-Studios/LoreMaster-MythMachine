
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


  // Character Editor Suggestion Buttons

  function getAISuggestions() {
    // Creates a prompt based on attribute name and description,
    // then communicates with the AI Python Server by sending a request.

    // Once the request succeeds, the response will passed to loadAISugestions

    var attName = document.getElementById("attributeName").innerHTML;
    var attDesc = document.getElementById("attributeDesc").innerHTML;

    var prompt = "In the context of filling out a Character Sheet for a fictional character, give me list of possible entries to satisfy the field named \""+attName+"\". The field's description is \""+attDesc+"\". Respond only with your entries, keep them delimited by commas and do not include any punctuation."

    console.warn(prompt)
    
    var sysSpec = "Respond only in single words delimited by commas";
    
    $.ajax({
      url: "http://localhost:5000/api/anthropic",
      type: "POST",
      data: JSON.stringify({ prompt: prompt, sysSpec: sysSpec }),
      contentType: "application/json; charset=utf-8",
      dataType: "json",
      success: function(response) {          
        loadAISuggestions(response.result);
      }
    });    
    

    // Test
    //loadAISuggestions("Blonde, Brown, Black, Red, Auburn, Chestnut, Strawberry Blonde, Golden, Honey, Ash, Sandy, Platinum, Silver, Gray, White, Raven, Jet Black, Ebony, Salt and Pepper, Mousy, Dirty Blonde, Copper, Ginger, Titian, Burgundy, Mahogany, Crimson, Purple, Lavender, Blue, Green, Pink, Rainbow, Multicolored, Ombre, Highlighted, Streaked, Dyed")

  }

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

  function clearSuggestionButtons() {
    document.getElementById("suggestion-box").innerHTML = "";
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