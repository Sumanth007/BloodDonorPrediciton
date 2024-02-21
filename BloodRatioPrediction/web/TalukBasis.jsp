
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
        <link href="css/index.css" rel="stylesheet">

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
                                              <li><a href="index.jsp">Home<i class="icon-home"></i></a> </li>
                    <li><a href="#">Importance</i></a> </li>                    
                     <li><a href="predict.jsp">Prediction</a> </li>
                   <li><a href="classification.jsp">Classification </a> </li>
                    <li><a href="TalukBasis.jsp">Comparison </a> </li>

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
                </div><!--end top-nav -->
            </div><!-- HEADER END -->


             <div id="banner">
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <h1 style="text-align: center; color: white; text-transform:uppercase">Blood Donor Prediction And Analysis</h1>
        </div>
      </div>
    </div>
  </div>


<!--            <div class="border_btm">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <ol class="breadcrumb">
                                <li><a href="javascript:void(0);"><i class="icon icon-home color_primary"></i></a></li>
                                <li class="active">Blood Donor Prediction And Analysis</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div> end breadcrumb -->


            <main class="main-content">
                <section class="section wow fadeInUp" data-wow-delay="1.5s">
                    <div class="container" >
                        <div class="row">
                            <div class="col-md-3 col-sm-4"></div>
                            <div class="col-md-2 col-sm-4">
                                <select id="ctype" onchange="getSubCategories()" class="form-control" style="border: solid black 1px">
                                    <option value="-1">Select Category</option>
                                    <option value="Gender">Gender</option>
                                    <option value="Occupation">occupation</option>
                                    <option value="Bloodgroup">Blood Group</option>
                                    <option value="Age">Age</option>
                                    
                                </select>
                            </div>
                            <div class="col-md-3 col-sm-4">
                                <select id="csubtype" class="form-control" style="border: solid black 1px">
                                    <option value="-1">---Select Sub-Category---</option>
                                </select>
                            </div>
                            <div class="col-md-2 col-sm-4">
                                <select id="year" class="form-control" style="border: solid black 1px">
                                    <option value="-1">---Select Year---</option>
                                    
                                    <option value="2012">2012</option>
                                    <option value="2013">2013</option>
                                    <option value="2014">2014</option>
                                    <option value="2015">2015</option>
                                    <option value="2016">2016</option>
                                    <option value="2017">2017</option>
                                    <option value="2018">2018</option>
                                     <option value="2019">2019</option>
                                    <option value="2020">2020</option>
                                    <option value="2021">2021</option>
                                </select>
                            </div>
                            <div class="col-md-1 col-sm-4" style="margin-top: 0.5%"><button type="button" class="btn btn-primary btn-sm" onclick="getdata()">Submit</button></div>
                            <div class="col-md-3 col-sm-4"></div>
                            <div class="col-md-12 col-sm-12">
                                <div id="container" style="height:600px;margin:1.5em 1em;"></div>
                            </div>
                        </div>
                    </div>
                </section><!-- end section -->






            </main><!-- end main-content -->




            <footer class="footer">


                <div class="footer__bottom">
                    

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

                                function getSubCategories()
                                {
                                    var ctype = $("#ctype").val();
                                    var opt = "";
                                   if (ctype == "Gender")
                                    {
                                        opt += "<option value='-1'>--Select Sub Category--</option>";
                                        opt += "<option value='Male'>Male</option>";
                                        opt += "<option value='Female'>Female</option>";
                                       
                                    }
                                    else if (ctype == "Occupation")
                                    {
                                        opt += "<option value='-1'>--Select Sub Category--</option>";
                                        opt += "<option value='Business'>Business</option>";
                                        opt += "<option value='Government'>Government</option>";
                                        opt += "<option value='Software'>Software</option>";
                                        opt += "<option value='Farmer'>Farmer</option>";
                                       
                                    }
                                    else if (ctype == "Bloodgroup")
                                    {
                                        opt += "<option value='-1'>--Select Sub Category--</option>";
                                        opt += "<option value='Opos'>O+</option>";
                                        opt += "<option value='Oneg'>O-</option>";
                                        opt += "<option value='Apos'>A +</option>";
                                        opt += "<option value='Aneg'>A-</option>";
                                        opt += "<option value='Bpos'>B+</option>";
                                        opt += "<option value='Bneg'>B-</option>";
                                        opt += "<option value='ABpos'>Ab+</option>";
                                        opt += "<option value='ABneg'>AB-</option>";
                                    }
                                    else if (ctype == "Age")
                                    {
                                        opt += "<option value='-1'>--Select Sub Category--</option>";
                                        opt += "<option value='Age18'>Age 18-20</option>";
                                        opt += "<option value='Age21'>Age 21-40</option>";
                                        opt += "<option value='Age41'>Age 41-60</option>";
                                        opt += "<option value='Age60'>Age 60 and above</option>";
                                        
                                    }

                                    $("#csubtype").empty();
                                    $("#csubtype").append(opt);

                                }

                                function getdata()
                                {
                                    var year = $("#year").val();
                                    var ctype = $("#ctype").val();
                                    var csubtype = $("#csubtype").val();
                                    if (csubtype == "-1")
                                    {
                                        alert("Please Select Category");
                                    }
                                    else
                                    {
                                        $.ajax({
                                            url: "StateBasis",
                                            dataType: 'json',
                                            type: 'POST',
                                            data: {year: year, ctype: ctype, csubtype: csubtype},
                                            success: function(data) {
                                                var chart = new Highcharts.Chart({
                                                    chart: {
                                                        renderTo: 'container',
                                                        type: 'pie'
                                                    },
                                                    title: {
                                                        text: ''
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
                                                        categories: data.aray2,
                                                        title: {
                                                            text: 'Taluk'
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
                                                            text: 'Donors',
                                                            rotation: 270,
                                                            margin: 50,
                                                        }
                                                    },
                                                    series: data.aray1
                                                });

                                            }
                                        });

                                    }
                                }
        </script>

    </body>

    <!-- Mirrored from templines.rocks/html/health/about-1.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 24 Jan 2018 05:07:05 GMT -->
</html>

