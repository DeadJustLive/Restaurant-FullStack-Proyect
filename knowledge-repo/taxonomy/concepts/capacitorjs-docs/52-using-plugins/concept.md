# Using plugins

## Fuente
CapacitorJS — Documentación Oficial (Cap. 52)

## Contenido
## Products

## Open Source

# Automated Capacitor Project Configuration

## Project API​

## Configuration Tool​

## Contents

Many large-scale apps need to automate the configuration of their Capacitor project. This could mean incrementing iOS and Android build numbers, configuring manifest and plist files, adding build dependencies in Gradle files, modifying resources, and more.

Capacitor comes with a two useful packages that can be used for managing projects:@trapezedev/projectand@trapezedev/configure.@trapezedev/projectis a lower-level project management library and@trapezedev/configureis an automated tool that uses the library under the hood but presents a more convenient configuration option for certain use cases.

Both projects and their documentation are available in theTrapeze repo.

The@trapezedev/projectlibrary provides a typed JavaScript interface for Capacitor projects and the native iOS and Android projects that they contain.

Once the project is loaded, operations can be performed against it. For example, here is how versions and build numbers can be managed:

The API works on a virtual filesystem to buffer changes without modifying files on the filesystem. When finished, to make sure changes are reflected in your files, run:

There are many other options this library can perform. To see the full list, consult theproject documentation.

Along with the project API,@trapezedev/configureprovides an automated, configuration-driven experience for applying the underlying operations in@trapezedev/project, but from a convenient yaml configuration file format. There are some additional features as well, such as the ability to require and supply variables to populate values in the final configuration, and a way to test and see changes before they are applied against your project source files.

This tool is likely going to be most useful for Capacitor plugin authors that wish to publish a set of configuration changes their plugin requires, to avoid users having to manually configure their projects.

This tool is meant to be used as an npm script that is then supplied with a yaml format that follows theexample configuration:

Consult theproject documentationfor more information on using this tool.

Mobile CI/CD made easy. Build, publish, and update from the cloud.

## Código

```
@trapezedev/project
```

```
@trapezedev/configure
```

```
@trapezedev/project
```

```
@trapezedev/configure
```

```
@trapezedev/project
```

```
import{MobileProject,MobileProjectConfig}from'@trapezedev/project';// This takes a MobileProjectConfig// to know where the ios and android projects areconstconfig:MobileProjectConfig={ios:{path:'ios/App',},android:{path:'android',},};constproject=newMobileProject(process.cwd(),config);awaitproject.load();
```

```
import{MobileProject,MobileProjectConfig}from'@trapezedev/project';// This takes a MobileProjectConfig// to know where the ios and android projects areconstconfig:MobileProjectConfig={ios:{path:'ios/App',},android:{path:'android',},};constproject=newMobileProject(process.cwd(),config);awaitproject.load();
```

```
awaitproject.ios?.setVersion('App','Debug','1.4.5');awaitproject.ios?.incrementBuild('App');awaitproject.ios?.getBuild('App','Debug');awaitproject.ios?.getBuild('App','Release');awaitproject.android?.setVersionName('1.0.2');awaitproject.android?.getVersionName();awaitproject.android?.setVersionCode(11);awaitproject.android?.getVersionCode();awaitproject.android?.incrementVersionCode();
```

```
awaitproject.ios?.setVersion('App','Debug','1.4.5');awaitproject.ios?.incrementBuild('App');awaitproject.ios?.getBuild('App','Debug');awaitproject.ios?.getBuild('App','Release');awaitproject.android?.setVersionName('1.0.2');awaitproject.android?.getVersionName();awaitproject.android?.setVersionCode(11);awaitproject.android?.getVersionCode();awaitproject.android?.incrementVersionCode();
```

```
awaitproject.commit();
```

```
awaitproject.commit();
```

```
@trapezedev/configure
```

```
@trapezedev/project
```

```
"scripts":{"cap-config":"trapeze run config.yaml"}
```

```
"scripts":{"cap-config":"trapeze run config.yaml"}
```

```
npmrun cap-config
```

```
npmrun cap-config
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
- Upgrade GuidesUpdating to 7.0Updating plugins to 7.0Updating to 6.0Updating plugins to 6.0Updating to 5.0Updating plugins to 5.0Updating to 4.0Updating to 3.0Updating to 2.0Updating to 1.1Updating plugins to 3.0
- Updating to 7.0
- Updating plu

> [Contenido truncado — consulta el capítulo completo con knowledge read]
