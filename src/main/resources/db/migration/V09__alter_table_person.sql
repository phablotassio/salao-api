ALTER TABLE person
ADD CONSTRAINT unique_document_number UNIQUE (document_number);

ALTER TABLE person
CHANGE COLUMN email email varchar(100);