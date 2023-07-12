
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Kaktus</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
        rel="stylesheet">
  <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>

<body>
<header class="page-header">
  <nav class="navbar navbar-expand-lg justify-content-between">
    <a href="/" class="navbar-brand main-logo main-logo-smaller">
      <span>Kaktus</span>
    </a>
    <div class="d-flex justify-content-around">
      <h4 class="text-light mr-3">Imię</h4>
      <div class="circle-div text-center"><i class="fas fa-user icon-user"></i></div>
    </div>
  </nav>
</header>

<section class="dashboard-section">
  <div class="row dashboard-nowrap">
    <ul class="nav flex-column long-bg">
      <li class="nav-item">
        <a class="nav-link " href="/">
          <span>Pulpit</span>
          <i class="fas fa-angle-right"></i>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/customer/list">
          <span>Kilenci</span>
          <i class="fas fa-angle-right"></i>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/contractors/list">
          <span>Kontrahenci</span>
          <i class="fas fa-angle-right"></i>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/order/list">
          <span>Zlecenia</span>
          <i class="fas fa-angle-right"></i>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/production/list">
          <span>Zamówienia</span>
          <i class="fas fa-angle-right"></i>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/invoices/list">
          <span>Faktury</span>
          <i class="fas fa-angle-right"></i>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/edit/user">
          <span>Edytuj dane</span>
          <i class="fas fa-angle-right"></i>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="/userpassword">
          <span>Zmień hasło</span>
          <i class="fas fa-angle-right"></i>
        </a>
      </li>
    </ul>

    <div class="m-4 p-3 width-medium">
      <div class="dashboard-content border-dashed p-3 m-4 view-height">
        <div class="row border-bottom border-3 p-1 m-1">
          <div class="col noPadding">
            <h3 class="color-header text-uppercase">LISTA KONTRAHENTÓW</h3>
          </div>
          <div class="col d-flex justify-content-end mb-2 noPadding">
            <a href="/contractors/add" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Dodaj kontrahenta</a>
          </div>
        </div>

        <div class="schedules-content">
          <table class="table border-bottom">
            <thead>
            <tr class="d-flex">
              <th class="col-1">ID</th>
              <th class="col-2">NAZWA</th>
              <th class="col-1">EMAIL</th>
              <th class="col-2">ADRES</th>
              <th class="col-1">TELEFON</th>
              <th class="col-1">NIP</th>
              <th class="col-1">KONTAKT</th>
              <th class="col-3 center">AKCJE</th>
            </tr>
            </thead>
            <tbody class="text-color-lighter">
            <c:forEach var="contractor" items="${contractors}">
              <tr class="d-flex">
                <td class="col-1">${contractor.id}</td>
                <td class="col-2">${contractor.name}</td>
                <td class="col-1">${contractor.email}</td>
                <td class="col-2">${contractor.address}</td>
                <td class="col-1">${contractor.phone}</td>
                <td class="col-1">${contractor.nip}</td>
                <td class="col-1">${contractor.poc}</td>
                <td class="col-3 d-flex align-items-center justify-content-center flex-wrap">
                  <a href="/contractors/delete-confirm/${contractor.id}" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                  <a href="/contractors/edit/${contractor.id}" class="btn btn-warning rounded-0 text-light m-1">Edytuj</a>
                  <a href="/app/recipe/details?id=${contractor.id}" class="btn btn-info rounded-0 text-light m-1">Dodaj zlecenie</a>
                  <a href="/app/recipe/details?id=${contractor.id}" class="btn btn-warning rounded-0 text-light m-1">Dodaj fakturę</a>
                  <a href="/app/recipe/details?id=${contractor.id}" class="btn btn-warning rounded-0 text-light m-1">Zlecenia</a>
                  <a href="/app/recipe/details?id=${contractor.id}" class="btn btn-warning rounded-0 text-light m-1">Faktury</a>
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
