<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

 <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PETA</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
                          
    
    <section class="user">
        <div class="user_options-container">
            <div class="user_options-text">
                <div class="user_options-unregistered">
                    <h2 class="user_unregistered-title">Don't have an account?</h2>
                    <p class="user_unregistered-text">If you don't have an account register for this app</p>
                    <button class="user_unregistered-signup" id="signup-button">Register</button>
                </div>

                <div class="user_options-registered">
                    <h2 class="user_registered-title">Have an account?</h2>
                    <p class="user_registered-text">If you have an account signup for this app</p>
                    <button class="user_registered-login" id="login-button">Login</button>
                </div>
            </div>
            <!-- form for login -->
            <div class="user_options-forms" id="user_options-forms">
                <div class="user_forms-login">
                    <h2 class="forms_title">Login</h2>
                    <form class="forms_form" action="login" method="post">
                        <fieldset class="forms_fieldset">
                            <div class="forms_field">
                                <input type="email" placeholder="Email" name="log_email" id="log_email" class="forms_field-input"
                                    required autofocus />
                            </div>
                            <div class="forms_field">
                                <input type="password" placeholder="Password" name="log_password" id="log_password"
                                    class="forms_field-input" required />
                            </div>
                        </fieldset>
                        <div class="forms_buttons">
                            
                            <input type="submit" value="Log In" class="forms_buttons-action">
                        </div>
                    </form>
                </div>
                <!--form for register-->
                <div class="user_forms-signup">
                    <h2 class="forms_title">Register</h2>
                    <form class="forms_form" action="register" method="post">
                        <fieldset class="forms_fieldset">
                            <div class="forms_field">
                                <input type="text" placeholder="Full Name" name="reg_name" id="reg-name" class="forms_field-input"
                                    required />
                            </div>
                            <div class="forms_field">
                                <input type="email" placeholder="Email" name="reg_email" id="reg-email" class="forms_field-input"
                                    required />
                            </div>
                            <div class="forms_field">
                                <input type="password" placeholder="Password" name="reg_password" id="reg-password"
                                    class="forms_field-input" required />
                            </div>
                        </fieldset>
                        <div class="forms_buttons">
                            <input type="submit" value="Register" class="forms_buttons-action">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <script src="js.js"></script>

    <!-- ----------Smooth Scroll-------------   
    <script src="smooth-scroll.js"></script>
    <script>
	   var scroll = new SmoothScroll('a[href*="#"]');
    </script>
     -->

</body>

</html>