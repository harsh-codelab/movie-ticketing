<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Movie Ticketing</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <style>
        .row-header {
            margin: 0px auto;
            padding: 0px;
        }

        .row-content {
            margin: 0px auto;
            padding: 50px 0px 50px 0px;
            border-bottom: 1px ridge;
            min-height: 400px;
        }

        .jumbotron {
            padding: 70px 30px 70px 30px;
            margin: 0px auto;
            background: #9510d3;
            color: floralwhite;
        }

        address {
            font-size: 80%;
            margin: 0px;
            color: #0f0f0f;
        }

        .navbar-dark {
            background: #230270;
        }

        .tab-content {
            border-left: 1px solid #ddd;
            border-right: 1px solid #ddd;
            border-bottom: 1px solid #ddd;
            padding: 10px;
        }

        div {
            overflow: auto;
        }

        .tooltip {
            pointer-events: none;
        }
    </style>
    <script>
        $(document).ready(function () {
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'right'
            });
        });
    </script>
</head>

<body>
    <div class="jumbotron">
        <div class="container">
            <div class="col-12 col-sm-8">
                <h2 style="font-family: Sans-serif">Book Your Favourite Show !!</h2>
                <p>You can view and book your favourite show using the below tabs.</p>
            </div>
        </div>
    </div>
    <div class="row container row-content" style="border-bottom: none">
        <div class="col-12">
            <h2>Ready To Plan ?</h2>
            <br>
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-link active" href="#availaibleShows" role="tab"
                        data-toggle="tab">Availaible Shows</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#upcomingShows" role="tab"
                        data-toggle="tab">Upcoming Shows</a>
                </li>

            </ul>
            <div class="tab-content">

                <div role="tabpanel" class="tab-pane fade show active" id="availaibleShows">
                    <p style="font-size: x-large">Availaible Shows List</p>
                </div>

                <div role="tabpanel" class="tab-pane fade show" id="upcomingShows">
                    <p style="font-size: x-large">Upcoming Shows List</p>
                </div>

            </div>
        </div>
    </div>

    <br><br>
</body>

</html>