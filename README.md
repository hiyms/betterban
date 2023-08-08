# BetterBan
基于Bukkit api实现的Minecraft插件  
支持使用正则匹配banip  
**理论支持版本** 1.12及以上  
**测试版本** 1.19  
## 使用
### 配置文件
```yaml
run: false
# 总开关
rebanip:
  - "127.0.0.1$"
# 用于匹配的正则
whiteuser:
  - "steve"
# 此处包含的玩家名称跳过检查
```
### 命令
#### 重载
```mclang
/bban reload
```
需要权限`bban.reload`
#### 关于
```mclang
/bban abort
```