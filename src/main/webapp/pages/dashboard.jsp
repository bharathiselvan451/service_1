<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="style1.css" rel="stylesheet">

    <title>Dashboard</title>
  </head> 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

   
    <div class="container-fluid" >
        <div class="row flex-nowrap">
            <div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0" style="background-color: #B2D3C2">
                <div class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 min-vh-100" style="color:black">
                    <p class="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-white text-decoration-none">
                        <span class="fs-5 d-none d-sm-inline" style="color:black; font-weight: bold;">Personal Expense Tracker</span>
                        <img src="{{url_for('static', filename='images/Logo.png')}}" style="width:50px;height: 50px;">
                    </p>
                    <!--<ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start" id="menu">
                        <li class="nav-item mt-2" style="background-color:#00AD83; height: 50px; width: 150px; border-radius: 5px;">
                            <a href="dashboard.html" class="nav-link align-middle px-0" style="color:black;">
                               <span class="ms-1 d-none d-sm-inline">Home</span><img src="{{url_for('static', filename='images/house-outline.svg')}}" style="width:20px;height:20px;margin-left: 5px;">
                            </a>
                        </li>-->
                        <!-- <li class="nav-item mt-2">
                            <a href="addexpense.html" class="nav-link px-0 align-middle" style="color:black;">
                                <span class="ms-1 d-none d-sm-inline">Add Expense</span><img src="pay.png" style="width:20px;height:20px;margin-left: 5px;">
                            </a>
                        </li> -->
                        <!-- <li class="nav-item mt-2">
                            <a href="modifyexpense.html" class="nav-link px-0 align-middle" style="color:black;">
                                <span class="ms-1 d-none d-sm-inline">Modify Expense</span><img src="edit_icon.svg" style="width:20px;height:20px;margin-left: 5px;">
                            </a>
                        </li> -->
                        <!-- <li class="nav-item mt-2">
                            <a href="analysis.html" class="nav-link px-0 align-middle" style="color:black;">
                                <span class="ms-1 d-none d-sm-inline">View Analysis</span><img src="graph.png" style="width:20px;height:20px;margin-left: 5px;">
                            </a>
                        </li> -->
                        <!-- <li class="nav-item mt-2">
                            <a href="rewards.html" class="nav-link px-0 align-middle" style="color:black;">
                                <span class="ms-1 d-none d-sm-inline">Rewards & Goals</span><img src="reward.png" style="width:20px;height:20px;margin-left: 5px;">
                            </a>
                        </li> -->
                    </ul>
                </div>
            </div>
            
           
            
            
            <div class="col py-3" style="background-color:black">
            <h3 style="color:white; text-align: center;">Welcome Back! Here are your expenses: budget = ${budget}  current expense = ${expense}</h3>
            <h4 style="color:white; text-align: center;">${message}</h4>
            
                <form action="setexpense" class="expense" method="post">
                    <label for="expense">TODAYS EXPENSES:</label><br>
                    <input type="text" id="fname" name="TExpenses"><br>
                    <input type="submit" value="Submit">
                </form>
                <form action="setbudget" class="inline">
                    <button class="float-left submit-button" >set budget</button>
                </form>
                <form style="margin-left: auto;
	margin-right: auto;
    color: white;
    
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, 650%);" action="getexpense"  class="finddate">
                     <label style="color:white; text-align: center;">Enter date</label>
                     <input type="date" id="date" name="date">
                     <button type="submit">ENTER</button>
                </form>
            </div>
        </div>
    </div>

</html>