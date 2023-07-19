<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="heaeder.jsp" %>
<div class="m-4 p-3 width-medium">
    <div class="dashboard-content border-dashed p-3 m-4 view-height">
        <div class="row border-bottom border-3 p-1 m-1">
            <div class="col noPadding">
                <h3 class="color-header text-uppercase">CZY NA PEWNO CHCESZ USUNĄĆ</h3>
            </div>

            <div class="schedules-content">
                <table class="table border-bottom">
                    <thead>

                    <tbody class="text-color-lighter">

                    <td class="col-3 d-flex align-items-center justify-content-center flex-wrap">
                        <a href="/customerInvoices/delete/${customerInvoices.id}" class="btn btn-warning rounded-0 text-light m-1">Potwierdź</a>
                        <a href="/customerInvoices/list/" class="btn btn-warning rounded-0 text-light m-1">Anuluj</a>
                    </td>
                    </tr>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</html>
