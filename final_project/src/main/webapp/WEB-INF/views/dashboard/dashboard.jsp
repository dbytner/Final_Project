
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="panelheader.jsp" %>
<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <ul class="nav flex-column long-bg">
            <li class="nav-item">
                <a class="nav-link active" href="/dashboard">
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
                <a class="nav-link" href="/orders/list">
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

        <div class="m-4 p-4 width-medium">
            <div class="dashboard-header m-4">
                <div class="dashboard-menu">
                    <div class="menu-item border-dashed">
                        <a href="/customer/add">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">dodaj klienta</span>
                        </a>
                    </div>
                    <div class="menu-item border-dashed">
                        <a href="/customer/add">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">dodaj kontrahenta</span>
                        </a>
                    </div>
                    <div class="menu-item border-dashed">
                        <a href="/orders/add">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">dodaj zamówienie</span>
                        </a>
                    </div>
                    <div class="menu-item border-dashed">
                        <a href="/production/add">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">dodaj zlecenie</span>
                        </a>
                    </div>
                    <div class="menu-item border-dashed">
                        <a href="/invoices/add">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">dodaj fakturę</span>
                        </a>
                    </div>
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