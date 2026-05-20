# Games

## Fuente
CapacitorJS — Documentación Oficial (Cap. 26)

## Contenido
## Products

## Open Source

# Configuring Android

## ConfiguringAndroidManifest.xml​

## Changing the Package ID​

## Changing the App Name​

## Deeplinks (aka Android App Links)​

## URL Schemes​

## Setting Permissions​

## Contents

Android apps manage permissions, device features, and other settings in theAndroidManifest.xmlfile, which is located atandroid/app/src/main/AndroidManifest.xml.

AndroidManifest.xmlmay reference additional files such asstyles.xmlandstrings.xmlwithin theandroid/app/src/main/res/valuesdirectory via@styleand@string.Read more about Android Resources.

This article covers the basic modifications you'll need to make to your app. Read theAndroid Manifest docsto learn a whole lot more.

To change your app's Package ID (akaApplication IDfor Android), editapplicationIdat the top ofandroid/app/build.gradle:

To change the name of your app, change the value forapp_nameinstrings.xml:

It may make sense to change the activity name to match, especially if your app has a single activity:

For a Deep Links guide,see here.

To enable deeplinking through Android App Links, follow the official Android guide onAdding Android App Links. Android Studio comes with a handy wizard for configuring App Links.

Once configured, thegetLaunchUrl()method in the App APIwill provide any URL the app was launched with, and the'appUrlOpen'eventwill fire any time the app receives a new App Link deeplink.

Your app can respond to custom URLs on launch, making it possible to handle deeplinks and app interactions.

To change the URL, search for and modify this line instrings.xml. It's recommended to set this to the Package ID.

In this example, the app will respond to URLs with thecom.capacitorjs.myapp://scheme.

To get any custom URL the app may have launched with, see the Deeplinks section above.

In Android, permissions your app will need are defined inAndroidManifest.xmlinside of the<manifest>tag, generally at the bottom of the file.

For example, here's what adding Network permissions looks like:

Generally, the plugin you choose to use will ask you to set a permission. Add it in this file.

Mobile CI/CD made easy. Build, publish, and update from the cloud.

## Código

```
AndroidManifest.xml
```

```
AndroidManifest.xml
```

```
android/app/src/main/AndroidManifest.xml
```

```
AndroidManifest.xml
```

```
styles.xml
```

```
strings.xml
```

```
android/app/src/main/res/values
```

```
@style
```

```
@string
```

```
applicationId
```

```
android/app/build.gradle
```

```
defaultConfig {-applicationId "com.capacitorjs.app"+applicationId "com.mycompany.myapp"
```

```
defaultConfig {-applicationId "com.capacitorjs.app"+applicationId "com.mycompany.myapp"
```

```
app_name
```

```
strings.xml
```

```
<stringname="app_name">MyApp</string>
```

```
<stringname="app_name">MyApp</string>
```

```
<stringname="title_activity_main">MyApp</string>
```

```
<stringname="title_activity_main">MyApp</string>
```

```
getLaunchUrl()
```

```
'appUrlOpen'
```

```
strings.xml
```

```
<stringname="custom_url_scheme">com.capacitorjs.myapp</string>
```

```
<stringname="custom_url_scheme">com.capacitorjs.myapp</string>
```

```
com.capacitorjs.myapp://
```

```
AndroidManifest.xml
```

```
<manifest>
```

```
<manifestxmlns:android="http://schemas.android.com/apk/res/android"package="com.getcapacitor.myapp"><activity><!-- other stuff --></activity><!-- More stuff --><!-- Your permissions --><!-- Network API --><uses-permissionandroid:name="android.permission.ACCESS_NETWORK_STATE"/></manifest>
```

```
<manifestxmlns:android="http://schemas.android.com/apk/res/android"package="com.getcapacitor.myapp"><activity><!-- other stuff --></activity><!-- More stuff --><!-- Your permissions --><!-- Network API --><uses-permissionandroid:name="android.permission.ACCESS_NETWORK_STATE"/></manifest>
```

```
AndroidManifest.xml
```

- v8
- v7
- v6
- v5
- v4
- v3
- v2

- Appflow
- Portals

- Ionic Framework
- Capacitor
- Stencil

- Getting StartedIntroductionEnvironment SetupInstalling CapacitorBuilding Your UIUsing with Ionic FrameworkVS Code ExtensionCapacitor TemplatesFAQs
- Introduction
- Environment Setup
- Installing Capacitor
- Building Your UI
- Using with Ionic Framework
- VS Code Extension
- Capacitor Templates
- FAQs
- BasicsDevelopment WorkflowUsing PluginsConfiguring Your AppJavaScript API
- Development Workflow
- Using Plugins
- Configuring Your App
- JavaScript API
- Upgrade GuidesUpdating to 8.0Updating plugins to 8.0Updating to 7.0Updating plugins to 7.0Updating to 6.0Updating plugins to 6.0Updating to 5.0Updating plugins to 5.0Updating to 4.0Updating to 3.0Updating to 2.0Updating to 1.1Updating plugins to 3.0
- Updating to 8.0
- Updating plugins to 8.0
- Updating to 7.0
- Updating plugins to 7.0
- Updating to 6.0
- Updating plugins to 6.0
- Updating to 5.0
- Updating plugins to 5.0
- Updating to 4.0
- Updating to 3.0
- Updating to 2.0
- Updating to 1.1
- Updating plugins to 3.0
- Cordova/PhoneGapOverviewMigrating Stra

> [Contenido truncado — consulta el capítulo completo con knowledge read]
