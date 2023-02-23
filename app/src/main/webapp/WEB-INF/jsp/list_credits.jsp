<%@ include file="common/header.jspf" %>

<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Credit Id</th>
            <th scope="col">Customer Id</th>
            <th scope="col">Customer Name</th>
            <th scope="col">Customer Surname</th>
            <th scope="col">Customer Tc</th>
            <th scope="col">Credit Limit</th>
            <th scope="col">Approved</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${credits}" var="credit">
            <tr>
                <td>${credit.id}</td>
                <td>${credit.customer.id}</td>
                <td>${credit.customer.name}</td>
                <td>${credit.customer.surname}</td>
                <td>${credit.customer.tc}</td>
                <td>${credit.creditLimit}</td>
                <td>${credit.approved}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="common/footer.jspf" %>