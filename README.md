## Author

Juan Pablo Poveda Cañon

# Taller 5 - Calculadora Web MVC

## Arquitectura

![ArquitectyraCalculadora - Marco básico de Azure (2019)](https://github.com/juancanon1725/CalculatorWeb/assets/98672541/388e8b34-ac12-4716-af3f-e5e62e71f8b8)


## Prerequisitos

Maven: Automatiza y estandariza el flujo de vida de la construcción de software.

Git: Administrador descentralizado de configuraciones.

## Instalación

Para instalar el proyecto maven se usa el siguiente comando:

```
mvn clean install
```

## Ejecución

Para ejecutar el proyecto maven se el siguiente comando

```
 mvn spring-boot:run
```

Y probamos el browser:

![localhost:8080/calculator.html](localhost:8080/calculator.html)

## Ejecución en AWS

Clonamos el repositorio en la instancia de AWS:

![gitclone](https://github.com/juancanon1725/CalculatorWeb/assets/98672541/1171b49c-827a-49b4-83c4-6f978b9749a0)

Ejecutamos el proyecto con el comando `mvn spring-boot:run`

![running](https://github.com/juancanon1725/CalculatorWeb/assets/98672541/52db56e3-2ad9-4b57-915e-098b67380236)

Y probamos el formulario `calculator.html` con `calculate`

![calculator](https://github.com/juancanon1725/CalculatorWeb/assets/98672541/b4ba2756-f2d6-4117-8b09-e22790fc2513)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
