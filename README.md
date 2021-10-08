# 加密工具 - Android

## 功能

1. MD5、SHA-1、SHA-256、SHA-384、SHA-512演算法支援
2. 可純文字加密或加入Salt
3. 可查看歷史紀錄，並以不同的演算法產生新的結果(長按歷史記錄)
4. 透過本地記錄以及第三方網站嘗試從加密結果反推明文

## 專案簡介

* 程式語言：Kotlin 1.5.31
* Android版本要求： 最低21(Android 5.0.0 Lollipop)
* 套件
    * Kotlin Coroutines
    * Android Jetpack Room 2.3.0
    * Android Jetpack Lifecycle-ViewModel 2.3.1
    * Android DataBinding

## 專案執行

啟動前需在根目錄建立`api_key.properties`檔案，裡面要有以下變數

```properties
api.email="API_EMAIL"
api.code="API_CODE"
```

以上兩個變數的值需到此[第三方API](https://md5decrypt.net/en/Api/)取得
