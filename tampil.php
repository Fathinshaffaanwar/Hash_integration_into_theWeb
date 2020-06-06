<!DOCTYPE html>
<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Daftar Editor</title>
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

        <div class="container"style= "margin-top: 60px;">
            <div class="row">
                <div class="col">
                    <div class="result d-flex justify-content-center mt-4"></div>
                </div>
            </div>
        </div>

        <script src="assets\bootstrap\js\jquery.min.js">
        </script>
        <script src="assets\bootstrap\js\bootstrap.min.js">
        </script>
                <script>

                let loading = '<img class="text-center" alt="loading......" class="ml-auto" src="assets\\img\\loading.gif" width="30%">'
                $(".result").html(loading);
                loadData();

        function loadData(){
            $.get('core/get.php?q=show', function(data){
                $(".result").html(data);
            });
        }
        </script>
    </body>
</html>
