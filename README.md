# Meow Bottom Navigation
كيف نسوي منيو زي هذي بالفيديو تحت ؟:)

# المحتويات
* [المكاتب اللي بننزلها](#المكاتب_اللي_بننزلها)
* [xml ملف](#xml_ملف)
* [الصور](#الصور)
* [menu](#menu)
* [ملف جافا الاساسي](#ملف_جافا)
* [باقي الصفحات](#باقي_الصفحات)
* [عداد](#عداد)

## المكاتب_اللي_بننزلها
### 1- في ملف build.gradle (module path) عند ال dependencies بنضيف المكتبه التاليه : 
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
  ### 2- في ملف setting.gradle (setting project) عند ال repositories بنضيف : 
  #
        jcenter()
#### فيصير كذا :
#
      pluginManagement {
        repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        jcenter()
    }
    }
      dependencyResolutionManagement {
         repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
        repositories {
             google()
              mavenCentral()
            jcenter()
    }
    }
### 3- في ملف gradle.properties بنضيف , هذي السطرين :
#
        android.useAndroidX=true
        android.enableJetifier=true
#### فايدة السطرين هذول انه (لاستخدام AndroidX في مشروع ، لازم نخلي ال targetSdkVersion لمشروعنا إلى 28 فهي تخليه كذا)
  
  
 ## xml_ملف
### 1- بنضيف FrameLayout فاضيه (فايدتها عشان المحتوى اللي جوه بيتغير وهو بيكون محتوى الصفحات واللي بتكونFragment)
# 
      <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/frag"/>
### 2- بنضيف ال Meow Bottom Navigation , كذا :
#
          <com.etebarian.meowbottomnavigation.MeowBottomNavigation
            android:id="@+id/navi"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_alignParentEnd="true"
            android:layout_alignParentBottom="true"
            app:mbn_backgroundBottomColor="#ffffff"
            app:mbn_circleColor="#ffffff"
            app:mbn_countBackgroundColor="#670862"
            app:mbn_countTextColor="#ffffff"
            app:mbn_defaultIconColor="#90a4ae"
            app:mbn_rippleColor="#2f424242"
            app:mbn_selectedIconColor="#3c415e"
            app:mbn_shadowColor="#1f212121" />
#### ونقدر نغير الالوان والاشياء زي ما نبغا وهذي الاشياء بتكون فيmain xml 

## الصور
### بنضيف الصور باننا نروح لمجلد ال drawable الموجود في مجلد res , ونضغط عليه بالزر اليمين بعدين new بعدها Image Asset وعند name بنحط الاسم اللي نبغا صورتنا تتسمى فيه ومن ال Icon Type نختار notification icon وعند Asset type بنختار Clip Art وعند Clip Art بنضغط على الزر ونختار صوره ونقدر نبحث بعد , بعدين ok وبعدين next وبعدين finish , بنروح لمجلد drawable نلقا كودها فبنشيل خاصيه tint 
### هذا فيديو توضيحي للكلام اللي فوق :)
https://user-images.githubusercontent.com/107775566/217816893-62e5fab6-ffb9-4083-9ece-5ac2cb2aba24.mp4

## menu
### الان بنبدا نسوي القائمة , بنروح لمجلد ال menu الموجود بمجلد ال res وننشيء ملف bottom_nav_menu.xml وبنضيف فيه الكود التالي :
#
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <item
        android:id="@+id/home"
        android:title="Home"
        android:icon="@drawable/ic_home"
        app:showAsAction="ifRoom"
        />

    <item
        android:id="@+id/annou"
        android:title="Announcements"
        android:icon="@drawable/fu"
        />

    <item
        android:id="@+id/plus"
        android:title="Add Announcements"
        app:showAsAction="ifRoom"
        />

    <item
        android:id="@+id/profile"
        android:title="Profile"
        android:icon="@drawable/ic_person"
        app:showAsAction="ifRoom"
        />

    <item
        android:id="@+id/cart"
        android:title="Cart"
        app:showAsAction="ifRoom"
        android:icon="@drawable/cartt" />
</menu>

#### طبعا كل item بيمثل عنصر او مربع في هذي القائمة وخاصيه title بتمثل النص المكتوب ونغيره حسب المطلوب , وال icon بتكون كذا  android:icon="@drawable/الاسم" والاسم هنا اقصد فيه اسم الصوره اللي اضفناها في الخطوه اللي قبل هذي 
#### طيب لو ما عندنا مجلد menu ؟  بننشئه كذا (نضغط بالزر اليمين على مجلد res -> بعدها Android Resource Directory -> بعدين في Resource Type بنختار menu)
https://user-images.githubusercontent.com/107775566/217820190-8c296258-5d73-41b0-bac5-5b655ab44b2b.mp4


  ## ملف_جافا
  ### 1- بنسوي اوبجكت من كلاس MeowBottomNavigation عشان نعرف فيه المنيو حقتنا 
  #
      MeowBottomNavigation bottomNavigation;
  ### 2- بنربطه بال MeowBottomNavigation اللي عرفناها بال main xml 
  #
      bottomNavigation=findViewById(R.id.navi);
      
 ### 3- في ال OnCreate method بنضيف العناصر للقائمة , زي كذا :
 #
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.fu));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_add));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.cartt));
        bottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.ic_person));
#### استدعينا داله add الموجوده ب MeowButtomNavigATION ومررنا لها اوبجكت منها واستدعينا ال method اللي اسمها Model ومررنا لها قيمتين اول شي الرقم بيكون مثل id للعنصر عشان نقول اذا ضغط هذا العنصر وش يسوي والعنصر الثاني بيكون الصوره فبعد drawable بيكون اسم صورتنا
  ### 4- بنستدعي ليسنر عشان تسوي شي عند ضغط اي عنصر , مثلا هنا بتطلع لك رساله انه انضغظ
  #
          bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
              Toast.makeText(getApplicationContext(),"Clicked " +item.getId(),Toast.LENGTH_LONG).show();
            }
        });
### 5- بنستدعي ليسنر عشان ينقلنا لصحفه "Fragment" اخرى عند الضغط على العنصر
#
      bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment;
                if (item.getId() == 2) {
                    fragment=new all();
                }else if (item.getId() == 3) {
                    fragment=new add();
                }else if (item.getId() == 4) {
                    fragment=new Cart();
                }else if(item.getId()==5){
                    fragment=new Profile();
                } else
                    fragment = new Home();
                loadFragment(fragment);//استدعاء للداله بالخطوه 8 
            }
        });
### 6- بنسدعي ليسنر عشان يسوي لنا شي عند اعادة الضغط على عنصر اصلا احنا ضاغطين عليه , فهنا بيطلع رساله تقول انك قاعده تختاره من جديد
#
       bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(), "Reselected " + item.getId(), Toast.LENGTH_LONG).show();
            }
            });
### 7- عشان نحدد وش الصفحة الافتراضيه اللي بتظهر اول شي بنستخدم داله show , وهنا قلنا ان ال item اللي الرقم حقها يوم اضفناهم فوق يساوي 1 هي الافتراضيه
#
        bottomNavigation.show(1,true);
### 8- بنعرف داله loadFragment خارج ال OnCreate طبعا , وهي اللي استدعيناها بخطوه 5 في ال setOnShowListener , وفايدتها تنقلنا لل Fragment المختار رقمه  
#
    private void loadFragment(Fragment fragment) {
        //replace the fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frag,fragment, null)
                .commit();
      }



  ## باقي_الصفحات
  ### لكل item في ال menu بيكون عندنا Fragment وبنحط ال xml وال java على كيفنا 
  ### طريقة انشاء Fragment : بالزر اليمين على اسم البكج اللي فيه ملفات جافا بعدين new وبعدهاGallery وبعدين نختار شكل وnext واخر شي الاسم وFinish 
https://user-images.githubusercontent.com/107775566/217826551-ed732122-bf4d-4de1-a146-ad4b45def65b.mp4

 
  ## عداد
   ### 1- عشان نحط عداد للسله مثلا يقول كم العناصر في السله , بس بدل 4 بيكون رقم ال id حق ال item اللي نبغا نحط له عداد وهنا السله ال id حقها يساوي 4 وبدل ال 5 بنحط متغير يمثل عدد العناصر فيها
#
        bottomNavigation.setCount(4,"5");
   ### 2- عشان نحذف العداد من اي عنصر , وبدل 4 بيكون id حق ال item حسب ما احنا معرفين فوق
#
        bottomNavigation.clearCount(4);
