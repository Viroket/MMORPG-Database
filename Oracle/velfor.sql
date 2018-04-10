CREATE TABLE MMOServer (
         ServerID      NUMBER(5) PRIMARY KEY,
         ServerName      VARCHAR2(15) NOT NULL,
         MaxCapacity        NUMBER(9) ,
         currentOnline         NUMBER(6),
        NumRegistered        NUMBER(8)
        );
        
 CREATE TABLE MMOUsers (
         UserID      NUMBER(5) PRIMARY KEY,
         UserName      VARCHAR2(40) NOT NULL,
         UserPassword         VARCHAR2(40)  NOT NULL ,
         Email        VARCHAR2(100),
        NumRegistered NUMBER(6) ,
        ServerID  NUMBER(5) ,
        CONSTRAINT fk_serverID FOREIGN KEY (ServerID) references MMOServer(ServerID)
        );
        
 CREATE TABLE MMOCharacter  (
         CharID      NUMBER(5) PRIMARY KEY,
         NickName       VARCHAR2(15) ,
         CharClass     VARCHAR2(15),
         Race                 VARCHAR2(15),
         Experience   NUMBER(5),
         HP                      NUMBER(5),
         Mana                 NUMBER(5),
         Gold                 NUMBER(5),
         CharLevel     NUMBER(5),
         CharLocation  NUMBER(5),
         UserID      NUMBER(5),
        CONSTRAINT fk_userID FOREIGN KEY (UserID) references MMOUsers(UserID)
        );
       
CREATE TABLE MMOItems  (
         ItemID      NUMBER(5) PRIMARY KEY,
         ItemName      VARCHAR2(15) NOT NULL,
         ItemValue        VARCHAR2(15) NOT NULL,
         Slot         NUMBER(6),
         Weight        NUMBER(8),
        ItemType  VARCHAR2(15)
        );
        
CREATE TABLE MMOQuests  (
         QuestID      NUMBER(5) PRIMARY KEY,
         QuestsName      VARCHAR2(15) NOT NULL,
         QuestLevel        NUMBER(9) ,
         ExperienceReward         NUMBER(6),
        ItemReward        NUMBER(8),
        Objective          NUMBER(8)
        );
        
        
 CREATE TABLE MMOMonsters (
         MonsterID      NUMBER(5) PRIMARY KEY,
         MonsterName      VARCHAR2(15) NOT NULL,
         HP       NUMBER(9) ,
         Damage         NUMBER(6),
         MonsterLocation        NUMBER(8)
        );
        
 CREATE TABLE MMOQuestsStatus (
         CharID     NUMBER(5),
         QuestID        NUMBER(5),
         Status       VARCHAR2(15) ,
        CONSTRAINT fk_characterID FOREIGN KEY (CharID) references  MMOCharacter(CharID),
        CONSTRAINT fk_questID FOREIGN KEY (QuestID) references MMOQuests(QuestID)
        );
        
CREATE TABLE MMOuser_names_history 
    (oldName  VARCHAR2(15)
    ); 
    
    CREATE OR REPLACE PACKAGE monsters_package AS 
   PROCEDURE addMonsters(c_id   MMOMONSTERS.MONSTERID%type, 
   c_name MMOMONSTERS.MONSTERNAME%type, 
   c_hp  MMOMONSTERS.HP%type, 
   c_damage MMOMONSTERS.DAMAGE%type,  
   c_location  MMOMONSTERS.MONSTERLOCATION%type); 
   
   PROCEDURE delMonster(c_id  MMOMONSTERS.MONSTERID%TYPE); 

END monsters_package; 

CREATE OR REPLACE PACKAGE BODY monsters_package AS 
   PROCEDURE addMonsters(c_id   MMOMONSTERS.MONSTERID%type, 
   c_name MMOMONSTERS.MONSTERNAME%type, 
   c_hp  MMOMONSTERS.HP%type, 
   c_damage MMOMONSTERS.DAMAGE%type,  
   c_location  MMOMONSTERS.MONSTERLOCATION%type)
   IS 
   BEGIN 
      INSERT INTO MMOMONSTERS (MONSTERID,MONSTERNAME,HP,DAMAGE,MONSTERLOCATION) 
         VALUES(c_id, c_name, c_hp, c_damage, c_location); 
   END addMonsters; 
   
   PROCEDURE delMonster(c_id   MMOMONSTERS.MONSTERID%type) IS 
   BEGIN 
      DELETE FROM MMOMONSTERS 
      WHERE MONSTERID = c_id; 
   END delMonster;
   END monsters_package; 
        
CREATE or REPLACE TRIGGER old_names_trigger 
BEFORE DELETE  
ON MMOUSERS 
FOR EACH ROW 
BEGIN 
INSERT INTO MMOuser_names_history 
VALUES 
(:old.USERNAME); 
END; 
        

DELETE FROM MMOUSERS
WHERE USERNAME = 'sacas';
        
CREATE SEQUENCE seq_server
START WITH 0
MINVALUE 0
INCREMENT BY 1
CACHE 100;

CREATE SEQUENCE seq_users
START WITH 0
MINVALUE 0
INCREMENT BY 1
CACHE 100;

CREATE SEQUENCE seq_Items
START WITH 0
MINVALUE 0
INCREMENT BY 1
CACHE 100;

CREATE SEQUENCE seq_Quests
START WITH 0
MINVALUE 0
INCREMENT BY 1
CACHE 100;

SELECT SERVERID 
FROM MMOSERVER 
WHERE SERVERID = 111;

CREATE SEQUENCE seq_monsters
START WITH 0
MINVALUE 0
INCREMENT BY 1
CACHE 100;

CREATE SEQUENCE SEQ_CHARACTER
START WITH 0
MINVALUE 0
INCREMENT BY 1
CACHE 100;

CREATE OR REPLACE PROCEDURE strong_monsters_locations
IS
r_monsters MMOMONSTERS%rowtype;
CURSOR c_monsters IS SELECT * FROM MMOMONSTERS WHERE MONSTERLOCATION >= 100;
BEGIN
    OPEN c_monsters;
    FETCH c_monsters into r_monsters;
    WHILE c_monsters%FOUND
    LOOP
    	dbms_output.put_line(r_monsters.MONSTERID || ', ' || r_monsters.MONSTERNAME || ', ' ||  r_monsters.MONSTERLOCATION);
        FETCH c_monsters into r_monsters;
    END LOOP;
    CLOSE c_monsters;
END;

CREATE OR REPLACE TRIGGER tr_maxCapacity
    BEFORE INSERT ON MMOSERVER
    FOR EACH ROW
BEGIN
    IF :NEW.MAXCAPACITY > 5000 THEN
        :NEW.MAXCAPACITY := :NEW.MAXCAPACITY * .4;
    END IF;
END;


SELECT CHARID FROM MMOCHARACTER;
SELECT QUESTID FROM MMOQUESTS;

UPDATE MMOSERVER
SET MAXCAPACITY = 5000
WHERE SERVERID = 1;

UPDATE VMMOSERVER
SET MAXCAPACITY = 3000
WHERE SERVERID = 1;

CREATE OR REPLACE VIEW YellowPages( theId, theName,  ff, State, Phone )
  AS
  SELECT Au_LName || ' ' || Au_FName, 'A', City, State, Phone
  FROM Authors
  UNION
  SELECT Ed_LName || ' ' || Ed_FName, 'E', City, State, Phone
  FROM Editors
  UNION
  SELECT Pub_Name, 'P', City, State, NULL
  FROM Publishers
  ORDER BY 1;


SELECT  MMOSERVER.SERVERNAME , COUNT(MMOUSERS.SERVERID) AS NUM_USERS
FROM MMOSERVER , MMOUSERS
WHERE MMOSERVER.SERVERID = MMOUSERS.SERVERID
GROUP BY  MMOSERVER.SERVERNAME;

select cast(CURRENTONLINE as decimal(10,2))
from MMOSERVER;

SELECT AVG(MAX(cast(CURRENTONLINE as decimal(10,2)))) AS AVREGE
  FROM MMOSERVER
  GROUP BY SERVERID;

SELECT * 
FROM MMOSERVER;


CREATE OR REPLACE VIEW vMmoServer
AS
SELECT *
FROM MMOSERVER 
WHERE MAXCAPACITY > (SELECT AVG(MAXCAPACITY) FROM MMOSERVER);

CREATE OR REPLACE VIEW vMmoMonsters
AS
SELECT *
FROM MMOMONSTERS 
WHERE HP > 10000;

CREATE OR REPLACE VIEW vMmoMonstersAndServer
AS
SELECT SERVERNAME FROM   MMOSERVER
INTERSECT 
SELECT MONSTERNAME FROM   MMOMONSTERS;

UPDATE MMOUSERS SET 'sacas' WHERE USERID = '308'

CREATE OR REPLACE FUNCTION smallerName (
    string_in IN VARCHAR2,
    start_in IN INTEGER,
    end_in IN INTEGER
    )
    RETURN VARCHAR2
IS
    NAME_TOO_SHORT EXCEPTION;
BEGIN
    IF length(string_in) < end_in THEN RAISE NAME_TOO_SHORT;
    END IF;
    RETURN (SUBSTR (string_in,  start_in, end_in ));
    EXCEPTION
        WHEN NO_DATA_FOUND THEN 
            raise_application_error(-20005,'No User Selected');
        WHEN NAME_TOO_SHORT THEN 
            raise_application_error(-20006,'User Name Too Short');
         WHEN OTHERS THEN 
            raise_application_error(-20007,'Unknown Error');
END smallerName;




SELECT * FROM VMMOSERVER ;

SELECT *
FROM MMOSERVER
WHERE SERVERNAME = 'FireBlade' AND NUMREGISTERED  < 700;

select * 
from MMOSERVER
WHERE  NUMREGISTERED < 800;

SELECT *
FROM MMOSERVER
ORDER BY SERVERID ASC ;

SELECT max(CURRENTONLINE)
FROM MMOSERVER;

SELECT SERVERID
FROM MMOSERVER;

SELECT * 
FROM MMOUsers;

SELECT * 
FROM MMOUsers;

SELECT * 
FROM MMOCharacter;

SELECT * 
FROM MMOItems;

SELECT * 
FROM MMOQuests;

SELECT * 
FROM MMOMonsters;

SELECT * 
FROM MMOQuestsStatus;

  CREATE OR REPLACE PROCEDURE GET_ITEM_NAME_PROC 
(
  ITEM_ID_INPUT IN NUMBER 
, ITEM_NAME_OUTPUT OUT VARCHAR2 
) AS 
BEGIN
    SELECT ITEMNAME INTO ITEM_NAME_OUTPUT FROM MMOITEMS WHERE ITEMID = ITEM_ID_INPUT;
END GET_ITEM_NAME_PROC;

CREATE OR REPLACE PACKAGE BODY monsters_package AS 
   PROCEDURE addMonsters(c_id   MMOMONSTERS.MONSTERID%type, 
   c_name MMOMONSTERS.MONSTERNAME%type, 
   c_hp  MMOMONSTERS.HP%type, 
   c_damage MMOMONSTERS.DAMAGE%type,  
   c_location  MMOMONSTERS.MONSTERLOCATION%type)
   IS 
   BEGIN 
      INSERT INTO MMOMONSTERS (MONSTERID,MONSTERNAME,HP,DAMAGE,MONSTERLOCATION) 
         VALUES(c_id, c_name, c_hp, c_damage, c_location); 
   END addMonsters; 

   PROCEDURE delMnster(c_id   MMOMONSTERS.MONSTERID%type) IS 
   BEGIN 
      DELETE FROM MMOMONSTERS 
      WHERE MONSTERID = c_id; 
   END delMnster;
   END monsters_package; 
   
   CREATE OR REPLACE TRIGGER delete_server_trigger
   BEFORE DELETE
   ON MMOSERVER
   FOR EACH ROW
   BEGIN
   DELETE FROM MMOUSERS WHERE (SERVERID = MMOUSERS.SERVERID);
   END;
   

   CURSOR itm_cur IS 
   SELECT * 
   FROM MMOITEMS
   WHERE WEIGHT > 99; 
        