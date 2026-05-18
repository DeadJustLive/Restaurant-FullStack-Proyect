# Ads

## Products

## Open Source

# Configuring iOS

## ConfiguringInfo.plist​

## Managing Permissions​

## Setting Capabilities​

## Renaming your App​

## Deeplinks (aka Universal Links)​

## iPadOS 26​

## Contents

TheInfo.plistfile is the main configuration file for iOS apps. You may need to edit it whenever a Capacitor plugin requires new settings or permissions.

To modify it,open your project in Xcode, select theAppproject and theApptarget, and click theInfotab.

You can show the true key names by right-clicking in the table and checkingRaw Keys & Valuesin the context menu.

You can also open and edit theios/App/App/Info.plistfile manually to inspect the raw keys. Usethis reference documentationfor a list of possible keys.

iOS permissions do not need to be specified explicitly like they are in Android. However, iOS requires "Usage Descriptions" to be defined inInfo.plist. These settings are human-readable descriptions that will be presented to the end user when permission is requested for a particular device API.

Consult theCocoa Keyslist for keys containingUsageDescriptionto see the various usage description settings that may be required for your app.

For more information, Apple has provided a guide toResolving the Privacy-Sensitive Data App Rejectionwhich contains more information on APIs that require usage descriptions.

Capabilities are used to enable key features that your app may need. You may need to configure them whenever a Capacitor plugin requires it.

Unlike other configuration options and usage descriptions, capabilities arenotconfigured inInfo.plist.

To add a new capability,open your app in Xcode, select theAppproject and theApptarget, clickSigning & Capabilitiesin the tab bar, and then click the+ Capabilitybutton. Seethis articlefor more information about iOS capabilities.

You can't rename theAppdirectory, but you can set the name of your app by renaming theApptarget.

To rename theApptarget,open your project in Xcode, select theAppproject, and double-click theApptarget.

Then, openios/App/Podfileand rename the current target at the bottom of the file:

Finally, add theschemeattribute inside theiosobject in theCapacitor configuration file.

For a Deep Links guide,see here.

Starting in iPadOS 26, Apple has added new window controls to make the experience more desktop-like.  These controls may overlap your app interface:

To fix this add the following entry to yourInfo.plist:UIDesignRequiresCompatibility = YES:

This should prevent the controls from overlapping:

This is a temporary fix until we add further configuration over the windowing controls in future versions of Capacitor.

Mobile CI/CD made easy. Build, publish, and update from the cloud.

## Código

```
Info.plist
```

```
Info.plist
```

```
ios/App/App/Info.plist
```

```
Info.plist
```

```
UsageDescription
```

```
Info.plist
```

```
ios/App/Podfile
```

```
-target 'App' do+target 'MyRenamedApp' docapacitor_pods# Add your Pods hereend
```

```
-target 'App' do+target 'MyRenamedApp' docapacitor_pods# Add your Pods hereend
```

```
scheme
```

```
Info.plist
```

```
UIDesignRequiresCompatibility = YES
```

```
Info.plist
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

- ConfiguringInfo.plist
- Managing Permissions
- Setting Capabilities
- Renaming your App
- Deeplinks (aka Universal Links)
- iPadOS 26