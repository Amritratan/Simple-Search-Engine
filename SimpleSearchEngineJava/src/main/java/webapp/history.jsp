<%@page import = "java.util.ArrayList"%>
<%@page import = "Com.Accio.HistoryResult"%>
<html>
<head>
     <link rel= "stylesheet" type = "text/css" href = "styles.css">
</head>
<body>
    <h1>Simple Search Engine</h1>
    <form action="Search">
             <input type="text" name="keyword">
             <button type="submit">Search</button>
    </form>
    <table border = 2 class="resultTable">
        <tr>
           <th>Keyword</th>
           <th>Link</th>
        </tr>
        <%
           ArrayList<HistoryResult> results = (ArrayList<HistoryResult>)request.getAttribute("results");
           for(HistoryResult result: results){
        %>
        <tr>
            <td><%out.println(result.getKeyword());%></td>
            <td><a href="<%out.println(result.getLink());%>"><%out.println(result.getLink());%></a></td>
        </tr>
        <%
           }
        %>
    </table>
</body>
</html>