按照文件名创建这两个数据库即可。

`finance-local.sql`是不含测试数据的。主要是忒累，对方是直接导出的表。主要问题就是我这是MySQL5.7.那版本是8.0。原本数据是多了点引擎，编码，检查编码的内容。删着太累了。于是连测试数据就给删了。

`xxl-job-local.sql`是包含测试数据的。顺便也可以学习下如何插入数据，哈哈。不过这里就是加锁了。但是这个数据库导入容易崩，如果电脑不太好的话。没成功就把测试数据给删了就行，就lock和unlock中间的内容。
