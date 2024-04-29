from flask import Flask, request, jsonify
from flask_cors import CORS
import anthropic
import os

app = Flask(__name__)
CORS(app)  # Allow cross-origin requests from any origin

@app.route('/api/anthropic', methods=['POST'])
def handle_anthropic_request():
    
    # Input Prompt to send to Claude
    prompt = request.json['prompt']
    systemSpec = request.json['sysSpec']

    # Create Client
    client = anthropic.Anthropic()

    # Create & Send Message To Claude
    message = client.messages.create(
        model="claude-3-opus-20240229",
        max_tokens=1000,
        temperature=0.0,
        system=systemSpec,
        messages=[
            {"role": "user", "content": prompt}
        ]
    )
    
    result = ""
    for block in message.content:
        result += block.text  
    
    json = jsonify({ "result" : result })
    
    return json


if __name__ == '__main__':
    app.run()
