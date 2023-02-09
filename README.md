# Meow Bottom Navigation
كيف نسوي منيو زي هذي بالفيديو تحت ؟:)

# المحتويات
* [المكاتب اللي بننزلها](#المكاتب_اللي_بننزلها)
* [ملف جافا](#java)
* [xml ملف](#xml)
* [الصور](#xml)
* [باقي الصفحات](#pages)
* [عداد](#count)

## المكاتب_اللي_بننزلها
### بنضيف dependencies عند ال build.gradle (module path) في ملف
#
      implementation 'com.etebarian:meow-bottom-navigation-java:1.2.0'
#### فيصير كذا :
#
      dependencies {
      implementation 'androidx.appcompat:appcompat:1.5.1'
      implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
      implementation 'androidx.navigation:navigation-fragment:2.5.3'
      implementation 'androidx.navigation:navigation-ui:2.5.3'
      testImplementation 'junit:junit:4.13.2'
      implementation 'com.google.android.gms:play-services-maps:18.1.0'
      implementation 'com.stripe:stripe-android:20.11.0'
      implementation 'com.etebarian:meow-bottom-navigation-java:1.2.0'
      }
  
