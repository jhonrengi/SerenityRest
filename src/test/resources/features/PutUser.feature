Feature: Update user

  @PutUser
  Scenario Outline: Update user successfully.
    When I consume the endpoint "<endpoint>" and I update the user's information id "<id>", username "<username>" firstname "<firstname>" lastname "<lastname>"
    Then  can validate the response services <code>

    Examples:
      | id | username | firstname|lastname  | endpoint | code |
      | 1  | carlos24 | camilo  |   gomez    | /user/carlos24     | 200  |