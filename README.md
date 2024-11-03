# Caso Práctico 3 Programación Concurrente: Implementación de un Sistema de Gestión Mágico en el Ministerio de Magia

### Enlace al repositorio: https://github.com/Tapiiaa/CasoPractico3PConcurrente

## Descripción
Este proyecto consiste en el desarrollo de un sistema avanzado de gestión dede hechizos y eventos basada en programación orientada a aspectos (OAP). De este modo un usuario dependiendo de su rol y permisos dentro del sistema podrá lanzar unos u otros hechizos y convocar eventos mágicos.

## Funcionalidades principales
- **Autenticación y autorización de usuarios:** Los usuarios se autentican y obtienen permisos específicos según su rol dentro del sistema.
- **Gestión de hechizos y eventos mágicos:** Los usuarios autorizados pueden realizar ciertas acciones mágicas, limitadas por sus permisos.
- **Seguridad y auditoría:** Mediante AOP, el sistema aplica automáticamente medidas de seguridad y registra los eventos mágicos y las actividades de los usuarios.
- **Modularidad y gestión de transacciones:** El uso de AOP facilita la gestión de transacciones y asegura que las funcionalidades se apliquen de forma modular y eficiente, manteniendo la integridad y confiabilidad del sistema.

## Arquitectura del proyecto
### Modelos (Models): Representan las entidades principales de la aplicación:
- **Hechizo:** Define los atributos de un hechizo mágico.
- **Usuario:** Representa a los usuarios del sistema, con información como nombre, correo y roles.
- **EventoMagico:** Registra eventos mágicos asociados a usuarios.
- **Role:** Define roles de usuario para aplicar control de acceso.
  
### Controladores (Controllers): Los controladores manejan las peticiones HTTP y delegan la lógica de negocio a los servicios. Algunos de los controladores principales incluyen:
- **AdminController:** Gestiona aspectos administrativos.
- **HechizoController:** Permite la gestión de hechizos.
- **EventoMagicoController:** Administra eventos mágicos.
- **TestController:** Para pruebas y diagnósticos.
- **Aspectos (Aspects):** La Programación Orientada a Aspectos (AOP) se utiliza para manejar preocupaciones transversales, como:

### Seguridad (SeguridadAspect): Aplica control de acceso de forma centralizada.
- **Transacciones (TransaccionAspect):** Maneja la gestión de transacciones para asegurar la consistencia.
- **Auditoría (AuditoriaAspect):** Registra y audita eventos mágicos.
- **Ejecución Concurrente (ConcurrentExecutionAspect):** Facilita la ejecución concurrente para mejorar el rendimiento en operaciones específicas.
- **Servicios y Repositorios de Seguridad:** Incluyen clases de servicio y repositorios para manejar la autenticación y autorización de usuarios.

### SeguridadService: Realiza la lógica de autenticación y asignación de roles.
- **RoleRepository y UsuarioRepository:** Interfaces de repositorio para acceder a los datos de roles y usuarios.
- **Configuración (Config):** Define las configuraciones de seguridad y transacciones:

### SecurityConfig: Configura los aspectos de seguridad y autenticación.
- **TransaccionConfig:** Configura el manejo de transacciones para persistencia de datos.
- **AsyncConfig:** Configura la ejecución asincrónica, permitiendo procesamiento paralelo en el sistema.







