const api_url =
      "http://localhost:8081/book";
// Function to define innerHTML for HTML table
function show(data) {
    let tab =
        ``;
    // Loop to access all rows
    for (let r of data.listResult) {
        var random_rate = Math.floor(Math.random() * 100) + 1;
        tab += `<tr>
                    <td>
                        <div class="d-flex px-2">
                            <div>
                                <img src="${r.imgUrl}" class="avatar avatar-sm rounded-circle me-2" alt="spotify">
                            </div>
                            <div class="my-auto">
                                <h6 class="mb-0 text-sm">${r.name}</h6>
                            </div>
                        </div>
                    </td>
                    <td>
                        <p class="text-sm font-weight-bold mb-0">$ ${r.price}</p>
                    </td>
                    <td>
                        <span class="text-xs font-weight-bold">${r.author}</span>
                    </td>
                    <td class="align-middle text-center">
                        <div class="d-flex align-items-center justify-content-center">
                            <span class="me-2 text-xs font-weight-bold">${random_rate}%</span>
                            <div>
                                <div class="progress">
                                    <div class="progress-bar bg-gradient-info" role="progressbar" aria-valuenow="${random_rate}" aria-valuemin="0" aria-valuemax="100" style="width: ${random_rate}%;"></div>
                                </div>
                            </div>
                        </div>
                    </td>
                    <td class="align-middle">
                        <div class="drop-left float-lg-end pe-4">
                            <a class="cursor-pointer" id="dropdownTable" data-bs-toggle="dropdown" aria-expanded="false">
                              <i class="fa fa-ellipsis-v text-secondary"></i>
                            </a>
                            <ul class="dropdown-menu px-2 py-3 ms-sm-n4 ms-n5" aria-labelledby="dropdownTable">
                              <li><a class="dropdown-item border-radius-md" href="javascript:window.location.href='/admin/product/create?id=${r.id}';">Chỉnh sửa</a></li>
                              <li><a class="dropdown-item border-radius-md" href="javascript:deleteProduct(${r.id});">Xóa</a></li>
                            </ul>
                        </div>
                    </td>
                </tr>`;
    }
    // Setting innerHTML as tab variable
    document.getElementById("product-data").innerHTML = tab;
}
// Defining async function
async function get_api(url) {
    // Storing response
    const response = await fetch(url);
    // Storing data in form of JSON
    var data = await response.json();
    console.log(data);
    show(data);
}
// Calling that async function
get_api(api_url);