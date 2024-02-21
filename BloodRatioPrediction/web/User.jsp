

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.database.util.DBsingletone"%>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from templines.rocks/html/health/about-1.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 24 Jan 2018 05:06:47 GMT -->
    <!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Blood Donor Analysis</title>
        <link rel="shortcut icon" type="image/x-icon" href="favicon.png" />
        <link href="css/master.css" rel="stylesheet">
        <link href="css/bloodbank.css" rel="stylesheet">
        <link rel="stylesheet" href="plugins/iview/css/iview.css" type='text/css' media='all' />
        <link rel="stylesheet" href="plugins/iview/css/skin/style.css" type='text/css' media='all' />
        
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <script src= "js/jquery-migrate-1.2.1.js" ></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/bootstrap-3.1.1.min.js"></script>
        <script src="js/modernizr.custom.js"></script>
        <script src="js/highcharts.js" type="text/javascript"></script>
        <script src="js/highcharts-more.js" type="text/javascript"></script>
        <script src="js/exporting.js" type="text/javascript"></script>
    </head>

    <body>
        <div class="layout-theme animated-css"  data-header="sticky" data-header-top="200"  >

            <div class="header">
                

                <div class="top-nav ">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12  col-xs-12">
                                <div class="navbar yamm " >
                                    <div class="navbar-header hidden-md  hidden-lg  hidden-sm ">
                                        <button type="button" data-toggle="collapse" data-target="#navbar-collapse-1" class="navbar-toggle"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                                        <a href="#" class="navbar-brand">Menu</a> </div>
                                    <div id="navbar-collapse-1" class="navbar-collapse collapse">
                                        <ul class="nav navbar-nav">
                                            <li><a href="">User</a></li>
                                            <li><a href="login.jsp" style="color: red; font-weight: 800; margin-left: 900px">LogOut<i class="icon-logout"></i></a> </li>

                 
                                        </ul>
<!--                                        <form id="search-global-menu" class="hidden-xs hidden-sm" method="get">
                                            <input type="text" value="" id="search" name="s" >
                                            <button type="submit"><i class="icon-magnifier"></i></button>
                                        </form>-->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>



    <div id="banner">
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <h1 style="text-align: center; color: white; text-transform:uppercase">Blood Bank</h1>
        </div>
      </div>
    </div>
  </div>

        
            
        <!-- SCRIPTS -->
        <script type="text/javascript" src="plugins/isotope/jquery.isotope.min.js"></script>
        <script src="js/waypoints.min.js"></script>
        <script src="plugins/bxslider/jquery.bxslider.min.js"></script>
        <script src="plugins/prettyphoto/js/jquery.prettyPhoto.js"></script>
        <script src="../../../cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
        <script src="plugins/datetimepicker/jquery.datetimepicker.js"></script>
        <script src="plugins/jelect/jquery.jelect.js"></script>
        <script src="plugins/nouislider/jquery.nouislider.all.min.js"></script>
        <script src="js/cssua.min.js"></script>
        <script src="js/wow.min.js"></script>
        <script src="js/custom.js"></script>



    </body>

    <!-- Mirrored from templines.rocks/html/health/about-1.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 24 Jan 2018 05:07:05 GMT -->
</html>
