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
<form:form method="GET" action="/get-player">
    <table>
        <tr>
            <td><input type="submit" value="player 1" onclick="form.action='/get-player1';"></td>
            <td><input type="submit" value="player 2" onclick="form.action='/get-player2';"></td>
        </tr>
    </table>
</form:form>

<form:form modelAttribute="playerNo" method="get" action="/game">
    <form:form modelAttribute="gameState" method="GET" action="/game">
        <h3>Currently active: Player ${gameState.getActivePlayer().getId()}</h3>
        <h4>Turn stage: ${gameState.getTurnStage().toString()}</h4>
    </form:form>
    <form:form modelAttribute="gameState" method="GET" action="/end-stage">
        <c:if test="${playerNo == 1 && gameState.getActivePlayer().getId() == 1}"><input type="submit" value="End stage"
                                                                                         onclick="form.action='/end-stage1';"></c:if>
        <c:if test="${playerNo == 2 && gameState.getActivePlayer().getId() == 2}"><input type="submit" value="End stage"
                                                                                         onclick="form.action='/end-stage2';"></c:if>
    </form:form>
    <h3>Enemy Board</h3>
    <form:form modelAttribute="gameState" method="GET" action="/game">
        <h4>Enemy hero: ${gameState.getNonPlayer(playerNo).getHero().getName()}
            (Health: ${gameState.getNonPlayer(playerNo).getHero().getCurrentHealth()})</h4>
        <table border="1">
            <tr>
                <c:forEach var="card" items="${gameState.getNonPlayer(playerNo).getBoard().getCards()}">
                    <td colspan="2">${card.getName()}</td>

                </c:forEach>
            </tr>
            <tr>
                <c:forEach var="card" items="${gameState.getNonPlayer(playerNo).getBoard().getCards()}">
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
                <c:forEach var="card" items="${gameState.getPlayer(playerNo).getBoard().getCards()}">
                    <td colspan="2">${card.getName()}</td>

                </c:forEach>
            </tr>
            <tr>
                <c:forEach var="card" items="${gameState.getPlayer(playerNo).getBoard().getCards()}">
                    <td>${card.getAttack()}</td>
                    <td>${card.getCurrentHealth()}</td>
                </c:forEach>
            </tr>
        </table>
        <h4>Your hero: ${gameState.getPlayer(playerNo).getHero().getName()}
            (Health: ${gameState.getPlayer(playerNo).getHero().getCurrentHealth()})</h4>
    </form:form>
    <h3>Your Hand</h3>
    <form:form modelAttribute="gameState" method="GET" action="/game">
        <table border="1">
            <tr>
                <c:forEach var="card" items="${gameState.getPlayer(playerNo).getHand().getCards()}">
                    <td>${card.getName()}</td>
                </c:forEach>
            </tr>
        </table>
    </form:form>
    <form:form modelAttribute="gameState" method="GET" action="/game">
        <h4>Mana left: ${gameState.getPlayer(playerNo).getManaLeft()}</h4>
    </form:form>
    <form:form modelAttribute="gameState" method="GET" action="/play-card">
        <c:if test="${playerNo==gameState.getActivePlayer().getId()}">
            <c:if test="${cardPlay.getName().equals('S6a6t6a6n')}">
                <table>
                    <tr>
                        <td>
                            <form:select path="card">
                                <c:forEach items="${gameState.getOptions()}" var="option">
                                    <option value="${option.getId()}">
                                            ${option.toString()}
                                    </option>
                                </c:forEach>
                            </form:select>
                        </td>
                        <td><input type="submit" value="choose" onclick="form.action='/play-card';"></td>
                    </tr>
                </table>
            </c:if>
            <c:if test="${!cardPlay.getName().equals('S6a6t6a6n')}">
                <table>
                    <tr>
                        <td>
                            <form:select path="card2">
                                <form:option value="NONE">Choose target</form:option>
                                <form:options items="${gameState.getSecondaryOption(cardPlay)}"></form:options>
                            </form:select>
                        </td>
                        <td><input type="submit" value="choose" onclick="form.action='/play-target';"></td>
                    </tr>
                </table>
            </c:if>
        </c:if>
    </form:form>
</form:form>


</body>
</html>