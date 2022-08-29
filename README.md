"# docs" 
#Checkout Rest API code 
git clone https://github.com/v893979/docs.git
cd docs
chmod +x mvnw
./mvnw -DskipTests spring-boot:run



#Create database

gcloud sql instances create docs-instance
gcloud sql databases create DOCS --instance docs-instance
gcloud sql instances describe docs-instance | grep connectionName
connectionName: devjam-360201:us-central1:docs-instance

gcloud sql databases create DOCS --instance messages


gcloud sql connect docs-instance --user=root 

USE DOCS;

create table DOCS.docvault(
id int NOT NULL AUTO_INCREMENT primary key,
doc_id varchar(50) NOT NULL,
doc_name varchar(50) NOT NUll,
doc_source varchar(50) NOT NUll,
certification_status varchar(50) NOT NUll,
certification_rating varchar(50) NOT NUll,
certification_history varchar(250) NUll,
created_on DATETIME DEFAULT CURRENT_TIMESTAMP NUll);

USE DOCS;
SHOW TABLES;

INSERT INTO DOCS.docvault(doc_id, doc_name, doc_source, certification_status, certification_rating, certification_history)
VALUES ("DOC0001","Birth Certificate","Immigration","verified","9/10","NA");

{
    "docId": "DOC0001",
    "docName": "Australia Passport",
    "docSource": "Immigration and Citizenship",
    "certificationStatus": "verified",
    "certificationRating": "9/10",
    "certificationHistory": "NA"
}

ALTER TABLE DOCS.docvault
ADD COLUMN document varchar(150) AFTER doc_source;

UPDATE `DOCS`.`docvault` SET `document` = 'https://storage.googleapis.com/devjamdocs/2%20Sample%20ofhttps://storage.googleapis.com/devjamdocs/Birth%20Certificate.jpg' WHERE (`id` = '1');
UPDATE `DOCS`.`docvault` SET `document` = 'https://storage.googleapis.com/devjamdocs/Medicare.jpg' WHERE (`id` = '2');
UPDATE `DOCS`.`docvault` SET `document` = 'https://storage.googleapis.com/devjamdocs/Education.jpg' WHERE (`id` = '3');
