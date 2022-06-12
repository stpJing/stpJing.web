基于java8 spring-boot-starter-web 2.3.12.RELEASE

以以下格式返回后端请求

```json
{
"success": true,
"data": {},
"errorMessage": "error message",
"timestamp": ""
}
```

错误消息默认全局处理

需要用@MessageController取代@RestController，以标记你想要这么处理的api

