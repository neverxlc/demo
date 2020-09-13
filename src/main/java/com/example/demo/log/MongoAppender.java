package com.example.demo.log;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;


/**
 *
 * 定义MongoDB的配置参数，可通过log4j.properties配置：
 *
 * connectionUrl：连接mongodb的串
 * databaseName：数据库名
 * collectionName：集合名
 * 定义MongoDB的连接和操作对象，根据log4j.properties配置的参数初始化：
 *
 * mongoClient：mongodb的连接客户端
 * mongoDatabase：记录日志的数据库
 * logsCollection：记录日志的集合
 * 重写append函数：
 *
 * 根据log4j.properties中的配置创建mongodb连接
 * LoggingEvent提供getMessage()函数来获取日志消息
 * 往配置的记录日志的collection中插入日志消息
 * 重写close函数：关闭mongodb的
 *
 *
 *
 *
 */
public class MongoAppender extends AppenderSkeleton {

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCollection<BasicDBObject> logsCollection;

    private String connectionUrl;
    private String databaseName;
    private String collectionName;

    /**
     *
     * 配置log4j.properties
     * 设置名为mongodb的logger：
     *
     * 记录INFO级别日志
     * appender实现为com.didispace.log.MongoAppende
     * mongodb连接地址：mongodb://localhost:27017
     * mongodb数据库名：logs
     * mongodb集合名：logs_request
     *
     *
     *
     * log4j.logger.mongodb=INFO, mongodb
     * # mongodb输出
     * log4j.appender.mongodb=com.didispace.log.MongoAppender
     * log4j.appender.mongodb.connectionUrl=mongodb://localhost:27017
     * log4j.appender.mongodb.databaseName=logs
     * log4j.appender.mongodb.collectionName=logs_request
     *
     *
     *
     * @param loggingEvent
     */
    @Override
    protected void append(LoggingEvent loggingEvent) {

        if (mongoDatabase == null) {
            MongoClientURI connectionString = new MongoClientURI(connectionUrl);
            mongoClient = new MongoClient(connectionString);
            mongoDatabase = mongoClient.getDatabase(databaseName);
            logsCollection = mongoDatabase.getCollection(collectionName, BasicDBObject.class);
        }
        logsCollection.insertOne((BasicDBObject) loggingEvent.getMessage());
    }

    @Override
    public void close() {

        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }


    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public MongoDatabase getMongoDatabase() {
        return mongoDatabase;
    }

    public void setMongoDatabase(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    public MongoCollection<BasicDBObject> getLogsCollection() {
        return logsCollection;
    }

    public void setLogsCollection(MongoCollection<BasicDBObject> logsCollection) {
        this.logsCollection = logsCollection;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
}
