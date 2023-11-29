<script>

        function deleteEntity(id, deleteUrl) {
                    var confirmation = confirm('Are you sure you want to delete this record?');
              <%-- deleteUrl = "./admin-tours?action=delete"  --%>
                    if (confirmation) {
                        fetch(deleteUrl + '&id=' + id, {
                            method: 'DELETE'
                        })
                        .then(response => {
                            if (!response.ok) {
                                throw new Error('Network response was not ok');
                            }
              <%--  return response.json(); --%>

                           console.log("Deleted................");
                        })
                        .catch(error => console.error('Error:', error));
                    }
                }


     document.getElementById("searchForm").addEventListener("submit", function(event) {
         event.preventDefault();

         const formData = new FormData(this);
         const searchItem = formData.get("searchItem");

         const searchUrl = document.getElementById("searchUrl").value;

         const url = `${searchUrl}?action=search&searchItem=${encodeURIComponent(searchItem)}`;

           fetch(url)
                 .then(response => response.text())
                 .then(data => {
                     console.log("Data fetched:", data);

                     const parser = new DOMParser();
                     const htmlDoc = parser.parseFromString(data, 'text/html');

                     const tableContent = htmlDoc.querySelector('.TourList');

                     const table = document.querySelector('.TourList');
                     if (table && tableContent) {
                         table.innerHTML = tableContent.innerHTML;
                     }
                 })
                 .catch(error => console.error("Error fetching data:", error));
     });




</script>