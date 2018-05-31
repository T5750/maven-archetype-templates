# spring-data-elasticsearch-query

## Runtime Environment
- [Spring Boot 1.5.2.RELEASE](https://projects.spring.io/spring-boot)
- [Elasticsearch 2.3.2](https://www.elastic.co/downloads/past-releases/elasticsearch-2-3-2)

## Quick Process
### API
- [http://localhost:8080/api/city/search?pageNumber=0&pageSize=10&searchContent=城市](http://localhost:8080/api/city/search?pageNumber=0&pageSize=10&searchContent=城市)

### application.properties 配置 ES 地址
```
spring.data.elasticsearch.repositories.enabled = true
spring.data.elasticsearch.cluster-nodes = 127.0.0.1:9300
```
默认 9300 是 Java 客户端的端口。9200 是支持 Restful HTTP 的接口。
更多配置：
- `spring.data.elasticsearch.cluster-name` Elasticsearch    集群名。(默认值: elasticsearch)
- `spring.data.elasticsearch.cluster-nodes`    集群节点地址列表，用逗号分隔。如果没有指定，就启动一个客户端节点。
- `spring.data.elasticsearch.propertie`     用来配置客户端的额外属性。
- `spring.data.elasticsearch.repositories.enabled`     开启 Elasticsearch 仓库。(默认值:true。)

## Links
- [《深入浅出 spring-data-elasticsearch – 实战案例详解（四）》](http://www.bysocket.com/?p=1902)
- [Spring Data Elasticsearch](https://docs.spring.io/spring-data/elasticsearch/docs/2.1.1.RELEASE/reference/html/)
- [Elasticsearch: 权威指南](https://www.elastic.co/guide/cn/elasticsearch/guide/current/index.html)
