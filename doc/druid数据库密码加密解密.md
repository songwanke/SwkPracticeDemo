### 集成Druid---数据库密码加密解密  

[参考druid官网](https://github.com/alibaba/druid/wiki/%E5%A6%82%E4%BD%95%E5%9C%A8Spring-Boot%E4%B8%AD%E9%85%8D%E7%BD%AE%E6%95%B0%E6%8D%AE%E5%BA%93%E5%AF%86%E7%A0%81%E5%8A%A0%E5%AF%86%EF%BC%9F)  
 
使用jar包版本：druid-1.0.29.jar  

**明文密码+私钥(privateKey)加密=加密密码**

**加密密码+公钥(publicKey)解密=明文密码**

###### 1. 加密，用以下命令将密码加密
cmd命令行执行:

```  
java -cp D:/druid-1.0.29.jar com.alibaba.druid.filter.config.ConfigTools 密码
```





 


