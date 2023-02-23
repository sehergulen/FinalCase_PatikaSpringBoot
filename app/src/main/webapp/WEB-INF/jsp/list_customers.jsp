<%@ include file="common/header.jspf" %>

<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Surname</th>
            <th scope="col">BirthDate</th>
            <th scope="col">TC</th>
            <th scope="col">CreditPoint</th>
            <th scope="col">Income</th>
            <th scope="col">Phone</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td>${customer.name}</td>
                <td>${customer.surname}</td>
                <td>${customer.birthdate}</td>
                <td>${customer.tc}</td>
                <td>${customer.creditPoint}</td>
                <td>${customer.income}</td>
                <td>${customer.phoneNumber}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="common/footer.jspf" %>