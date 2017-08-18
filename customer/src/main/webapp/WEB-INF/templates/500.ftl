<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>出错啦...</title>
    <link rel="stylesheet" href="/dist/common/base.css" />
    <script type="text/javascript" src="/dist/depend/requirejs/require.js"></script>
    <script type="text/javascript" src="/dist/depend/jquery.min.js"></script>
    <script type="text/javascript" src="/dist/depend/c.js"></script>
    <style>
        html{
            background-color:#fff;
        }
        .errbox{
            width: 325px;
            margin: 0 auto;
            display: block;
        }
        .errbox img{
            width:100px;
            margin:0 auto;
            display: block;
        }
        .errlb{
            width:100%;
            text-align: center;
            margin-top:20px
        }
        .errlb label{
            height: 93px;
            font-size: 16px;
        }
        .footer{
            position: absolute;
            width: 100%;
            bottom: 0;
            left: 0;
        }
    </style>
    <script>
        require.config({
            urlArgs: urlArgs,
            baseUrl: baseUrl,
            paths: {
                'template': 'depend/template.js/template',
                'css': 'depend/requirejs/css',
                'text': 'depend/requirejs/text',
                'proxy': 'proxy/proxy',
                'layer': 'modul/layer/layer',
                'scrollbar': 'modul/scrollBar/jquery.mCustomScrollbar.concat.min',
                'lazyload': 'modul/lazyload/jquery.lazyload.min'
            }
        });

        requirejs(['error/error']);
    </script>
</head>

<body>
<div id="lheader"></div>
<div class="w site-content" id="main">
    <div class="errbox">
        <div class="errlb">
            <label>"500"</label>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer"></div>
</body>

</html>