### Security in aws
- La seguridad en AWS, está relacionada con cuentas, usuarios, grupos y credenciales de acceso
- En esta lección se aprenderá acerca de autenticación y autorización (además de buenas practicas)
#AWS IAM 
Dentro de los servicios de AWS, se necesita:
- Authentication : conocer quien eres
- Authorization : que estás permitido de realizar
- Users : un usuario obviamente
- Groupos : conjunto de usuarios para determinado fin
- Password Policy : politicas de credenciales
- Multifacto Authentication : algo que tienes / algo que conoces / algo que eres
### Users
- Creacion de usuarios
- creacion de grupo y asignar usuario creado a dicho grupo
- crear llaves de acceso para el usuario (para usar SDK o AWS-CLI) / necesarios para comunicarse con las APIS de AA de AWS

### Persmissions and Policies
- Una cosa es tener un usuario (con credenciales y con una llave) y otra es que con ese usuario puedas realizar una accion (crear recursos en AWS).
- Para poder hacer eso, se necesita otorgarle a los usuarios permisos
- Los permisos (authorization) se otorgan mediante politicas
# Permisos: 
Politicas: escritas en JSON (pueden crearse mediante un generador o escribirlas manualmente)
Tipos de politicas
  - Managed policy
    - AWS managed
    - Customer managed
  - Inline policy
# Logica de evaluacion de una politica:
  - Defaults to implicit deny : todo empiezan con un negación implicita
  - Explicit deny : siempre gana, tiene prioridad sobretodo, no importa lo demás
  - Explicit allow
# ARN
Format pattern:
arn:partition:service:region:account-id:resourceType/resource
arn:partition:service:region:account-id:resourceType:resource

Ejemplos
 - arn:aws:iam::12345678912:user/rnmd   --la region no es necesaria para servicios globales
 - arn:aws:s3:::mybucket/*    --no es necesario account-id para s3 bucket
 
Revisa la documentacion para conocer más sobre el formato de los arn

Ejemplo de politica 

```json
 {
 "Version": "2021-10-17",
 "Statement": [
  {
    "Effect": "Allow",
    "Action":[
      "s3:GetObject",
      "s3:PutObject"
    ],
    "Resource":[
      "arn:aws:s3:::mybucket/*"
    ]
  }
 ]
 }
```
En el ejemplo, en la parte de efecto se está indicando explicitamente como Allow
