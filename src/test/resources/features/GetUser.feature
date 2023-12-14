Feature: get user

  @GetUser
  Scenario Outline: get user successfully.
    When I consume the endpoint "<endpoint>" and I send the user information username "<username>"
    Then I can validate the answer service <code>

    Examples:
      | username | endpoint | code |
      | carlos24 | /user/carlos24 | 200  |