### spring boot 热部署

Spring-Loaded项目提供了强大的热部署功能，添加/删除/修改 方法/字段/接口/枚举 等代码的时候都可以热部署，速度很快，很方便  

在spring-boot-maven-plugin插件下面添加依赖:

```
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>springloaded</artifactId>
        <version>1.2.5.RELEASE</version>
    </dependency>
</dependencies>
```

**注意:** 使用热部署的时候，需要IDE编译类后才能生效，你可以打开**自动编译**功能，这样在你保存修改的时候，类就自动重新加载了。

### idea自动编译：

> * 开启自动测试: File->setting->compiler 复选框全部勾选。
> * 修改run/debug配置:Run->Edit Configurations->Application->Before Launch 下面的make去掉。
> * 重启:File->Invalidate Caches /Restart

**注意：** 以上将make去掉后，run的时候会报classNotFoundException,需要手动编译一次，可以将make改为make, no error check，为了不用每次run一个Class都需要做修改，可以在Defaults里面修改。




