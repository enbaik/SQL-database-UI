use ADVENTURE_GAME;

/* Banned Player List by Most Time Played */
select P.Display_name, P.Time_played
from PLAYER P
	join ACCOUNT A on A.Player_name = P.Display_name
where A.Status = 'Banned'
order by P.Time_played desc;


/* Number of Players that Completed Each Quest */
select Q.Quest_name, count(*)
from QUEST Q
	join ACCEPTED_QUEST AQ on Q.Quest_id = AQ.Quest_id
where AQ.Completed_stages = Q.Quest_stages
group by Q.Quest_id
order by count(*);


/* Membership Expirations This Month */
select A.Player_name, A.Email, B.Expiration_date
from ACCOUNT A
	join BILLING_INFO B on A.Id = B.Account_id
where month(curdate()) = month(B.Expiration_date)
	and year(curdate()) = year(B.Expiration_date);


/* Most Rare Item */
SET sql_mode = '';
select A.Player_name, A.Email, max(S.Item_amount)
from ACCOUNT A
	join PLAYER P on A.Player_name = P.Display_name
    join STORED_ITEM S on P.Display_name = S.Owner_name
where S.Item_name = 'Golden Chefs Hat'
group by S.Item_name;

/* Cheat Detection */
select P.Display_name, sum(S.Skill_exp), P.Time_played
from PLAYER P
	join KNOWS_SKILL S on P.Display_name = S.Player_name
group by P.Display_name
having (P.Time_played * 80000) < sum(S.Skill_exp);

/* All the rest of the queries use a variable entered in a textbox in the UI.
For example purposes, we use "zombie" as an example.*/

/* Account of Player */
select * 
from ACCOUNT 
where Player_name = 'zombie';

/* Skills of Player */
select Player_name, Skill_name, Skill_rank, Skill_exp 
from KNOWS_SKILL JOIN SKILL on KNOWS_SKILL.Skill_id = SKILL.Skill_id where Player_name = 'zombie'; 

/* Items Stored for Player */
select Owner_name, Stored_in, Item_name, Item_amount, Item_type, Item_picture, Item_upgrade    
from STORED_ITEM where Owner_name = 'zombie'
ORDER BY Stored_in,Item_name;

/* Quests of Player*/
select Player_name, Quest_name, Completed_stages, Quest_stages
from ACCEPTED_QUEST join QUEST on QUEST.Quest_id = ACCEPTED_QUEST.Quest_id
where Player_name = 'zombie';

/* Conditions of Player */
select Player_name, Condition_effect, HAS_STATUS_CONDITION.Condition_duration
from HAS_STATUS_CONDITION join STATUS_CONDITION on HAS_STATUS_CONDITION.Condition_id = STATUS_CONDITION.Condition_id
where Player_name = 'zombie';



