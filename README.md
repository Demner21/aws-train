# aws-train
# AWS Overview
### What is cloud computing
Literalmente es... la computadora de alguien más
### Caracteristicas [segun NIST]
Las caracteristicas que debe cumplir cualquier proveedor de servicios cloud son:
- On-Demand: obtienes el servicio que deseas al instante..bueno al menos en unos minutos
- broad network access: tienes acceso a la red (puedes crear redes privadas y acceder a internet desde el servicio cloud) .-.
- resource pooling: el proveedor sirve a multiples clientes con servicios escalables
- rapid elasticity: aqui la palabra clave es **escalamiento**, lo que no es tan sencillo de lograr en soluciones on-premise, debe ser sencillo en la nube
- measured service: paga por lo que usas

### Service model
Tipicamente existe 3 tipos de servicios:
- IAAS
- SAAS
- PAAS

### Regions
AWS posee varias regiones a través del mundo
- Las regiones son los **bloques primarios** de cualquier solucion cloud
- Algunos servicios no requieren la configuracion de las región (denominados servicios globales)
- Algunos criterios para seleccionar una region determinada:
   - es la que proporcione menor latencia [¿como sabemos que tendremos menor latencia en X region? ]
   - costo [no siempre es el mismo], es determinado por la región
   - **politicas de seguridad**
   
### Availability Zones
AWS AZ, son literalmente, collecciones de data-centers, las cuales conforman una region, poseen su propia red [propia fibra]

Por ejemplo, la region de Oregon (us-west-2) posee un AZ de 3 datacenters: 
 - us-west-2a
 - us-west-2b
 - us-west-2c

Cada region al menos tendrá un AZ mayor o igual a 2

Si las regiones son los bloques primarios de las soluciones cloud, AZ son los que proporcionan la tolerancia a fallos y alta disponibilidad
### Edge locations
EL, sirve 2 propositos:
- Amazon S3
- Amazon CDN
No se posee un control directo de un EL, es decir, no se puede elegir que determinado EL proporcione X servicio/contenido, podemos elegir que para nuestra solucion 
determinado EL será el más conveniente

### Scope of services
- Global: no necesitamos seleccionar determinada region o AZ, realizar cambios en x service, se replicará en todoo
- Regional: mientras se lance determinado servicio, se deberá seleccionar la región, tanto como HA (high availability) y FT (fault tolerance) son implicitos
- Availability zone: servicios asociados a AZ, es decir son servicios que permiten mejorar ciertos aspectos de un servicio que está en cierto AZ
  esto se entiende mejor con un ejemplo: supongamos que creamos una maquina virtual en cierta region (y por defecto con un AZ), si deseamos aumentar la 
  capacidad de almacenamiento de dicha mv, se tendria que usar un servicio AZ para ese AZ ...suena raro pero es la forma en la que lo he entendido, porque no tendria
  sentido aumentar el almacenamiento de dicha MV y que ese nuevo espacio se encuentre en un AZ diferente ... en una región diferente, .-.
  tendriamos que usar un servicio e
