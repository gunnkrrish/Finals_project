document.getElementById("myForm").addEventListener("submit", function (e) {
    e.preventDefault();
    document.getElementById("myForm").style.display = "none";
    document.getElementById("heading").innerText = "Social Media Survey Result";
    var formData = new FormData(e.target);
    let arr = '<div>';
    for (var pair of formData.entries()) {
        const t1 = `<strong class="resultLabel">${pair[0]} :</strong>`;
        const t2 = `<div class="resultValue">${pair[1]}</div>`;
        arr = arr + '<div class="resultRow">' + t1 + t2 + '</div>';
    }
    arr = arr + '</div>';
    const resultEle = document.getElementById("result");
    resultEle.innerHTML = arr;
});
