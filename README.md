# IHome
jcr加入

2025.1.14
jcr修改：
  在config包中添加ThreadPoolConfig类，实现多线程
  添加job包，添加AmqpClient类，实现监听服务器，接收服务器信息
  添加properties包，添加AliIotConfigProperties类，保存服务器信息
  修改application.properties文件，添加服务器配置信息
  修改pom.xml文件，添加相应依赖
  
  功能实现：实现与模拟设备的连接，可以获取模拟设备的状态变化