# Desarrollo de una Aplicación de Gestión de Turnos


Aplicación para la creación de turnos para una entidad gubernamental, en la cual debemos crear un usuario y el mismo 
crea el turno, agregando la fecha, hora y el tipo de trámite que quiere realizar.

## Manejabilidad del proyecto(Gestión de Turnos)

![Portada_Gestion_Turnos](media\portada.png)


En esta imagen podremos observar el formulario para tanto para crear al usuario como para crear el turno que requiere el ciudadano.

Los campos que aparecen en el formulario son obligatorios para la creación del mismo.

## Botones

Los botones que aparecen en el formulario son:

![botones](media\botonera.png)

### Botón Registrar turno

El botón de registrar turno la misma palabra lo dice, va a registrar tanto el usuario junto con el turno.

### Botón de buscar turno por fecha

En este botón vamos a buscar por una fecha determinada todos los turnos que hay en ese día:

![buscar_por_fecha](media\buscar_por_fecha.png)

La primera vez que queremos buscar el turno por fecha se nos abrirá esta ventana lista para buscar la fecha deseada:

![buscar](media\buscar_por_fecha2.png)

Y como podremos ver os trae todos los datos que hay en la base de datos. 
Como podremos ver también tenemos un botón que es para cambiar el estado, este botón nos cambiará de estado del turno a
_"Ya atendido"_ :



###  Botón de Buscar turno por fecha y estado

En este botón como bien dice su escrito va a buscar el turno por fecha y estado, es muy similar 
al buscar por fecha pero agregando el select para elegir _"En espera"_ o _"Ya atendido"_

![buscar_fecha_estado](media\buscar_fecha_estado.png)

Y le agregaremos la fecha que queremos buscar que es el primer requisito para poder buscar por estado, si no agregamos
primero :

![mostrar_turno_fecha_estado](media\mostrar_turno_fecha_estado.png)

Y como hemos podido ver en cada ejemplo hay un botón que dice: **Volver Atrás**, pues este botón es el encargado 
de ir hacia la página de atrás.


## Errores

Los errores que puedes salir cunado queramos registrar un turno es dejar los campos a rellenar vacíos, en este caso
nos saldrá una advertencia de que son obligatorios todos los campos.

También otro de los errores que pueden ocurrir es que escribamos cualquier campo mal, en este caso si por ejemplo escribimos mal un DNI nos saltará
el error _DNI inválido_, en este caso se nos permitirá volver a ingresar el campo que hayamos agregado mal.


## Requerimientos a tener en cuenta para nuevas actualizaciones

Una de las actualizaciones es que si para algún turno en concreto la hora elegida por el usuario ya se a elegido por otro usuario, 
que automáticamente se deshabilite en el selector de horas para así no pisar los turno. No se a implementado, ya que a efectos prácticos recoge bien las
horas y se formatea correctamente.
Otra de las actualizaciones es mejorar la interfaz gráfica, pero ya que el objetivo del ejercicio es controlar el tema de las relaciones entre tablas
de la base de datos y toda la lógica del backend.




