function deleteProduct(id){
    ids = [];
    ids.push(id);
    var result = JSON.stringify(ids);
    swal({
        title: "Chắc chắn muốn xóa?",
        text: "Bạn sẽ không thể khôi phục lại sản phẩm này!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
    .then((willDelete) => {
        if(willDelete){
            console.log(result);
            fetch("http://localhost:8081/book/", {
                 // Adding method type
                 method: "DELETE",
                 // Adding headers to the request
                 body: result,
                 // Adding headers to the request
                 headers: {
                     "Content-type": "application/json; charset=UTF-8"
                 }
            })
            // Success
            .then(response => {
                 var returnData = response.json();
                 swal("Good job!", "Xóa thành công!", "success")
                      .then((value) => {
                      window.location.href = "/admin/product";
                      });
            })
            // Catch error
            .catch(error => {
                 // Handle error
                 swal("Oops!", "Xóa thất bại!", "error");
            });
        }
    });
}