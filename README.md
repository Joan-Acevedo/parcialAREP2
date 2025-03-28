### Parcial segundo tercio

### Autor: Joan Acevedo

---

## Descripción

Esta aplicación presenta un sistema de microservicios que tiene un servicio con el nombre Math Services para computar la función de collatzsequence. El servicio deberia estar desplegado en dos de EC2 por separado. 

Adicionalmente, se  deberia implementar un servicio proxy que recibe las solicitudes de llamado desde los clientes donde balancea las cargas con round-robin. 

El proxy deberia estar desplegado en otra máquina EC2. Éste tiene un cliente Web con un formulario que recibe el valor que el usuario ingrese.

---

**Nota:**

En el parcial no se logro completar todo el desarrollo requerido, a continuación se explica cómo deberia ejecutarse en un caso exitoso.

---

## Ejecucucion del proyecto:

Para ejecutar el proyecto se debe seguir los siguientes pasos:

### Instalación

#### Instalación en AWS

Ejecute los siguientes comandos para instalar git, maven y java en su máquina EC2.

```ssh
sudo yum install -y git
```

```ssh
sudo yum install -y java-17-amazon-corretto-devel
```

#### Instalación en local 

Realice los siguientes pasos para clonar el proyecto.

```ssh
git clone https://github.com/Joan-Acevedo/parcialAREP2.git
```

## Ejecutando la aplicación local 

Para ejecutar la aplicación, ejecute los siguientes comandos en la raíz del proyecto.

En una terminal ejecute el siguiente comando para compilar el proyecto:

```ssh
mvn clean compile
```

El anterior comando limpiará las contrucciones previas, compilará y luego ejecutará en distintos contenedores los servicios de la aplicación.

Una vez compilado ejecute el servidor proxy en una terminal con el siguiente comando:

```ssh
mvn exec:java -Dexec.mainClass="org.example.ServidorProxy"
```

En otra terminal ejecute el siguiente comando para ejecutar el servicio de math para usar el collatzsequence:

```ssh
mvn exec:java -Dexec.mainClass="org.example.MathService"
```


## Arquitecura de la aplicación 

La aplicación tiene los siguientes componentes:

**Aplicación web ProxyServer:**

- Está compuesta por un cliente web que presenta un formulario para usar los servicios de collatzsequence.
- Cuando un usuario envía un mensaje, el cliente web lo envía al servicio REST.
- El servicio REST deveria procesar el mensaje y actualizar la pantalla del cliente web con la información devuelta en formato JSON.
- Implementa un algoritmo de balanceo de cargas de Round Robin para distribuir la carga entre dos instancias del servicio MathService.

vista de como se veria el formulario:

![Image](https://github.com/user-attachments/assets/3ce25a2c-1448-40b3-9093-2670265d75f3)

**MathService:**

- Servicio que ofrece la funcionalidad de collatzsequence segun un numero ingresado por el usuario por el usuario.


