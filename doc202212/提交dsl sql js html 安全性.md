提交dsl sql js html 安全性

druid sql过滤。以及sql+mgdb实现安全性
16.HtmlSanitizer
可用于防止XSS攻击的HTML净化器，如何让前台用户可以提交HTML数据而又不被脚本攻击呢？HtmlSanitizer就是一个非常好的解决方案：设置不危险的“标签、属性”白名单,把所有不在白名单中的“标签、属性”全部干掉。

AntiXSS：微软官方预防跨站XSS脚本入侵攻击的开源类库，它通过白名单机制进行内容编码。