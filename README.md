# Plantilla de Spring Boot Docker

### Empezando

#### Instalación

Instala Maven (mvn), Docker y Java en tu computadora.
Ejecuta lo siguiente sin errores para verificar si todas tus versiones están correctas:
```
java -version
mvn -v
docker -v
```

#### Dockerfile and Docker-compose
Asegúrate de cambiar el nombre de tu archivo Dockerfile de la aplicación (de "demo" a cualquier nombre que tenga tu aplicación).
Antes de ejecutar cualquier cosa en Docker, asegúrate de que tu aplicación se ejecute correctamente. Dejé algunas propiedades de aplicación útiles en recursos, para que puedas cambiarlas como desees. Después de eso, ejecuta lo siguiente para empaquetar de nuevo tu proyecto:
```
mvn package spring-boot:repackage
```
Esto generará un archivo .jar en tu carpeta de paquetes.

Ahora, puedes ejecutar el docker-compose de la siguiente manera en la terminal:
```
docker compose -f ./docker-compose.yaml up
```
Si ambos contenedores se ejecutan correctamente y sin errores, entonces puedes verificar localhost:8080 o conectar tu base de datos a un administrador de bases de datos.
### Antes de correr Springboot

Cuando se crea la base de datos de Docker, es necesario crear los tipos de datos antes de crear los datos con Springboot.

#### Authority Types
```sql
CREATE TYPE public.authority_type AS ENUM (
	'ROLE_PARENT',
	'ROLE_ADMIN',
	'READ',
	'WRITE');
```

#### Alert Types
```sql
CREATE TYPE public.alert_type AS ENUM (
	'BLOCK ENTRY',
	'SOLICIT_UNBLOCK',
	'PHONE_TIME_EXCEEDED');
```

#### Device Types
```sql
CREATE TYPE public.device_type AS ENUM (
	'TABLET',
	'PHONE',
	'LAPTOP',
	'PC');
```
#### Indicaciones para el uso de la aplicación web

-El usuario accede a la aplicación web y se muestra la página de registro del padre.
-El usuario completa los campos requeridos en el formulario de registro y envía la información.
-Después del registro, se muestra la página de inicio de sesión del padre.
-El usuario ingresa sus credenciales en el formulario de inicio de sesión y se autentica en la aplicación.
-Una vez autenticado, se muestra el perfil del usuario padre con información personal y opciones de configuración.
-En la página de perfil, el usuario puede acceder a la sección de dispositivos bloqueados, donde se muestra el dispositivo por defecto y el listado de aplicaciones bloqueadas.
-El usuario puede navegar a la sección de listado de aplicaciones disponibles para bloquearlas.
-En esta sección, se muestra un listado de aplicaciones de la base de datos que el usuario padre puede seleccionar para bloquear.
-El usuario también puede acceder a la sección de listado de días disponibles para bloquear las aplicaciones.
-En esta sección, se muestra un calendario o una lista de días en los que el usuario puede especificar el bloqueo de aplicaciones.
-Cuando el usuario selecciona una aplicación o un día para bloquear, se muestra una confirmación de desbloqueo de la aplicación.
-El usuario puede confirmar el bloqueo y se guarda la configuración en la base de datos.
-Además de las aplicaciones, el usuario puede acceder a la sección de dispositivos bloqueados con enlaces.
-En esta sección, se muestra el dispositivo por defecto y el listado de enlaces bloqueados.
-El usuario puede agregar un nuevo URL bloqueado accediendo al modal de agregado de un nuevo URL.
-El usuario completa la información requerida, como el URL y una descripción opcional, y guarda la configuración.
-Por último, el usuario puede acceder a la sección de ayuda al usuario para obtener información adicional o asistencia con el uso de la aplicación.

### Documentación de Referencia
Para más información de referencia, considera las siguientes secciones:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.5/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#using.devtools)
* [Docker](https://docs.docker.com/)

### Guías
Las siguientes guías ilustran cómo utilizar algunas características concretamente:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

