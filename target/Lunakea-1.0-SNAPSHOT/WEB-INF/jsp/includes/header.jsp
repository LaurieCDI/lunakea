<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<c:url value="/css/style.css" />" type="text/css" media="all" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/style/js/dialogUtils.js"></script>
        <title>Lunakea</title>
<style>
* {
    box-sizing: border-box;
}

body {
    font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
.header {
    background-color: #f1f1f1;
    padding: 30px;
    text-align: center;
    font-size: 35px;
}

/* Create three unequal columns that floats next to each other */
.col-container {
    display: table;
    width: 100%;
}

.row {
    display: flex;
}

.column {
    float: left;
    padding: 10px;
}

/* Left and right column */
.column.side {
    width: 30%;
}

/* Middle column */
.column.middle {
    width: 70%;
}

.column.full {
    width:100%;
}

/* Clear floats after the columns */
.row:after {
    content: "";
    display: table;
    clear: both;
}

/* Style the footer */
.footer {
    background-color: #f1f1f1;
    padding: 10px;
    text-align: center;
}

input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

divForm {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}

/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
@media (max-width: 600px) {
    .column.side, .column.middle {
        width: 100%;
    }
}
</style>
</head>
<body>
    </header>


