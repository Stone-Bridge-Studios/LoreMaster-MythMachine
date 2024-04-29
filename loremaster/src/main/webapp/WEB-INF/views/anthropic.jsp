<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Anthropic AI</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="\js\claudeAI.js"></script>
  </head>
  <body>
    <h1>Anthropic AI</h1>
    <input type="text" id="prompt" placeholder="Enter your prompt">
    <button id="sendPrompt" onclick="sendClaudePrompt()">Send Prompt</button>
    <div id="response"></div>
  </body>
</html>