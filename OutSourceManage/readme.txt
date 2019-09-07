 <Resource auth="Container" driverClassName="com.mysql.jdbc.Driver" maxActive="100" maxIdle="30"
  maxWait="10000" name="OutSourceManage" password="shida123456"  type="javax.sql.DataSource" 
  url="jdbc:mysql://192.168.1.250:3306/outsourcemanage?useUnicode=true&amp;characterEncoding=utf-8&amp;allowMultiQueries=true" username="root"/> 
  #微信回调地址
  https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx629e79a82e05937f&redirect_uri=http://cs.shidakj.cn/OutSourceManage/wxManagerWx/transfer.html&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect

  https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx629e79a82e05937f&redirect_uri=
  http://cs.shidakj.cn/OutSourceManage/wxManagerWx/transfer.html&response_type=code&
  scope=snsapi_base&state=STATE#wechat_redirect