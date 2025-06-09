# Elm 外卖后台系统

这是一个面向学习者的外卖小程序后端系统，实现了基本的业务接口，支持通过 Docker 快速部署运行。项目分为两个主要版本：

- **v1.0.0**：基于 Servlet + JDBC 实现
- **v2.0.0**：基于 Spring Boot + MyBatis 实现，新增 Docker 部署支持

---

## 🧰 技术栈

- Java 17
- Spring Boot 3.x
- MyBatis
- MySQL
- Maven
- Docker / Docker Compose

---

## 📦 项目结构
```yaml
elm-backend/ # 后端源码
├── src/
├── pom.xml
├── Dockerfile
├── application.yml or application.properties

elmclient/ # 前端 Vue 小程序（可选）
docker-compose.yml # 一键部署入口
elm.sql # MySQL 初始化脚本
```

---

## 🚀 快速开始

### 使用 Docker 部署（推荐）

1. 确保已安装 `Docker` 和 `Docker Compose`
2. 将 `elm.sql` 放在合适目录中或更改`docker-compose.yml`，确保 `docker-compose.yml` 中配置路径正确
3. 执行以下命令：

```bash
docker compose up --build
```

## 📚 接口功能简介
本项目实现了外卖小程序的以下后端功能接口：

- 商家信息查询

- 食品列表展示

- 用户下单、订单查询

- 购物车操作

- 配送地址维护

接口设计遵循 RESTful 风格，具体请求格式可通过前端代码或 Postman 参考学习。

## 🏷️ 版本说明
- v1.0.0	Servlet + JDBC 实现
- v2.0.0	Spring Boot + MyBatis 实现，支持 Docker 部署

## 📄 License
仅供学习使用，禁止用于商业用途。