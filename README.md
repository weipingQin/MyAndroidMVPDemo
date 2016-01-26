###    时间：2015年12月23号
##### review:建议TextView中关于text的相关中文和文字放入到strings.xml中，平时编写代码就需要养成习惯
###    时间：2015年12月28号
##### change：进一步对控件进行了修改，同时添加了DrawerLayout的布局

###    时间 2015年 12月30号 
###    异常信息 ```java.lang.IllegalStateException: This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead

##### 修复BUG：参考资料: 1.[http://stackoverflow.com/questions/26515058/this-activity-already-has-an-action-bar-supplied-by-the-window-decor]
			 2.[http://stackoverflow.com/questions/21357974/android-drawerlayout-crashes-when-clicking-on-the-icon]
		       