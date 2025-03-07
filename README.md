# Proyecto de Entrenamiento con Puzzles de Ajedrez

Este es un proyecto basado en **Spring Boot** que permite el entrenamiento con puzzles de ajedrez.

## Instalación de dependencias

Para ejecutar este proyecto, es necesario contar con **Maven** instalado.

### Verificar si Maven está instalado

Ejecuta el siguiente comando para comprobar si Maven está disponible:

```sh
mvn -version
```

Si el comando muestra información sobre Maven, ya lo tienes instalado

### Instalar Maven 


#### **Windows:**
Descarga el instalador desde [Maven](https://maven.apache.org/download.cgi), extrae el contenido y configura la variable de entorno `MAVEN_HOME`.

### Descargar las dependencias del proyecto

Una vez instalado Maven, navega a la carpeta raíz del proyecto y ejecuta:

```sh
mvn clean install
```

Esto descargará todas las dependencias declaradas en el archivo `pom.xml`, incluyendo **Spring Boot** y **chesslib**.

Si solo deseas descargar las dependencias sin compilar el proyecto, usa:

```sh
mvn dependency:resolve
```



