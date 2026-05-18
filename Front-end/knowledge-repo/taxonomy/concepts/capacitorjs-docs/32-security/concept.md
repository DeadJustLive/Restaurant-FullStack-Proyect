# Security

## Fuente
CapacitorJS — Documentación Oficial (Cap. 32)

## Contenido
# Security

## Products

## Open Source

# PWA Elements

## Installation​

#### Importing PWA Elements​

#### Including through script tag​

## Contents

Some Capacitor plugins, such asCameraorToast, have web-based UI available when not running natively. For example, callingCamera.getPhoto()will load a responsive photo-taking experience when running on the web:

This UI is implemented using web components. Due to the elements being encapsulated by theShadow DOM, these components should not conflict
with your own UI.

To enable these controls, you must add@ionic/pwa-elementsto your app.

A typical installation involves importing the package and registering the elements, or adding a script tag to the<head>of theindex.htmlfor your app:

Then, depending on your framework of choice, import the element loader and call it at the correct time:

main.tsxorindex.tsxorindex.js:

PWA Elements can be included through a script tag in yourindex.html. However, keep in mind this will not work for offline scenarios:

Micro Frontends for any React Native, Android, or iOS mobile apps.

## Código

```
Camera
```

```
Camera.getPhoto()
```

```
@ionic/pwa-elements
```

```
<head>
```

```
index.html
```

```
npminstall@ionic/pwa-elements
```

```
npminstall@ionic/pwa-elements
```

```
main.tsx
```

```
index.tsx
```

```
index.js
```

```
import{defineCustomElements}from'@ionic/pwa-elements/loader';// Call the element loader before the render calldefineCustomElements(window);
```

```
import{defineCustomElements}from'@ionic/pwa-elements/loader';// Call the element loader before the render calldefineCustomElements(window);
```

```
main.ts
```

```
// Above the createApp() lineimport{defineCustomElements}from'@ionic/pwa-elements/loader';defineCustomElements(window);
```

```
// Above the createApp() lineimport{defineCustomElements}from'@ionic/pwa-elements/loader';defineCustomElements(window);
```

```
main.ts
```

```
import{defineCustomElements}from'@ionic/pwa-elements/loader';// Call the element loader before the bootstrapModule/bootstrapApplication calldefineCustomElements(window);if(environment.production){enableProdMode();}
```

```
import{defineCustomElements}from'@ionic/pwa-elements/loader';// Call the element loader before the bootstrapModule/bootstrapApplication calldefineCustomElements(window);if(environment.production){enableProdMode();}
```

```
index.html
```

```
<scripttype="module"src="https://unpkg.com/@ionic/pwa-elements@latest/dist/ionicpwaelements/ionicpwaelements.esm.js"></script><scriptnomodulesrc="https://unpkg.com/@ionic/pwa-elements@latest/dist/ionicpwaelements/ionicpwaelements.js"></script>
```

```
<scripttype="module"src="https://unpkg.com/@ionic/pwa-elements@latest/dist/ionicpwaelements/ionicpwaelements.esm.js"></script><scriptnomodulesrc="https://unpkg.com/@ionic/pwa-elements@latest/dist/ionicpwaelements/ionicpwaelements.js"></script>
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
- Deplo
