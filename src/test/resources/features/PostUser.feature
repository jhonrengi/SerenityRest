Feature: Create user

  @PostUser
  Scenario Outline: Create user successfully.
    When I consume the endpoint "<endpoint>" and I send the user information id "<id>", username "<username>" firstname "<firstname>" lastname "<lastname>"
    Then I can validate the response services <code>

    Examples:
      | id | username | firstname|lastname  | endpoint | code |
      | 1  | carlos24 | carlos  |   sanchez    | /user     | 200  |