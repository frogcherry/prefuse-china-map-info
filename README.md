prefuse-china-map-info
=======================================

这是什么？
---------------------------

* 这是一个学习Java Prefuse和Swing的练习程序。
     
     关于Prefuse: http://prefuse.org/

怎么玩？
---------------------------

* 如果你有jdk (> 1.6)和ant, 在根目录"./"下直接ant一下。你没有？快去下一个！
* 看到./dist目录下多了一个多了一个prefuse-china-map-info-${version}.jar了吧？运行./run.bat,或者你自己运行jar
* 多了一个swing窗口？对了，就是它。
* 鼠标滑过各省，会在左下角显示简单信息。鼠标点住拖拽，可以拖动地图；释放，又回到原地。就这么些功能啦^_^~
* Enjoy!

遇到问题了？马上联系我: frogcherry@gmail.com。Thx!

资源与目录说明
---------------------------

* ./src/main/java  源代码目录
* ./src/test/java  junit单元测试代码
* ./build 编译生成class文件目录，（运行ant编译后生成，gitignore）
* ./conf  配置文件目录
* ./conf/prefuse-map-info.properties   生效配置文件
* ./conf/prefuse-map-info.properties.sample   配置文件说明示例
* ./data  各省数据文件
* ./data/china_map_data.csv  生效的配置文件，utf-8编码
* ./dist  编译生成的jar目录，（运行ant编译后生成，gitignore）
* ./docs  文档目录，当前仅有javadoc文档，（运行ant编译后生成，gitignore）
* ./images  图片资源目录
* ./lib   必要的其他jar lib
* ./log   日志目录，当前包含单元测试报告和单元测试覆盖率报告，（运行ant编译后生成，gitignore）
* ./build.bat  windows下编译脚本
* ./build.xml  ant编译配置
* ./README.md  本README文件
* ./run.bat    windows下运行程序脚本，ant构建后方能运行

缺点？
---------------------------

* SWING小菜写的SWING当然是漏洞百出了T.T~
* prefuse不是很适合这个场景，所以这个东东并不是那么prefuse-ful
* 省份判定算法设计得不是很好，后来想到一个更好的，但那时程序已经成型了，就没修改过去了
* JUnit单元测试比较少

TODO:
---------------------------

