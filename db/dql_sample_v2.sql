/* ************* SAMPLE QUERY ************* */

-- Searching candidates that have mastered Python
select can_id, can_name from candidate where can_id in (select distinct(fk_can_id) from candidate_skill cs where (cs.fk_skill_id = 2 and cs.skill_level = '5'));

-- Searching candidates that have mastered Brainfuck and Martial Arts
select can_id, can_name from candidate where can_id in (select distinct(fk_can_id) from candidate_skill cs where (cs.fk_skill_id = 1 and cs.skill_level = '5') and fk_can_id in (select distinct(fk_can_id) 
from candidate_skill cs where (cs.fk_skill_id = 7 and cs.skill_level = '5')));






