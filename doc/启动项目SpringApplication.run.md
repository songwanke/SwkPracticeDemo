### 启动项目SpringApplication.run 
启动Spring Boot项目最简单的方法就是执行下面的方法：
```
SpringApplication.run(PracticeApplication.class, args);
```
该方法返回一个ApplicationContext对象，使用注解的时候返回的具体类型是AnnotationConfigApplicationContext或AnnotationConfigEmbeddedWebApplicationContext，当支持web的时候是第二个。

除了上面这种方法外，还可以用下面的方法：
```
SpringApplication application = new SpringApplication(Application.class);
application.run(args);  
```
SpringApplication包含了一些其他可以配置的方法，如果你想做一些配置，可以用这种方式。

除了上面这种直接的方法外，还可以使用SpringApplicationBuilder：
```
new SpringApplicationBuilder()
        .showBanner(false)
        .sources(Application.class)
        .run(args);
```
当使用SpringMVC的时候由于需要使用子容器，就需要用到SpringApplicationBuilder，该类有一个child(xxx...)方法可以添加子容器。