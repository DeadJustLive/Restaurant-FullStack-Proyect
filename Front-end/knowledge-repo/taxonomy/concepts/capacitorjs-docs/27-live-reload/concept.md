# Live reload

## Fuente
CapacitorJS — Documentación Oficial (Cap. 27)

## Contenido
# Live reload

## Products

## Open Source

# Setting Android Target SDK

## Capacitor Android Requirements​

## Android Target SDK Matrix​

## Custom Target SDK Versions​

## Contents

All Android applications must specify a target SDK version, or the version of Android that the application is designed to run on. Each year, Google releases updates to the Android operating system and subsequently bumps the version number that applications are required to target. Typically,this date is August 31stof each year. Because of this, it is important to keep your application up to date with the latest version of Android. In a Capacitor application, this is done by specifying your target SDK in the/android/variables.gradlefile.

In Capacitor, the Android target SDK version is strongly tied to the major version of Capacitor. This means that while you could change the target SDK to a higher version and rebuild your application, there's a very strong likelihood that your application will experience issues not otherwise present. The Capacitor team releases a new major version of Capacitor every year that includes support for the new target SDK version to ensure that applications remain compliant with Google's requirements. For this reason, it is important to keep your application up to date with the latest major version of Capacitor.

The following table shows the target SDK versions that are supported by Capacitor Android.

Capacitor Android does not support custom target SDK versions. Each version of Capacitor Android requires a specific target SDK version and support is only provided for that matching version.

Micro Frontends for any React Native, Android, or iOS mobile apps.

## Código

```
/android/variables.gradle
```

```
targetSdkVersion=36
```

```
targetSdkVersion=36
```

| Capacitor Android | Target SDK Version |
| --- | --- |
| 8.x | 36 |
| 7.x | 35 |
| 6.x | 34 |
| 5.x | 33 |
| 4.x | 32 |
| 3.x | 30 |
| 2.x | 29 |
| 1.x | 28 |

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
- Usi
