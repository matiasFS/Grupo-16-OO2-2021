<a id="readme-top"></a>
<br />
<div align="center">
<h3 align="center">Gestión de permisos</h3>

</div>



<!-- TABLA DE CONTENIDOS -->
<details>
  <summary>Tabla de contenidos</summary>
  <ol>
    <li>
      <a href="#acerca-del-proyecto">Acerca del proyecto</a>
      <ul>
        <li><a href="#tecnologías-utilizadas">Tecnologías utilizadas</a></li>
      </ul>
    </li>
    <li><a href="#instalación">Instalación</a></li>
    <li><a href="#funciones-de-la-plataforma">Funciones de la plataforma</a></li>
    <li><a href="#contacto">Contacto</a></li>
   </ol>
</details>



<!-- ABOUT THE PROJECT -->
## Acerca del proyecto

Plataforma web para gestionar permisos de circulación. Permite sacar un permiso para un día o por un tiempo determinado, ver los permisos asociados y escanear un QR con la información del permiso. También se desarrolló un login para administración y auditoría.
<p align="right">(<a href="#readme-top">Volver arriba</a>)</p>



### Tecnologías utilizadas

* JAVA
* SPRING
* JAVASCRIPT
* HTML
* CSS
* BOOTSTRAP
* MySQL
* HIBERNATE
  

<p align="right">(<a href="#readme-top">Volver arriba</a>)</p>



<!-- INSTALACION -->
## Instalación

Asegurarse de tener Java 8+ y MySQL instalados.

1. Clonar el repositorio
  ```sh
  git clone https://github.com/matiasFS/Grupo-16-OO2-2021.git
  ```

2. Crear base de datos con nombre "grupo-16-oo2-2021"
   
3. En el archivo application.properties, que se encuentra en la carpeta "src/main/resources", realizar los siguientes cambios:

   spring.datasource.username="usuario"
 
    spring.datasource.password="contraseña"

  Reemplazar "usuario" y "contraseña" con la información correspondiente a tu configuración de MySQL, sin las comillas.

4. Ejecución:

   Desde la IDE de tu preferencia, buscar la clase "Grupo16Oo22021Application.java", que se encuentra en la carpeta "src/main/java/com/trabajo/Grupo16OO22021", y ejecutarla como una aplicación Java.

5. Acceso a la aplicación:

  Una vez que la aplicación haya iniciado correctamente, abrir el navegador web e ingresar la dirección http://localhost:puerto (El puerto predeterminado suele ser 8080, pero puede variar según tu configuración).
  Luego de realizar estos pasos, la interfaz debería ser visible y deberías poder probarla.
  
<p align="right">(<a href="#readme-top">Volver arriba</a>)</p>


<!-- FUNCIONES -->
## Funciones de la plataforma

  1. Página de incio
     ![1](https://github.com/user-attachments/assets/1a3d8a7d-87bb-4161-8538-67317fbe3b51)

  2. Gestion de permisos

      Al seleccionar la pestaña "Gestión de permisos", el usuario puede registrarse, registrar su vehículo y crear un permiso.

  ![2](https://github.com/user-attachments/assets/5f4f2965-9c77-4cea-af28-8d36a98dc00d)
  ![3](https://github.com/user-attachments/assets/2627591b-deb3-4c4c-bfcd-4095a492134b)
  ![4](https://github.com/user-attachments/assets/86410eee-d961-4064-a522-50c426cfc06b)
  ![5](https://github.com/user-attachments/assets/701f104f-9229-482a-a9a1-2b6983e86594)

  3. Buscar permiso por persona

     Al seleccionar la pestaña "Permiso por persona", el usuario puede buscar los permisos utilizando su apellido y número de documento.

![6](https://github.com/user-attachments/assets/91e391f5-c1a1-4e6f-ad7a-4bb5dbca5211)
![7](https://github.com/user-attachments/assets/e5bf8e75-2bd4-43a1-a3dd-3c8d703a7589)
![8](https://github.com/user-attachments/assets/46616bbc-ca16-44dd-a052-71be1a9fd90a)

  4. Usuario con rol de administrador

      El usuario con permisos de administrador puede ver, crear, editar y borrar usuarios y perfiles.

  ![10](https://github.com/user-attachments/assets/333fa9c5-5043-4c71-8abf-ae280a2a7f61)

   ![11](https://github.com/user-attachments/assets/1f4e26dd-0c20-48cc-b769-36016557d847)
  ![12](https://github.com/user-attachments/assets/7825272c-2953-4195-b52b-d8aa1eb30f95)
  ![13](https://github.com/user-attachments/assets/5e6e3995-375a-44d2-aef8-8ff236f798cb)

  ![14](https://github.com/user-attachments/assets/852d94a9-b3f7-4286-94df-09540e315203)

  Al querer borrar un usuario aparece un mensaje de confirmación
 
  ![15](https://github.com/user-attachments/assets/d0790057-09e4-4048-a540-3ceae2432b7a)


  5. Usuario con rol de auditor

     El usuario con rol de administrador, puede ver la lista de usuarios y perfiles, exportarlas a pdf, y puede ver los permisos por persona, por fecha, por fecha y lugar, y por rodado.

      ![aaa](https://github.com/user-attachments/assets/ffdad8c2-4485-4c24-a2de-34e3c470d2b6)
      ![aaaa](https://github.com/user-attachments/assets/57f96e9f-07bb-43f3-b206-fe1a232b8579)
      ![17](https://github.com/user-attachments/assets/ea008aeb-053e-4f19-a6fa-3f4b8e57a46a)

      Al exportar la lista como pdf queda de la siguiente forma:
     
        ![16](https://github.com/user-attachments/assets/d5191509-cd6d-43bc-ad77-61e73e46002f)


  
<!-- CONTACT -->
## Contacto

Matias Silvestri - [Linkedin](https://www.linkedin.com/in/matias-franco-silvestri-1a037721b/) - matias.f.silvestri1@gmail.com

<p align="right">(<a href="#readme-top">Volver arriba</a>)</p>
