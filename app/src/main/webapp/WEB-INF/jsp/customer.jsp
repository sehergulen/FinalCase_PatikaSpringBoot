<%@ include file="common/header.jspf" %>
<div class="container">
    <table class="table">
        <h3>CREDIT APPROVAL SYSTEM</h3>
        <%
            String profile_msg=(String)request.getAttribute("profile_msg");
            if(profile_msg!=null){
                out.print(profile_msg);
            }
            String login_msg=(String)request.getAttribute("login_msg");
            if(login_msg!=null){
                out.print(login_msg);
            }
        %>
        <br/>
        <form method="get" action="http://localhost:8080/creditMvc/list" >
            NAME:<input type="text" name="name"/><br/><br/>
            SURNAME:<input type="text" name="surname"/><br/><br/>
            TC:<input type="number" name="tc"/><br/><br/>
            <input type="submit" value="SEARCH"/>
        </form>
    </table>
</div>
<%@ include file="common/footer.jspf" %>