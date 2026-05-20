# Autofill credentials

## Products

## Open Source

# Privacy Manifest

## Steps to Meet Requirements​

### VS Code Extension​

### Manual Steps​

## Before Store Submission​

## Contents

Apple recently introduced newprivacy protocols for third-party SDKsat WWDC23, requiring SDK authors to declare approved reasons for API usage within their SDKs to enhance transparency and user privacy.

Starting March 13th, 2024, App Store Connect will notify users when a new or updated app is uploaded without approved reasons to access certain APIs.

Starting May 1st, 2024, you will be required to include approved reasons when submitting a new or updated app to App Store Connect.

Not all Applications will be flagged but certain plugins such as@capacitor/filesystemand@capacitor/preferencesmay necessitate a Privacy Manifest File. If you have received a notification:

Make sure you have theIonic VS Code extensioninstalled and open your project.

Under recommendations you will seeAdd Privacy Manifestif your application is using a plugin that uses certain APIs.

Choose Yes to create the bare minimum privacy manifest file.

The extension will then list all changes needed as recommendations titledMissing Privacy Manifest Category. For example:

You must select one of the reason codes to explain how you use the plugin. If you are unsure, clickDocsto go to the Apple’s documentation on the explanations of each reason code.

Please note that the VS Code extension has a set of rules for known plugins to help you. If you are still being rejected by Apple for missing privacy manifest reasons it may be that you are using a plugin that the extension does not know. You can open an issue on theVS Code extension issue tracker.

If you would prefer to perform the steps for creating a Privacy Manifest file manually open Xcode then:

ChooseFile > New File.

Scroll down to theResourcesection and selectApp Privacy Filetype.

Check your app in theTargetslist.

A file calledPrivacyInfo.xcprivacywill be created. This file is challenging to create interactively in the Xcode UI so it may be easier to edit it manually by right clicking it and choosingOpen with External Editor.

As a sample file here is aPrivacyInfo.xcprivacyfile that uses the UserDefaults API through its use of the@capacitor/preferencesplugin.

To find code and plugins which may require privacy manifest changes you can use a script likethis oneby runningsh required_reason_api_text_scanner.sh node_modules.

To choose the correct reason codes (likeCA92.1in the above example) you will need to readApple’s documentation.

Before App store submission you may need to disclose user tracking, tracking domains or collection of other data types that are unique for your application. SeeApple’s documentationfor more information.

Mobile CI/CD made easy. Build, publish, and update from the cloud.

## Código

```
@capacitor/filesystem
```

```
@capacitor/preferences
```

```
>= 7.0.0
```

```
>= 6.0.0
```

```
>= 5.7.4
```

```
>= 4.8.2
```

```
PrivacyInfo.xcprivacy
```

```
PrivacyInfo.xcprivacy
```

```
@capacitor/preferences
```

```
<?xml version="1.0" encoding="UTF-8"?><!DOCTYPEplistPUBLIC"-//Apple//DTD PLIST 1.0//EN""http://www.apple.com/DTDs/PropertyList-1.0.dtd"><plistversion="1.0"><dict><key>NSPrivacyTracking</key><false/><key>NSPrivacyAccessedAPITypes</key><array><dict><key>NSPrivacyAccessedAPIType</key><string>NSPrivacyAccessedAPICategoryUserDefaults</string><key>NSPrivacyAccessedAPITypeReasons</key><array><string>CA92.1</string></array></dict></array><key>NSPrivacyTrackingDomains</key><array/></dict></plist>
```

```
<?xml version="1.0" encoding="UTF-8"?><!DOCTYPEplistPUBLIC"-//Apple//DTD PLIST 1.0//EN""http://www.apple.com/DTDs/PropertyList-1.0.dtd"><plistversion="1.0"><dict><key>NSPrivacyTracking</key><false/><key>NSPrivacyAccessedAPITypes</key><array><dict><key>NSPrivacyAccessedAPIType</key><string>NSPrivacyAccessedAPICategoryUserDefaults</string><key>NSPrivacyAccessedAPITypeReasons</key><array><string>CA92.1</string></array></dict></array><key>NSPrivacyTrackingDomains</key><array/></dict></plist>
```

```
sh required_reason_api_text_scanner.sh node_modules
```

```
CA92.1
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

- Update Capacitor to:
a.>= 7.0.0for Capacitor 7
b.>= 6.0.0for Capacitor 6
c.>= 5.7.4for Capacitor 5
d.>= 4.8.2for Capacitor 4
e. Capacitor <= 3 is not supported
- Use either the VS Code Extension to create the privacy manifest file for your app or create it manually.

- Steps to Meet RequirementsVS Code ExtensionManual Steps
- VS Code Extension
- Manual Steps
- Before Store Submission

- VS Code Extension
- Manual Steps