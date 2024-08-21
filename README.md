# MicroservicesCart

**MicroservicesCart** es una solución de microservicios diseñada para gestionar el ciclo completo de procesamiento de órdenes y pagos en un entorno de comercio electrónico. El proyecto está compuesto por varios microservicios interconectados, incluyendo **ProductService**, **OrderService** y **PaymentService**.

## Características Principales

- **Gestión de Productos**: Consulta de información sobre productos a través de la [Fake Store API](https://fakestoreapi.com/).
- **Gestión de Órdenes**: Creación y actualización de órdenes con validaciones integradas.
- **Procesamiento de Pagos**: Validación de pagos y manejo de excepciones.
- **Pruebas y Validación**: Colección de Postman para probar y validar la funcionalidad de las APIs.

## Tecnologías Utilizadas

- Java 17
- Spring Boot
- Feign Client
- Fake Store API
- Git
- Postman

## Instalación y Configuración

### Clonar el Repositorio

Clona el repositorio a tu máquina local:
```bash
git clone <URL-del-repositorio>
Configuración del Proyecto
Navega al directorio del proyecto:

bash
Copiar código
cd <directorio-del-proyecto>
Compilar y Ejecutar
Compila y ejecuta el proyecto utilizando Maven:

bash
Copiar código
./mvnw clean install
./mvnw spring-boot:run
Configuración de Entorno
Asegúrate de tener Java 17 instalado en tu máquina. Puedes verificarlo con:

bash
Copiar código
java -version
Uso
Endpoints
Productos: /products - Obtiene todos los productos.
Producto por ID: /products/{id} - Obtiene un producto específico.
Órdenes: /orders - Crea y actualiza órdenes.
Pagos: /payments - Procesa pagos.
Colección de Postman
La colección de Postman para probar todos los endpoints está disponible en el directorio postman_collection/. Puedes importar esta colección a Postman para realizar pruebas.

Contribución
Si deseas contribuir al proyecto, sigue estos pasos:

Haz un fork del repositorio.
Crea una rama con tu feature o bugfix (git checkout -b feature/nueva-caracteristica).
Realiza tus cambios y haz un commit (git commit -am 'Añadir nueva característica').
Sube tus cambios (git push origin feature/nueva-caracteristica).
Crea un pull request desde tu fork al repositorio principal.
Licencia
Este proyecto está licenciado bajo la Licencia MIT - consulta el archivo LICENSE para obtener más detalles.

Contacto
Para más información, puedes contactar con el autor a través de tu-email@ejemplo.com.

Créditos
Agradecimientos a las siguientes herramientas y servicios utilizados en el proyecto:

Spring Boot
Feign Client
Fake Store API
Postman