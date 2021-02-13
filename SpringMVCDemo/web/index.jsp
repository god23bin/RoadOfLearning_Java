<%--
  Created by IntelliJ IDEA.
  User: Bin
  Date: 2020/8/14
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
  <head>
    <title>第一次使用SpringMVC</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
    <style>
      .container-md{
        width: 600px;
      }
    </style>
  </head>
  <body>
    <div class="container container-md">
      <h1>测试SpringMVC</h1>
        <a href="toSuccess">试试使用SpringMVC</a>
      <h2>一、关于@RequestMapping的属性</h2>

        <h3>method属性：method = RequestMethod.POST</h3>

      <hr>
        <a href="toSuccess2">get请求（405，方法不允许）</a>
        <form action="toSuccess2" method="post">
          <button class="btn btn-danger" type="submit">post请求（可以访问）</button>
        </form>

        <h3>params属性：params = {"name = a","age = 23"}</h3>

      <hr>
        <form class="form-group" action="toSuccess3" method="post">
          <input class="form-control" type="text" name="name">
          <input class="form-control" type="text" name="age">
          <button class="btn btn-danger btn-block" type="submit">post请求（可以访问）</button>
        </form>

        <h3>关于路径</h3>

        <a href="A/abc/a">含*通配符，路径请求 </a>
        <br>
        <a href="A/abc/route">含?问号，路径请求 </a>

        <hr>
        <h4>使用@PathVariable</h4>
        <a href="toSuccess/zs">路径含有参数，请求</a>

      <h2>二、Rest风格</h2>
        <form class="form-group" action="testRest/23" method="post">
          <input class="form-control" type="hidden"  name="_method" value="DELETE">
          <button class="btn btn-warning btn-block" type="submit" value="删除">Rest-删除DELETE</button>
        </form>
        <form class="form-group" action="testRest/23" method="post">
          <input class="form-control" type="hidden"  name="_method" value="PUT">
          <button class="btn btn-success btn-block" type="submit" value="修改">Rest-修改PUT</button>
        </form>

      <h2>三、使用@RequestParam</h2>
        <form class="form-group" action="testRequestParam" method="post">
          <input class="form-control" type="text"  name="username">
          <button class="btn btn-success btn-block" type="submit">提交测试</button>
        </form>

      <h2>四、使用@RequestHeader</h2>
        <a href="testRequestHeader">获取请求头信息</a>

      <h2>五、使用@CookieValue</h2>
        <a href="testCookieValue">获取cookie信息</a>

      <h2>六、使用实体类接收数据</h2>
        <form class="form-group" action="testReceiveEntity" method="post">
          <input class="form-control" type="text"  name="name">
          <input class="form-control" type="text"  name="age">
          <button class="btn btn-warning btn-block" type="submit">提交测试</button>
        </form>
      <h2>七、返回数据给前端显示</h2>
      <h3>ModelAndView</h3>
      <form class="form-group" action="testModelAndView" method="post">
        <button class="btn btn-warning btn-block" type="submit">获取要显示的数据</button>
      </form>
      <h3>ModelMap</h3>
      <form class="form-group" action="testModelMap" method="post">
        <button class="btn btn-warning btn-block" type="submit">获取要显示的数据</button>
      </form>
      <h3>Map &lt String,Object &gt</h3>
      <form class="form-group" action="testMap" method="post">
        <button class="btn btn-warning btn-block" type="submit">获取要显示的数据</button>
      </form>
      <h3>Model</h3>
      <form class="form-group" action="testModel" method="post">
        <button class="btn btn-warning btn-block" type="submit">获取要显示的数据</button>
      </form>
      <h3>@ModelAttribute</h3>
      <form class="form-group" action="testModelAttribute" method="post">
        <input class="form-control" type="text" name="name">
        <button class="btn btn-warning btn-block" type="submit">修改名字</button>
      </form>
      <h2>八、其他功能</h2>
      <h3>无需写Controller</h3>
      <a href="noNeedController">无需写Controller</a>
      <h3>指定请求转发or重定向</h3>
      <a href="testForwardOrRedirect">测试</a>
      <h2>类型转换</h2>
      <form class="form-group" action="testConverter" method="post">
        <input class="form-control" type="text" name="studentInfo">
        <button class="btn btn-warning btn-block" type="submit">类型转换</button>
      </form>
      <h2>九、Ajax请求SpringMVC</h2>
      <form class="form-group" action="testAjax" method="post">
        <button id="aboutAjax" class="btn btn-warning btn-block" type="submit">Ajax请求</button>
      </form>
      <h2>十、文件上传</h2>
      <form class="form-group" action="testUpload" method="post" enctype="multipart/form-data">
        <input class="form-control" type="text" name="desc">
        <input class="form-control" type="file" name="file">
        <button class="btn btn-danger btn-block" type="submit">上传文件</button>
      </form>
      <h2>十一、拦截器</h2>
      <form class="form-group" action="testInterceptor" method="post">
        <button class="btn btn-danger btn-block" type="submit">测试拦截器</button>
      </form>
    </div>

    <script src="js/jquery-3.4.1.js"></script>
    <script>
      $(function () {
        $('#aboutAjax').click(function () {
          $.post(
                  "testAjax",//服务器地址，请求路径
                  //{"name":"LeBron","age":23},//可带参数，Json格式
                  function (data) {//回调函数，服务器处理后返回结果
                      //因为使用了@ResponseBody，所以返回给前端的是Json数据，就是数组，直接遍历出来
                    for(var i = 0; i < data.length; i++){
                        console.log(data[i].name+"-"+data[i].age);
                    }
                  }
          );
        });
      })
    </script>
  </body>
</html>
