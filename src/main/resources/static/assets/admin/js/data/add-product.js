function handleFormSubmit(event) {
  event.preventDefault();

  const data = new FormData(event.target);

  const formJSON = Object.fromEntries(data.entries());

  var result = JSON.stringify(formJSON, null, 2);
  console.log(result);
  var id = findGetParameter("id");

  if(id!=null){
    fetch("http://localhost:8081/book/"+String(id), {
              // Adding method type
              method: "PUT",
              // Adding body or contents to send
              body: result,
              // Adding headers to the request
              headers: {
                  "Content-type": "application/json; charset=UTF-8"
              }
          })
          // Success
          .then(response => {
               var returnData = response.json();
               swal("Good job!", "Chỉnh sửa thành công!", "success")
                    .then((value) => {
                    window.location.href = "/admin/product";
                    });
          })
          // Catch error
          .catch(error => {
              // Handle error
              swal("Oops!", "Chỉnh sửa thất bại!", "error");
          });
  }else{
    fetch("http://localhost:8081/book", {
          // Adding method type
          method: "POST",
          // Adding body or contents to send
          body: result,
          // Adding headers to the request
          headers: {
              "Content-type": "application/json; charset=UTF-8"
          }
      })
      // Success
      .then(response => {
           var returnData = response.json();
           swal("Good job!", "Thêm mới thành công!", "success")
                .then((value) => {
                window.location.href = "/admin/product";
                });
      })
      // Catch error
      .catch(error => {
          // Handle error
          swal("Oops!", "Thêm mới thất bại!", "error");
      });
  }
}

const form = document.querySelector('#bookForm');
form.addEventListener('submit', handleFormSubmit);

function findGetParameter(parameterName) {
    var result = null,
        tmp = [];
    location.search
        .substr(1)
        .split("&")
        .forEach(function (item) {
          tmp = item.split("=");
          if (tmp[0] === parameterName) result = decodeURIComponent(tmp[1]);
        });
    return result;
}

async function checkEditing(){
    var id = findGetParameter("id");
    if(id!=null){
        var api_url =
             "http://localhost:8081/book/"+String(id);
        const response = await fetch(api_url);
            // Storing data in form of JSON
        var data = await response.json();
        console.log(data);
        document.getElementById("header").innerHTML = "Chỉnh sửa sản phẩm";
        document.getElementById("name").value = data.name;
        document.getElementById("author").value = data.author;
        document.getElementById("price").value = data.price;
        document.getElementById("categoryCode").value = data.categoryCode;
        document.getElementById("imgUrl").value = data.imgUrl;
    }
}

checkEditing();
