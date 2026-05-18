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
exportinterfaceCapacitorConfig{/*** The unique identifier of your packaged app.** This is also known as the Bundle ID in iOS and the Application ID in* Android. It must be in reverse domain name notation, generally* representing a domain name that you or your company owns.**@since1.0.0*/appId?:string;/*** The human-friendly name of your app.** This should be what you'd see in the App Store, but can be changed after* within each native platform after it is generated.**@since1.0.0*/appName?:string;/*** The directory of your compiled web assets.** This directory should contain the final `index.html` of your app.**@since1.0.0*/webDir?:string;/*** The build configuration (as defined by the native app) under which Capacitor* will send statements to the log system. This applies to log statements in* native code as well as statements redirected from JavaScript (`console.debug`,* `console.error`, etc.). Enabling logging will let statements render in the* Xcode and Android Studio windows but can leak information on device if enabled* in released builds.** 'none' = logs are never produced* 'debug' = logs are produced in debug builds but not production builds* 'production' = logs are always produced**@since3.0.0*@defaultdebug*/loggingBehavior?:'none'|'debug'|'production';/*** User agent of Capacitor Web View.**@since1.4.0*/overrideUserAgent?:string;/*** String to append to the original user agent of Capacitor Web View.** This is disregarded if `overrideUserAgent` is used.**@since1.4.0*/appendUserAgent?:string;/*** Background color of the Capacitor Web View.**@since1.1.0*/backgroundColor?:string;/*** Enable zooming within the Capacitor Web View.**@defaultfalse*@since6.0.0*/zoomEnabled?:boolean;/*** Whether to give the webview initial focus.**@since7.0.0*@defaulttrue*/initialFocus?:boolean;android?:{/*** Specify a custom path to the native Android project.**@since3.0.0*@defaultandroid*/path?:string;/*** User agent of Capacitor Web View on Android.** Overrides global `overrideUserAgent` option.**@since1.4.0*/overrideUserAgent?:string;/*** String to append to the original user agent of Capacitor Web View for Android.** Overrides global `appendUserAgent` option.** This is disregarded if `overrideUserAgent` is used.**@since1.4.0*/appendUserAgent?:string;/*** Background color of the Capacitor Web View for Android.** Overrides global `backgroundColor` option.**@since1.1.0*/backgroundColor?:string;/*** Enable zooming within the Capacitor Web View for Android.**@defaultfalse*@since6.0.0*/zoomEnabled?:boolean;/*** Enable mixed content in the Capacitor Web View for Android.** [Mixed* content](https://developer.mozilla.org/en-US/docs/Web/Security/Mixed_content)* is disabled by default for security. During development, you may need to* enable it to allow the Web View to load files from different schemes.** **This is not intended for use in production.****@since1.0.0*@defaultfalse*/allowMixedContent?:boolean;/*** This enables a simpler keyboard which may have some limitations.** This will capture JS keys using an alternative* [`InputConnection`](https://developer.android.com/reference/android/view/inputmethod/InputConnection).**@since1.0.0*@defaultfalse*/captureInput?:boolean;/*** Always enable debuggable web content.** This is automatically enabled during development.**@since1.0.0*@defaultfalse*/webContentsDebuggingEnabled?:boolean;/*** The build configuration under which Capacitor will generate logs on Android.** Overrides global `loggingBehavior` option.**@since3.0.0*@defaultdebug*/loggingBehavior?:'none'|'debug'|'production';/*** Allowlist of plugins to include during `npx cap sync` for Android.** Overrides global `includePlugins` option.**@since3.0.0*/includePlugins?:string[];/*** Android flavor to use.** If the app has flavors declared in the `build.gradle`* configure the flavor you want to run with `npx cap run` command.**@since3.1.0*/flavor?:string;/*** Whether to give the webview initial focus.** Overrides global `initialFocus` option.**@since3.5.1*@defaulttrue*/initialFocus?:boolean;/*** The minimum supported webview version on Android supported by your app.** The minimum supported cannot be lower than version `55`, which is required for Capacitor.** If the device uses a lower WebView version, an error message will be shown on Logcat.* If `server.errorPath` is configured, the WebView will redirect to that file, so can be* used to show a custom error.**@since4.0.0*@default60*/minWebViewVersion?:number;/*** The minimum supported Huawei webview version on Android supported by your app.** The minimum supported cannot be lower than version `10`, which is required for Capacitor.** If the device uses a lower WebView version, an error message will be shown on Logcat.* If `server.errorPath` is configured, the WebView will redirect to that file, so can be* used to show a custom error.**@since4.6.4*@default10*/minHuaweiWebViewVersion?:number;buildOptions?:{/*** Path to your keystore**@since4.4.0*/keystorePath?:string;/*** Password to your keystore**@since4.4.0*/keystorePassword?:string;/*** Alias in the keystore to use**@since4.4.0*/keystoreAlias?:string;/*** Password for the alias in the keystore to use**@since4.4.0*/keystoreAliasPassword?:string;/*** Bundle type for your release build**@since4.4.0*@default"AAB"*/releaseType?:'AAB'|'APK';/*** Program to sign your build with**@since5.1.0*@default"jarsigner"*/signingType?:'apksigner'|'jarsigner';};/*** Use legacy [addJavascriptInterface](https://developer.android.com/reference/android/webkit/WebView#addJavascriptInterface(java.lang.Object,%20java.lang.String))* instead of the new and more secure [addWebMessageListener](https://developer.android.com/reference/androidx/webkit/WebViewCompat#addWebMessageListener(android.webkit.WebView,java.lang.String,java.util.Set%3Cjava.lang.String%3E,androidx.webkit.WebViewCompat.WebMessageListener))**@since4.5.0*@defaultfalse*/useLegacyBridge?:boolean;/*** Make service worker requests go through Capacitor bridge.* Set it to false to use your own handling.**@since7.0.0*@defaulttrue*/resolveServiceWorkerRequests?:boolean;};ios?:{/*** Specify a custom path to the native iOS project.**@since3.0.0*@defaultios*/path?:string;/*** iOS build scheme to use.** Usually this matches your app's target in Xcode. You can use the* following command to list schemes:** ```shell* xcodebuild -workspace ios/App/App.xcworkspace -list* ```**@since3.0.0*@defaultApp*/scheme?:string;/*** User agent of Capacitor Web View on iOS.** Overrides global `overrideUserAgent` option.**@since1.4.0*/overrideUserAgent?:string;/*** String to append to the original user agent of Capacitor Web View for iOS.** Overrides global `appendUserAgent` option.** This is disregarded if `overrideUserAgent` is used.**@since1.4.0*/appendUserAgent?:string;/*** Background color of the Capacitor Web View for iOS.** Overrides global `backgroundColor` option.**@since1.1.0*/backgroundColor?:string;/*** Enable zooming within the Capacitor Web View for iOS.**@defaultfalse*@since6.0.0*/zoomEnabled?:boolean;/*** Configure the scroll view's content inset adjustment behavior.** This will set the* [`contentInsetAdjustmentBehavior`](https://developer.apple.com/documentation/uikit/uiscrollview/2902261-contentinsetadjustmentbehavior)* property on the Web View's* [`UIScrollView`](https://developer.apple.com/documentation/uikit/uiscrollview).**@since2.0.0*@defaultnever*/contentInset?:'automatic'|'scrollableAxes'|'never'|'always';/*** Configure whether the scroll view is scrollable.** This will set the* [`isScrollEnabled`](https://developer.apple.com/documentation/uikit/uiscrollview/1619395-isscrollenabled)* property on the Web View's* [`UIScrollView`](https://developer.apple.com/documentation/uikit/uiscrollview).**@since1.0.0*/scrollEnabled?:boolean;/*** Configure custom linker flags for compiling Cordova plugins.**@since1.0.0*@default[]*/cordovaLinkerFlags?:string[];/*** Allow destination previews when pressing on links.** This will set the* [`allowsLinkPreview`](https://developer.apple.com/documentation/webkit/wkwebview/1415000-allowslinkpreview)* property on the Web View, instead of using the default value.**@since2.0.0*/allowsLinkPreview?:boolean;/*** The build configuration under which Capacitor will generate logs on iOS.** Overrides global `loggingBehavior` option.**@since3.0.0*@defaultdebug*/loggingBehavior?:'none'|'debug'|'production';/*** Allowlist of plugins to include during `npx cap sync` for iOS.** Overrides global `includePlugins` option.**@since3.0.0*/includePlugins?:string[];/*** Sets WKWebView configuration for limitsNavigationsToAppBoundDomains.** If the Info.plist file includes `WKAppBoundDomains` key, it's recommended to* set this option to true, otherwise some features won't work.* But as side effect, it blocks navigation outside the domains in the* `WKAppBoundDomains` list.* `localhost` (or the value configured as `server.hostname`) also needs to be* added to the `WKAppBoundDomains` list.**@since3.1.0*@defaultfalse*/limitsNavigationsToAppBoundDomains?:boolean;/*** The content mode for the web view to use when it loads and renders web content.** - 'recommended': The content mode that is appropriate for the current device.* - 'desktop': The content mode that represents a desktop experience.* - 'mobile': The content mode that represents a mobile experience.**@since4.0.0*@defaultrecommended*/preferredContentMode?:'recommended'|'desktop'|'mobile';/*** Configure if Capacitor will handle local/push notifications.* Set to false if you want to use your own UNUserNotificationCenter to handle notifications.**@since4.5.0*@defaulttrue*/handleApplicationNotifications?:boolean;/*** Using Xcode 14.3, on iOS 16.4 and greater, enable debuggable web content for release builds.** If not set, it's `true` for development builds.**@since4.8.0*@defaultfalse*/webContentsDebuggingEnabled?:boolean;/*** Whether to give the webview initial focus.** Overrides global `initialFocus` option.**@since7.0.0*@defaulttrue*/initialFocus?:boolean;buildOptions?:{/*** The signing style to use when building the app for distribution.**@since7.1.0*@default'automatic'*/signingStyle?:'automatic'|'manual';/*** The method used by xcodebuild to export the archive**@since7.1.0*@default'app-store-connect'*/exportMethod?:string;/*** A certificate name, SHA-1 hash, or automatic selector to use for signing for iOS builds.**@since7.1.0*/signingCertificate?:string;/*** A provisioning profile name or UUID for iOS builds.**@since7.1.0*/provisioningProfile?:string;};};experimental?:{/*** Experimental iOS-specific configuration.** These options may change or be removed in future versions.**@since8.2.0*/ios?:{/*** Swift Package Manager (SPM) specific configuration.**@since8.2.0*/spm?:{/*** Swift tools version to use in Package.swift header.** Defines the minimum version of the Swift compiler version required to build your app.* For more information check the [swift documentation](https://docs.swift.org/swiftpm/documentation/packagemanagerdocs/settingswifttoolsversion/)** Warning: Capacitor does not officially support Swift 6 yet.* Setting this property to 6.0 or higher may cause issues.* If you need to set this property to 6.0 or higher, make sure to throughrouly test your iOS app.** This setting may graduate to `ios.spm.swiftToolsVersion` in a future major release.**@since8.3.0*@default'5.9'*@example'6.1'*/swiftToolsVersion?:string;/*** Define package traits for SPM plugin dependencies.** This requires explicitly setting experimental.ios.spm.swiftToolsVersion* to '6.1' or higher.** The key is the plugin ID (e.g. `@capacitor-firebase/analytics`)* and the value is an array of trait names.** Packages can have default traits. If you use this property, and* want to preserve the defaults, include ".defaults" in the array.** This setting may graduate to `ios.spm.packageTraits` in a future major release.**@since8.3.0*/packageTraits?:{[pluginId:string]:string[]};};};};server?:{/*** Configure the local hostname of the device.** It is recommended to keep this as `localhost` as it allows the use of* Web APIs that would otherwise require a [secure* context](https://developer.mozilla.org/en-US/docs/Web/Security/Secure_Contexts)* such as* [`navigator.geolocation`](https://developer.mozilla.org/en-US/docs/Web/API/Navigator/geolocation)* and* [`MediaDevices.getUserMedia`](https://developer.mozilla.org/en-US/docs/Web/API/MediaDevices/getUserMedia).**@since1.0.0*@defaultlocalhost*/hostname?:string;/*** Configure the local scheme on iOS.** [Can't be set to schemes that the WKWebView already handles, such as http or https](https://developer.apple.com/documentation/webkit/wkwebviewconfiguration/2875766-seturlschemehandler)* This can be useful when migrating from* [`cordova-plugin-ionic-webview`](https://github.com/ionic-team/cordova-plugin-ionic-webview),* where the default scheme on iOS is `ionic`.**@since1.2.0*@defaultcapacitor*/iosScheme?:string;/*** Configure the local scheme on Android.** Custom schemes on Android are unable to change the URL path as of Webview 117. Changing this value from anything other than `http` or `https` can result in your* application unable to resolve routing. If you must change this for some reason, consider using a hash-based url strategy, but there are no guarentees that this* will continue to work long term as allowing non-standard schemes to modify query parameters and url fragments is only allowed for compatibility reasons.* https://ionic.io/blog/capacitor-android-customscheme-issue-with-chrome-117**@since1.2.0*@defaulthttps*/androidScheme?:string;/*** Load an external URL in the Web View.** This is intended for use with live-reload servers.** **This is not intended for use in production.****@since1.0.0*/url?:string;/*** Allow cleartext traffic in the Web View.** On Android, all cleartext traffic is disabled by default as of API 28.** This is intended for use with live-reload servers where unencrypted HTTP* traffic is often used.** **This is not intended for use in production.****@since1.5.0*@defaultfalse*/cleartext?:boolean;/*** Set additional URLs the Web View can navigate to.** By default, all external URLs are opened in the external browser (not* the Web View).** **This is not intended for use in production.****@since1.0.0*@default[]*/allowNavigation?:string[];/*** Specify path to a local html page to display in case of errors.* On Android the html file won't have access to Capacitor plugins.**@since4.0.0*@defaultnull*/errorPath?:string;/*** Append a path to the app URL.** Allows loading from other paths than the default `/index.html`.*@since7.3.0*@defaultnull*/appStartPath?:string;};cordova?:{/*** Populates <access> tags in the config.xml with the origin set to* the values entered here.* If not provided, a single <access origin="*" /> tag gets included.* It only has effect on a few Cordova plugins that respect the whitelist.**@since3.3.0*/accessOrigins?:string[];/*** Configure Cordova preferences.**@since1.3.0*/preferences?:{[key:string]:string|undefined};/*** Fail on cap update/sync if the CLI detects that a cordova plugin* has uninstalled dependencies.**@defaultfalse*@since7.4.0*/failOnUninstalledPlugins?:boolean;};/*** Configure plugins.** This is an object with configuration values specified by plugin class* name.**@since1.0.0*/plugins?:PluginsConfig;/*** Allowlist of plugins to include during `npx cap sync`.** This should be an array of strings representing the npm package name of* plugins to include when running `npx cap sync`. If unset, Capacitor will* inspect `package.json` for a list of potential plugins.**@since3.0.0*/includePlugins?:string[];}exportinterfacePluginsConfig{/*** Plugin configuration by class name.**@since1.0.0*/[key:string]:|{[key:string]:any;}|undefined;/*** Capacitor Cookies plugin configuration**@since4.3.0*/CapacitorCookies?:{/*** Enable CapacitorCookies to override the global `document.cookie` on native.**@defaultfalse*/enabled?:boolean;};/*** Capacitor Http plugin configuration**@since4.3.0*/CapacitorHttp?:{/*** Enable CapacitorHttp to override the global `fetch` and `XMLHttpRequest` on native.**@defaultfalse*/enabled?:boolean;};/*** System Bars plugin configuration**@since8.0.0*/SystemBars?:{/*** Specifies how to handle problematic insets on Android.** This option is only supported on Android.** `css` = Injects CSS variables (`--safe-area-inset-*`) containing correct safe area inset values into the webview.** `disable` = Disable CSS variables injection.**@default"css"*/insetsHandling?:'css'|'disable';/*** The style of the text and icons of the system bars.** This option is only supported on Android.**@default`DEFAULT`*/style?:string;/*** Hide the system bars on start.**@defaultfalse*/hidden?:boolean;/*** The type of status bar animation used when showing or hiding.** This option is only supported on iOS.**@default'FADE'**/animation?:'FADE'|'NONE';};}
```

```
exportinterfaceCapacitorConfig{/*** The unique identifier of your packaged app.** This is also known as the Bundle ID in iOS and the Application ID in* Android. It must be in reverse domain name notation, generally* representing a domain name that you or your company owns.**@since1.0.0*/appId?:string;/*** The human-friendly name of your app.** This should be what you'd see in the App Store, but can be changed after* within each native platform after it is generated.**@since1.0.0*/appName?:string;/*** The directory of your compiled web assets.** This directory should contain the final `index.html` of your app.**@since1.0.0*/webDir?:string;/*** The build configuration (as defined by the native app) under which Capacitor* will send statements to the log system. This applies to log statements in* native code as well as statements redirected from JavaScript (`console.debug`,* `console.error`, etc.). Enabling logging will let statements render in the* Xcode and Android Studio windows but can leak information on device if enabled* in released builds.** 'none' = logs are never produced* 'debug' = logs are produced in debug builds but not production builds* 'production' = logs are always produced**@since3.0.0*@defaultdebug*/loggingBehavior?:'none'|'debug'|'production';/*** User agent of Capacitor Web View.**@since1.4.0*/overrideUserAgent?:string;/*** String to append to the original user agent of Capacitor Web View.** This is disregarded if `overrideUserAgent` is used.**@since1.4.0*/appendUserAgent?:string;/*** Background color of the Capacitor Web View.**@since1.1.0*/backgroundColor?:string;/*** Enable zooming within the Capacitor Web View.**@defaultfalse*@since6.0.0*/zoomEnabled?:boolean;/*** Whether to give the webview initial focus.**@since7.0.0*@defaulttrue*/initialFocus?:boolean;android?:{/*** Specify a custom path to the native Android project.**@since3.0.0*@defaultandroid*/path?:string;/*** User agent of Capacitor Web View on Android.** Overrides global `overrideUserAgent` option.**@since1.4.0*/overrideUserAgent?:string;/*** String to append to the original user agent of Capacitor Web View for Android.** Overrides global `appendUserAgent` option.** This is disregarded if `overrideUserAgent` is used.**@since1.4.0*/appendUserAgent?:string;/*** Background color of the Capacitor Web View for Android.** Overrides global `backgroundColor` option.**@since1.1.0*/backgroundColor?:string;/*** Enable zooming within the Capacitor Web View for Android.**@defaultfalse*@since6.0.0*/zoomEnabled?:boolean;/*** Enable mixed content in the Capacitor Web View for Android.** [Mixed* content](https://developer.mozilla.org/en-US/docs/Web/Security/Mixed_content)* is disabled by default for security. During development, you may need to* enable it to allow the Web View to load files from different schemes.** **This is not intended for use in production.****@since1.0.0*@defaultfalse*/allowMixedContent?:boolean;/*** This enables a simpler keyboard which may have some limitations.** This will capture JS keys using an alternative* [`InputConnection`](https://developer.android.com/reference/android/view/inputmethod/InputConnection).**@since1.0.0*@defaultfalse*/captureInput?:boolean;/*** Always enable debuggable web content.** This is automatically enabled during development.**@since1.0.0*@defaultfalse*/webContentsDebuggingEnabled?:boolean;/*** The build configuration under which Capacitor will generate logs on Android.** Overrides global `loggingBehavior` option.**@since3.0.0*@defaultdebug*/loggingBehavior?:'none'|'debug'|'production';/*** Allowlist of plugins to include during `npx cap sync` for Android.** Overrides global `includePlugins` option.**@since3.0.0*/includePlugins?:string[];/*** Android flavor to use.** If the app has flavors declared in the `build.gradle`* configure the flavor you want to run with `npx cap run` command.**@since3.1.0*/flavor?:string;/*** Whether to give the webview initial focus.** Overrides global `initialFocus` option.**@since3.5.1*@defaulttrue*/initialFocus?:boolean;/*** The minimum supported webview version on Android supported by your app.** The minimum supported cannot be lower than version `55`, which is required for Capacitor.** If the device uses a lower WebView version, an error message will be shown on Logcat.* If `server.errorPath` is configured, the WebView will redirect to that file, so can be* used to show a custom error.**@since4.0.0*@default60*/minWebViewVersion?:number;/*** The minimum supported Huawei webview version on Android supported by your app.** The minimum supported cannot be lower than version `10`, which is required for Capacitor.** If the device uses a lower WebView version, an error message will be shown on Logcat.* If `server.errorPath` is configured, the WebView will redirect to that file, so can be* used to show a custom error.**@since4.6.4*@default10*/minHuaweiWebViewVersion?:number;buildOptions?:{/*** Path to your keystore**@since4.4.0*/keystorePath?:string;/*** Password to your keystore**@since4.4.0*/keystorePassword?:string;/*** Alias in the keystore to use**@since4.4.0*/keystoreAlias?:string;/*** Password for the alias in the keystore to use**@since4.4.0*/keystoreAliasPassword?:string;/*** Bundle type for your release build**@since4.4.0*@default"AAB"*/releaseType?:'AAB'|'APK';/*** Program to sign your build with**@since5.1.0*@default"jarsigner"*/signingType?:'apksigner'|'jarsigner';};/*** Use legacy [addJavascriptInterface](https://developer.android.com/reference/android/webkit/WebView#addJavascriptInterface(java.lang.Object,%20java.lang.String))* instead of the new and more secure [addWebMessageListener](https://developer.android.com/reference/androidx/webkit/WebViewCompat#addWebMessageListener(android.webkit.WebView,java.lang.String,java.util.Set%3Cjava.lang.String%3E,androidx.webkit.WebViewCompat.WebMessageListener))**@since4.5.0*@defaultfalse*/useLegacyBridge?:boolean;/*** Make service worker requests go through Capacitor bridge.* Set it to false to use your own handling.**@since7.0.0*@defaulttrue*/resolveServiceWorkerRequests?:boolean;};ios?:{/*** Specify a custom path to the native iOS project.**@since3.0.0*@defaultios*/path?:string;/*** iOS build scheme to use.** Usually this matches your app's target in Xcode. You can use the* following command to list schemes:** ```shell* xcodebuild -workspace ios/App/App.xcworkspace -list* ```**@since3.0.0*@defaultApp*/scheme?:string;/*** User agent of Capacitor Web View on iOS.** Overrides global `overrideUserAgent` option.**@since1.4.0*/overrideUserAgent?:string;/*** String to append to the original user agent of Capacitor Web View for iOS.** Overrides global `appendUserAgent` option.** This is disregarded if `overrideUserAgent` is used.**@since1.4.0*/appendUserAgent?:string;/*** Background color of the Capacitor Web View for iOS.** Overrides global `backgroundColor` option.**@since1.1.0*/backgroundColor?:string;/*** Enable zooming within the Capacitor Web View for iOS.**@defaultfalse*@since6.0.0*/zoomEnabled?:boolean;/*** Configure the scroll view's content inset adjustment behavior.** This will set the* [`contentInsetAdjustmentBehavior`](https://developer.apple.com/documentation/uikit/uiscrollview/2902261-contentinsetadjustmentbehavior)* property on the Web View's* [`UIScrollView`](https://developer.apple.com/documentation/uikit/uiscrollview).**@since2.0.0*@defaultnever*/contentInset?:'automatic'|'scrollableAxes'|'never'|'always';/*** Configure whether the scroll view is scrollable.** This will set the* [`isScrollEnabled`](https://developer.apple.com/documentation/uikit/uiscrollview/1619395-isscrollenabled)* property on the Web View's* [`UIScrollView`](https://developer.apple.com/documentation/uikit/uiscrollview).**@since1.0.0*/scrollEnabled?:boolean;/*** Configure custom linker flags for compiling Cordova plugins.**@since1.0.0*@default[]*/cordovaLinkerFlags?:string[];/*** Allow destination previews when pressing on links.** This will set the* [`allowsLinkPreview`](https://developer.apple.com/documentation/webkit/wkwebview/1415000-allowslinkpreview)* property on the Web View, instead of using the default value.**@since2.0.0*/allowsLinkPreview?:boolean;/*** The build configuration under which Capacitor will generate logs on iOS.** Overrides global `loggingBehavior` option.**@since3.0.0*@defaultdebug*/loggingBehavior?:'none'|'debug'|'production';/*** Allowlist of plugins to include during `npx cap sync` for iOS.** Overrides global `includePlugins` option.**@since3.0.0*/includePlugins?:string[];/*** Sets WKWebView configuration for limitsNavigationsToAppBoundDomains.** If the Info.plist file includes `WKAppBoundDomains` key, it's recommended to* set this option to true, otherwise some features won't work.* But as side effect, it blocks navigation outside the domains in the* `WKAppBoundDomains` list.* `localhost` (or the value configured as `server.hostname`) also needs to be* added to the `WKAppBoundDomains` list.**@since3.1.0*@defaultfalse*/limitsNavigationsToAppBoundDomains?:boolean;/*** The content mode for the web view to use when it loads and renders web content.** - 'recommended': The content mode that is appropriate for the current device.* - 'desktop': The content mode that represents a desktop experience.* - 'mobile': The content mode that represents a mobile experience.**@since4.0.0*@defaultrecommended*/preferredContentMode?:'recommended'|'desktop'|'mobile';/*** Configure if Capacitor will handle local/push notifications.* Set to false if you want to use your own UNUserNotificationCenter to handle notifications.**@since4.5.0*@defaulttrue*/handleApplicationNotifications?:boolean;/*** Using Xcode 14.3, on iOS 16.4 and greater, enable debuggable web content for release builds.** If not set, it's `true` for development builds.**@since4.8.0*@defaultfalse*/webContentsDebuggingEnabled?:boolean;/*** Whether to give the webview initial focus.** Overrides global `initialFocus` option.**@since7.0.0*@defaulttrue*/initialFocus?:boolean;buildOptions?:{/*** The signing style to use when building the app for distribution.**@since7.1.0*@default'automatic'*/signingStyle?:'automatic'|'manual';/*** The method used by xcodebuild to export the archive**@since7.1.0*@default'app-store-connect'*/exportMethod?:string;/*** A certificate name, SHA-1 hash, or automatic selector to use for signing for iOS builds.**@since7.1.0*/signingCertificate?:string;/*** A provisioning profile name or UUID for iOS builds.**@since7.1.0*/provisioningProfile?:string;};};experimental?:{/*** Experimental iOS-specific configuration.** These options may change or be removed in future versions.**@since8.2.0*/ios?:{/*** Swift Package Manager (SPM) specific configuration.**@since8.2.0*/spm?:{/*** Swift tools version to use in Package.swift header.** Defines the minimum version of the Swift compiler version required to build your app.* For more information check the [swift documentation](https://docs.swift.org/swiftpm/documentation/packagemanagerdocs/settingswifttoolsversion/)** Warning: Capacitor does not officially support Swift 6 yet.* Setting this property to 6.0 or higher may cause issues.* If you need to set this property to 6.0 or higher, make sure to throughrouly test your iOS app.** This setting may graduate to `ios.spm.swiftToolsVersion` in a future major release.**@since8.3.0*@default'5.9'*@example'6.1'*/swiftToolsVersion?:string;/*** Define package traits for SPM plugin dependencies.** This requires explicitly setting experimental.ios.spm.swiftToolsVersion* to '6.1' or higher.** The key is the plugin ID (e.g. `@capacitor-firebase/analytics`)* and the value is an array of trait names.** Packages can have default traits. If you use this property, and* want to preserve the defaults, include ".defaults" in the array.** This setting may graduate to `ios.spm.packageTraits` in a future major release.**@since8.3.0*/packageTraits?:{[pluginId:string]:string[]};};};};server?:{/*** Configure the local hostname of the device.** It is recommended to keep this as `localhost` as it allows the use of* Web APIs that would otherwise require a [secure* context](https://developer.mozilla.org/en-US/docs/Web/Security/Secure_Contexts)* such as* [`navigator.geolocation`](https://developer.mozilla.org/en-US/docs/Web/API/Navigator/geolocation)* and* [`MediaDevices.getUserMedia`](https://developer.mozilla.org/en-US/docs/Web/API/MediaDevices/getUserMedia).**@since1.0.0*@defaultlocalhost*/hostname?:string;/*** Configure the local scheme on iOS.** [Can't be set to schemes that the WKWebView already handles, such as http or https](https://developer.apple.com/documentation/webkit/wkwebviewconfiguration/2875766-seturlschemehandler)* This can be useful when migrating from* [`cordova-plugin-ionic-webview`](https://github.com/ionic-team/cordova-plugin-ionic-webview),* where the default scheme on iOS is `ionic`.**@since1.2.0*@defaultcapacitor*/iosScheme?:string;/*** Configure the local scheme on Android.** Custom schemes on Android are unable to change the URL path as of Webview 117. Changing this value from anything other than `http` or `https` can result in your* application unable to resolve routing. If you must change this for some reason, consider using a hash-based url strategy, but there are no guarentees that this* will continue to work long term as allowing non-standard schemes to modify query parameters and url fragments is only allowed for compatibility reasons.* https://ionic.io/blog/capacitor-android-customscheme-issue-with-chrome-117**@since1.2.0*@defaulthttps*/androidScheme?:string;/*** Load an external URL in the Web View.** This is intended for use with live-reload servers.** **This is not intended for use in production.****@since1.0.0*/url?:string;/*** Allow cleartext traffic in the Web View.** On Android, all cleartext traffic is disabled by default as of API 28.** This is intended for use with live-reload servers where unencrypted HTTP* traffic is often used.** **This is not intended for use in production.****@since1.5.0*@defaultfalse*/cleartext?:boolean;/*** Set additional URLs the Web View can navigate to.** By default, all external URLs are opened in the external browser (not* the Web View).** **This is not intended for use in production.****@since1.0.0*@default[]*/allowNavigation?:string[];/*** Specify path to a local html page to display in case of errors.* On Android the html file won't have access to Capacitor plugins.**@since4.0.0*@defaultnull*/errorPath?:string;/*** Append a path to the app URL.** Allows loading from other paths than the default `/index.html`.*@since7.3.0*@defaultnull*/appStartPath?:string;};cordova?:{/*** Populates <access> tags in the config.xml with the origin set to* the values entered here.* If not provided, a single <access origin="*" /> tag gets included.* It only has effect on a few Cordova plugins that respect the whitelist.**@since3.3.0*/accessOrigins?:string[];/*** Configure Cordova preferences.**@since1.3.0*/preferences?:{[key:string]:string|undefined};/*** Fail on cap update/sync if the CLI detects that a cordova plugin* has uninstalled dependencies.**@defaultfalse*@since7.4.0*/failOnUninstalledPlugins?:boolean;};/*** Configure plugins.** This is an object with configuration values specified by plugin class* name.**@since1.0.0*/plugins?:PluginsConfig;/*** Allowlist of plugins to include during `npx cap sync`.** This should be an array of strings representing the npm package name of* plugins to include when running `npx cap sync`. If unset, Capacitor will* inspect `package.json` for a list of potential plugins.**@since3.0.0*/includePlugins?:string[];}exportinterfacePluginsConfig{/*** Plugin configuration by class name.**@since1.0.0*/[key:string]:|{[key:string]:any;}|undefined;/*** Capacitor Cookies plugin configuration**@since4.3.0*/CapacitorCookies?:{/*** Enable CapacitorCookies to override the global `document.cookie` on native.**@defaultfalse*/enabled?:boolean;};/*** Capacitor Http plugin configuration**@since4.3.0*/CapacitorHttp?:{/*** Enable CapacitorHttp to override the global `fetch` and `XMLHttpRequest` on native.**@defaultfalse*/enabled?:boolean;};/*** System Bars plugin configuration**@since8.0.0*/SystemBars?:{/*** Specifies how to handle problematic insets on Android.** This option is only supported on Android.** `css` = Injects CSS variables (`--safe-area-inset-*`) containing correct safe area inset values into the webview.** `disable` = Disable CSS variables injection.**@default"css"*/insetsHandling?:'css'|'disable';/*** The style of the text and icons of the system bars.** This option is only supported on Android.**@default`DEFAULT`*/style?:string;/*** Hide the system bars on start.**@defaultfalse*/hidden?:boolean;/*** The type of status bar animation used when showing or hiding.** This option is only supported on iOS.**@default'FADE'**/animation?:'FADE'|'NONE';};}
```

```
CAPACITOR_ANDROID_STUDIO_PATH
```

```
CAPACITOR_COCOAPODS_PATH
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
- Cordova/PhoneGapOverviewMigrating StrategyCordova to Capacitor Migration
- Overview
- Migrating Strategy
- Cordova to Capacitor Migration
- ConceptsAdsAngularAutofill CredentialsAutomated ConfigurationCI/CDDeep LinksDeploying and UpdatingEnvironment Specific ConfigurationsGamesIn App PurchasesLive ReloadMocking PluginsPush Notifications - FirebaseReact HooksScreen OrientationSecuritySplash Screens and IconsStorageCommunity Guides
- Ads
- Angular
- Autofill Credentials
- Automated Configuration
- CI/CD
- Deep Links
- Deploying and Updating
- Environment Specific Configurations
- Games
- In App Purchases
- Live Reload
- Mocking Plugins
- Push Notifications - Firebase
- React Hooks
- Screen Orientation
- Security
- Splash Screens and Icons
- Storage
- Community Guides
- iOSGetting StartedConfiguring iOSCustom Native iOS CodePrivacy ManifestDeploying to App StoreCustom ViewControllerTroubleshootingSwift Package Manager
- Getting Started
- Configuring iOS
- Custom Native iOS Code
- Privacy Manifest
- Deploying to App Store
- Custom ViewController
- Troubleshooting
- Swift Package Manager
- AndroidGetting StartedConfigurationCustom Native CodeSetting Target SDKDeploying to Google PlayTroubleshooting
- Getting Started
- Configuration
- Custom Native Code
- Setting Target SDK
- Deploying to Google Play
- Troubleshooting
- Web/PWAGetting StartedBuilding Progressive Web AppsPWA Elements
- Getting Started
- Building Progressive Web Apps
- PWA Elements
- ReferenceConfigCapacitor iOS APICapacitor Android APICapacitor Web APICapacitor Data TypesPersisting Plugin CallsPlugin APIsSupport PolicyCLI
- Config
- Capacitor iOS API
- Capacitor Android API
- Capacitor Web API
- Capacitor Data Types
- Persisting Plugin Calls
- Plugin APIs
- Support Policy
- CLI

- Introduction
- Environment Setup
- Installing Capacitor
- Building Your UI
- Using with Ionic Framework
- VS Code Extension
- Capacitor Templates
- FAQs

- Development Workflow
- Using Plugins
- Configuring Your App
- JavaScript API

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

- Overview
- Migrating Strategy
- Cordova to Capacitor Migration

- Ads
- Angular
- Autofill Credentials
- Automated Configuration
- CI/CD
- Deep Links
- Deploying and Updating
- Environment Specific Configurations
- Games
- In App Purchases
- Live Reload
- Mocking Plugins
- Push Notifications - Firebase
- React Hooks
- Screen Orientation
- Security
- Splash Screens and Icons
- Storage
- Community Guides

- Getting Started
- Configuring iOS
- Custom Native iOS Code
- Privacy Manifest
- Deploying to App Store
- Custom ViewController
- Troubleshooting
- Swift Package Manager

- Getting Started
- Configuration
- Custom Native Code
- Setting Target SDK
- Deploying to Google Play
- Troubleshooting

- Getting Started
- Building Progressive Web Apps
- PWA Elements

- Config
- Capacitor iOS API
- Capacitor Android API
- Capacitor Web API
- Capacitor Data Types
- Persisting Plugin Calls
- Plugin APIs
- Support Policy
- CLI

- Community Hub
- Forum
- Blog
- Twitter

- Help Center
- Customer Support
- Enterprise Advisory

- English
- 日本語

- CAPACITOR_ANDROID_STUDIO_PATH: The path to Android Studio executable on your system.
- CAPACITOR_COCOAPODS_PATH: The path to thepodbinary on your system.

- Example
- Schema
- Environment Variables