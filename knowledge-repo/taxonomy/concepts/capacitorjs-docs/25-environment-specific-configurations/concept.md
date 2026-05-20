# Environment specific configurations

## Fuente
CapacitorJS — Documentación Oficial (Cap. 25)

## Contenido
## Products

## Open Source

# Capacitor Android Documentation

## Android Support​

## Adding the Android Platform​

## Opening the Android Project​

## Running Your App​

### Running on the Command-Line​

### Running with Android Studio​

## Troubleshooting​

## Next Steps​

## Further Reading​

## Contents

Capacitor features a native Android runtime that enables developers to communicate between JavaScript and Native Java or Kotlin code.

Capacitor Android apps are configured and managed through Android Studio.

API 24+ (Android 7 or later) is supported, which represents around 99% of the Android market. Capacitor requires an Android WebView with Chrome version 60 or later. On Android 7-9,Google Chromeprovides the WebView. On Android 10+ Capacitor uses theAndroid System WebView.

First, install the@capacitor/androidpackage.

Then, add the Android platform.

To open the project in Android Studio, run:

Alternatively, you can open Android Studio and import theandroid/directory as an Android Studio project.

You can either run your app on the command-line or with Android Studio.

To use an Android Emulator you must use an API 24+ system image. The System WebView does not automatically update on emulators. Physical devices should work as low as API 24 as long as their System WebView is updated.

To run the project on a device or emulator, run:

The command will prompt you to select a target.Learn more aboutrun.

Either a physical Android device or a downloaded emulator system image is required to use theruncommand. See thedocumentation here for creating emulator devices and downloading system images in Android Studio.

In Android Studio, first select the device or emulator and then click the run or debug button to run your app. Unless you're debugging Java or Kotlin code, the run button is preferred.

If you encountered any issues while getting started, you can consult theAndroid Troubleshooting Guide. Feel free toopen a discussionif you need help.

If your app ran you are now ready to continue developing and building your app. Use the various APIs available, Capacitor or Cordova plugins, or custom native code to build out the rest of your app.

Follow these Android-specific guides for more information on setting permissions for your app, updating dependencies, building plugins, and more:

Configuring and setting permissions for Android ›

Building Native Plugins for Android ›

Micro Frontends for any React Native, Android, or iOS mobile apps.

## Código

```
@capacitor/android
```

```
npminstall@capacitor/android
```

```
npminstall@capacitor/android
```

```
npx capaddandroid
```

```
npx capaddandroid
```

```
npx capopenandroid
```

```
npx capopenandroid
```

```
android/
```

```
npx cap run android
```

```
npx cap run android
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
- AndroidGetting StartedC

> [Contenido truncado — consulta el capítulo completo con knowledge read]
