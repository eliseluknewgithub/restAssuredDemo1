Feature:
  NonBDDReusable Methods

  Scenario: Get posts from url by Non BDD Reusable Method
    Given I perform GET operation for "/posts" by Non BDD Reusable Method
    Then I should see the author names through Non BDD Reusable Method


  Scenario: Get one post from url with query params by Non BDD Reusable Method
    And I perform GET operation for "/posts" with query params by Non BDD Reusable Method
      | id |
      | 1  |
    Then I should see one author name through Non BDD Reusable Method

  Scenario: Get one post from url with path params by Non BDD Reusable Method
    And I perform GET operation for "/posts/{id}" with path params by Non BDD Reusable Method
      | id |
      | 1  |
    Then I should see one author name with path params through Non BDD Reusable Method

  Scenario: Verify Post operation for Profile
    Given I Perform Post operation for "/posts" with body by Non BDD Reusable Method
      | id | title | author |
      | 5  | DDD | 45678       |
    Then I should see the body has title as "DDD" by Non BDD Reusable Method

  Scenario: Verify Post operation with path parameter for Profile
    Given I Perform Post operation for "/posts/{profileNo}/profile" with body
      | name | profile |
      | Sams | 2       |
    Then I should see the body has name as "Sams" by Non BDD Reusable Method


  Scenario: Verify PUT operation after POST
    Given I ensure to Perform POST operation for "/posts" by Non BDD Reusable Method with body as
      | id | title | author |
      | 6  | API Testing course | ExecuteAutomation |

    And I Perform PUT operation  by Non BDD Reusable Method for "/posts/{postid}/" with body as
      | id | title | author |
      | 6  | API Testing | ExecuteAutomation |

    And I perform GET operation with path parameter by Non BDD Reusable Method for "/posts/{postid}"
      | postid |
      | 6      |

    Then I should see the body with title as "API Testing"


  Scenario: Verify DELETE operation after POST
    Given I Perform DELETE operation for "/posts/{postid}/" by Non BDD Reusable Method
      | postid |
      | 5     |
    Then I should not see the body with title as "API Testing"