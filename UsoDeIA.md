
## Uso de Inteligencia Artificial (IA) en el Proyecto

En base a lo estipulado en el README.md del proyecto, se ha decidido documentar el uso de la Inteligencia Artificial (IA) en el desarrollo del mismo, pero en un documento aparte. Esta decisión fue tomada para no llenar el codigo de diversas anotaciones, casi sin valor. Y el hecho de que, tener todos los cambios hechos con IA en un solo lugar, permite ver de una manera más clara y sencilla, el uso que se le ha dado a la IA en el proyecto.

### Etapa 1: Diseño Base y Principios SOLID
En esta etapa inicial, la IA fue utilizada principalmente para agilizar tareas repetitivas relacionadas con la generación de código. Los casos específicos incluyen:
- **Autocompletado de código**: Se empleó la IA para generar automáticamente getters, setters y estructuras base de ciertas funciones, como los menús de consola. Esto permitió ahorrar tiempo y garantizar consistencia en el código. Casi siempre estos autocompletados fueron levemente modificados, por ejemplo, en el nombre de variables o funciones.

### Etapa 2: Gestión de Recursos y Colecciones
En esta etapa, la IA fue utilizada para abordar problemas más complejos y realizar modificaciones estructurales en el proyecto. Los casos específicos incluyen:
1. **Función de búsqueda avanzada**: Se utilizó la IA para desarrollar la función `buscarUsuariosCoincidentes(String busqueda)`. Esta función permite realizar búsquedas flexibles que funcionan con nombres o apellidos, incluso si están incompletos o contienen errores parciales. La IA ayudó a diseñar una lógica más sofisticada para este propósito. Despues, me di cuenta que no era un sistema de búsqueda, si no un filtrado lo que queria hacer, asi que le cambie el nombre a `filtrarPorNombre`.
2. **Reestructuración de menús**: Se solicitó a la IA que reestructurara todos los menús en la clase `Consola` para incluir un bucle `while` en cada uno de ellos. Aunque el resultado no fue completamente satisfactorio, ya que se eliminaron otras partes del código, se uso la IA para ello, asi que era necesario mencionarlo.
3. **Test Unitario**: Se usó la IA para generar un modelo de test para los diferentes metodos de búsqueda y filtrado, con el uso de parameterized, ya que sabía como usarlos en python, pero no en java. Ya hechos, a partir de ahi fue copiar, pegar, adaptar a las distintas clases de testGestor.

### Etapa 3: Sistema de Préstamos y Reservas



### Etapa 4: Reportes y Análisis


### Conclusion
En resumen, la IA ha sido una herramienta valiosa en el desarrollo del proyecto, especialmente para automatizar tareas repetitivas y abordar problemas específicos. Sin embargo, también se han identificado áreas donde su uso requiere correcion inmediata, porque, en palabras menos tecnicas, se la recontra manda.