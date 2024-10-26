function createRule() {
    const ruleString = document.getElementById("ruleInput").value;
    fetch(`/api/rules/create?ruleString=${encodeURIComponent(ruleString)}`, {
        method: 'POST',
    }).then(response => response.json())
      .then(data => document.getElementById("createResult").textContent = JSON.stringify(data))
      .catch(error => console.error('Error:', error));
}

function evaluateRule() {
    const data = JSON.parse(document.getElementById("dataInput").value);
    fetch(`/api/rules/evaluate`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data),
    }).then(response => response.json())
      .then(result => document.getElementById("evalResult").textContent = "Result: " + result)
      .catch(error => console.error('Error:', error));
}
