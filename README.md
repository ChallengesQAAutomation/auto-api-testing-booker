# Automatizacion de pruebas API BOOKER
Este proyecto de automatización se enfoca en realizar pruebas de regresión a una API REST. Utiliza Java como lenguaje base y se apoya en las siguientes herramientas y patrones:

Serenity BDD: una biblioteca que facilita la automatización de pruebas y la generación de reportes detallados.
Cucumber: una herramienta de especificación y prueba basada en lenguaje natural que permite escribir escenarios de prueba en un formato fácilmente comprensible.
Patrón Screenplay: un enfoque de diseño de pruebas que promueve la legibilidad, el mantenimiento y la reutilización del código.
El informe completo de la ejecución de las pruebas se encuentra disponible en el siguiente enlace: [enlace al informe](URL del informe). En el informe podrán encontrar todos los detalles sobre las pruebas realizadas, sus resultados y cualquier otra información relevante para el proyecto.
[Ver resultados de la ejecución](target/site/serenity/index.html)

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

# Run Test

## Run Regression Testing

 - HappyPath y UnHappyPath

> 9 caso de prueba, duración aproximada de la ejecución ⏱️ 40 segundos.

````
gradle regression aggregate
````

- HappyPath
> 7 caso de prueba, duración aproximada de la ejecución ⏱️ 30 segundos.

````
gradle clean HappyPaths aggregate
````

- UnHappyPath
> 2 caso de prueba, duración aproximada de la ejecución ⏱️ 10 segundos.

````
gradle clean UnhappyPaths aggregate
````


## Ver reportes

> report
```
./target/site/serenity/serenity-summary.html
```

> aggregate
```
./target/site/serenity/index.html
```


