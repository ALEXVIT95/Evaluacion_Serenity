@CompraWeb
Feature: Flujo de compra en demoblaze

  @Compra
  Scenario Outline: Validar que un usuario registrado pueda realizar una compra en abstracta

    Given Usuario se logueo en opencart.abstracta
    When agrego <cantProds> productos de la categoria <categoria>

    And visualizo el carrito
    And completo el 'Checkout' como invitado: 'Guest Checkout'
      | FirstName | LastName  | Email                    | Telefono  | Company | Address         | City | PostCode | Country | Region |
      | Alejandro      | Viteri | prueba@prueba.com | 0963933465 | Empresa ACME | Av. Republica | Quito | 170303   | Ecuador    | Quito   |
    Then finalizo la compra
    And visualizo la confirmación: <validacion>
    Examples:
      | cantProds | categoria     | validacion                  |
      | 2         | Phones & PDAs | Your order has been placed! |








