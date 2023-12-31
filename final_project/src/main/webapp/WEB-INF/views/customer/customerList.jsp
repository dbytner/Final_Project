
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="heaeder.jsp" %>


    <div class="m-4 p-3 width-medium">
      <div class="dashboard-content border-dashed p-3 m-4 view-height">
        <div class="row border-bottom border-3 p-1 m-1">
          <div class="col noPadding">
            <h3 class="color-header text-uppercase">LISTA KLIENTÓW</h3>
          </div>
          <div class="col d-flex justify-content-end mb-2 noPadding">
            <a href="/customer/add" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Dodaj klienta</a>
          </div>
        </div>

        <div class="schedules-content">
          <table class="table border-bottom">
            <thead>
            <tr class="d-flex">
              <th class="col-1">ID</th>
              <th class="col-2">NAZWA</th>
              <th class="col-2">EMAIL</th>
              <th class="col-2">ADRES</th>
              <th class="col-2">TELEFON</th>
              <th class="col-3 center">AKCJE</th>
            </tr>
            </thead>
            <tbody class="text-color-lighter">
            <c:forEach var="customer" items="${customers}">
              <tr class="d-flex">
                <td class="col-1">${customer.id}</td>
                <td class="col-2">${customer.name}</td>
                <td class="col-2">${customer.email}</td>
                <td class="col-2">${customer.address}</td>
                <td class="col-2">${customer.phone}</td>
                <td class="col-3 d-flex align-items-center justify-content-center flex-wrap">
                  <a href="/customer/delete-confirm/${customer.id}" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                  <a href="/customer/edit/${customer.id}" class="btn btn-warning rounded-0 text-light m-1">Edytuj</a>
                  <a href="/orders/add/${customer.id}" class="btn btn-info rounded-0 text-light m-1">Dodaj zamówienie</a>
                  <a href="/customerInvoices/add/${customer.id}" class="btn btn-warning rounded-0 text-light m-1">Dodaj fakturę</a>
                  <a href="/customer/ordersList/${customer.id}" class="btn btn-warning rounded-0 text-light m-1">Zamówienia</a>
                  <a href="/customer/invoicesList/${customer.id}" class="btn btn-warning rounded-0 text-light m-1">Faktury</a>
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</section>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>
