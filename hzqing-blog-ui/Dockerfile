FROM  hub.c.163.com/library/tomcat:8.5
# 镜像联系人
MAINTAINER hzqing
# 删除tomcat自待的问题
RUN rm -rf /usr/local/tomcat/webapps/ROOT/
# 将项目复制进去
COPY  dist/  /usr/local/tomcat/webapps/ROOT/



############################################################
## npm run build
## 构建命令  docker build -t hzqing-blog:1 .
############################################################