pom作为项目对象模型。通过xml表示maven项目，使用pom.xml来实现。
主要描述了项目：包括配置文件；开发者需要遵循的规则，缺陷管理系统，组织和licenses，项目的url，项目的依赖性，以及其他所有的项目相关因素。  

**POM** 包括了所有的项目信息。  
**groupId:** 项目或者组织的唯一标志，并且配置时生成路径也是由此生成，如org.myproject.mojo生成的相对路径为：/org/myproject/mojo。  
**artifactId:** 项目的通用名称。  
**version:** 项目的版本。  
**packaging:** 打包机制，如pom,jar,maven-plugin,ejb,war,ear,rar,par。  
**name:** 用户描述项目的名称，无关紧要的东西，可选。  
**url:** 应该是只是写明开发团队的网站，无关紧要，可选。  
**classifer:** 分类  
其中**groupId,artifactId,version,** packaging这四项组成了项目的唯一坐标。一般情况下，前面三项就可以组成项目的唯一坐标了。

--

**groupId, artifactId, version这三个组合标示依赖的具体工程，而且 这个依赖工程必需是maven中心包管理范围内的，如果碰上非开源包，maven支持不了这个包，那么则有有三种 方法处理：**  

##### 1. 本地安装这个插件install plugin
例如：mvn install:intall-file -Dfile=non-maven-proj.jar -DgroupId=som.group -DartifactId=non-maven-proj -Dversion=1

##### 2. 创建自己的repositories并且部署这个包，使用类似上面的deploy:deploy-file命令，
##### 3. 设置scope为system,并且指定系统路径。

--

**dependency里属性介绍：**  
**type：** 默认为jar类型，常用的类型有：jar,ejb-client,test-jar...,可设置plugins中的extensions值为true后在增加 新的类型。  
**scope：** 是用来指定当前包的依赖范围，maven的依赖范围。  
**optional:** 设置指依赖是否可选，默认为false,即子项目默认都继承，为true,则子项目必需显示的引入，与dependencyManagement里定义的依赖类似。    
**exclusions：** 如果X需要A,A包含B依赖，那么X可以声明不要B依赖，只要在exclusions中声明exclusion。  
**exclusion:** 是将B从依赖树中删除。  
**properties:** 是为pom定义一些常量，在pom中的其它地方可以直接引用。  

--

####build设置:
**defaultGoal:** 默认的目标，必须跟命令行上的参数相同，如：jar:jar,或者与时期parse相同,例如install。  
**directory:** 指定build target目标的目录，默认为$(basedir}/target,即项目根目录下的target。  
**finalName:** 指定去掉后缀的工程名字，例如：默认为${artifactId}-${version}。  
**filters:** 用于定义指定filter属性的位置，例如filter元素赋值filters/filter1.properties,那么这个文件里面就可以定义name=value对，这个name=value对的值就可以在工程pom中通过${name}引用，默认的filter目录是${basedir}/src/main/fiters/。  
**targetPath:** 指定build资源到哪个目录，默认是base directory。  
**filtering:** 指定是否将filter文件(即上面说的filters里定义的*.property文件)的变量值在这个resource文件有效。  
**directory:** 指定属性文件的目录，build的过程需要找到它，并且将其放到targetPath下，默认的directory是${basedir}/src/main/resources。  
**includes:** 指定包含文件的patterns,符合样式并且在directory目录下的文件将会包含进project的资源文件。  
**excludes:** 指定不包含在内的patterns,如果inclues与excludes有冲突，那么excludes胜利，那些符合冲突的样式的文件是不会包含进来的。  
**testResources:** 这个模块包含测试资源元素，其内容定义与resources类似，不同的一点是默认的测试资源路径是${basedir}/src/test/resources,测试资源是不部署的。  

**plugin配置：** 
```
       <plugin> 
        <groupId>org.apache.maven.plugins</groupId> 
        <artifactId>maven-jar-plugin</artifactId> 
        <version>2.0</version> 
        <extensions>false</extensions> 
        <inherited>true</inherited> 
        <configuration> 
          <classifier>test</classifier> 
        </configuration> 
        <dependencies>...</dependencies> 
        <executions>...</executions> 
     </plugin>
```

**extensions:** true or false, 决定是否要load这个plugin的extensions，默认为true。  
**inherited:** 是否让子pom继承，ture or false 默认为true。  
**configuration:** 通常用于私有不开源的plugin,不能够详细了解plugin的内部工作原理，但使plugin满足的properties。  
**dependencies:** 与pom基础的dependencies的结构和功能都相同，只是plugin的dependencies用于plugin,而pom的denpendencies用于项目本身。在plugin的dependencies主要用于改变plugin原来的dependencies，例如排除一些用不到的dependency或者修改dependency的版本等。  
**executions:** plugin也有很多个目标，每个目标具有不同的配置，executions就是设定plugin的目标。  

```
           <execution> 
            <id>echodir</id> 
            <goals> 
              <goal>run</goal> 
            </goals> 
            <phase>verify</phase> 
            <inherited>false</inherited> 
            <configuration> 
              <tasks> 
                <echo>Build Dir: ${project.build.directory}</echo> 
              </tasks> 
            </configuration> 
           </execution> 
```  
**id:** 标识符  
**goals:** 里面列出一系列的goals元素，例如上面的run goal。  
**phase:** 声明goals执行的时期，例如：verify。  
**inherited:** 是否传递execution到子pom里。  
**configuration:** 设置execution下列表的goals的设置，而不是plugin所有的goals的设置。  

参考：http://www.cnblogs.com/zhangjianbin/p/7169232.html