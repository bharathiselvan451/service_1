<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="budgetstyle.css">
</head>
<body>

    <h3>ONCE YOU SET YOUR BUDGET YOU WOULD NOT BE ABLE TO CHANHE IT FOR NEXT 30 DAYS</h3>

    <form class="setbudget" action="budget" method="post">

        <label class="budgetlabel">SET BUDGET</label><br>
        <input class="budgetin" type="text" id="budget" name="budget"><br>
        <input type="submit" class="budgetsubmit">
        

    </form>
     <form action="dashboard" class="inline">
                    <button class="float-left submit-button" >back</button>
                </form>
    
</body>
</html>