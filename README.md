# sass财务系统

本质的意义就是从新建文件夹开始创建一个Java项目。这样做的好处就是，可以专心分析需求。关于相对应的功能可以更好的复制粘贴。哈哈，开个玩笑。

只是说学过这么多。苍穹外卖就是写crud。他们给好了框架，只需要处理相关的数据库交互就完了。

通过苍穹外卖掌握了什么，熟悉idea，项目的部署，API接口的书写。通过编写接口，然后创建与数据库的交互。书写接口的响应，这个响应需要与数据库交互获取到信息，或者往数据库增加信息。

还有接口的调试。

后续根据补充springcloud的技术，用于微服务。

当然后续学springcloud属于是走错了，技术不关键，关键的在于如何从零开始。就是后续继续走偏了，

后续又查看微信小程序，node.js，Python这些从头看了一遍。但还是没有解决最后的问题。如何从零开始。

当然也不算走错，本来就是想背八股然后进公司之后在学，到时候又不是一个人处理。可惜。没得，投了简历等于石沉大海。

不能放弃自己的学习，然后就有了这个项目，从零开始。

那么开始吧。

## 前言

需要准备的有以下

* JavaIDE，1.8还有21版本
* idea，这里选择24.1版本，关于免费使用会有一个专门文档
* maven，当然idea里面绑定的有，3.9.6版本
* redis desktop用于查看redis数据内容
* navicat用于访问MySQL数据库
* github账号，用于存储代码
* 虚拟机，里面安装ubuntu系统，用于模拟服务器。
* docker，用于安装服务器上的生产环境软件，或者开发环境的软件
* MySQL，5.7或者8.0
* redis

后续还有XXL-job的使用，不过这些我也是现场学

## 创建项目

本章节是服务于项目立项，需求分析，创建能启动的框架。

### 创建仓库

首先是创建一个github仓库

![image-20240907021957873](https://cdn.jsdelivr.net/gh/Mirror18/imgage@main//202409070219998.png)

这里是初始化的仓库。根据选择就创建了。这里需要补充的是`.gitignore`文件的编写，原因是初始规则不够使用。

```.gitignore
HELP.md
target/
!.mvn/wrapper/maven-wrapper.jar
!**/src/main/**
!**/src/test/**

### STS ###
.apt_generated
.classpath
.factorypath
.project
.settings
.springBeans
.sts4-cache

### IntelliJ IDEA ###
.idea
*.iws
*.iml
*.ipr

### NetBeans ###
/nbproject/private/
/nbbuild/
/dist/
/nbdist/
/.nb-gradle/
build/

### VS Code ###
.vscode/


application-local.properties
logback-local.xml

*.log*
```

至于书写规则，简单讲下就是上面写的全部都不参与版本管理。`!`开头的除外。*是贪心匹配。反斜杠是目录。当然这里是简单的，主要这玩意儿跟正则表达式一个样，需要的时候瞅两眼就会写了。

然后就是license。这个证书随意，弯弯绕绕的其实还不少。但我相信现在看的，是看不懂这玩意儿的区别。



### 项目分析

分三步走吧，why ,how,what。

why

因为我需要一个从零开始的项目。开玩笑，因为需要一个财务管理系统。

how

分为前端和后端。前端负责页面，通过框架建立多个网页。一些数据需要从后端数据库中获得。否则就是一个静态网页。

后端就是处理前端发过来的API请求。或者说自己暴露出去的API接口。这玩意儿看是从前端开始还是后端开始了。

what

需要服务器，电脑。

好像上面有点太宽泛了。

![image-20240907023804943](https://cdn.jsdelivr.net/gh/Mirror18/imgage@main//202409070238980.png)

那就换成完成上述功能。

### 创建数据库

先创建好表再说。

数据库创建在`database`文件夹中。里面有解释文档。

### 创建模块

模块是因为所有代码写在一个文件夹中太乱。于是提取出父模块和子模块。

~~我也不知道为什么，他那代码不处理我是真跑不了。~~

首先看看都有什么模块

| 模块名            | 功能                                                       |
| ----------------- | ---------------------------------------------------------- |
| parent            | 父模块，管理依赖包，编译打包配置，远程仓库镜像配置等       |
| common            | 子模块，通用类库，工具类，统一异常处理，接口返回统一格式等 |
| mybatis           | 子模块，代码生成插件，通用orm操作类                        |
| wx                | 子模块，微信模块，微信相关常用操作类                       |
| finance-biz       | 子模块，系统业务操作模块                                   |
| finance-admin-api | 子模块，api接口服务，供前端调用                            |

详细的模块创建我放到各个模块中。

那就剩一点要吐槽的了。只有一个父子关系，为什么要单独创建一个父模块，把parent的`pom.xml`文件放到project的`pom.xml`不就可以了么，后续创建子模块的时候文件位置也能放对。

其实感觉像是个人习惯。单独把parent模块独立出来，引用关系更加清晰。除了新创建子模块的时候麻烦点。为什么会有这想法，纯属就是idea创建的时候的想法。因为是真麻烦。

吐槽完毕。那么就来总结什么模块是必须的。

首先是parent，这个 模块提供依赖关系。

然后是common，提供公共类，主要是一些常量，还有全局异常的处理，还有一些自己的工具包，例如转换时间成自己的格式。

这俩模块是必须的。

还有几个我们必须要实现的任务。

​	一个是提供数据库的操作，也就是提供一大堆map接口的地方。封装数据库的操作

​	另一个是封装bean的模块。就是提供数据库对应bean，或者叫entity。提供给前端的，vo。数据库提供给poject的，用于层间传递的dto。

​	一个提供方法的。有数据库操作，有实体。足够我们编写方法了。

​	最后一个是我们编写的control，用于提供接口的东西。

这四个任务交给了，mybatis模块，finance-biz模块，finance-admin-api模块这三个模块。

还剩下一个wx模块，这个就是功能模块，需要这个模块提供附属服务，去掉不影响主体功能的模块。



通过以上的内容

![image-20240907044934989](https://cdn.jsdelivr.net/gh/Mirror18/imgage@main//202409070449099.png)

这是创建好的内容，里面都只写了pom文件。

当然这些之后了

### 配置启动项

启动项说法不是很准确。这是一个application，没有牵扯到微服务。所以也无伤大雅了。

那现在要做的，就是创建一个springboot的应用了。这里就先编写admin-api模块。

![image-20240907050802068](https://cdn.jsdelivr.net/gh/Mirror18/imgage@main//202409070508165.png)

那么需要编写什么。先把这五个文件创建好。

![image-20240907050851398](https://cdn.jsdelivr.net/gh/Mirror18/imgage@main//202409070508449.png)

这里写好配置文件即可运行最简单的应用。

那么有效配置文件为什么要设置local，从哪里设置的，其实就是第二个文件，`application-local.yml`文件，本来是`application.yml`文件就足够了，但是为了一些私有信息不上传，还有就是根据环境设置不同的信息，所以就出现了这个。叫profile也行。

这个local是根据后缀来的。

---

以上就完成了一个最简单的项目骨架，也就是创建完了，但是距离我们编写项目文件还差点，为什么这么说。因为我们只是启动了一个程序，但是一些工具还没装配好。

那怎么处理呢，我想在这里插入一个篇外，因为我是要记录我怎么从零开始的，完整的项目文档别人那里有。所以我严格按照顺序来书写。

### 编写common模块

现在要做的是，先书写统一格式，用于后续模块开发时候，可以只需要编写对应功能即可。

![image-20240907171306171](https://cdn.jsdelivr.net/gh/Mirror18/imgage@main//202409071713254.png)

就是先编写这些，那干了什么，就是补充了几个配置json,swagger的配置，注册进springboot中。还有两个关于security的环境配置注入。因为这些都是第三方包，需要注册到spring中，所以需要配置类

![image-20240907182056180](https://cdn.jsdelivr.net/gh/Mirror18/imgage@main//202409071820218.png)

定义了两个常量，也就是枚举类。

![image-20240907182129321](https://cdn.jsdelivr.net/gh/Mirror18/imgage@main//202409071821353.png)

定义了四个dto也就是层间传递格式。

![image-20240907182148410](https://cdn.jsdelivr.net/gh/Mirror18/imgage@main//202409071821443.png)

定义了五个全局异常，用于抛出的异常的格式化。

![image-20240907182206825](https://cdn.jsdelivr.net/gh/Mirror18/imgage@main//202409071822851.png)

然后定义了两个工具包，属于工具类。常见的时间格式。然后生成随机数字什么的。

![image-20240907182218538](https://cdn.jsdelivr.net/gh/Mirror18/imgage@main//202409071822564.png)



最后想了想，还是把两个服务类给装配上，因为需要给应用加上拦截。还有就是生成token的服务。

![image-20240907182627772](https://cdn.jsdelivr.net/gh/Mirror18/imgage@main//202409071826796.png)



或许看出来这还少很多的东西，配置没有全面，还有一些服务没有提供。但这些都可以随着后面编写

### 编写mybatis模块

或者说也不叫mybatis的generator的编写。然后就有个疑问，为什么不用mybatis-plus呢。我觉得其他的再怎么不咋地，也比这种写的强啊。

具体也不好说啥，因为这玩意儿也就是需要的时候看两眼。毕竟东西太多。

![image-20240907183629529](https://cdn.jsdelivr.net/gh/Mirror18/imgage@main//202409071836564.png)

最后是这样的。

---

以上做完之后就可以开发各种模块了。开发流程就是创建controllor，service，mapper。还有dto.对应的就是对外提供web接口。提供方法给web接口。提供操作操作数据库的方法给service。数据结构dto则就是model。



当然不是这么简单的，因为后续还需要提供一些其他服务，例如微信登陆，用啥乱七八糟的软件之类的，或者添加验证的。

不过这种就跟配置框架一样。东西都搭建好了，剩下的就是缝缝补补了。当然要是想搞微服务，也不是不行，其实这个整体的框架，看样子就是为微服务提供的，可以无缝转。不需要修改什么乱七八糟的东西。。

至于说微服务，别听什么高大上的，真要类比起来就是dto嘛，层间传递的数据通过web来进行传递，这样做的好处就是各种服务分开。哪个模块掉线了也很容易排查，但是对于中微企业来说，真搞这框架，服务器响应还会降级。还有什么乱七八糟的主从表，本质上就是服务划分。emmmm。

其实我到这一步应该算是完事了，因为需要研究从零开始已经到了很多人都熟悉的环境了。 就是后续还有mq什么乱七八糟的。所以也就继续吧。但不会像现在这么细致了。而且我也想看看是怎么调用手机号这些三方登陆。



### 补充

我做了改动主要是先进行升级jdk版本变成了21.升级springBoot为3.1版本。

这里面有不少的弯弯绕绕，因为lombok版本问题，还有swagger也要卸载，具体流程是一样的，然后因为报错的问题，又删掉了json的配置，我也不知道这为啥说注入两个包，包管理还有清理缓存都不起作用，

当然到这添加功能的时候，切记一定要先进行运行，确保运行无障碍。后续的模块编写是增添功能的，不会涉及到解决无法运行的问题，所以这是在可以运行的基础上来进行编写框架的。

## 编写功能

