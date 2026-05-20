# Screen orientation

## Fuente
CapacitorJS — Documentación Oficial (Cap. 31)

## Contenido
## Products

## Open Source

# Building Progressive Web Apps

## What is a Progressive Web App?​

## Capacitor and Progressive Web Apps​

## Adding Progressive Web App Support to your app​

### App Manifest​

### Service Worker​

## Progressive Web App Performance​

## Contents

Capacitor has first-class support for Progressive Web Apps, making it easy to build an app that runs natively on iOS and Android, but also on the web as a mobile web app or "Progressive Web App."

Put simply, a Progressive Web App (PWA) is a web app that uses modern web capabilities to deliver an app-like experience to users. These apps are deployed to traditional web servers, are accessible through URLs, and can be indexed by search engines.

A Progressive Web App is, for all practical purposes, just another term for a website that has been optimized for mobile performance and that utilizes newly available Web APIs to deliver features that are similar to a traditional native app, such as push notifications and offline storage.

Capacitor has first-class support for Progressive Web Appsandnative apps. That means that Capacitor's bridge supports running in either a native context or in the web, with many plugins availablein both contextswith the exact same API and calling conventions.

This means you use@capacitor/coreand Capacitor plugins as dependencies for both your native appandyour Progressive Web App, and Capacitor seamlessly calls web code when required and native code when available.

Additionally, Capacitor offers a number of utilities for querying the current platform to provide customized experiences when running natively or on the web.

Progressive Web Apps should have an App Manifest and a Service Worker.

First, you'll need anApp Manifestfile (manifest.json) that sits alongside yourindex.htmlfile and provides metadata about your app, such as its name, theme colors, and icons. This information will be used when your app is installed on the home screen, for example.

Next, in order to send push notifications and store data offline, aService Workerwill enable your web app to proxy network requests and perform background tasks needed to process and sync data.

Service Workers are powerful, but complicated. Generally, writing them from scratch is not recommended. Instead, take a look at tools likeWorkboxthat provide common Service Worker recipes that you can easily incorporate into your app.

Read more about using Service Workers, including how to register them, on theUsing Service Workerspage on MDN.

Progressive Web Apps are judged by several performance standards, includingTime to InteractiveandFirst Meaningful Paint.

Follow theProgressive Web App Checklistbefore going live, and useLighthouseto audit and test your app.

If you're struggling to meet Progressive Web App performance standards with your existing frontend stack, take a look atIonic Frameworkas an option for getting fast PWA support with nearly zero configuration.

Micro Frontends for any React Native, Android, or iOS mobile apps.

## Código

```
@capacitor/core
```

```
index.html
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
- iOSGetting StartedConfiguring iOSCustom Native 

> [Contenido truncado — consulta el capítulo completo con knowledge read]
