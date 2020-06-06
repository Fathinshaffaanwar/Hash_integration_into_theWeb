<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Cari Editor Editor</title>
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="index.php">Data Editor</a><button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">Menu<i class="fas fa-bars ml-1"></i></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ml-auto">
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="cari.php">Cari Editor</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="tampil.php">Editor</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="about.php">About Me</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- End Navbar -->
        <div class="container" style= "margin-top: 60px;">
            <div class="row justify-content-center">
                <div class="col">
                    <div class="input-group mb-3 mt-5 w-50 mx-auto">
                        <input aria-describedby="button-addon2" aria-label="Recipient's username" class="form-control input" placeholder="Nama Editor" type="text">
                            <div class="input-group-append">
                                <a class="btn btn-warning search text-white" id="button-addon2" type="button">
                                    <i class="fas fa-search">cari
                                    </i>
                                </a>
                            </div>
                        </input>
                    </div>
                    <hr class="my-4">
                    </hr>
                    <div class="result text-center">
                    </div>
                </div>
            </div>
        </div>
        <script src="assets\bootstrap\js\jquery.min.js">
        </script>
        <script src="assets\bootstrap\js\bootstrap.min.js">
        </script>
        <script>
            $(".search").click(function(){
                let loading = '<img alt="loading......" class="ml-auto" src="assets\\img\\loading.gif" width="30%">'
                $(".result").html(loading);
            loadData();
        });

        function loadData(){
            $.get('core/get.php?q="'+$(".input").val()+'"', function(data){
                $(".result").html(data);
            });
        }
        </script>
    </body>
</html>
