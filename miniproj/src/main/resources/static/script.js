const baseUrl = "http://localhost:8080/api";

function createBranch() {
    const name = document.getElementById("branchName").value;
    const rate = document.getElementById("branchRate").value;
    const parentId = document.getElementById("parentId").value || null;

    fetch(`${baseUrl}/branch`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, rate, parentId })
    })
    .then(res => res.json())
    .then(data => alert("Branch created: " + JSON.stringify(data)))
    .catch(err => console.error(err));
}

function createAccount() {
    const name = document.getElementById("accountName").value;
    const branchId = document.getElementById("branchIdForAccount").value;

    fetch(`${baseUrl}/account`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, branchId })
    })
    .then(res => res.json())
    .then(data => alert("Account created: " + JSON.stringify(data)))
    .catch(err => console.error(err));
}

function updateRate() {
    const branchId = document.getElementById("rateBranchId").value;
    const rate = document.getElementById("newRate").value;

    fetch(`${baseUrl}/rate/${branchId}?rate=${rate}`, {
        method: "PUT"
    })
    .then(res => res.text())
    .then(data => alert(data))
    .catch(err => console.error(err));
}

function getBranches() {
    fetch(`${baseUrl}/branches`)
    .then(res => res.json())
    .then(data => {
        document.getElementById("branchesOutput").textContent = JSON.stringify(data, null, 2);
    });
}

function getAccounts() {
    fetch(`${baseUrl}/accounts`)
    .then(res => res.json())
    .then(data => {
        document.getElementById("accountsOutput").textContent = JSON.stringify(data, null, 2);
    });
}
