<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<h1>Product List Page</h1>
<hr/>
<table border="1">
    <tr>
        <th>번호</th>
        <th>상품명</th>
        <th>가격</th>
        <th>재고</th>
        <th>등록일</th>
    </tr>
    <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.price}</td>
        <td>${product.qty}</td>
        <td><fmt:formatDate value="${product.createdAt}" pattern="yyyy-MM-dd"/></td>
    </tr>
</table>
<form action="/product/${product.id}/purchaseForm" method="get">
    <input type="submit" value="구매하기">
</form>

<%@ include file="../layout/footer.jsp" %>