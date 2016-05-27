<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
    <title>Shop</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />" type="text/css" media="all"/>


    <meta name="keywwords"
          content="Shop Around - Great free html template for on-line shop. Use it as a start point for your on line business. The template can be easily implemented in many open source E-commerce platforms"/>
    <meta name="description"
          content="Shop Around - Great free html template for on-line shop. Use it as a start point for your on line business. The template can be easily implemented in many open source E-commerce platforms"/>

    <!-- JS -->
    <script src="<c:url value="/resources/js/jquery-1.4.1.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/jquery.jcarousel.pack.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/jquery-func.js" />" type="text/javascript"></script>
    <!-- End JS -->

</head>
<body onload='document.loginForm.username.focus();'>

<!-- Shell -->
<div class="shell">

    <!-- Header -->
    <div id="header">
        <h1 id="logo"><a href="#">shoparound</a></h1>

        <!-- Cart -->
        <div id="cart">
            <a href="#" class="cart-link">Your Shopping Cart</a>

            <div class="cl">&nbsp;</div>
            <span>Articles: <strong>4</strong></span>
            &nbsp;&nbsp;
            <span>Cost: <strong>$250.99</strong></span>
        </div>
        <!-- End Cart -->

        <!-- Navigation -->
        <div id="navigation">
            <ul>
                <li><a href="#" class="active">Home</a></li>
                <li><a href="#">Support</a></li>
                <li><a href="#">My Account</a></li>
                <li><a href="#">The Store</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
        </div>
        <!-- End Navigation -->
    </div>
    <!-- End Header -->

    <!-- Main -->
    <div id="main">
        <div class="cl">&nbsp;</div>

        <!-- Content -->
        <div id="content">

            <!-- Content Slider -->
            <div id="slider" class="box">
                <div id="slider-holder">
                    <ul>
                        <li><a href="#"><img src="<c:url value="/resources/css/images/slide1.jpg" />" alt=""/></a></li>
                        <li><a href="#"><img src="<c:url value="/resources/css/images/slide1.jpg" />" alt=""/></a></li>
                        <li><a href="#"><img src="<c:url value="/resources/css/images/slide1.jpg" />" alt=""/></a></li>
                        <li><a href="#"><img src="<c:url value="/resources/css/images/slide1.jpg" />" alt=""/></a></li>
                    </ul>
                </div>
                <div id="slider-nav">
                    <a href="#" class="active">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                </div>
            </div>
            <!-- End Content Slider -->

            <!-- Products -->
            <div class="products">
                <div class="cl">&nbsp;</div>
                <ul>
                    <li>
                        <a href="#"><img src="<c:url value="/resources/css/images/big1.jpg" />" alt=""/></a>

                        <div class="product-info">
                            <h3>LOREM IPSUM</h3>

                            <div class="product-desc">
                                <h4>WOMEN’S</h4>

                                <p>Lorem ipsum dolor sit<br/>amet</p>
                                <strong class="price">$58.99</strong>
                            </div>
                        </div>
                    </li>
                    <li>
                        <a href="#"><img src="<c:url value="/resources/css/images/big1.jpg" />" alt=""/></a>

                        <div class="product-info">
                            <h3>LOREM IPSUM</h3>

                            <div class="product-desc">
                                <h4>WOMEN’S</h4>

                                <p>Lorem ipsum dolor sit<br/>amet</p>
                                <strong class="price">$58.99</strong>
                            </div>
                        </div>
                    </li>
                    <li class="last">
                        <a href="#"><img src="<c:url value="/resources/css/images/big1.jpg" />" alt=""/></a>

                        <div class="product-info">
                            <h3>LOREM IPSUM</h3>

                            <div class="product-desc">
                                <h4>WOMEN’S</h4>

                                <p>Lorem ipsum dolor sit<br/>amet</p>
                                <strong class="price">$58.99</strong>
                            </div>
                        </div>
                    </li>
                </ul>
                <div class="cl">&nbsp;</div>
            </div>
            <!-- End Products -->

        </div>
        <!-- End Content -->

        <!-- Sidebar -->
        <div id="sidebar">

            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <!-- Log-in -->
                <div class="box search">
                    <div class="box-content">
                        <h2>Get access<span></span></h2>
                        <c:if test="${param.error != null}">
                            <div class="error">
                                <p>Invalid username and password.</p>
                            </div>
                        </c:if>
                        <c:if test="${param.logout != null}">
                            <div class="msg">
                                <p>You have been logged out successfully.</p>
                            </div>
                        </c:if>
                        <form name='loginForm'
                              action="${loginUrl}" method='POST'>
                            <label>Username</label>
                            <input type='text' name='username' class="field">
                            <label>Password:</label>
                            <input type='password' name='password' class="field"/>
                            <input name="submit" type="submit"
                                   value="Log-in" class="search-submit"/>
                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                        </form>
                        <form name='regForm' action="#" method='POST'>
                            <input name="submit" type="submit" value="Register" class="register-submit"/>
                        </form>
                        <p class="more"><a href="#" class="bul">Forget the password</a></p>
                    </div>
                </div>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <div class="box login">
                    <div class="box-content">
                        <h2>Welcome ${pageContext.request.userPrincipal.name}<span></span></h2>
                        <form name='logoutForm'
                              action="<c:url value='/logout' />" method='POST'>
                            <input name="submit" type="submit"
                                   value="Log-out" class="search-submit"/>
                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                        </form>
                    </div>
                </div>
            </c:if>

            <!-- Search -->
            <div class="box search">
                <h2>Search by <span></span></h2>

                <div class="box-content">
                    <form action="" method="post">

                        <label>Keyword</label>
                        <input type="text" class="field"/>

                        <label>Category</label>
                        <select class="field">
                            <option value="">-- Select Category --</option>
                        </select>

                        <div class="inline-field">
                            <label>Price</label>
                            <select class="field small-field">
                                <option value="">$10</option>
                            </select>
                            <label>to:</label>
                            <select class="field small-field">
                                <option value="">$50</option>
                            </select>
                        </div>

                        <input type="submit" class="search-submit" value="Search"/>

                        <p>
                            <a href="#" class="bul">Advanced search</a><br/>
                            <a href="#" class="bul">Contact Customer Support</a>
                        </p>

                    </form>
                </div>
            </div>
            <!-- End Search -->

            <!-- Categories -->
            <div class="box categories">
                <h2>Categories <span></span></h2>

                <div class="box-content">
                    <ul>
                        <li><a href="#">Category 1</a></li>
                        <li><a href="#">Category 2</a></li>
                        <li><a href="#">Category 3</a></li>
                        <li><a href="#">Category 4</a></li>
                        <li><a href="#">Category 5</a></li>
                        <li><a href="#">Category 6</a></li>
                        <li><a href="#">Category 7</a></li>
                        <li><a href="#">Category 8</a></li>
                        <li><a href="#">Category 9</a></li>
                        <li><a href="#">Category 10</a></li>
                        <li><a href="#">Category 11</a></li>
                        <li><a href="#">Category 12</a></li>
                        <li class="last"><a href="#">Category 13</a></li>
                    </ul>
                </div>
            </div>
            <!-- End Categories -->

        </div>
        <!-- End Sidebar -->

        <div class="cl">&nbsp;</div>
    </div>
    <!-- End Main -->

    <!-- Side Full -->
    <div class="side-full">

        <!-- More Products -->
        <div class="more-products">
            <div class="more-products-holder">
                <ul>
                    <li><a href="#"><img src="<c:url value="/resources/css/images/small1.jpg" />" alt=""/></a></li>
                    <li><a href="#"><img src="<c:url value="/resources/css/images/small2.jpg" />"/>" alt="" /></a></li>
                    <li><a href="#"><img src="<c:url value="/resources/css/images/small3.jpg" />" alt=""/></a></li>
                    <li><a href="#"><img src="<c:url value="/resources/css/images/small4.jpg" />" alt=""/></a></li>
                    <li><a href="#"><img src="<c:url value="/resources/css/images/small5.jpg" />" alt=""/></a></li>
                    <li><a href="#"><img src="<c:url value="/resources/css/images/small6.jpg" />" alt=""/></a></li>
                    <li><a href="#"><img src="<c:url value="/resources/css/images/small7.jpg" />" alt=""/></a></li>
                    <li><a href="#"><img src="<c:url value="/resources/css/images/small1.jpg" />" alt=""/></a></li>
                    <li><a href="#"><img src="<c:url value="/resources/css/images/small2.jpg" />" alt=""/></a></li>
                    <li><a href="#"><img src="<c:url value="/resources/css/images/small3.jpg" />" alt=""/></a></li>
                    <li><a href="#"><img src="<c:url value="/resources/css/images/small4.jpg" />" alt=""/></a></li>
                    <li><a href="#"><img src="<c:url value="/resources/css/images/small5.jpg" />" alt=""/></a></li>
                    <li><a href="#"><img src="<c:url value="/resources/css/images/small6.jpg" />" alt=""/></a></li>
                    <li><a href="#"><img src="<c:url value="/resources/css/images/small7.jpg" />" alt=""/></a></li>
                    <li><a href="#"><img src="<c:url value="/resources/css/images/small1.jpg" />" alt=""/></a></li>
                    <li><a href="#"><img src="<c:url value="/resources/css/images/small2.jpg" />" alt=""/></a></li>
                    <li><a href="#"><img src="<c:url value="/resources/css/images/small3.jpg" />" alt=""/></a></li>
                    <li><a href="#"><img src="<c:url value="/resources/css/images/small4.jpg" />" alt=""/></a></li>
                    <li><a href="#"><img src="<c:url value="/resources/css/images/small5.jpg" />" alt=""/></a></li>
                    <li><a href="#"><img src="<c:url value="/resources/css/images/small6.jpg" />" alt=""/></a></li>
                    <li class="last"><a href="#"><img src="<c:url value="/resources/css/images/small7.jpg" />" alt=""/></a>
                    </li>
                </ul>
            </div>
            <div class="more-nav">
                <a href="#" class="prev">previous</a>
                <a href="#" class="next">next</a>
            </div>
        </div>
        <!-- End More Products -->

        <!-- Text Cols -->
        <div class="cols">
            <div class="cl">&nbsp;</div>
            <div class="col">
                <h3 class="ico ico1">Donec imperdiet</h3>

                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec imperdiet, metus ac cursus auctor,
                    arcu felis ornare dui.</p>

                <p class="more"><a href="#" class="bul">Lorem ipsum</a></p>
            </div>
            <div class="col">
                <h3 class="ico ico2">Donec imperdiet</h3>

                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec imperdiet, metus ac cursus auctor,
                    arcu felis ornare dui.</p>

                <p class="more"><a href="#" class="bul">Lorem ipsum</a></p>
            </div>
            <div class="col">
                <h3 class="ico ico3">Donec imperdiet</h3>

                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec imperdiet, metus ac cursus auctor,
                    arcu felis ornare dui.</p>

                <p class="more"><a href="#" class="bul">Lorem ipsum</a></p>
            </div>
            <div class="col col-last">
                <h3 class="ico ico4">Donec imperdiet</h3>

                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec imperdiet, metus ac cursus auctor,
                    arcu felis ornare dui.</p>

                <p class="more"><a href="#" class="bul">Lorem ipsum</a></p>
            </div>
            <div class="cl">&nbsp;</div>
        </div>
        <!-- End Text Cols -->

    </div>
    <!-- End Side Full -->

    <!-- Footer -->
    <div id="footer">
        <p class="left">
            <a href="#">Home</a>
            <span>|</span>
            <a href="#">Support</a>
            <span>|</span>
            <a href="#">My Account</a>
            <span>|</span>
            <a href="#">The Store</a>
            <span>|</span>
            <a href="#">Contact</a>
        </p>

        <p class="right">
            Copyright &copy; 2015 &nbsp; <a href="http://partners-pro.ru" target="_blank"><u>Partners-Pro.ru |
            Бесплатное изготовление сайтов</u></a>
        </p>
    </div>
    <!-- End Footer -->

</div>
<!-- End Shell -->
<div class="container">
    <table align="center" border="0" cellpadding="0" cellspacing="0" style="height:75px; width:560px">
        <tbody>
        <tr>
            <td style="height:75px; text-align:center; vertical-align:middle; width:560px">
                <p><a href="http://partners-pro.ru" target="_blank"><img
                        alt="Изготовление партнёрских интернет-магазинов и бесплатных сайтов"
                        src="http://partners-pro.ru/site-free/banner.gif" style="height:75px; width:560px"/></a></p>
            </td>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>