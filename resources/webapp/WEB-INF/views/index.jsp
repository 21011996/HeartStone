<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
    <title>HeartStone</title>
</head>
<BODY>
<h3>Select player</h3>

<h3>Enemy Board</h3>
<form:form modelAttribute="gameState" method="GET" action="/game">
    <table border="1">
        <tr>
            <c:forEach var="card" items="${gameState.getNonActivePlayer().getBoard().getCards()}">
                <td colspan="2">${card.getName()}</td>

            </c:forEach>
        </tr>
        <tr>
            <c:forEach var="card" items="${gameState.getNonActivePlayer().getBoard().getCards()}">
                <td>${card.getAttack()}</td>
                <td>${card.getCurrentHealth()}</td>
            </c:forEach>
        </tr>
    </table>
</form:form>
<h3>Your Board</h3>
<form:form modelAttribute="gameState" method="GET" action="/game">
    <table border="1">
        <tr>
            <c:forEach var="card" items="${gameState.getActivePlayer().getBoard().getCards()}">
                <td colspan="2">${card.getName()}</td>

            </c:forEach>
        </tr>
        <tr>
            <c:forEach var="card" items="${gameState.getActivePlayer().getBoard().getCards()}">
                <td>${card.getAttack()}</td>
                <td>${card.getCurrentHealth()}</td>
            </c:forEach>
        </tr>
    </table>
</form:form>
<h3>Your Hand</h3>
<form:form modelAttribute="gameState" method="GET" action="/game">
    <table border="1">
        <tr>
            <c:forEach var="card" items="${gameState.getActivePlayer().getHand().getCards()}">
                <td>${card.getName()}</td>
            </c:forEach>
        </tr>
    </table>
</form:form>
<form:form modelAttribute="gameState" method="GET" action="/game">
    <h4>Mana left:${gameState.getActivePlayer().getManaLeft()}</h4>
</form:form>
<form:form modelAttribute="gameState" method="GET" action="/game">
    <table border="1" cellpadding="10">
        <c:forEach var="option" items="${gameState.getOptions()}">
            <tr>
                <td>${option.getName()}</td>
                <td><input type="submit" value="select"
                           onclick="form.action='/delete-task';document.checkForm.toDelete.value=${option.getName()};document.checkForm.toDelete.submit();">
                </td>
            </tr>
        </c:forEach>
        <input type="hidden" name="toDelete"/>
        <input type="submit" style="display:none" name="hB" value="add"/>
    </table>
</form:form>


</body>
</html>