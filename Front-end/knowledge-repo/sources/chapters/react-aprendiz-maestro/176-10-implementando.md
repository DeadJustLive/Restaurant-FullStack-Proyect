# 10. Implementando

Persistencia en localStorage
Ahora mismo nuestra aplicación no puede mantener su estado si la página se refresca.
Una buena forma de solucionar este problema es almacenar el estado de la aplicación
en el localStorage1 y recuperarlo cuando ejecutemos la aplicación de nuevo.
Esto no es un problema si estamos trabajando contra un backend, aunque incluso en
ese caso tener una caché temporal en localStorage puede ser útil, únicamente estate
seguro de que no almacenas información sensible ya que es fácil acceder a ella.