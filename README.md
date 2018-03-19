# ImitateIosDialog
仿ios对话框
![Image text](https://github.com/17770843708/ImitateIosDialog/blob/master/Screenshot_20180319-104832.png)
![Image text](https://github.com/17770843708/ImitateIosDialog/blob/master/Screenshot_20180319-104856.png)

# Gradle
![Image text](https://github.com/17770843708/ImitateIosDialog/blob/master/20180319110549.png)
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
```
dependencies {
    ...
    compile 'com.github.17770843708:ImitateIosDialog:V1.0'
}
```

# Usage
```
final IosAlertDialogFragment iosAlertDialogFragment = new IosAlertDialogFragment();
                iosAlertDialogFragment.show(getSupportFragmentManager(), "标题", "内容", new IosAlertDialogFragment.OnBtnClickListener() {
                    @Override
                    public void onNoClick() {
                        iosAlertDialogFragment.cancel();
                        Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onYesClick() {
                        iosAlertDialogFragment.cancel();
                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                    }
                });
```
```
final IosDialogFragment iosDialogFragment = new IosDialogFragment();
                iosDialogFragment.show(getSupportFragmentManager(), "自定义", dialogView, new IosAlertDialogFragment.OnBtnClickListener() {
                    @Override
                    public void onNoClick() {
                        iosDialogFragment.cancel();
                        Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onYesClick() {
                        iosDialogFragment.cancel();
                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                    }
                });
```
