<%-- 
    Document   : armstrong
    Created on : Feb 4, 2023, 11:21:28 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Armstrong JSP</title>
        <link rel="stylesheet" href="style.css" type="text/css" >
    </head>
    <body>


        <% int n = Integer.parseInt(request.getParameter("num"));
        %>

        <%! 
        boolean armstrong(int n){
            int originalNumber, remainder, result = 0;
            int count=0;
        originalNumber = n;
        int num =n;
        while(num!=0){
        num = num/10;
        count++;
        }
        while (originalNumber != 0)
        {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, count);
            originalNumber /= 10;
        }  
            if(result == n){
            return true;
        }else{
         return false;
        }
        }
        %>
        <% 
            if(armstrong(n)){
        out.print("<h1>"+n+ " is an Armstrong number</h1>");
            }
            else{
            out.print("<h1>"+n+ " is not an Armstrong number</h1>");
            }
        %>
    </body>
</html>
