# Cordova

## Products

## Open Source

# Data Storage in Capacitor

## Why can't I just use LocalStorage or IndexedDB?​

## Capacitor Preferences API​

## Large data or high performance storage options​

## Contents

Most apps need to persist and read local data. Depending on the specific use case, there are a few approaches one can take.

Need your local data encrypted? Ionic provides an out of the box security suite for Capacitor apps that includes Authentication, Biometrics, and Secure Storage.Learn more.

Since Capacitor apps run primarily in a web view or browser, Web APIs for storage are available to Capacitor developers. However, there are some major caveats to keep in mind with these APIs.

Local Storage can be used for small amounts of temporary data, such as a user id, butmust be considered transient, meaning your app needs to expect that the data will be lost eventually. This is because the OS will reclaim local storage from Web Views if a device is running low on space. The same can be said for IndexedDB at least on iOS (on Android, thepersisted storage APIis available to mark IndexedDB as persisted). Read more ondata storage eviction policiesin the browser.

Capacitor comes with a nativePreferences APIthat avoids the eviction issues above, but is meant for small amounts of data.

The Preferences API provides a simple key/value API with no advanced query support:

For storing large amounts of data and accessing it in a high performance way, there are a few options.

The most widely supported option is SQLite. There are a number of community-maintained SQLite plugins that should work in Capacitor, includingcapacitor-sqliteandcordova-plugin-sqlite.

The Capacitor team also offers anenterprise SQLite storage solutionwith encryption support and integration withsecure key management APIson device.

Mobile CI/CD made easy. Build, publish, and update from the cloud.

## Código

```
import{Preferences}from'@capacitor/preferences';// JSON "set" exampleasyncsetObject(){awaitPreferences.set({key:'user',value:JSON.stringify({id:1,name:'Max'})});}// JSON "get" exampleasyncgetObject(){constret=awaitPreferences.get({key:'user'});constuser=JSON.parse(ret.value);}
```

```
import{Preferences}from'@capacitor/preferences';// JSON "set" exampleasyncsetObject(){awaitPreferences.set({key:'user',value:JSON.stringify({id:1,name:'Max'})});}// JSON "get" exampleasyncgetObject(){constret=awaitPreferences.get({key:'user'});constuser=JSON.parse(ret.value);}
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

- Why can't I just use LocalStorage or IndexedDB?
- Capacitor Preferences API
- Large data or high performance storage options