Feature: QA3 - Advanced Automation. Database

#  Task 1 – Simple validation
#  Create a test where we find agent with name Lucida and assert all his data (Check his id, name, city, phone number)
  @CreateDBTableAgents @DropDBTableAgents
  Scenario: 01. Simple data validation
	When I verify 'AGENTS' table entity with 'Lucida' agent name contains values
	  | TABLE_KEY    | NEW_VALUE    |
	  | AGENT_CODE   | A012         |
	  | AGENT_NAME   | Lucida       |
	  | WORKING_AREA | San Jose     |
	  | COMMISSION   | 0.12         |
	  | PHONE_NO     | 044-52981425 |

#  Task 2 – Add/Remove data
#  Create a test where we insert Agent – Test from Riga and PhoneNumber - 778-32556178
  @CreateDBTableAgents @DropDBTableAgents
  Scenario: 02. Add and remove data - insert new agent
	When I update 'AGENTS' table entity with 'Test' agent name contains values
	  | TABLE_KEY    | NEW_VALUE    |
	  | AGENT_CODE   | A013         |
	  | AGENT_NAME   | Test         |
	  | WORKING_AREA | Riga         |
	  | COMMISSION   | 0.75         |
	  | PHONE_NO     | 778-32556178 |
	  | COUNTRY      | LATVIA       |
	Then I verify 'AGENTS' table entity with 'Test' agent name contains values
	  | TABLE_KEY    | NEW_VALUE    |
	  | AGENT_CODE   | A013         |
	  | AGENT_NAME   | Test         |
	  | WORKING_AREA | Riga         |
	  | COMMISSION   | 0.75         |
	  | PHONE_NO     | 778-32556178 |
	  | COUNTRY      | LATVIA       |

#  Create a test where we update Agent – Mukesh. Change that he is from Bangladesh and his PhoneNumber is 777-11111111
  @CreateDBTableAgents @DropDBTableAgents
  Scenario: 03. Add and remove data - change agent data
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
	Then I verify 'AGENTS' table entity with 'Mukesh' agent name contains values
	  | TABLE_KEY    | NEW_VALUE    |
	  | AGENT_CODE   | A002         |
	  | AGENT_NAME   | Mukesh       |
	  | WORKING_AREA | Bangladesh   |
	  | COMMISSION   | 0.11         |
	  | PHONE_NO     | 777-11111111 |