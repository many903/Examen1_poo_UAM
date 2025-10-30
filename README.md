Perfecto ✅ Aquí tienes un **README.md** profesional y claro para un proyecto como el que describes (“Clase Producto con menú en Java”):

---

# 🧩 Proyecto: Gestión de Productos (POO en Java)

## 📘 Descripción general

Este proyecto implementa una aplicación en **Java** que utiliza los principios de la **Programación Orientada a Objetos (POO)** para gestionar productos de una tienda.
Permite registrar productos, mostrar su información, aplicar descuentos, vender unidades, reponer inventario y verificar disponibilidad mediante un **menú interactivo en consola**.

---

## 🎯 Objetivo

Desarrollar un programa que modele un sistema de inventario básico utilizando clases, atributos, métodos y un menú controlado por estructuras de selección y repetición.

---

## 🧱 Estructura del proyecto

### 1. Clase `Producto`

Define la estructura de un producto dentro del inventario con los siguientes atributos y métodos:

#### 🔸 Atributos privados

* `nombre` (`String`) — Nombre del producto
* `precio` (`double`) — Precio unitario
* `cantidad` (`int`) — Unidades disponibles
* `categoria` (`String`) — Categoría del producto
* `disponible` (`boolean`) — Indica si el producto está disponible para la venta

#### 🔸 Métodos públicos

* `mostrarInformacion()` — Muestra los datos completos del producto
* `aplicarDescuento(double porcentaje)` — Reduce el precio según el porcentaje indicado
* `vender(int unidades)` — Disminuye el inventario si hay existencias suficientes
* `reponer(int unidades)` — Aumenta la cantidad en inventario
* `verificarDisponibilidad()` — Actualiza la disponibilidad según la cantidad actual
* Métodos **getters y setters** para cada atributo

---

### 2. Clase `Principal`

Contiene el método `main()` y un **menú interactivo** que permite al usuario realizar operaciones sobre dos objetos `Producto`.

#### 🧮 Opciones del menú

1. Capturar Producto 1
2. Capturar Producto 2
3. Mostrar inventario
4. Aplicar descuento
5. Vender unidades
6. Reponer unidades
7. Mostrar integrantes del equipo
8. Salir

El menú se implementa con un **switch** y un **ciclo repetitivo** que mantiene el programa activo hasta seleccionar “Salir”.

---

## ⚙️ Ejemplo de ejecución

```text
=== MENÚ INVENTARIO ===
1) Capturar Producto 1
2) Capturar Producto 2
3) Mostrar inventario
4) Aplicar descuento
5) Vender unidades
6) Reponer unidades
7) Mostrar integrantes
8) Salir

Selecciona una opción: 4
¿Qué porcentaje de descuento aplicar a Laptop Lenovo? 10
Se aplicó un descuento del 10.0% a Laptop Lenovo
```

---

## 🧑‍💻 Tecnologías utilizadas

* **Lenguaje:** Java
* **Entorno:** Cualquier IDE (Eclipse, NetBeans, VS Code)
* **Versión recomendada de JDK:** 17 o superior

---

## 🧩 Estructura de carpetas

```bash
Proyecto_Productos/
│
├── src/
│   ├── Producto.java
│   └── Principal.java
│
├── README.md
└── Evaluacion1_Clase_Producto_Menu.pdf
```

---

## 🚀 Ejecución

1. Compila los archivos Java:

   ```bash
   javac src/*.java
   ```
2. Ejecuta el programa principal:

   ```bash
   java src.Principal
   ```

---

## 🧠 Autores

Incluye los nombres y matrículas de los integrantes del equipo.
Por ejemplo:

```
Integrantes:
- Manuel García N. — Matrícula: 123456
- [Nombre del compañero] — Matrícula: 654321
```

---

## 📝 Evidencias

Para la entrega se deben incluir:

* Capturas de pantalla de cada opción del menú
* Video mostrando el funcionamiento completo
* Reporte final en PDF

---

¿Quieres que te genere también un archivo `.md` descargable con este contenido (listo para subir al repositorio de GitHub)?
