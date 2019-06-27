DROP DATABASE ADVENTURE_GAME;

CREATE DATABASE ADVENTURE_GAME;

USE ADVENTURE_GAME;

CREATE TABLE ACCOUNT
(
Id INT NOT NULL AUTO_INCREMENT,
Username VARCHAR(20) NOT NULL UNIQUE,
Password VARCHAR(20) NOT NULL,
Email VARCHAR(80) NOT NULL UNIQUE,
Status VARCHAR(9) NOT NULL,
Player_name VARCHAR(20) NOT NULL UNIQUE,
PRIMARY KEY(Id),
CONSTRAINT Status_range CHECK (Status IN ('Banned', 'Permitted'))
);


CREATE TABLE PLAYER 
(
Display_name VARCHAR(20) NOT NULL,
Max_health INT NOT NULL,
Current_health INT NOT NULL,
Level INT,
Time_played INT,
Is_online BOOLEAN NOT NULL,
PRIMARY KEY(Display_name),
FOREIGN KEY(Display_name) REFERENCES ACCOUNT(Player_name),
CONSTRAINT Max_Health_range CHECK (Max_Health BETWEEN 1 and 100),
CONSTRAINT Current_health_range CHECK (Current_health BETWEEN 0 and 100),
CONSTRAINT Level_range CHECK (Level BETWEEN 1 and 100),
CONSTRAINT Time_played_range CHECK (Time_played >= 0)
);

CREATE TABLE BILLING_INFO 
(
Fname VARCHAR(20) NOT NULL,
Mname VARCHAR(20),
Lname VARCHAR(20) NOT NULL,
Phone BIGINT NOT NULL UNIQUE,
Membership VARCHAR(10) NOT NULL,
Expiration_date DATE,
Account_id INT NOT NULL, 
PRIMARY KEY(Lname, Phone, Account_id),
FOREIGN KEY(Account_id) REFERENCES ACCOUNT(Id),
CONSTRAINT Phone_range CHECK (Phone BETWEEN 1000000000 and 9999999999),
CONSTRAINT Membership_range CHECK (Membership IN ('Yearly', 'Monthly', 'Non-member'))
);

CREATE TABLE STATUS_CONDITION 
(
Condition_id INT NOT NULL,
Condition_duration INT NOT NULL,
Condition_effect VARCHAR(10) NOT NULL,
PRIMARY KEY(Condition_id),
CONSTRAINT Duration_range CHECK (Condition_duration > 0),
CONSTRAINT Effect_range CHECK (Condition_effect IN ('Poison', 'Confusion', 'Weak', 'Fear'))
);

CREATE TABLE SKILL 
(
Skill_id INT NOT NULL,
Skill_name VARCHAR(20) NOT NULL,
Skill_exp_cap INT NOT NULL,
PRIMARY KEY(Skill_id),
CONSTRAINT Exp_cap_range CHECK (Skill_exp_cap > 0)
);


CREATE TABLE QUEST 
(
Quest_id INT NOT NULL,
Quest_name VARCHAR(20) NOT NULL,
Quest_stages INT NOT NULL,
PRIMARY KEY(Quest_id),
CONSTRAINT Stages_range CHECK (Quest_stages > 0)
);

CREATE TABLE HAS_STATUS_CONDITION 
(
Player_name VARCHAR(20) NOT NULL,
Condition_id INT NOT NULL,
Condition_duration INT NOT NULL,
PRIMARY KEY(Player_name, Condition_id),
FOREIGN KEY(Player_name) REFERENCES PLAYER(Display_name),
FOREIGN KEY(Condition_id) REFERENCES STATUS_CONDITION(Condition_id),
CONSTRAINT Duration_range CHECK (Condition_duration > 0)
);

CREATE TABLE KNOWS_SKILL 
(
Player_name VARCHAR(20) NOT NULL,
Skill_id INT NOT NULL,
Skill_rank INT NOT NULL,
Skill_exp INT NOT NULL,
PRIMARY KEY(Player_name, Skill_id),
FOREIGN KEY(Player_name) REFERENCES ACCOUNT(Player_name),
FOREIGN KEY(Skill_id) REFERENCES SKILL(Skill_id),
CONSTRAINT Rank_range CHECK (Skill_rank BETWEEN 0 and 100),
CONSTRAINT Exp_range CHECK (Skill_exp >= 0)
);

CREATE TABLE ACCEPTED_QUEST 
(
Player_name VARCHAR(20) NOT NULL,
Quest_id INT NOT NULL,
Completed_stages INT NOT NULL,
PRIMARY KEY(Player_name, Quest_id),
FOREIGN KEY(Player_name) REFERENCES PLAYER(Display_name),
FOREIGN KEY(Quest_id) REFERENCES QUEST(Quest_id),
CONSTRAINT Completion_range CHECK (Completed_stages >= 0)
);

CREATE TABLE STORED_ITEM 
(
Owner_name VARCHAR(20) NOT NULL,
Stored_in VARCHAR(20) NOT NULL,
Item_id INT NOT NULL,
Item_name VARCHAR(20) NOT NULL,
Item_amount INT NOT NULL,
Item_type VARCHAR(20) NOT NULL,
Item_picture VARCHAR(50) NOT NULL,
Item_upgrade INT NOT NULL,
PRIMARY KEY(Owner_name, Stored_in, Item_id, Item_upgrade),
FOREIGN KEY(Owner_name) REFERENCES PLAYER(Display_name),
CONSTRAINT Stored_range CHECK (Stored_in IN ('Bank', 'Inventory')),
CONSTRAINT Amount_range CHECK (Item_amount > 0),
CONSTRAINT Item_upgrade CHECK (Item_upgrade < 10 AND Item_upgrade > -1),
CONSTRAINT Type_range CHECK (Item_type IN ('Weapon', 'Armor', 'Potion', 'Food', 'Misc'))
);