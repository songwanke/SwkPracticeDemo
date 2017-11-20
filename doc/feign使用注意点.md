#### SpringMVC的请求参数绑定机制  
预设一个RestController，在本地的8080端口启动一个应用，用于接收http请求。  
````
@RestController
public class BookController {
    @RequestMapping(value = "/hello") // <1>
    public String hello(String name) { // <2>
        return "hello " + name;
    }
}
````  
这个接口写起来非常简单，但实际springmvc做了非常多的兼容，使得这个接口可以接受多种请求方式。  
> * <1>RequestMapping代表映射的路径，使用GET,POST,PUT,DELETE方式都可以映射到该端点。
> * <2>SpringMVC中常用的请求参数注解有（@RequestParam,@RequestBody,@PathVariable）等。name被默认当做@RequestParam。
形参String name由框架使用字节码技术获取name这个名称，自动检测请求参数中key值为name的参数，也可以使用@RequestParam(“name”)覆盖变量本身的名称。
当我们在url中携带name参数或者form表单中携带name参数时，会被获取到。  
````
POST /hello HTTP/1.1
Host: localhost:8080
Content-Type: application/x-www-form-urlencoded
name=formParam
````  
或
````
GET /hello?name=queryString HTTP/1.1
Host: localhost:8080
````  
#### Feign的请求参数绑定机制  
我们来看一个非常简单的，但是实际上错误的接口写法：
````
//注意：错误的接口写法
@FeignClient("book")
public interface BookApi {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello(String name);
}
````  
配置请求地址：
````
ribbon:
  eureka:
   enabled: false
book:
  ribbon:
    listOfServers: http://localhost:8080
````  
我们按照写SpringMVC的RestController的习惯写了一个FeignClient,按照我们一开始的想法，由于置顶了请求方式是GET,那么name应该会作为QueryString拼接到URL中吧？发出一个这样的GET请求：
````
GET /hello?name=xxx HTTP/1.1
Host: localhost:8080
````  
而实际上，RestController并没有接收到，我们在RestController一侧的应用中获得了一些提示：
![](http://mmbiz.qpic.cn/mmbiz_png/eZzl4LXykQwY1cPcMc5Qwj94PuQNicDhq5TgmJZhGsp2QJnxtCQeA0XaUot2A8DibdvhNdgsmiclQO1CPDcsK9DEw/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1)  
> * 并没有按照期望使用GET方式发送请求，而是POST方式  
> * name参数没有被封装，获得了一个null值  

查看文档发现，如果不加默认的注释，Feign则会对参数默认加上@RequestBody注解，而RequestBody一定是包含在请求体中的，GET方式无法包含，
所以上述两个现象得到了解释。Feign在GET请求包含RequestBody时强制转成了POST请求，而不是报错。

理解清楚了这个机制我们可以在开发Feign接口避免很多坑，而解决上述这个问题也很简单  
> * 在Feign接口中为name添加@RequestParam(“name”)注解，name必须指定，Feign的请求参数不会利用SpringMVC字节码的机制自动给定一个默认的名称。
> * 由于Feign默认使用@RequestBody，也可以改造RestController，使用@RequestBody接收。但是，请求参数通常是多个，推荐使用上述的@RequestParam，而@RequestBody一般只用于传递对象。  
#### Feign绑定复合参数  
指定请求参数的类型与请求方式，上述问题的出现实际上是由于在没有理清楚Feign内部机制的前提下想当然的和SpringMVC进行了类比。同样，在使用对象作为参数时，也需要注意这样的问题。  
对于这样的接口
````
@FeignClient("book")
public interface BookApi {
    @RequestMapping(value = "/book",method = RequestMethod.POST)
    Book book(@RequestBody Book book); // <1>
   
    @RequestMapping(value = "/book",method = RequestMethod.POST)
    Book book(@RequestParam("id") String id,@RequestParam("name") String name); // <2>
   
    @RequestMapping(value = "/book",method = RequestMethod.POST)
    Book book(@RequestParam Map map); // <3>
   
    //错误的写法
    @RequestMapping(value = "/book",method = RequestMethod.POST)
    Book book(@RequestParam Book book); // <4>
}
````  
> * 使用@RequestBody传递对象是最常用的方式。  
> * 如果参数并不是很多，可以平铺开使用@RequestParam  
> * 使用Map，这也是完全可以的，但不太符合面向对象的思想，不能从代码立刻看出该接口需要什么样的参数。  
> * 错误的用法，Feign没有提供这样的机制自动转换实体为Map。  
