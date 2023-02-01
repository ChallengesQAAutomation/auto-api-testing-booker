# Automatizacion de pruebas API BOOKER

Desafio de pruebas automatizadas.

## Requerimientos
- Java
- JDK 17
- Graddle

## Versiones

serenityCoreVersion = "3.3.10"
## Instalacion

```
gradle build
```

## Estructura del proyecto

Patron de diseño Screnplay usando serenity BDD

- StepdefinitionSetup: Configuracion inicial

```
src/test/java/stepdefinition/SetupStepDefinition.java
```
- Features: Escnarios de pruebas
````
src/test/resources/features
````
- Runners: Clases utilizada para ejecutar los escenarios de pruebas utiliazando cucumber
````
src/test/java/runners
````
- Task: Logica del comportamiento
```
src/main/java/task
```
- Question: Logica de aserciones.
````
src/main/java/question
````
- Model: Serializacion de objectos.
````
src/main/java/model
````
- Util: Utilidades utilizada en el proyecto.
````
src/main/java/util
````