Feature: QA3 - Advanced Automation. Database

  Scenario: 01. Simple data validation
	When I verify 'AGENTS' table entity with 'Mukesh' agent name contains values
	  | TABLE_KEY    | NEW_VALUE    |
	  | AGENT_CODE   | A002         |
	  | AGENT_NAME   | Mukesh       |
	  | WORKING_AREA | Mumbai       |
	  | COMMISSION   | 0.11         |
	  | PHONE_NO     | 029-12358964 |
	And I update 'AGENTS' table entity with 'Mukesh' agent name with new values
	  | TABLE_KEY    | NEW_VALUE    |
	  | WORKING_AREA | Bangladesh   |
	  | PHONE_NO     | 777-11111111 |
	And I verify 'AGENTS' table entity with 'Mukesh' agent name contains values
	  | TABLE_KEY    | NEW_VALUE    |
	  | AGENT_CODE   | A002         |
	  | AGENT_NAME   | Mukesh       |
	  | WORKING_AREA | Bangladesh   |
	  | COMMISSION   | 0.11         |
	  | PHONE_NO     | 777-11111111 |
	Then I update 'AGENTS' table entity with 'Mukesh' agent name with new values
	  | TABLE_KEY    | NEW_VALUE    |
	  | WORKING_AREA | Mumbai       |
	  | PHONE_NO     | 029-12358964 |