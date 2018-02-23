初始化工具类

里面主要有 baseActivity baseFarement ToastUtils LoggerUtils json初始化方法 以及 正则表达式等  其他方法后续添加

使用方法
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
	
dependencies {
	        compile 'com.github.yanzhenxiang:appUtils:1.0.0'
	}
