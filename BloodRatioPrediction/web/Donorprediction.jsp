

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
                <div class="container">
                    <div class="header-inner">
                        <div class="row">
                            <div class="col-md-4 col-xs-12">
                                <h2>
                                   Blood Donor Prediction And Analysis
                                </h2>
                            </div>
                            <div class="col-md-8 col-xs-12">
                                <div class="header-block">

                                </div>
<!--                                <form class="hidden-md hidden-lg text-center" id="search-global-mobile" method="get">
                                    <input type="text" value="" id="search-mobile" name="s" >
                                    <button type="submit"><i class="icon fa fa-search"></i></button>
                                </form>-->
                            </div>
                        </div>
                    </div><!-- end header-inner-->
                </div><!-- end container-->

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
                                           <li><a href="indexx.html"  >Home </a> </li>
                     <li><a href="Donorprediction.jsp">Prediction</a> </li>
                    <li><a href="classification.jsp"  >Classification </a> </li>
                    <li><a href="TalukBasis.jsp"  >Comparison </a> </li>
                    
                      <li><a href="predict.jsp">Prediction2018</a></li>
                                        </ul>
                                        <form id="search-global-menu" class="hidden-xs hidden-sm" method="get">
                                            <input type="text" value="" id="search" name="s" >
                                            <button type="submit"><i class="icon-magnifier"></i></button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!--end top-nav -->
            </div><!-- HEADER END -->


            <div class="ui-title-page bg_title bg_transparent">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <h1>Blood Donor Analysis</h1>

                        </div>
                    </div>
                </div>
            </div><!-- end ui-title-page -->


            <div class="border_btm">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <ol class="breadcrumb">
                                <li><a href="javascript:void(0);"><i class="icon icon-home color_primary"></i></a></li>
                                <li class="active">Blood Donor Analysis</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div><!-- end breadcrumb -->


            <main class="main-content">
                <section class="section wow fadeInUp" data-wow-delay="1.5s">
                    <div class="container" >
                        <div class="row">
                            <div class="col-md-2 col-sm-4">
                                <select id="ctype" class="form-control" style="border: solid black 1px">
                                    <option value="Season1">Season1</option>
                                    <option value="Season2">Season2</option>
                                   
                                    
                                </select>
                            </div>
                           
                            <div class="col-md-5 col-sm-4" style="margin-top: 0.5%" ><button type="button" class="btn btn-primary btn-sm" onclick="getdata()">Submit</button></div>
                            <div class="col-md-12 col-sm-12">
                                <div id="container" style="height:500px;margin:1.5em 1em;"></div>
                                
                                
                            </div>
                            
                               <div class="col-md-12 col-sm-12">
                                <div id="containerone" style="height:500px;margin:1.5em 1em;"></div>
                                
                                
                            </div>
                            
                        </div>
                    </div>
                </section><!-- end section -->






            </main><!-- end main-content -->




            <footer class="footer">


                <div class="footer__bottom">
                    <span class="copyright">? Copyrights 2018 Blood Ratio Rate Analysis</span>

                </div>
            </footer>


        </div><!-- end layout-theme -->

        <span class="scroll-top bg-color_second"> <i class="fa fa-angle-up"> </i></span>
       

        <!-- SCRIPTS -->
        <script type="text/javascript" src="plugins/isotope/jquery.isotope.min.js"></script>
        <script src="js/waypoints.min.js"></script>
        <script src="plugins/bxslider/jquery.bxslider.min.js"></script>
        <script src="plugins/prettyphoto/js/jquery.prettyPhoto.js"></script>
        <script src="../../../cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
        <script src="plugins/datetimepicker/jquery.datetimepicker.js"></script>
        <script src="plugins/jelect/jquery.jelect.js"></script>
        <script src="plugins/nouislider/jquery.nouislider.all.min.js"></script>

        <!--THEME-->
        <script src="js/cssua.min.js"></script>
        <script src="js/wow.min.js"></script>
        <script src="js/custom.js"></script>

        <script>

                               
                                function getdata()
                                {
                                
                                    var ctype = $("#ctype").val();
                                    if (ctype == "-1")
                                    {
                                        alert("Please select ctype");
                                    }
                                    else
                                    {
                                        var cat = [];
                                       
                                            cat.push('2009');
                                            cat.push('2010');
                                            cat.push('2011');
                                            cat.push('2012');
                                            cat.push('2013');
                                            cat.push('2014');
                                            cat.push('2015');
                                            cat.push('2016');
                                            cat.push('2017');
                                            cat.push('2018');
                                            cat.push('2019');
                                        
                                        
                                        $.ajax({
                                            url: "getDonorsData",
                                            dataType: 'json',
                                            type: 'POST',
                                            data: {ctype: ctype},
                                            success: function(data) {
                                                var chart = new Highcharts.Chart({
                                                    chart: {
                                                        renderTo: 'container',
                                                        type: 'column'
                                                    },
                                                    title: {
                                                        text: ctype + ' based Blood Donor prediction'
                                                    },
                                                    credits: {enabled: false},
                                                    legend: {
                                                    },
                                                    plotOptions: {
                                                        series: {
                                                            shadow: false,
                                                            borderWidth: 0,
                                                        }
                                                    },
                                                    xAxis: {
                                                        lineColor: '#999',
                                                        lineWidth: 1,
                                                        tickColor: '#666',
                                                        tickLength: 3,
                                                        categories: cat,
                                                        title: {
                                                            text: 'Years'
                                                        }
                                                    },
                                                    yAxis: {
                                                        lineColor: '#999',
                                                        lineWidth: 1,
                                                        tickColor: '#666',
                                                        tickWidth: 1,
                                                        tickLength: 3,
                                                        gridLineColor: '#ddd',
                                                        title: {
                                                            text: 'Blood Donor',
                                                            rotation: 270,
                                                            margin: 50,
                                                        }
                                                    },
                                                    series: data
                                                });

                                            }
                                        });

                                    }
                                }
        </script>

    </body>

    <!-- Mirrored from templines.rocks/html/health/about-1.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 24 Jan 2018 05:07:05 GMT -->
</html>
