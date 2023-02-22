

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>String Manipulation</title>
        <link rel="stylesheet" href="style.css" type="text/css" >
    </head>
    <body>
        
        <h1>String Manipulation<h1>
        <% 
        String s1 = request.getParameter("s1");
        String s2 = request.getParameter("s2");
        String s3 = request.getParameter("action");
       
        %>
        
        <% 
            if(s3.equals("Concat"))
            out.print("<h3>Concatenated Strings: "+ s1.concat(s2)+"</h3>");
            
            if(s3.equals("Compare")){
            out.print("<h3> Comparing String1 and String2 </h3>");
            if(s1.compareTo(s2) ==0){
            out.print("<h3>Equal</h3>");
            }
            else{
            out.print("<h3>Not Equal</h3>");
            }
            }
            
            if(s3.equals("toUpper")){
            out.print("<h3> Strings to uppercase:</h3>");
            out.print("<h3>String 1: "+ s1.toUpperCase()+"</h3>");
            out.print("<h3>String 2: "+ s2.toUpperCase()+"</h3>");
            }
            if(s3.equals("toLower")){
            out.print("<h3> Strings to lowercase:</h3>");
            out.print("<h3>String 1: "+ s1.toLowerCase()+"</h3>");
            out.print("<h3>String 2: "+ s2.toLowerCase()+"</h3>");
            }
            
            if(s3.equals("Replace")){
            String getstr = request.getParameter("replstr");
            String newstr1 =  s1.replace(s1,getstr);
            String newstr2 =  s2.replace(s2,getstr);
            out.print("<h3> Replaced Strings are: </h3>");
            out.print("<h3> String 1: "+newstr1+"<br> String 2: "+newstr2+"</h3>");
            }
        
            %>
            
          
    </body>
</html>
