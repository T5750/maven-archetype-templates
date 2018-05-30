# spring-data-elasticsearch-crud

## Runtime Environment
- [Spring Boot 1.5.2.RELEASE](https://projects.spring.io/spring-boot)
- [Elasticsearch 2.3.2](https://www.elastic.co/downloads/past-releases/elasticsearch-2-3-2)

## Quick Process
### 一、Elasticsearch 安装
#### 1. .tar.gz 安装包安装 Elasticsearch
```
wget https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-5.3.0.tar.gz
tar -xzf elasticsearch-5.3.0.tar.gz
cd elasticsearch-5.3.0/
```

#### 2. 配置文件
`config/elasticsearch.yml`
```
# allow origin
http.cors.enabled: true
http.cors.allow-origin: "*"
```

#### 3. 运行
```
./bin/elasticsearch -d
```
[http://localhost:9200/](http://localhost:9200/)

#### 4. 关闭
```
ps aux |grep elasticsearch
kill -7 pid
```

### 二、可视化插件 elasticsearch-head 安装
```
git clone git://github.com/mobz/elasticsearch-head.git
cd elasticsearch-head
npm install
npm run start
```
[http://localhost:9100/](http://localhost:9100/)

### API
- [http://127.0.0.1:8080/api/city](http://127.0.0.1:8080/api/city)
```
{
    "id": 1,
    "score": 5,
    "name": "上海",
    "description": "上海是个热城市"
}

{
    "id":"2",
    "score":"4",
    "name":"温岭",
    "description":"温岭是个沿海城市"
}
```
- [http://localhost:8080/api/city/description/find?description=温岭](http://localhost:8080/api/city/description/find?description=温岭)
- [http://localhost:8080/api/city/description/find?description=温岭&score=4](http://localhost:8080/api/city/description/find?description=温岭&score=4)
- [http://localhost:8080/api/city/or/find?description=上海&score=4](http://localhost:8080/api/city/or/find?description=上海&score=4)
- [http://localhost:8080/api/city/description/not/find?description=温州](http://localhost:8080/api/city/description/not/find?description=温州)
- [http://localhost:8080/api/city/like/find?description=城市](http://localhost:8080/api/city/like/find?description=城市)

## Links
- [《深入浅出 spring-data-elasticsearch – 基本案例详解（三）》](http://www.bysocket.com/?p=1899)
- [Elasticsearch 和插件 elasticsearch-head 安装详解](https://www.bysocket.com/?p=1744)
