# Reto 6

**Arquitectura, estilo MVC (Model-View-Controller) con Patrón Command:**
El proyecto desacopla la lógica matemática de la interpretación de datos. En el paquete **model**, `ArithmeticBlock` y el enum `MathOperation` encapsulan el núcleo matemático (sumas, multiplicaciones y reducción de listas). En el paquete **view**, `ConsoleResultPrinter` se encarga únicamente de mostrar el resultado final. En **controller**, `CalculatorController` organiza el flujo, delegando la tarea de interpretar la entrada a comandos especializados.

**Principios aplicados:**
* **Responsabilidad Única (SRP):** Separación estricta de intereses. `FileInputReader` solo lee el archivo, `MathOperation` solo sabe operar números, y `AdvancedGridCommand` solo sabe cómo escanear columnas verticales.
* **Inversión de Dependencias (DIP):** El sistema es robusto gracias al uso de interfaces. `CalculatorController` y `Main` dependen de `InputReader` y `CalculationCommand` (abstracciones), no de las clases concretas, permitiendo cambiar la fuente de datos o el algoritmo de cálculo fácilmente.
* **Abierto-Cerrado (OCP):** El diseño es extensible. Si se requiere una nueva forma de interpretar la matriz , basta con añadir una nueva clase que implemente `CalculationCommand` sin tocar el código existente del modelo o del controlador.

**Extras:**
* **Paquete Command:** Encapsula los diferentes algoritmos de parsing (`SimpleMatrix` vs `AdvancedGrid`) permitiendo que el controlador ejecute cualquiera de ellos.
* **Enums con Comportamiento:** `MathOperation` no es solo un listado de constantes, sino que contiene la lógica funcional (`apply` con streams) para ejecutar la operación.
* **Streams y Programación Funcional:** Uso avanzado de `IntStream` para iteraciones complejas (como recorrer columnas verticalmente) y `reduce` para realizar las operaciones matemáticas de forma concisa.
