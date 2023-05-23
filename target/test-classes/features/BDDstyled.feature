Feature:
  BDDStyled Methods

  Scenario: Get post from url by BDD styled method
    Given I perform GET operation for "/posts" by BDD styled method
    Then I should see the author names through BDD styled method

  Scenario: Get post from url with path params by BDD styled method
    Given I perform GET operation for "/posts" with path params by BDD styled method
    Then I should see the author name with one path params through BDD styled method


  Scenario: Get post from url with query params by BDD styled method
    Given I perform GET operation for "/posts" with query params by BDD styled method
    Then I should see the author name with one query params through BDD styled method


  Scenario: Verify Post operation by BDD styled method
    Given I perform POST operation for "/posts" by BDD styled method


  Scenario: Verify PUT operation by BDD styled method
    Given I perform PUT operation for "/posts" by BDD styled method


  Scenario: Verify DELETE operation by BDD styled method
    Given I perform DELETE operation for "/posts" by BDD styled method