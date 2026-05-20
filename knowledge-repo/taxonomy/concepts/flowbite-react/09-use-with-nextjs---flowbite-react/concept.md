# Use with Next.js - Flowbite React

## Fuente
Flowbite React - Componentes UI (Cap. 9)

## Contenido
# Use with Next.js - Flowbite React

> Fuente: [https://flowbite-react.com/docs/components/dropdown](https://flowbite-react.com/docs/components/dropdown)

Learn how to install Flowbite React for your Next.js project and start developing with the most popular React-based framework built by Vercel

This guide provides three ways to integrate Flowbite React with Next.js:

The fastest way to get started is using our project creation CLI, which sets up a new Next.js project with Flowbite React, Tailwind CSS, and all necessary configurations:

If you already have a Next.js project and want to add Flowbite React, you can use our initialization CLI:

This will automatically:

If you prefer to set everything up manually or need more control over the configuration, follow these steps:

Create a new Next.js project:

When prompted:

Install Flowbite React:

To avoid page flicker in dark mode before hydration, add theThemeModeScriptto your root layout:

For App Router:

For Pages Router:

Now that you have successfully installed Flowbite React you can start using the components from the library:

Flowbite is an ecosystem built on top of Tailwind CSS including a component library, block sections, a Figma design system and other resources.

Code licensedMIT, docsCC BY 3.0

```
npx create-flowbite-react@latest-tnextjs
```

```
npx create-flowbite-react@latest-tnextjs
```

```
npx flowbite-react@latest init
```

```
npx flowbite-react@latest init
```

```
npx create-next-app@latest
```

```
npx create-next-app@latest
```

```
npx flowbite-react@latest init
```

```
npx flowbite-react@latest init
```

```
ThemeModeScript
```

```
// app/layout.tsximport{ThemeModeScript}from"flowbite-react";exportdefaultfunctionRootLayout({children}){return(<htmlsuppressHydrationWarning><head><ThemeModeScript/></head><body>{children}</body></html>);}
```

```
// app/layout.tsximport{ThemeModeScript}from"flowbite-react";exportdefaultfunctionRootLayout({children}){return(<htmlsuppressHydrationWarning><head><ThemeModeScript/></head><body>{children}</body></html>);}
```

```
// pages/_document.tsximport{ThemeModeScript}from"flowbite-react";exportdefaultfunctionDocument(){return(<HtmlsuppressHydrationWarning><Head><ThemeModeScript/></Head><body><Main/><NextScript/></body></Html>);}
```

```
// pages/_document.tsximport{ThemeModeScript}from"flowbite-react";exportdefaultfunctionDocument(){return(<HtmlsuppressHydrationWarning><Head><ThemeModeScript/></Head><body><Main/><NextScript/></body></Html>);}
```

```
// app/page.tsximport{Button}from"flowbite-react";exportdefaultfunctionPage(){return<Button>Click me</Button>;}
```

```
// app/page.tsximport{Button}from"flowbite-react";exportdefaultfunctionPage(){return<Button>Click me</Button>;}
```

- getting startedIntroductionQuickstartupdatedCompatibilityCLIupdatedEditor SetupAI IntegrationServer ComponentsLicenseChangelogContributing
- Introduction
- Quickstartupdated
- Compatibility
- CLIupdated
- Editor Setup
- AI Integration
- Server Components
- License
- Changelog
- Contributing
- integration guidesAdonisJSAstroBlitz.jsBunESBuildFarmGatsbyLaravelMeteor.jsModern.jsNext.jsParcelReact RouterReact ServerRedwoodJSRemixRsbuildRspackTanStack RouterTanStack StartVikeViteWakuWebpack
- AdonisJS
- Astro
- Blitz.js
- Bun
- ESBuild
- Farm
- Gatsby
- Laravel
- Meteor.js
- Modern.js
- Next.js
- Parcel
- React Router
- React Server
- RedwoodJS
- Remix
- Rsbuild
- Rspack
- TanStack Router
- TanStack Start
- Vike
- Vite
- Waku
- Webpack
- customizeColorsConfigCustom ComponentsDark ModePrefixThemeupdated
- Colors
- Config
- Custom Components
- Dark Mode
- Prefix
- Themeupdated
- componentsAccordionAlertAvatarBadgeBannerBreadcrumbButtonButton groupCardCarouselClipboardDatepickerDrawerDropdownFooterFormsKBDList groupMega menuModalNavbarPaginationPopoverProgress barRatingSidebarSpinnerTableTabsTimelineToastTooltip
- Accordion
- Alert
- Avatar
- Badge
- Banner
- Breadcrumb
- Button
- Button group
- Card
- Carousel
- Clipboard
- Datepicker
- Drawer
- Dropdown
- Footer
- Forms
- KBD
- List group
- Mega menu
- Modal
- Navbar
- Pagination
- Popover
- Progress bar
- Rating
- Sidebar
- Spinner
- Table
- Tabs
- Timeline
- Toast
- Tooltip
- formsFile InputFloating Label
- File Input
- Floating Label
- typographyBlockquoteHRList
- Blockquote
- HR
- List

- Introduction
- Quickstartupdated
- Compatibility
- CLIupdated
- Editor Setup
- AI Integration
- Server Components
- License
- Changelog
- Contributing

- AdonisJS
- Astro
- Blitz.js
- Bun
- ESBuild
- Farm
- Gatsby
- Laravel
- Meteor.js
- Modern.js
- Next.js
- Parcel
- React Router
- React Server
- RedwoodJS
- Remix
- Rsbuild
- Rspack
- TanStack Router
- TanStack Start
- Vike
- Vite
- Waku
- Webpack

- Colors
- Config
- Custom Components
- Dark Mode
- Prefix
- Themeupdated

- Accordion
- Alert
- Avatar
- Badge
- Banner
- Breadcrumb
- Button
- Button group
- Card
- Carousel
- Clipboard
- Datepicker
- Drawer
- Dropdown
- Footer
- Forms
- KBD
- List group
- Mega menu
- Modal
- Navb
