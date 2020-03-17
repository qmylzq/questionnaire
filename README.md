# springboot实现的定制问卷
现有的定制问卷系统是无法实现处理随机图片的，问卷中对于图片与答案的设定都是写死的。
但是对于对于室内设计等需要灵活的视觉传达效果的问卷，很难实现问卷中图片的灵活处理，问卷会有很大的主观性。
在此做出以下尝试：爬取图片资源并上传至服务器，作为问卷图片的资源库，从中随机选图并生成调研题目，这才符合市场调研的初衷。
[这是运行的视频](https://www.bilibili.com/video/av94617689)
## 依赖都在pom.xml里面
## 总共有三个功能模块
（1）/question/paper发布一份问卷

（2）/question/add保存一道题的答案

（3）/question/code生成一个问卷编码
### 运行
（1）直接打开IDEA open本地项目，按照pom.xml导入依赖

（2）需要在本地创建数据库，以及对应数据表

（3）可以运行试试，可能不可避免会有文件路径不对的问题

### 本地压力测试
[JMeter压力测试](https://www.bilibili.com/video/av94782753)
### Spring-data-JPA结果统计
在hello.html里面添加问卷号或系列名称，向后台发送两个请求

（1）/answer/showByWorkerId根据问卷号查询结果

（2）/answer/showByCategory根据系列名称查询结果
### 编解码
在hello.jtml里面添加用户提供的Verify_code，向后台发送查询请求：
如果直接将编码值作为索引，查询非常艰难。

采取先解码后查询的思路

（1）/answer/showByCode根据用户提交的编码查询结果
### 使用redis缓存减少数据库IO
有两处改动

（1）原本/answer/add向数据库写入一条answer变成redis写入一条记录

（2）原本/answer/code向数据库插入一条code，变成从缓存中取10条数据写入数据库

