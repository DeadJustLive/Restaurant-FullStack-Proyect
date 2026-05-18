# Community

## Fuente
CapacitorJS — Documentación Oficial (Cap. 22)

## Contenido
# Community

## Products

## Open Source

# Capacitor Android API

## Bridge​

### getConfig()​

### triggerJSEvent(...)​

## Passing data​

## Saving CAPPluginCall​

## Contents

Capacitor Android is the native runtime that powers Capacitor apps on Android.

The Android bridge is the heart of the Capacitor Android library. There are several methods available on the bridge which provide information or change behavior.

When registered with Capacitor, plugins have access to the bridge:

This property contains the configuration object known to the Capacitor runtime.

Fire an event on a JavaScriptEventTargetsuch aswindowordocument. If possible, it is preferred to usePlugin Eventsinstead.

Note:datamust be a serialized JSON string value.

Notes on how to work with data that is passed between environments can befound here.

Notes on persisting plugin calls for asynchronous or repeated operations can befound here.

Mobile CI/CD made easy. Build, publish, and update from the cloud.

## Código

```
this.bridge
```

```
this.bridge
```

```
publicCapConfiggetConfig()
```

```
publicCapConfiggetConfig()
```

```
publicvoidtriggerJSEvent(finalStringeventName,finalStringtarget)publicvoidtriggerJSEvent(finalStringeventName,finalStringtarget,finalStringdata)
```

```
publicvoidtriggerJSEvent(finalStringeventName,finalStringtarget)publicvoidtriggerJSEvent(finalStringeventName,finalStringtarget,finalStringdata)
```

```
EventTarget
```

```
window
```

```
document
```

```
bridge.triggerJSEvent("myCustomEvent","window");bridge.triggerJSEvent("myCustomEvent","document","{ 'dataKey': 'dataValue' }");
```

```
bridge.triggerJSEvent("myCustomEvent","window");bridge.triggerJSEvent("myCustomEvent","document","{ 'dataKey': 'dataValue' }");
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
- Updat
