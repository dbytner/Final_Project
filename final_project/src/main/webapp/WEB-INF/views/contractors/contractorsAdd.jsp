
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="heaeder.jsp" %>

    <div class="m-4 p-3 width-medium text-color-darker">
      <div class="dashboard-content border-dashed p-3 m-4 view-height">
        <form method="post" action="/contractors/add">
          <div class="mt-4 ml-4 mr-4">
            <div class="row border-bottom border-3">
              <div class="col"><h3 class="color-header text-uppercase">Nowy kontrahent</h3></div>
              <div class="col d-flex justify-content-end mb-2">
                <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Zapisz</button>
              </div>
            </div>
            <form:form modelAttribute="contractors">
            <table class="table borderless">
              <tbody>
              <tr class="d-flex">
                <th scope="row" class="col-2">Nazwa</th>
                <td class="col-7">
                  <form:input name="name" class="w-100 p-1" value="" path="name"/>
                </td>
              </tr>
              <tr class="d-flex">
                <th scope="row" class="col-2">Email</th>
                      <td class="col-7">
                      <form:input name="email" class="w-100 p-1" value="" path="email"/>
                      </td>
              </tr>
              <tr class="d-flex">
                <th scope="row" class="col-2">Adres</th>
                          <td class="col-7">
                          <form:input name="address" class="w-100 p-1" value="" path="address"/>
                           </td>
              </tr>
              <tr class="d-flex">
                <th scope="row" class="col-2">Telefon</th>
                              <td class="col-7">
                              <form:input name="phone" class="w-100 p-1" value="" path="phone"/>
                              </td>
              </tr>
              <tr class="d-flex">
                <th scope="row" class="col-2">NIP</th>
                <td class="col-7">
                  <form:input name="nip" class="w-100 p-1" value="" path="nip"/>
                </td>
              </tr>
              <tr class="d-flex">
                <th scope="row" class="col-2">Kontakt</th>
                <td class="col-7">
                  <form:input name="poc" class="w-100 p-1" value="" path="poc"/>
                </td>
              </tr>
              </tbody>
            </table>
            </form:form>
            </div>
        </form>
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

