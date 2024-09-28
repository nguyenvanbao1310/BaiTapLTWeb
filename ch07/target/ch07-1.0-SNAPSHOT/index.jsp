<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Styles/main.css" type="text/css"/>
    </head>
    <body>
        <h2>CD List</h2>
            <table>
                <thead>
                  <tr>
                    <th scope="col" class="col1">Description</th>
                    <th scope="col" class = "col2">Price</th>
                    <th scope="col"></th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                        <form action="cartList" method="post">
                            <input type="hidden" name="action" value="add">
                            <input type="hidden" name="name" value="86 (the band) - True Life Songs and Pictures">
                            <input type="hidden" name="price" value="14.95">
                            <input type="hidden" name="id" value="P001">
                            <td>86 (the band) - True Life Songs and Pictures</td>
                            <td> $14.95</td>
                            <td><button type="submit">Add to Cart</button></td>
                        </form>
                  </tr>
                  <tr>
                        <form action="cartList" method="post">
                              <input type="hidden" name="action" value="add">
                              <input type="hidden" name="name" value="Paddiefoot - The first CD">
                              <input type="hidden" name="price" value="12.95">
                              <input type="hidden" name="id" value="P002">
                              <td>Paddiefoot - The first CD</td>
                              <td> $12.95</td>
                              <td><button type="submit">Add to Cart</button></td>
                        </form>
                  </tr>
                  <tr>
                        <form action="cartList" method="post">
                              <input type="hidden" name="action" value="add">
                              <input type="hidden" name="name" value="Paddlefoot - The second CD">
                              <input type="hidden" name="price" value="14.95">
                              <input type="hidden" name="id" value="P003">
                              <td>Paddlefoot - The second CD</td>
                              <td> $14.95</td>
                              <td><button type="submit">Add to Cart</button></td>
                        </form>
                  </tr>

                   <tr>
                        <form action="cartList" method="post">
                              <input type="hidden" name="action" value="add">
                              <input type="hidden" name="name" value="Joe Rut - Genuine Wood Grained Finish">
                              <input type="hidden" name="price" value="14.95">
                              <input type="hidden" name="id" value="P004">
                              <td>Joe Rut - Genuine Wood Grained Finish</td>
                              <td> $14.95</td>
                              <td><button type="submit">Add to Cart</button></td>
                        </form>
                  </tr>

                </tbody>
          </table>      
    </body>
</html>
