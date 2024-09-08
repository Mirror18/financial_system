# docker安装工具

这里主要是整合一些命令，省的自己改了。

不过我的docker是安装在Ubuntu的虚拟机上，这才是与原文档不同的根本所在。

## MySQL

因为是已经安装过的。不再赘述。

| 账号   | root |
| ------ | ---- |
| 密码   | root |
| 端口号 | 3306 |
|        |      |

## redis

| 账号   | 空     |
| ------ | ------ |
| 密码   | 000415 |
| 端口号 | 6379   |
|        |        |

## rocketMQ

这里不讲mq的原理。大概也是知道mq本身提供的功能就是信息中转。通过设置好通道，供数据传输。

所以这里需要安装两个软件，一个是mq。另一个是dashboard管理工具。

主要是配置topic和broker实在是有点蛋疼。

那么根据docker安装的事情可知，是提供api可供操作。要么是在Windows上有操作软件，要么就是开设的端口。为啥在这瞎逼逼，因为后续我还要在虚拟机上开端口。emmm。

### rocketmq-dashboard

首先是拉取镜像

```docker
docker pull apacherocketmq/rocketmq-dashboard:1.0.0
```

然后是创建运行容器

```she
docker run -d  --restart=always --name rocketmq-dashboard -e "JAVA_OPTS=-Drocketmq.namesrv.addr=host.docker.internal:9876" -p 7080:8080 -t apacherocketmq/rocketmq-dashboard:1.0.0

#  docker run -d --name rocketmq-dashboard -e "JAVA_OPTS=-Drocketmq.namesrv.addr=127.0.0.1:9876" -p 8080:8080 -t apacherocketmq/rocketmq-dashboard:latest


#-------------------------------------------------------------------以下命令仅供参考---------------------------------------------------------------------------

# 如果NameServer地址在宿主机上则使用host.docker.internal地址代替127.0.0.1，7080是宿主机端口，8080是rocketmq-dashboard所在容器中使用的端口（根据自己的情况调整）
# docker run -d --name rocketmq-dashboard -e "JAVA_OPTS=-Drocketmq.namesrv.addr=host.docker.internal:9876" -p 7080:8080 -t apacherocketmq/rocketmq-dashboard:latest

# 停止服务
# docker stop rocketmq-dashboard

# 删除容器
# docker rm rocketmq-dashboard
```

首先是搞明白参数呗，-d表示后台运行。--restart=always保证总是运行

--name 表示重命名，就是给容器命名。

-e表示启动的时候传递参数

-p 前面是docker外部端口，后面是docker内部端口，也就是我们要访问只能是使用外部端口。有点难解释，不过就是把这玩意当作虚拟机完了，内外端口不一致就是这点来的。

—t 分配一个伪终端。怎么说呢，就是到时候可以进入到docker中模拟终端。

后面就是镜像名，写编码也成

通过上述，可以理解我们虚拟机要开一个什么端口，7080端口，就可以通过web访问。



### rocketMQ

获取镜像

```dockerfile
docker pull rocketmqinc/rocketmq:4.4.0
```

创建运行容器

```dockerfile
 docker run -d  --restart=always --name rocketmq-namesrv -p 9876:9876 rocketmqinc/rocketmq:4.4.0 sh mqnamesrv
```

这里补充sh，可以理解为执行命令

附属吐槽一句，消息中间件还挺多的。真不打算学，现在用到了就现场查资料。

所以现在查资料，哈哈。

这里是创建一个注册中心，用于保存topic路由信息。注册中心之间是没有通信的，可以理解为集群。

然后在创建一个broker。这是干嘛呢，用于保存topic的信息，接受生产者生产的信息。

创建broker容器，

首先是创建文件。这傻逼玩意，运行之后才发现，这给的是个文件夹。

```shell
sudo mkdir rocketmq
sudo touch broker.conf
```



```shel
 sudo docker run -d --restart=always --name rocketmq-broker -v /home/mirror/rocketmq/broker.conf:/opt/rocketmq-4.4.0/conf/broker.conf -p 10911:10911 -p 10909:10909 -e "NAMESRV_ADDR=host.docker.internal:9876" rocketmqinc/rocketmq:4.4.0 sh mqbroker -n host.docker.internal:9876 -c /opt/rocketmq-4.4.0/conf/broker.conf

```

这里新添加一个-v，用于挂载存储卷。什么意思，就是将虚拟机的信息在外部也能访问到。其实就是挂载了配置信息。

开了俩端口，传入参数。执行命令。-n指定拿么server地址，-c指定broker配置文件路径。

### 开放端口

| 服务信息             | 端口号 |
| -------------------- | ------ |
| dashboard            | 7080   |
| nameServer           | 9876   |
| 消息存储，消费者通信 | 10911  |
| 访问管理控制台       | 10909  |

#### 访问路径

(http://localhost:7080/)

## elasticSearch

### elasticSearch

创建容器网络

```shell
docker network create elastic-net
```

下载镜像

```shell
docker pull docker.elastic.co/elasticsearch/elasticsearch:8.12.2
```

运行容器

```shell
sudo touch /es/elasticsearch.yml

docker run -d --restart=always --name elasticsearch --net elastic-net -v /home/mirror/es/elasticsearch.yml:/usr/share/elasticsearch/config/elasticsearch.yml -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" -t docker.elastic.co/elasticsearch/elasticsearch:8.12.2
```

然后就是重置密码，导出证书到本地，也就是在虚拟机中。

```shell
# 进入容器
 docker exec -it elasticsearch /bin/bash

# 重置用户名为elastic的密码
bin/elasticsearch-reset-password -u elastic
```

导出证书

```shell
docker cp elasticsearch:/usr/share/elasticsearch/config/certs/http_ca.crt .
```



### kibana

获取镜像

```shell
docker pull docker.elastic.co/kibana/kibana:8.12.2
```

运行

```shell
sudo touch /home/mirror/es/kibana.yml
docker run -d  --restart=always --name kibana --net elastic-net -v /home/mirror/es/kibana.yml:/usr/share/kibana/config/kibana.yml -p 127.0.0.1:5601:5601 -e "ELASTICSEARCH_HOSTS=http://elasticsearch:9200" docker.elastic.co/kibana/kibana:8.12.2
```



### 开放端口

| elaseticsearch | 9200 |
| -------------- | ---- |
| elaseticsearch | 9300 |
| kibana         | 5601 |



## minio

安装镜像

```shell
docker pull minio/minio:RELEASE.2024-04-18T19-09-19Z.fips
```

运行

```shell
sudo mkdir minio
sudo mkdir config/minio/
docker run -dt --restart=always -p 9002:9000 -p 9001:9001 -v /home/mirror/minio/data:/mnt/data -v /home/mirror/config/minio/config:/etc/config.env -e "MINIO_CONFIG_ENV_FILE=/etc/config.env" --name "minio" minio/minio:RELEASE.2024-04-18T19-09-19Z.fips server --console-address ":9001"
```

开放9002和9001端口

访问路径为

http://127.0.0.1:9001/login

账户minio

密码 12345678