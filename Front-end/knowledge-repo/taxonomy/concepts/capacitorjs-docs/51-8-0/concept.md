# 8 0

## Fuente
CapacitorJS — Documentación Oficial (Cap. 51)

## Contenido
# 8 0

## Products

## Open Source

# Deep Linking with Universal and App Links

## Demo Video​

## Prerequisites​

## Deep Link Routing using the Capacitor App API​

### Angular​

### React​

### Vue​

## Creating Site Association Files​

## iOS Configuration​

### Create Site Association File​

### Add Associated Domain​

## Android Configuration​

### Create Site Association File​

### Add Intent Filter​

## Website Configuration​

### Angular​

### NuxtJS​

### React​

### WordPress​

## Verification​

## Resources​

## Contents

Platforms: iOS, Android

Universal links (iOS) and App Links (Android) offer the ability to take users directly to specific content within a native app (commonly known as deep linking).

When users tap or click on a deep link, the user is sent directly into your app without routing through the device's web browser or website first. If the app isn't installed, then the user is directed to the website. If the user navigates directly to the website, they remain on the website. This makes deep links an excellent feature for cross-platform apps built for the web, iOS, and Android: a seamless mobile experience, with graceful fallback to the website.

Here's what it looks like in practice. In this example, the user has the native app installed. They tap on app links from an email and are brought directly into the app itself. First, the root link is tapped (https://beerswift.app), which directs the user to the main app page. Next, a deep link is tapped (https://beerswift.app/tabs/tab3) bringing the user to the Tab3 page.

For illustrative purposes,https://beerswift.appwill be used as the web app link.

When the native app is opened after a deep link is clicked, the mobile OS doesn't automatically know where to route the user. This must be implemented within the app itself using the CapacitorApp APIon app startup.

If your website and app paths don't match, you will need to implement more advanced url pattern matching (seethis guidefor examples). If your mobile app and web app use the same codebase though, this is very straightforward - just redirect to the same URL. The following examples assume this.

Routing should be implemented inapp.component.ts. Start by importingNgZoneandRouterfrom Angular, thenAppfrom Capacitor:

Next, addRouterandNgZoneto the constructor:

Last, listen for theappUrlOpenevent, and redirect when a deep link is found:

There's a variety of options for React. One approach is to wrap the App API listener functionality in a new component, then add it inside ofApp.tsx. Start by creatingAppUrlListener.tsxthen import the React RouteruseHistoryhook as well as the Capacitor App API:

Next, define the AppUrlListener component, listening for theappUrlOpenevent then redirecting when a deep link is found:

Over inApp.tsx, import the new component:

Then add it inside ofIonReactRouter(or wherever your app is bootstrapped, just ensure that the History hook is available):

VueJS offers a first party routing system that integrates natively with Vue called Vue Router. To set up deep linking with Vue Router, start in the file that you used to configure all of your routes (usuallyroutes.jsor something similar).

First we import the capacitorAppfrom plugins along withVueandVueRouter.

Next, configure your routes using the Vue Router (more information onGetting Started with Vue Router).

It's recommended to usemode: historyso you don't have to deal with the#.

Let Vue know that you are using Vue Router and register the router within Vue:

Finally, we need to register our app for deep linking. To do that, we add an event listener to theappUrlOpenevent on the Capacitor App. Capacitor will pick this up, then we hand it off to Vue Router to navigate to the page requested.

In order for Apple and Google to permit deep links to open your app, a two-way association between your website and app must be created. One file for each must be created and placed within a.well-knownfolder on your website, like so:https://beerswift.app/.well-known/.

Continue on for iOS and Android configuration details.

iOS configuration involves creating a site association file and configuring the native app to recognize the app domain.

You must be enrolled in the Apple Developer Program.

First, log into theApple Developer site. Navigate to the "Certificates, Identifiers, & Profiles" section and select your app's identifier. Note the Team ID and Bundle ID, and under Capabilities, toggle "Associated Domains" then save:

Next, create the site association file (apple-app-site-association).

Note: Despite being a JSON file, do not save it with a file extension.

An example of theapple-app-site-associationfile is below. Be sure to replaceTEAMID.BUNDLEIDwith your own IDs (example:8L65AZE66A.com.netkosoft.beerswift).

Next, upload the file to your web site (hosted on HTTPS), then validate that it's configured correctly using Apple's toolhere. The URL should follow this format:https://beerswift.app/.well-known/apple-app
