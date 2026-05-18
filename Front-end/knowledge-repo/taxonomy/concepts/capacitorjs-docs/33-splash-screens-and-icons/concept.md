# Splash screens and icons

## Fuente
CapacitorJS — Documentación Oficial (Cap. 33)

## Contenido
# Splash screens and icons

## Products

## Open Source

# Capacitor Configuration

## Example​

## Schema​

## Environment Variables​

## Contents

The Capacitor configuration file is used to set high-level options for Capacitor tooling.

This is an examplecapacitor.config.tsfile:

If you are not using TypeScript in your project, you can use acapacitor.config.jsonfile in the same way.

Here is the TypeScript interface for Capacitor configuration, complete with descriptions and defaults.

The Capacitor CLI will find dependencies on your system automatically. In the event you need to configure these paths, the following environment variables are available:

Mobile CI/CD made easy. Build, publish, and update from the cloud.

## Código

```
capacitor.config.ts
```

```
import{CapacitorConfig}from'@capacitor/cli';constconfig:CapacitorConfig={appId:'com.company.appname',appName:'My Capacitor App',webDir:'www',};exportdefaultconfig;
```

```
import{CapacitorConfig}from'@capacitor/cli';constconfig:CapacitorConfig={appId:'com.company.appname',appName:'My Capacitor App',webDir:'www',};exportdefaultconfig;
```

```
capacitor.config.json
```

```
exportinterfaceCapacitorConfig{/*** The unique identifier of your packaged app.** This is also known as the Bundle ID in iOS and the Application ID in* Android. It must be in reverse domain name notation, generally* representing a domain name that you or your company owns.**@since1.0.0*/appId?:string;/*** The human-friendly name of your app.** This should be what you'd see in the App Store, but can be changed after* within each native platform after it is generated.**@since1.0.0*/appName?:string;/*** The directory of your compiled web assets.** This directory should contain the final `index.html` of your app.**@since1.0.0*/webDir?:string;/*** The build configuration (as defined by the native app) under which Capacitor* will send statements to the log system. This applies to log statements in* native code as well as statements redirected from JavaScript (`console.debug`,* `console.error`, etc.). Enabling logging will let statements render in the* Xcode and Android Studio windows but can leak information on device if enabled* in released builds.** 'none' = logs are never produced* 'debug' = logs are produced in debug builds but not production builds* 'production' = logs are always produced**@since3.0.0*@defaultdebug*/loggingBehavior?:'none'|'debug'|'production';/*** User agent of Capacitor Web View.**@since1.4.0*/overrideUserAgent?:string;/*** String to append to the original user agent of Capacitor Web View.** This is disregarded if `overrideUserAgent` is used.**@since1.4.0*/appendUserAgent?:string;/*** Background color of the Capacitor Web View.**@since1.1.0*/backgroundColor?:string;/*** Enable zooming within the Capacitor Web View.**@defaultfalse*@since6.0.0*/zoomEnabled?:boolean;/*** Whether to give the webview initial focus.**@since7.0.0*@defaulttrue*/initialFocus?:boolean;android?:{/*** Specify a custom path to the native Android project.**@since3.0.0*@defaultandroid*/path?:string;/*** User agent of Capacitor Web View on Android.** Overrides global `overrideUserAgent` option.**@since1.4.0*/overrideUserAgent?:string;/*** String to append to the original user agent of Capacitor Web View for Android.** Overrides global `appendUserAgent` option.** This is disregarded if `overrideUserAgent` is used.**@since1.4.0*/appendUserAgent?:string;/*** Background color of the Capacitor Web View for Android.** Overrides global `backgroundColor` option.**@since1.1.0*/backgroundColor?:string;/*** Enable zooming within the Capacitor Web View for Android.**@defaultfalse*@since6.0.0*/zoomEnabled?:boolean;/*** Enable mixed content in the Capacitor Web View for Android.** [Mixed* content](https://developer.mozilla.org/en-US/docs/Web/Security/Mixed_content)* is disabled by default for security. During development, you may need to* enable it to allow the Web View to load files from different schemes.** **This is not intended for use in production.****@since1.0.0*@defaultfalse*/allowMixedContent?:boolean;/*** This enables a simpler keyboard which may have some limitations.** This will capture JS keys using an alternative* [`InputConnection`](https://developer.android.com/reference/android/view/inputmethod/InputConnection).**@since1.0.0*@defaultfalse*/captureInput?:boolean;/*** Always enable debuggable web content.** This is automatically enabled during development.**@since1.0.0*@defaultfalse*/webContentsDebuggingEnabled?:boolean;/*** The build configuration under which Capacitor will generate logs on Android.** Overrides global `loggingBehavior` option.**@since3.0.0*@defaultdebug*/loggingBehavior?:'none'|'debug'|'production';/*** Allowlist of plugins to include during `npx cap sync` for Android.** Overrides global `includePlugins` option.**@since3.0.0*/includePlugins?:string[];/*** Android flavor to use.** If the app has flavors declared in the `build.gradle`* configure the flavor you want to run w
