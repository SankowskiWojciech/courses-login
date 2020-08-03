-- ORGANIZATIONS
insert into ORGANIZATION(ORGANIZATION_ID, ALIAS, NAME, DESCRIPTION, EMAIL_ADDRESS)
values (1, 'zslitnr1', 'Zespół szkół licealnych i technicznych nr 1 w Warszawie', 'Technikum mechatroniczno - informatyczne', 'info@zslitnr1.pl');
insert into ORGANIZATION(ORGANIZATION_ID, ALIAS, NAME, DESCRIPTION, EMAIL_ADDRESS)
values (2, 'ssit', 'Szkoła śpiewu i tańca', 'Szkoła gdzie się uczy śpiewać i tańczyć', 'not.spam@dancewithme.pl');

-- TUTORS
insert into TUTOR(TUTOR_ID, ALIAS, FIRST_NAME, LAST_NAME, DESCRIPTION, EMAIL_ADDRESS)
values (1, 'wsankowski', 'Wojciech', 'Sankowski', 'Java Developer', 'sankowski.wojciech@gmail.com');
insert into TUTOR(TUTOR_ID, ALIAS, FIRST_NAME, LAST_NAME, DESCRIPTION, EMAIL_ADDRESS)
values (2, 'barkam', 'Bartosz', 'Kamiński', 'Profesjonalny tancerz', 'kaminski.bart@dancewithme.pl');

-- PARENTS
insert into PARENT(PARENT_ID, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS)
values (1, 'Kamil', 'Baczewski', 'kbac@gmail.com');

-- STUDENTS
insert into STUDENT(STUDENT_ID, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, PARENT_ID)
values (1, 'Marcin', 'Baczewski', 'marcin.b@gmail.com', 1);

-- SUBDOMAIN USER ACCESSES
insert into SUBDOMAIN_USER_ACCESS(SUBDOMAIN_EMAIL_ADDRESS, USER_EMAIL_ADDRESS)
values ('info@zslitnr1.pl', 'sankowski.wojciech@gmail.com');

-- LOGIN_CREDENTIALS
-- password: Test1
insert into LOGIN_CREDENTIALS(ID, EMAIL_ADDRESS, ENCRYPTED_PASSWORD, ACCOUNT_TYPE) values (1, 'sankowski.wojciech@gmail.com', 'JDJhJDE1JFhNV2RBYWxFREhQc3BKVk93cHRVdnVsN3QyRWMyLlVSZTNDMmJqR0MwNGkuNzdFTU9zVExD', 'TUTOR');






--INSERT INTO TOKEN(ID, TOKEN_VALUE, EMAIL_ADDRESS, RSA_PUBLIC_KEY, CREATION_DATE_TIME, EXPIRATION_DATE_TIME, IS_REVOKED) VALUES ('ff40d81e-63b3-4012-84fb-613d6246bab3', 'tokenValue', 'test1@gmail.com', 'rsaPublicKey', '2020-07-18T18:21:14.144', '2220-07-18T18:21:14.144', 'false');