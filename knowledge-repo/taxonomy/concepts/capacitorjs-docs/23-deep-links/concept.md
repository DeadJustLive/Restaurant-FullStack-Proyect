# Deep links

## Fuente
CapacitorJS — Documentación Oficial (Cap. 23)

## Contenido
## Products

## Open Source

# iOS Troubleshooting Guide

## iOS Toolbox​

### Google, Google, Google​

### Clean/Rebuild​

### Removing Derived Data​

## Error: Sandbox not in sync with the Podfile.lock​

## Indexing FOREVER​

## CocoaPods: Failed to connect to GitHub​

## Plugin Not Implemented​

## Contents

Creating a 100% perfect native management tool is nearly impossible, and sooner or later you'll run into various issues with some part of the iOS workflow.

This guide attempts to document common iOS/Xcode issues with possible solutions.

Every iOS developer learns a few common techniques for debugging iOS issues, and you should incorporate these into your workflow:

Any time you encounter an issue with iOS, or Xcode, your first step should be to copy and paste the error into a Google search.

Capacitor uses the standard iOS toolchain, so chances are if you run into something, many iOS developers have as well, and there's a solution out there.

It could be as simple as updating a dependency, running clean, or removing Derived Data.

Cleaning and rebuilding can fix a number of build issues. Navigate to Product -> Clean Build Folder in the Xcode menu to clean your current build.

Sometimes, Xcode clings to old, outdated build artifacts. To start fresh, you'll need to delete any Derived Data on disk.

To do this, open Xcode Preferences, choose the Locations tab, and click the small arrow next to your Derived Data path:

This opens a Finder window to the location of Xcode's temporary Derived Data.

Next, select all items in that directory and delete:

Finally, do a rebuild in Xcode.

This error can happen if CocoaPods hasn't been able to run to install your dependencies.

Run this to update your pods:

Perform a new build after running this command.

Xcode sometimes gets stuck indexing forever. This unfortunate situation looks like this:

The only solution is to Force Close Xcode (using Activity Monitor) and start it up again.

This error can happen on Macs with an old version of openssl and ruby installed, since GitHub
restricted the allowed cryptographic protocols when accessing repos.

The solution is to update openssl and update Ruby:

Finally, make sure yourPATHenvironment variable does not put/usr/local/binafter$PATH, but ratherbeforeit.

Seethis StackOverflow issuefor other possible solutions to this problem.

On iOS, this can happen if Capacitor doesn't find the plugins or can't inject its code into the WebView.

First of all, make sure the plugin is installed and appears in thepackage.json.

Then, runnpx cap sync ios.

Finally, check that the plugin is inios/App/Podfile. If the plugin is not listed, make sure your Podfile looks likethis oneand runnpx cap syncagain.

If still getting the "Plugin not implemented" error, make sure you don't haveWKAppBoundDomainskey inios/App/App/Info.plist, that prevents Capacitor's and Plugins code from injecting. Remove the key if not needed, or if it can't be removed, addlimitsNavigationsToAppBoundDomainsto your capacitor config file withtruevalue inside theiosobject.

Micro Frontends for any React Native, Android, or iOS mobile apps.

## Código

```
npx cap update ios
```

```
npx cap update ios
```

```
brewinstallopensslbrew upgrade opensslbrewinstallrubybrewlink--overwriteruby
```

```
brewinstallopensslbrew upgrade opensslbrewinstallrubybrewlink--overwriteruby
```

```
/usr/local/bin
```

```
package.json
```

```
npx cap sync ios
```

```
ios/App/Podfile
```

```
npx cap sync
```

```
WKAppBoundDomains
```

```
ios/App/App/Info.plist
```

```
limitsNavigationsToAppBoundDomains
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
- ConceptsAdsAngularAutofill CredentialsAutomated ConfigurationCI/CDDeep LinksDeploying and UpdatingEnvironment Specific ConfigurationsGamesIn App PurchasesLive ReloadMocking Plu

> [Contenido truncado — consulta el capítulo completo con knowledge read]
