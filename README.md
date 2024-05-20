# ChallengeG6-ConversorMoneda-api

Esta aplicación de conversión de monedas es una herramienta sencilla y eficiente que permite a los usuarios convertir entre tres tipos de monedas: USD, EUR y ARS. La aplicación utiliza la API de ExchangeRate-API para obtener las tasas de conversión actuales y elabora las conversiones solicitadas por el usuario. La interfaz de usuario se maneja a través de la consola, donde se guía al usuario a través de un menú para seleccionar las monedas y la cantidad a convertir.

## Herramientas Utilizadas

**ExchangeRate-API**: Esta API se utiliza para obtener las tasas de conversión actuales entre las distintas monedas. La API proporciona datos en formato JSON que son fáciles de manejar y procesar dentro de la aplicación.

**Gson**: Gson es una biblioteca de Java para la serialización y deserialización de objetos Java a y desde JSON. En esta aplicación, Gson se utiliza para convertir la respuesta JSON de la API de ExchangeRate-API en objetos Java utilizables.

#### Ejemplo de Uso
1. **Elija la moneda a convertir** (1 para USD, 2 para EUR, 3 para ARS).
2. **Elija la moneda requerida** (1 para USD, 2 para EUR, 3 para ARS).
3. **Ingrese la cantidad a convertir**.
4. La aplicación mostrará la **tasa de conversión** y el **resultado de la conversión**.
5. Decida si desea realizar otra conversión o finalizar la sesión.

#### Ejemplo de Output

